package com.example.attendanceproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private GetStudentData.Datum[] getStudentData;

    public ListAdapter(GetStudentData.Datum[] getStudentData)
    {
        this.getStudentData=getStudentData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.listview, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final GetStudentData.Datum getStudentData1=getStudentData[position];
        holder.listname.setText(getStudentData[position].getStdname());
        holder.listdept.setText(getStudentData[position].getDepartment());
        holder.listrollnum.setText(getStudentData[position].getRollnum());
        holder.listsec.setText(getStudentData[position].getSection1());
        holder.listyear.setText(getStudentData[position].getStdyear());

        holder.editImage.setImageResource(R.drawable.edit);
        holder.deleteimage.setImageResource(R.drawable.delete);
    }

    @Override
    public int getItemCount() {
        return getStudentData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView listname,listrollnum,listdept,listyear,listsec;
        public ImageView editImage,deleteimage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.listname=(TextView)itemView.findViewById(R.id.listname);
            this.listrollnum=(TextView)itemView.findViewById(R.id.listrollnum);
            this.listdept=(TextView)itemView.findViewById(R.id.listdept);
            this.listyear=(TextView)itemView.findViewById(R.id.listyear);
            this.listsec=(TextView)itemView.findViewById(R.id.listsec);
            this.editImage=(ImageView)itemView.findViewById(R.id.editImage);
            this.deleteimage=(ImageView)itemView.findViewById(R.id.deleteimage);
        }
    }
}
