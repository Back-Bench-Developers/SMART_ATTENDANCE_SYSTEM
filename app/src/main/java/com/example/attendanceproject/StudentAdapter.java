package com.example.attendanceproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{

    Context context;
    Student student1;
    String attendername;
    public StudentAdapter(Context context, Student student1)
    {
        this.context=context;
        this.student1=student1;
        this.attendername=attendername;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.studentlist,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtname.setText(student1.getStudentdata().get(position).getStdname());
        holder.txtroll.setText(student1.getStudentdata().get(position).getRollnum());
        holder.txtsec.setText(student1.getStudentdata().get(position).getSection1());
        holder.txtyear.setText(student1.getStudentdata().get(position).getStdyear());

        holder.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
                String s=student1.getStudentdata().get(position).getRollnum();
                Attendancedata1 attendancedata1=new Attendancedata1(student1.getStudentdata().get(position).getRollnum(),"1");
                Call<Attendancedata1> call=apiInterface.updatedata(attendancedata1);
                call.enqueue(new Callback<Attendancedata1>() {
                    @Override
                    public void onResponse(Call<Attendancedata1> call, Response<Attendancedata1> response) {
//                        Toast.makeText(context,"success",Toast.LENGTH_LONG).show();
                        Toast.makeText(context,"rollnum"+student1.getStudentdata().get(position).getRollnum(),Toast.LENGTH_LONG).show();
                        Log.e("roll",student1.getStudentdata().get(position).getRollnum());
                        if (response.isSuccessful())
                        {
                            Toast.makeText(context,"success",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(context,"  "+response.errorBody(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Attendancedata1> call, Throwable t) {
//                        Toast.makeText(context,"failiure",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return student1.getStudentdata().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
       public TextView txtname,txtroll,txtyear,txtsec;
       public Spinner department1;
       public Button Add;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtname=(TextView)itemView.findViewById(R.id.txtname);
            txtroll=(TextView)itemView.findViewById(R.id.txtroll);
            txtyear=(TextView)itemView.findViewById(R.id.txtyear);
            txtsec=(TextView)itemView.findViewById(R.id.txtsec);

            department1=(Spinner)itemView.findViewById(R.id.department1);
            Add=(Button)itemView.findViewById(R.id.Add);
        }
    }
}
