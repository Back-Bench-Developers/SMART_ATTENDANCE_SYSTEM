package com.example.attendanceproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class DeptAdapter extends RecyclerView.Adapter<DeptAdapter.Viewholder> {
    Context context;
    GetStudentData userListresponsedata;

    public DeptAdapter(Context context, GetStudentData userListresponsedata) {
        this.context = context;
        this.userListresponsedata = userListresponsedata;
    }



    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cardlist,null);
        Viewholder viewholder=new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.card_name.setText(userListresponsedata.getData().get(position).getStdname());
        holder.card_roll.setText(userListresponsedata.getData().get(position).getRollnum());
    }

    @Override
    public int getItemCount() {
        return userListresponsedata.getData().size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder
    {
        TextView card_name,card_roll;
        LinearLayout cardlinear;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            this.card_name=(TextView)itemView.findViewById(R.id.card_name);
            this.card_roll=(TextView)itemView.findViewById(R.id.card_roll);
            this.cardlinear=(LinearLayout)itemView.findViewById(R.id.cardlinear);
        }
    }
}
