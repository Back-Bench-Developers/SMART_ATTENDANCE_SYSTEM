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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    ImageView imglogin;
    TextInputLayout User_name,User_Password;
    Button login_btn,signin_btn;
    AlertDialog.Builder builder;
    String name,password,dept,post;
    CheckBox checkboxlogin;



    @Override
    protected void onStart() {
        super.onStart();
        checkSession();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /*public String getName(Context context) {
        String username=null;
        SessionManagement sessionManagement=new SessionManagement(context);
        int isUserLoggedin=sessionManagement.getSession();

        if (isUserLoggedin!=-1)
        {
           username= sessionManagement.name;
        }
        return username;
    }*/

    private void checkSession() {
        SessionManagement sessionManagement=new SessionManagement(Login.this);
        int isUserLoggedin=sessionManagement.getSession();
//        int isUserdept=sessionManagement.getdept();

        if (isUserLoggedin!=-1)
        {
            dept=sessionManagement.getdeptname();
            moveToMainActivity(dept);
        }
        else
        {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_login);


        imglogin=(ImageView)findViewById(R.id.imglogin);
        User_name=findViewById(R.id.User_name);
        User_Password=findViewById(R.id.User_Password);
        login_btn=(Button)findViewById(R.id.login_btn);

        checkboxlogin=(CheckBox)findViewById(R.id.checkboxlogin);

        builder=new AlertDialog.Builder(this);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=User_name.getEditText().getText().toString();
                password=User_Password.getEditText().getText().toString();

                if (isConnected(getApplicationContext()))
                {
//                    startActivity(new Intent(MainActivity.this,Registration.class));
                    ApiInterface apiInterface=Api.getClient().create(ApiInterface.class);
                    Call<GetData> call=apiInterface.getlist();
                    call.enqueue(new Callback<GetData>() {
                        @Override
                        public void onResponse(Call<GetData> call, Response<GetData> response) {
                            GetData resources=response.body();
                            List<GetData.Datum> datumList=resources.getData();
                            for (GetData.Datum datum:datumList)
                            {
                                if (datum.getName().equals(name) && datum.getPass_word().equals(password))
                                {

                                    dept=datum.getDob();
                                    post=datum.getStaffPost();
                                    Log.i("post",post);
                                    if (checkboxlogin.isChecked())
                                    {
                                        User user=new User(1,name,dept,post);

                                        SessionManagement sessionManagement=new SessionManagement(Login.this);
                                        sessionManagement.saveSession(user);

                                        sessionManagement.savedept(user);
                                        sessionManagement.savepost(user);
                                        moveToMainActivity(dept);
                                    }
                                    else
                                    {
                                        Intent i=new Intent(Login.this,AddnewStudent.class);
                                        SessionManagement sessionManagement=new SessionManagement(Login.this);
                                        User user=new User(1,name,dept,post);
                                        sessionManagement.savedept(user);
                                        sessionManagement.savepost(user);
                                        i.putExtra("dept",datum.getDob());
                                        startActivity(i);
                                    }
                                }
                            }
                        }



                        @Override
                        public void onFailure(Call<GetData> call, Throwable t) {
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
        });



    }
    private void moveToMainActivity(String dept1) {
        Intent intent=new Intent(Login.this,AddnewStudent.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("dept",dept1);
        startActivity(intent);
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

    private void showCustomDialog() {

    }
}