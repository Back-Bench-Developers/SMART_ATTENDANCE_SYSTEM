package com.example.attendanceproject.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendanceproject.GetStudentData;
import com.example.attendanceproject.R;
import com.example.attendanceproject.StudentYear;

public class EcedeptAdapter extends RecyclerView.Adapter<EcedeptAdapter.UserViewHolderEce>{
    Context context;
    StudentYear userListresponseData;
    String yr;

    public EcedeptAdapter(Context context, StudentYear userListresponseData, String yr)
    {
        this.context=context;
        this.userListresponseData=userListresponseData;
        this.yr=yr;
    }

    @NonNull
    @Override
    public UserViewHolderEce onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.deptlist,null);
        UserViewHolderEce userViewHolderEce=new UserViewHolderEce(view);
        return userViewHolderEce;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolderEce holder, int position) {
            holder.card_name_dept.setText(userListresponseData.getYearI().get(position).getStdname());
            holder.card_roll_dept.setText(userListresponseData.getYearI().get(position).getRollnum());
            holder.card_year_dept.setText(userListresponseData.getYearI().get(position).getSection1());
            holder.carddeptlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(v.getContext(),AttendanceSheet.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    i.putExtra("rollnum",userListresponseData.getYearI().get(position).getRollnum());
                    i.putExtra("name",userListresponseData.getYearI().get(position).getStdname());
                    context.getApplicationContext().startActivity(i);
                }
            });
    }

    @Override
    public int getItemCount() {
        return userListresponseData.getYearI().size();
    }

    public class UserViewHolderEce extends RecyclerView.ViewHolder
    {
        TextView card_name_dept,card_roll_dept,card_year_dept;
        LinearLayout carddeptlist;
        public UserViewHolderEce(@NonNull View itemView) {
            super(itemView);
            card_name_dept=(TextView)itemView.findViewById(R.id.card_name_dept);
            card_roll_dept=(TextView)itemView.findViewById(R.id.card_roll_dept);
            card_year_dept=(TextView)itemView.findViewById(R.id.card_year_dept);
            carddeptlist=(LinearLayout)itemView.findViewById(R.id.carddeptlist);
        }
    }

}
