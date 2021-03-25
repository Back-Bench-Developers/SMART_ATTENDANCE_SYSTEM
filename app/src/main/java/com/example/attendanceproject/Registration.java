package com.example.attendanceproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {

    TextInputLayout Register_User_name,Register_User_mail,Register_User_Password,Register_User_ConfirmPassword;
    Button register_btn;
    RadioGroup Radio_gender;
    RadioButton male,female;
    AlertDialog.Builder builder;

    TextInputEditText rname,rmail,rpass,rcpass,rdob;
    int in=0;

    String name,mail,password,confirmpassword,dob,coyear,cosec;
    String gender,department_1,staffpost;
    public static final String[] department_name={"ECE","EEE","IT","CSE","MECH","AUTO"};
    public static final String[] staffPosting={"HOD","Mendor","Co-Ordinator","none"};
    public static final String[] staffyear={"I","II","III","IV"};
    public static final String[] staffSec={"A","B","C"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Spinner department=(Spinner)findViewById(R.id.department1);
        Spinner staff_post=(Spinner)findViewById(R.id.staff_post);

        LinearLayout ll1=(LinearLayout)findViewById(R.id.ll1);
        LinearLayout ll2=(LinearLayout)findViewById(R.id.ll2);


        Spinner staff_post_year=(Spinner)findViewById(R.id.staff_post_year);
        Spinner staff_post_sec=(Spinner)findViewById(R.id.staff_post_sec);

        Register_User_name=findViewById(R.id.Register_User_name);
        Register_User_mail=findViewById(R.id.Register_User_mail);
        Register_User_Password=findViewById(R.id.Register_User_Password);
        Register_User_ConfirmPassword=findViewById(R.id.Register_User_ConfirmPassword);
//        Register_User_dob=findViewById(R.id.Register_User_dob);

        rname=(TextInputEditText)findViewById(R.id.rname);
        rmail=(TextInputEditText)findViewById(R.id.rmail);
        rpass=(TextInputEditText)findViewById(R.id.rpass);
        rcpass=(TextInputEditText)findViewById(R.id.rcpass);
//        rdob=(TextInputEditText)findViewById(R.id.rdob);

        register_btn= findViewById(R.id.register_btn);
        Radio_gender= findViewById(R.id.Radio_gender);
        male= findViewById(R.id.male);
        female= findViewById(R.id.female);

        builder=new AlertDialog.Builder(this);
//        name=rname.getEditableText().toString().trim();
//        mail=rmail.getEditableText().toString().trim();
//        password=rpass.getEditableText().toString().trim();
//        confirmpassword=rcpass.getEditableText().toString().trim();
//        dob=rdob.getEditableText().toString().trim();
//        name=rname.getEditableText().toString().trim();


//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String strDate = formatter.format(date);



    /*    register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//               Data d=new Data("ajith",strDate,"ajith@gmail.com","ajithkumar","ajithkumar",
//                       1);
//                Call<Data> call=apiInterface.postStudentDetails(d);
//                try {
//                    DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
//                    DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
//                    String inputDateStr="2013-06-24";
//                    Date date1 = inputFormat.parse(inputDateStr);
                    ApiInterface apiInterface=Api.getClient().create(ApiInterface.class);

//                    System.out.println("date1"+date1);
                Call<Data> call =apiInterface.registration("ajith","1999-03-01","ajith@gmail.com","ajithkumar","ajithkumar",
                        1);

                call.enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Registered failed",Toast.LENGTH_LONG).show();
                    }

                });
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
            }
        });*/

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,department_name);
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
        });

        ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinview1,staffPosting);
        staff_post.setAdapter(arrayAdapter1);

        staff_post.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    staffpost="HOD";
                    ll1.setVisibility(View.GONE);
                    ll2.setVisibility(View.GONE);
                    coyear="0";
                    cosec="0";
                }
                if (position==1)
                {
                    staffpost="Mendor";
                    ll1.setVisibility(View.GONE);
                    ll2.setVisibility(View.GONE);
                    coyear="0";
                    cosec="0";
                }
                if (position==2)
                {
                    staffpost="Co-Ordinator";
                    ll1.setVisibility(View.VISIBLE);
                    ll2.setVisibility(View.VISIBLE);
                }
                if (position==3)
                {
                    staffpost="none";
                    ll1.setVisibility(View.GONE);
                    ll2.setVisibility(View.GONE);
                    coyear="0";
                    cosec="0";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
//                department_1="ECE";
                staffpost="HOD";
            }
        });

       /* if (!staffpost.equals("Co-Ordinator"))
        {
            ll1.setVisibility(View.GONE);
            ll2.setVisibility(View.GONE);
        }*/
        if (staffpost!=null && in==1)
        {
            Toast.makeText(getApplicationContext(),"111",Toast.LENGTH_LONG).show();
            Log.i("msg","true");
            ll1.setVisibility(View.VISIBLE);
            ll2.setVisibility(View.VISIBLE);
        }

        ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinview2,staffyear);
        staff_post_year.setAdapter(arrayAdapter2);

        staff_post_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    coyear="I";
                }
                if (position==1)
                {
                    coyear="II";
                }
                if (position==2)
                {
                    coyear="III";
                }
                if (position==3)
                {
                    coyear="IV";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
//                department_1="ECE";
                coyear="I";
            }
        });

        ArrayAdapter<String> arrayAdapter3=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinview3,staffSec);
        staff_post_sec.setAdapter(arrayAdapter3);

        staff_post_sec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    cosec="A";
                }
                if (position==1)
                {
                    cosec="B";
                }
                if (position==2)
                {
                    cosec="C";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
//                department_1="ECE";
                cosec="A";
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"name"+name,Toast.LENGTH_LONG).show();
               if (isConnected(getApplicationContext()))
               {
                   boolean b;
                   b=checkuser();
                   if (b)
                   {
                       ApiInterface apiInterface=Api.getClient().create(ApiInterface.class);
                       Data data=new Data(name,department_1,mail,password,confirmpassword,gender,staffpost,coyear,cosec);
                       Call<Data> call=apiInterface.postStudentDetails(data);

                       call.enqueue(new Callback<Data>() {
                           @Override
                           public void onResponse(@NotNull Call<Data> call, @NotNull Response<Data> response) {
                               Toast.makeText(Registration.this,"hai"+" "+name+" "+mail,Toast.LENGTH_LONG).show();
                           }

                           @Override
                           public void onFailure(Call<Data> call, Throwable t) {
                               Toast.makeText(Registration.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                               Log.e("msg",t.getLocalizedMessage());
                               call.cancel();
                           }
                       });
                   }
                   if (!isConnected(getApplicationContext()))
                   {
                       builder.setMessage("please connect to the Internet to proceed further").setCancelable(false)
                               .setPositiveButton("connect", (dialog, which) -> startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS)))
                               .setNegativeButton("cancel", (dialog, which) -> dialog.cancel());
                       AlertDialog alert = builder.create();
                       alert.show();

                   }
               }
            }

            private boolean checkuser() {
                mail=Register_User_mail.getEditText().getText().toString();
                password=Register_User_Password.getEditText().getText().toString();
                confirmpassword=Register_User_ConfirmPassword.getEditText().getText().toString();
//                dob=Register_User_dob.getEditText().getText().toString();
                name=Register_User_name.getEditText().getText().toString();
                if (male.isChecked())
                {
                    gender="1";
                }
                else if (female.isChecked())
                {
                    gender="2";
                }
                if (mail.length()>0)
                {
                    return true;
                }
                return false;
            }
        });

    }
    private boolean isConnected(Context applicationContext) {
        ConnectivityManager connectivityManager=(ConnectivityManager)applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wificonnect=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileconnect=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wificonnect!=null && wificonnect.isConnected()) || (mobileconnect!=null && mobileconnect.isConnected()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}