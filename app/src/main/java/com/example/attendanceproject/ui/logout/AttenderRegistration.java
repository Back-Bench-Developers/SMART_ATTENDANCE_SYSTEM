package com.example.attendanceproject.ui.logout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.attendanceproject.Api;
import com.example.attendanceproject.ApiInterface;
import com.example.attendanceproject.AttenderData;
import com.example.attendanceproject.R;
import com.example.attendanceproject.SessionManagement;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttenderRegistration extends AppCompatActivity {
    public static final String[] department_name={"ECE","EEE","IT","CSE","MECH","AUTO"};
    String department_1,name,rollnum,password,dept;
    TextInputLayout User_name_attender,User_roll_attender,User_pass_attender;
    Button Attender_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attender_registration);

//        Spinner department=(Spinner)findViewById(R.id.departmentattender);
        User_name_attender=findViewById(R.id.User_name_attender);
        User_roll_attender=findViewById(R.id.User_roll_attender);
        User_pass_attender=findViewById(R.id.User_pass_attender);
        Attender_submit=findViewById(R.id.Attender_submit);

        SessionManagement sessionManagement=new SessionManagement(getApplicationContext());
        dept=sessionManagement.getdeptname();

      /*  ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,department_name);
        department.setAdapter(arrayAdapter);

        department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position==0)
                {
                    department_1="ECE";
                }
                if (position==1)
                {
                    department_1="EEE";
                }
                if (position==2)
                {
                    department_1="IT";
                }
                if (position==3)
                {
                    department_1="CSE";
                }
                if (position==4)
                {
                    department_1="MECH";
                }
                if (position==5)
                {
                    department_1="AUTO";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                department_1="ECE";
            }
        });*/

        department_1=dept;

        Attender_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b;
                b=checkusers();
                if (b)
                {
                    ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
                    AttenderData attenderData=new AttenderData(name,rollnum,department_1,password);
                    Call<AttenderData> call=apiInterface.postattenderdetails(attenderData);
                    call.enqueue(new Callback<AttenderData>() {
                        @Override
                        public void onResponse(Call<AttenderData> call, Response<AttenderData> response) {
                            Toast.makeText(getApplicationContext(),"registered successfully",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<AttenderData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }

    private boolean checkusers() {
        boolean b=true;
        name=User_name_attender.getEditText().getText().toString();
        rollnum=User_roll_attender.getEditText().getText().toString();
        password=User_pass_attender.getEditText().getText().toString();
        return b;
    }
}