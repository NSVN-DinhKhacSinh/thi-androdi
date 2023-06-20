package com.example.myapplication.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ClassAdapter;
import com.example.myapplication.dal.SQLiteHelper;
import com.example.myapplication.model.Lop;

import java.util.ArrayList;
import java.util.List;

public class FragmentNhapLop extends Fragment implements ClassAdapter.ClassListener {

    private ClassAdapter classAdapter;
    private RecyclerView recyclerView;
    private Button btAdd, btUpdate, btDelete;
    private EditText tenClass,moTa;
    private int maClass;
    private SQLiteHelper db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_nlop,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.rec_list_lop);
        classAdapter=new ClassAdapter();
        db = new SQLiteHelper(getContext());

        List<Lop> list= db.getAllClass();
        list.add(new Lop(1,"con nghe","như shit"));
        classAdapter.setListClass(list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(classAdapter);
        classAdapter.setClassListener(this);

        //
        btAdd=view.findViewById(R.id.btAddClass);
        btUpdate=view.findViewById(R.id.btUpdateClass);
        btDelete=view.findViewById(R.id.btDeleteClass);
        tenClass=view.findViewById(R.id.edTenLop);
        moTa=view.findViewById(R.id.edmMoTa);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tCl= tenClass.getText().toString();
                String mt= moTa.getText().toString();
                SQLiteHelper db = new SQLiteHelper(getContext());
                if(tenClass!=null) db.addClass(new Lop(tCl,mt));
                List<Lop> list=db.getAllClass();
                classAdapter.setListClass(list);
            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tCl= tenClass.getText().toString();
                String mt= moTa.getText().toString();
                SQLiteHelper db = new SQLiteHelper(getContext());
                if(tenClass!=null) db.updateClass(new Lop(maClass,tCl,mt));
                List<Lop> list=db.getAllClass();
                classAdapter.setListClass(list);
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteHelper db = new SQLiteHelper(getContext());
                if(tenClass!=null) db.delteClass(maClass);
                List<Lop> list=db.getAllClass();
                classAdapter.setListClass(list);
            }
        });

    }

    @Override
    public void onClClick(View view, int position) {
        Lop lop = classAdapter.getLop(position);
        maClass=lop.getMa_lop();
        tenClass.setText(lop.getTen_lop());
        moTa.setText(lop.getMo_ta());

    }

    @Override
    public void onResume() {
        super.onResume();
        List<Lop> list=db.getAllClass();
        classAdapter.setListClass(list);
    }
}
