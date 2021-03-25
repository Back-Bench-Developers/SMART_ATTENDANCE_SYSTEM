package com.example.attendanceproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {
    Context context;
    GetStudentData userListresponseData;
    String dept;
    View view;

    public UsersAdapter(Context context, GetStudentData userListresponseData)
    {
        this.context=context;
        this.userListresponseData=userListresponseData;
    }

    public  UsersAdapter(Context context, GetStudentData userListresponseData, String dept) {
        this.context=context;
        this.userListresponseData=userListresponseData;
        this.dept=dept;
    }


    public void ViewHolder(View v)
    {

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         view= LayoutInflater.from(context).inflate(R.layout.listview,null);
        UserViewHolder userViewHolder=new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {


            holder.listname.setText(userListresponseData.getData().get(position).getStdname());
            holder.listdept.setText(userListresponseData.getData().get(position).getDepartment());
            holder.listrollnum.setText(userListresponseData.getData().get(position).getRollnum());
            holder.listsec.setText(userListresponseData.getData().get(position).getSection1());
            holder.listyear.setText(userListresponseData.getData().get(position).getStdyear());

            holder.deleteimage.setImageResource(R.drawable.delete);
            holder.editImage.setImageResource(R.drawable.edit);

       /* else
        {
            holder.listname.setVisibility(View.GONE);
            holder.listdept.setVisibility(View.GONE);
            holder.listrollnum.setVisibility(View.GONE);
            holder.listsec.setVisibility(View.GONE);
            holder.listyear.setVisibility(View.GONE);

            holder.deleteimage.setVisibility(View.GONE);
            holder.recycleviewrelative.setVisibility(View.GONE);

            holder.editImage.setVisibility(View.GONE);

            holder.recycleviewrelative.removeAllViewsInLayout();


        }*/

    }

    @Override
    public int getItemCount() {
        return userListresponseData.getData().size();
    }



    public static class UserViewHolder extends RecyclerView.ViewHolder
    {
        public TextView listname,listrollnum,listdept,listyear,listsec;
        public ImageView editImage,deleteimage;
        public RelativeLayout recycleviewrelative;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            this.listname=(TextView)itemView.findViewById(R.id.listname);
            this.listrollnum=(TextView)itemView.findViewById(R.id.listrollnum);
            this.listdept=(TextView)itemView.findViewById(R.id.listdept);
            this.listyear=(TextView)itemView.findViewById(R.id.listyear);
            this.listsec=(TextView)itemView.findViewById(R.id.listsec);
            this.editImage=(ImageView)itemView.findViewById(R.id.editImage);
            this.deleteimage=(ImageView)itemView.findViewById(R.id.deleteimage);
            this.recycleviewrelative=(RelativeLayout)itemView.findViewById(R.id.recycleviewrelative);
        }
    }
}
