package com.example.attendanceproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.attendanceproject.Api;
import com.example.attendanceproject.ApiInterface;
import com.example.attendanceproject.DeptAdapter;
import com.example.attendanceproject.GetStudentData;
import com.example.attendanceproject.R;
import com.example.attendanceproject.SessionManagement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cardece extends AppCompatActivity {

    String dept;
    GetStudentData getStudentData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardece);


      /*  dept=getIntent().getExtras().getString("Data");


        ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
        Call<GetStudentData> call=null;
        if (dept.equals("ECE"))
        {
            call=apiInterface.getecedata();
        }
        else if (dept.equals("EEE"))
        {
            call=apiInterface.geteeedata();
        }
        else if (dept.equals("IT"))
        {
            call=apiInterface.getitdata();
        }
        else if (dept.equals("CSE"))
        {
            call=apiInterface.getcsedata();
        }
        else if (dept.equals("MECH"))
        {
            call=apiInterface.getmechdata();
        }
        else if (dept.equals("AUTO"))
        {
            call=apiInterface.getautodata();
        }
        call.enqueue(new Callback<GetStudentData>() {
            private LinearLayoutManager VerticalLinierLayout;
            @Override
            public void onResponse(Call<GetStudentData> call, Response<GetStudentData> response) {
                getStudentData=response.body();
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
                RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclercardView);
                recyclerView.setLayoutManager(linearLayoutManager);

                DeptAdapter deptAdapter=new DeptAdapter(getApplicationContext(),getStudentData);
                VerticalLinierLayout=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(VerticalLinierLayout);
                recyclerView.setAdapter(deptAdapter);
            }

            @Override
            public void onFailure(Call<GetStudentData> call, Throwable t) {

            }
        });*/
    }
}