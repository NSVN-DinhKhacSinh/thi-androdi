package com.example.myapplication.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.SinhVienAdapter;
import com.example.myapplication.dal.SQLiteHelper;
import com.example.myapplication.model.SV;

import java.util.List;

public class FragmentNhapSV extends Fragment implements SinhVienAdapter.SVListener {

    private SinhVienAdapter sinhVienAdapter;
    private RecyclerView recyclerView;
    private Button btAdd, btUpdate, btDelete;
    private SQLiteHelper db;
    private Spinner namHoc;
    private EditText tenSV,namSinh,queQuan;
    private int maSV;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_nsv,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.rec_list_sv);
        sinhVienAdapter = new SinhVienAdapter();
        db = new SQLiteHelper(getContext());


        List<SV> list= db.getAll();
        sinhVienAdapter.setListSV(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(sinhVienAdapter);
        sinhVienAdapter.setSvListener(this);

        btAdd=view.findViewById(R.id.btAdd);
        btUpdate=view.findViewById(R.id.btUpdate);
        btDelete=view.findViewById(R.id.btDelete);

        namHoc=view.findViewById(R.id.nam_hoc);
        tenSV=view.findViewById(R.id.ten_sv);
        namSinh=view.findViewById(R.id.nam_sinh);
        queQuan=view.findViewById(R.id.que_quan);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view==btAdd){
                    String tsv=tenSV.getText().toString();
                    String ns=namSinh.getText().toString();
                    String qq=queQuan.getText().toString();
                    String nh=namHoc.getSelectedItem().toString();
                    if(!tsv.isEmpty() && ns.matches("\\d+")){
                        SQLiteHelper sqLiteHelper= new SQLiteHelper(getContext());
                        sqLiteHelper.addSV(new SV(tsv,ns,qq,nh));

                        //lm moi
                        List<SV> list= db.getAll();
                        sinhVienAdapter.setListSV(list);
                    }
                }

            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view==btUpdate){

                    String tsv=tenSV.getText().toString();
                    String ns=namSinh.getText().toString();
                    String qq=queQuan.getText().toString();
                    String nh=namHoc.getSelectedItem().toString();
                    if(!tsv.isEmpty() && ns.matches("\\d+")){
                        SQLiteHelper sqLiteHelper= new SQLiteHelper(getContext());
                        sqLiteHelper.updateSV(new SV(maSV,tsv,ns,qq,nh));

                        //lm moi
                        List<SV> list= db.getAll();
                        sinhVienAdapter.setListSV(list);
                    }
                }
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteHelper sqLiteHelper= new SQLiteHelper(getContext());
                sqLiteHelper.deleteSV(maSV);
                List<SV> list= db.getAll();
                sinhVienAdapter.setListSV(list);

            }
        });

    }

    @Override
    public void onSVclick(View view, int position) {

        String[] spinner={"Nam Nhat","Nam Hai","Nam Ba","Nam Bon"};
        SV sv =sinhVienAdapter.getSV(position);
        int p=1;
        String nh=sv.getNam_hoc();
        for(int i=0;i<4;i++){
            if(nh.equals(spinner[i])) {
                p=i;
            }
        }
        maSV=sv.getMa_Sv();
        namHoc.setSelection(p);
        tenSV.setText(sv.getTen_Sv());
        namSinh.setText(sv.getNam_sinh());
        queQuan.setText(sv.getQue_quan());


    }

    @Override
    public void onResume() {
        super.onResume();
        List<SV>list=db.getAll();
        sinhVienAdapter.setListSV(list);
    }
}
