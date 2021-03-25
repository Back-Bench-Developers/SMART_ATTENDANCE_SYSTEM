package com.example.attendanceproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.attendanceproject.Api;
import com.example.attendanceproject.ApiInterface;
import com.example.attendanceproject.GetStudentData;
import com.example.attendanceproject.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardEceDept extends AppCompatActivity {

    GetStudentData getStudentData;
    public static final String[] year_name={"I","II","III","IV"};
    Spinner year;
    String year1,dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_ece_dept);

       /* year=(Spinner)findViewById(R.id.yearbyece);
        dept=getIntent().getExtras().getString("Data");

        Toast.makeText(getApplicationContext(),"=="+dept+"==",Toast.LENGTH_LONG).show();
        System.out.println(dept);
        Log.e("masg",dept);

        ArrayAdapter<String> arrayAdapter1 =new ArrayAdapter<String>(getApplicationContext(),R.layout.userspinner,year_name);
        year.setAdapter(arrayAdapter1);

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    year1="I";
                    loadview(year1);
                }
                else if (position==1)
                {
                    year1="II";
                    loadview(year1);
                }
                else if (position==2)
                {
                    year1="III";
                    loadview(year1);
                }
                else if (position==3)
                {
                    year1="IV";
                    loadview(year1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void loadview(String year1) {
        ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
        Call<GetStudentData> call=null;
        if (dept.equals("ECE"))
        {
            call=apiInterface.getbysectionece(year1);
        }
        else if (dept.equals("EEE"))
        {
            call=apiInterface.getbysectioneee(year1);
        }
        else if (dept.equals("IT"))
        {
            call=apiInterface.getbysectionit(year1);
        }
        else if (dept.equals("CSE"))
        {
            call=apiInterface.getbysectioncse(year1);
        }
        else if (dept.equals("AUTO"))
        {
            call=apiInterface.getbysectionauto(year1);
        }
        else if (dept.equals("MECH"))
        {
            call=apiInterface.getbysectionmech(year1);
        }

            call.enqueue(new Callback<GetStudentData>() {
                private LinearLayoutManager VerticalLinierLayout;
            @Override
            public void onResponse(Call<GetStudentData> call, Response<GetStudentData> response) {
                getStudentData=response.body();
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
                RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclercardEceView);
                recyclerView.setLayoutManager(linearLayoutManager);

                EcedeptAdapter cardEceDept=new EcedeptAdapter(getApplicationContext(),getStudentData);
                VerticalLinierLayout=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,true);
                recyclerView.setLayoutManager(VerticalLinierLayout);
                recyclerView.setAdapter(cardEceDept);
            }

            @Override
            public void onFailure(Call<GetStudentData> call, Throwable t) {

            }
        });*/
    }
}