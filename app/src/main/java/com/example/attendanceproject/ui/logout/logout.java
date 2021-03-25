package com.example.attendanceproject.ui.logout;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.attendanceproject.Api;
import com.example.attendanceproject.ApiInterface;
import com.example.attendanceproject.Attendancedata;
import com.example.attendanceproject.Login;
import com.example.attendanceproject.R;
import com.example.attendanceproject.SessionManagement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class logout extends Fragment {

    private LogoutViewModel mViewModel;
    Button logoutbtn,reset,New_Account,Attendance;

    public static logout newInstance() {
        return new logout();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.logout_fragment, container, false);

        logoutbtn=view.findViewById(R.id.logoutbtn);
        reset=view.findViewById(R.id.reset);
        New_Account=view.findViewById(R.id.New_Account);
        Attendance=view.findViewById(R.id.Attendance);
        Attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
                Call<Attendancedata> call=apiInterface.insertdata("name");
                call.enqueue(new Callback<Attendancedata>() {
                    @Override
                    public void onResponse(Call<Attendancedata> call, Response<Attendancedata> response) {

                    }

                    @Override
                    public void onFailure(Call<Attendancedata> call, Throwable t) {

                    }
                });
            }
        });
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionManagement sessionManagement=new SessionManagement(view.getContext());
                sessionManagement.removeSession();

                movetoLogin();
            }

            private void movetoLogin() {
                Intent intent=new Intent(view.getContext(), Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        New_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(view.getContext(),AttenderRegistration.class);
                startActivity(intent);
            }
        });
        return view;
    }

   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LogoutViewModel.class);
        // TODO: Use the ViewModel
    }*/

}