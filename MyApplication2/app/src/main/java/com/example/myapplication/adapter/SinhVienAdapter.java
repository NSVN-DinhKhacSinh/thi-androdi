package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.SV;

import java.util.ArrayList;
import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SinhVienView> {

    private List<SV> listSV;

    private SVListener svListener;

    public SinhVienAdapter() {
        this.listSV = new ArrayList<>();
    }

    public void setSvListener(SVListener svListener) {
        this.svListener = svListener;
    }

    public void setListSV(List<SV> listSV) {
        this.listSV = listSV;
        notifyDataSetChanged();
    }

    public SV getSV(int position){
        return listSV.get(position);
    }

    @NonNull
    @Override
    public SinhVienView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sv,parent,false);
        return new SinhVienView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienView holder, int position) {
        SV sv=listSV.get(position);
//        holder.maSv.setText(sv.getMa_Sv());
        holder.tenSV.setText(sv.getTen_Sv());
        holder.namSinh.setText(sv.getNam_sinh());
        holder.queQuan.setText(sv.getQue_quan());
        holder.namHoc.setText(sv.getNam_hoc());
    }

    @Override
    public int getItemCount() {
        return listSV.size();
    }

    public class SinhVienView extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView maSv,tenSV,namSinh,queQuan,namHoc;
        public SinhVienView(@NonNull View view) {
            super(view);
            tenSV=view.findViewById(R.id.tvTenSV);
            namSinh=view.findViewById(R.id.tvNamSinh);
            queQuan=view.findViewById(R.id.tvQueQuan);
            namHoc=view.findViewById(R.id.tvNamHoc);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (svListener!=null){
                svListener.onSVclick(view,getAdapterPosition());
            }
        }
    }
    public interface SVListener{
        void onSVclick(View view, int position);
    }
}
