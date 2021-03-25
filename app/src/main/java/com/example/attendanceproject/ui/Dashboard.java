package com.example.attendanceproject.ui;

import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendanceproject.Api;
import com.example.attendanceproject.ApiInterface;
import com.example.attendanceproject.GetStudentData;
import com.example.attendanceproject.R;
import com.example.attendanceproject.Student;
import com.example.attendanceproject.Studentcount;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends Fragment {

    private DashboardViewModel mViewModel;
    Studentcount userListResopnseData;
    SwipeRefreshLayout swipeLayout;
    GetStudentData getStudentData;;

    CardView cardece,cardeee,cardit,cardcse,cardmech,cardauto;
    TextView ececount,eeecount,itcount,csecount,mechcount,autocount;
    public static Dashboard newInstance() {
        return new Dashboard();
    }



  /*  @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.dashboard_fragment, container, false);
      *//*  ececount=(TextView)view.findViewById(R.id.ececount);
        eeecount=(TextView)view.findViewById(R.id.eeecount);
        itcount=(TextView)view.findViewById(R.id.itcount);
        csecount=(TextView)view.findViewById(R.id.csecount);
        mechcount=(TextView)view.findViewById(R.id.mechcount);
        autocount=(TextView)view.findViewById(R.id.autocount);
//        swipeLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipe_container);

        cardece=(CardView)view.findViewById(R.id.cardece);
        cardeee=(CardView)view.findViewById(R.id.cardeee);
        cardit=(CardView)view.findViewById(R.id.cardit);
        cardauto=(CardView)view.findViewById(R.id.cardauto);
        cardcse=(CardView)view.findViewById(R.id.cardcse);
        cardmech=(CardView)view.findViewById(R.id.cardmech);

//        String text=getArguments().getString("msg");
//        Toast.makeText(view.getContext(),"dept in dashboard is : => "+text,Toast.LENGTH_LONG).show();

        ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
        Studentcount studentcount=new Studentcount();
        Call<Studentcount> call=apiInterface.getcount();

        call.enqueue(new Callback<Studentcount>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Studentcount> call, Response<Studentcount> response) {
                userListResopnseData=response.body();
                assert userListResopnseData != null;
                ececount.setText(userListResopnseData.getCount().get(0).getEce().toString());
                eeecount.setText(userListResopnseData.getCount().get(0).getEee().toString());
                itcount.setText(userListResopnseData.getCount().get(0).getIt().toString());
                csecount.setText(userListResopnseData.getCount().get(0).getCse().toString());
                mechcount.setText(userListResopnseData.getCount().get(0).getMech().toString());
                autocount.setText(userListResopnseData.getCount().get(0).getAuto().toString());
            }

            @Override
            public void onFailure(Call<Studentcount> call, Throwable t) {

            }
        });

       *//**//* swipeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countfinder();
            }
        });*//**//*

        cardece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CardEceDept.class);
                intent.putExtra("Data","ECE");
                startActivity(intent);
            }
        });

        cardeee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CardEceDept.class);
                intent.putExtra("Data","EEE");
                startActivity(intent);
            }
        });

        cardit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CardEceDept.class);
                intent.putExtra("Data","IT");
                startActivity(intent);
            }
        });

        cardcse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CardEceDept.class);
                intent.putExtra("Data","CSE");
                startActivity(intent);
            }
        });

        cardmech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CardEceDept.class);
                intent.putExtra("Data","MECH");
                startActivity(intent);
            }
        });

        cardauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CardEceDept.class);
                intent.putExtra("Data","AUTO");
                startActivity(intent);
            }
        });*//*





       *//* final SwipeRefreshLayout pullToRefresh = view.findViewById(R.id.swipe_container);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onRefresh() {
                // your code
                Toast.makeText(view.getContext(),"refresh",Toast.LENGTH_LONG).show();
                pullToRefresh.setRefreshing(false);
            }
        });*//*

        return view;
    }*/



    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        // TODO: Use the ViewModel
    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.dashboard_fragment, container, false);
        CardView card1st,card2st,card3st,card4st;
        TextView firstyearcnt,secondyearcnt,thirdyearcnt,fourthyearcnt;


        card1st=(CardView)view.findViewById(R.id.card1st);
        card2st=(CardView)view.findViewById(R.id.card2st);
        card3st=(CardView)view.findViewById(R.id.card3st);
        card4st=(CardView)view.findViewById(R.id.card4st);

        firstyearcnt=view.findViewById(R.id.firstyearcnt);
        secondyearcnt=view.findViewById(R.id.secondyearcnt);
        thirdyearcnt=view.findViewById(R.id.thirdyearcnt);
        fourthyearcnt=view.findViewById(R.id.fourthyearcnt);

        ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
        Call<GetStudentData> call=apiInterface.getStudentdata("0");
        call.enqueue(new Callback<GetStudentData>() {
            @Override
            public void onResponse(Call<GetStudentData> call, Response<GetStudentData> response) {
                getStudentData=response.body();
                assert getStudentData != null;
                firstyearcnt.setText(getStudentData.getCount().get(0).getEce());
                secondyearcnt.setText(getStudentData.getCount().get(0).getEce2());
                thirdyearcnt.setText(getStudentData.getCount().get(0).getEce3());
                fourthyearcnt.setText(getStudentData.getCount().get(0).getEce4());
            }

            @Override
            public void onFailure(Call<GetStudentData> call, Throwable t) {

            }
        });

        card1st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(view.getContext(),NewCardview.class);
                intent.putExtra("yer","1");
                startActivity(intent);
            }
        });

        card2st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(view.getContext(),NewCardview.class);
                intent.putExtra("yer","2");
                startActivity(intent);
            }
        });
        card3st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(view.getContext(),NewCardview.class);
                intent.putExtra("yer","3");
                startActivity(intent);
            }
        });

        card4st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(view.getContext(),NewCardview.class);
                intent.putExtra("yer","4");
                startActivity(intent);
            }
        });

        return view;
    }
}