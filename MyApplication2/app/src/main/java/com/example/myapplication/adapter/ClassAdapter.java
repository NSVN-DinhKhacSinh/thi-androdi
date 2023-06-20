package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Lop;

import java.util.ArrayList;
import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassView>{
    private List<Lop> listClass;

    private  ClassListener classListener;

    public ClassAdapter(){
        this.listClass= new ArrayList<>();
    }

    public void setListClass(List<Lop> listClass) {

        this.listClass = listClass;
        notifyDataSetChanged();
    }

    public void setClassListener(ClassListener classListener) {
        this.classListener = classListener;
    }

    public Lop getLop(int position){
        return listClass.get(position);
    }

    @NonNull
    @Override
    public ClassView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lop,parent,false);
        return new ClassView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassView holder, int position) {
        Lop lop= listClass.get(position);
        holder.tenClass.setText(lop.getTen_lop());
        holder.moTa.setText(lop.getMo_ta());
    }

    @Override
    public int getItemCount() {
        return listClass.size();
    }




    public class ClassView extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tenClass, moTa;
        public ClassView(@NonNull View itemView) {
            super(itemView);
            tenClass=itemView.findViewById(R.id.tvTenClass);
            moTa=itemView.findViewById(R.id.tvMoTa);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(classListener!=null ){
                classListener.onClClick(view,getAdapterPosition());
            }
        }
    }

    public interface ClassListener{
        void onClClick(View view,int position);
    }
}
