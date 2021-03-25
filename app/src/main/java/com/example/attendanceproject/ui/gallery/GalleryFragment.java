package com.example.attendanceproject.ui.gallery;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendanceproject.Api;
import com.example.attendanceproject.ApiInterface;
import com.example.attendanceproject.GetStudentData;
import com.example.attendanceproject.ListAdapter;
import com.example.attendanceproject.R;
import com.example.attendanceproject.SessionManagement;
import com.example.attendanceproject.StudentData;
import com.example.attendanceproject.User;
import com.example.attendanceproject.UsersAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment  {

    private GalleryViewModel galleryViewModel;
    GetStudentData userListresponseData;
    String dept;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        /*final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

       /* ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
        Call<GetStudentData> call=apiInterface.getdata();
        call.enqueue(new Callback<GetStudentData>() {
            @Override
            public void onResponse(Call<GetStudentData> call, Response<GetStudentData> response) {
                GetStudentData resources=response.body();
                GetStudentData.Datum[] studentData = new GetStudentData.Datum[0];
                ListAdapter adapter = null;
                List<GetStudentData.Datum> datumList=resources.getData();
                RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
                for (GetStudentData.Datum datum:datumList)
                {
                    studentData=new GetStudentData.Datum[]{
                        new GetStudentData.Datum(datum.getStdname(),datum.getRollnum(),datum.getDepartment()
                        ,datum.getStdyear(),datum.getSection1())
                    };
                    adapter = new ListAdapter(studentData);
                    recyclerView.setHasFixedSize(true);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(root.getContext());
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<GetStudentData> call, Throwable t) {

            }
        });*/

        final ProgressDialog progressDialog = new ProgressDialog(root.getContext());
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show();

        SessionManagement sessionManagement=new SessionManagement(root.getContext());
        dept=sessionManagement.getdeptname();

        ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
//        Call<GetStudentData> call=apiInterface.getdata();
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
                progressDialog.dismiss();
                userListresponseData =response.body();
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(root.getContext());
                RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(linearLayoutManager);

                UsersAdapter usersAdapter=new UsersAdapter(root.getContext(),userListresponseData,dept);
                VerticalLinierLayout=new LinearLayoutManager(root.getContext(),LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(VerticalLinierLayout);
                recyclerView.setAdapter(usersAdapter);
               /* DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
                dividerItemDecoration.setDrawable(ContextCompat.getDrawable(root.getContext(), R.drawable.divider));
                recyclerView.addItemDecoration(dividerItemDecoration);*/
            }

            @Override
            public void onFailure(Call<GetStudentData> call, Throwable t) {
                progressDialog.dismiss();
            }
        });


        return root;
    }
}