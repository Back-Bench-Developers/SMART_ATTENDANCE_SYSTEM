package com.example.attendanceproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.attendanceproject.Api;
import com.example.attendanceproject.ApiInterface;
import com.example.attendanceproject.Attendancedata2;
import com.example.attendanceproject.R;
import com.example.attendanceproject.Student;
import com.example.attendanceproject.tableadapter;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendanceSheet extends AppCompatActivity {

    Attendancedata2 attendancedata2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_sheet);

        TextView sheet_name,sheet_num;

        RecyclerView sheetrecycle;

        sheet_name=(TextView)findViewById(R.id.sheet_name);
        sheet_num=(TextView)findViewById(R.id.sheet_num);

        Intent i=getIntent();
        String roll=i.getStringExtra("rollnum");
        sheet_num.setText(roll);
        sheet_name.setText(i.getStringExtra("name"));

        sheetrecycle=(RecyclerView)findViewById(R.id.sheetrecycle);

        ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
        Call<Attendancedata2> call=apiInterface.getsheet(roll);
        call.enqueue(new Callback<Attendancedata2>() {
            private LinearLayoutManager VerticalLinierLayout;
            @Override
            public void onResponse(Call<Attendancedata2> call, Response<Attendancedata2> response) {
                attendancedata2=response.body();
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
                sheetrecycle.setLayoutManager(linearLayoutManager);

                tableadapter studentAdapter=new tableadapter(getApplicationContext(),attendancedata2);
                VerticalLinierLayout=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,true);
                sheetrecycle.setLayoutManager(VerticalLinierLayout);
                sheetrecycle.setAdapter(studentAdapter);
            }

            @Override
            public void onFailure(Call<Attendancedata2> call, Throwable t) {

            }
        });
    }
}