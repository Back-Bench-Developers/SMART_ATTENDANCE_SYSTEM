package com.example.attendanceproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder builder;

    Button login_btn_main,signin_btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
        login_btn_main=findViewById(R.id.login_btn_main);
        signin_btn_login=findViewById(R.id.signin_btn_login);
        builder=new AlertDialog.Builder(this);

        signin_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected(getApplicationContext()))
                {
                    startActivity(new Intent(MainActivity.this,Registration.class));
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

        login_btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected(getApplicationContext())) {
                    startActivity(new Intent(getApplicationContext(), Login.class));
                }
                if (!isConnected(getApplicationContext()))
                {
                    builder.setMessage("please connect to the Internet to proceed further");
                    builder.setCancelable(false);
                    builder.setPositiveButton("connect", (dialog, which) -> {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    });
                    builder.setNegativeButton("cancel", (dialog, which) -> {
                        dialog.cancel();
                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
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