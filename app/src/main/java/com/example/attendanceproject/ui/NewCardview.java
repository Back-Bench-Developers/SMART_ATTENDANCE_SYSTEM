package com.example.attendanceproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.attendanceproject.Api;
import com.example.attendanceproject.ApiInterface;
import com.example.attendanceproject.R;
import com.example.attendanceproject.StudentYear;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewCardview extends AppCompatActivity {
    StudentYear studentYear;
    String yr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cardview);


        Intent intent=getIntent();
         yr=intent.getStringExtra("yer");

        RecyclerView deptrecycle;
        deptrecycle=findViewById(R.id.deptrecycle);

        EditText choosedept;
        ImageButton search_image1,cancel_image2;





        ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
        Call<StudentYear> call=apiInterface.getStudentdatabyyear(yr);
        call.enqueue(new Callback<StudentYear>() {
            private LinearLayoutManager VerticalLinierLayout;
            @Override
            public void onResponse(Call<StudentYear> call, Response<StudentYear> response) {
                studentYear=response.body();
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
                RecyclerView recyclerView=(RecyclerView)findViewById(R.id.deptrecycle);
                recyclerView.setLayoutManager(linearLayoutManager);

                EcedeptAdapter cardEceDept=new EcedeptAdapter(getApplicationContext(),studentYear,yr);
                VerticalLinierLayout=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(VerticalLinierLayout);
                recyclerView.setAdapter(cardEceDept);
            }

            @Override
            public void onFailure(Call<StudentYear> call, Throwable t) {

            }
        });



    }


}