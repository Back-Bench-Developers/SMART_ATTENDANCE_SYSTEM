package com.example.attendanceproject.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendanceproject.Api;
import com.example.attendanceproject.ApiInterface;
import com.example.attendanceproject.Login;
import com.example.attendanceproject.R;
import com.example.attendanceproject.SessionManagement;
import com.example.attendanceproject.Student;
import com.example.attendanceproject.StudentAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    String text;
    Student student;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
       /* final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        LinearLayout search_view,slideshow;
        EditText search_text;
        ImageButton search_image,cancel_image1;

        search_view=(LinearLayout)root.findViewById(R.id.search_view);
        slideshow=root.findViewById(R.id.slideshow);
        search_text=(EditText) root.findViewById(R.id.search_text);
        search_image=(ImageButton) root.findViewById(R.id.search_image);
        cancel_image1=(ImageButton)root.findViewById(R.id.cancel_image1);

        SessionManagement sessionManagement=new SessionManagement(root.getContext());
        String post=sessionManagement.getPosting();
//        Toast.makeText(getContext(),"post  =  "+post,Toast.LENGTH_LONG).show();

        if (!post.equals("HOD"))
        {
            slideshow.setVisibility(View.GONE);
            Toast.makeText(getContext(),"You dont have access",Toast.LENGTH_LONG).show();
        }
        else
        {
            RecyclerView recycle_search=(RecyclerView)root.findViewById(R.id.recycle_search);
            ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
            search_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text=search_text.getText().toString();
                    search_image.setVisibility(View.GONE);
                    cancel_image1.setVisibility(View.VISIBLE);

                    cancel_image1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            text=null;
                            Toast.makeText(root.getContext(),text,Toast.LENGTH_LONG).show();
                            search_text.setText(null);
                            search_image.setVisibility(View.VISIBLE);
                            cancel_image1.setVisibility(View.GONE);
                            recycle_search.setVisibility(View.GONE);
                        }
                    });
                    Toast.makeText(root.getContext(),text,Toast.LENGTH_LONG).show();
                    recycle_search.setVisibility(View.VISIBLE);
                    Call<Student> call=apiInterface.getstudentdetails(text,"ECE");
                    call.enqueue(new Callback<Student>() {
                        private LinearLayoutManager VerticalLinierLayout;
                        @Override
                        public void onResponse(Call<Student> call, Response<Student> response) {
                            student=response.body();

                            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(root.getContext());
                            recycle_search.setLayoutManager(linearLayoutManager);

                            StudentAdapter studentAdapter=new StudentAdapter(root.getContext(),student);
                            VerticalLinierLayout=new LinearLayoutManager(root.getContext(),LinearLayoutManager.VERTICAL,true);
                            recycle_search.setLayoutManager(VerticalLinierLayout);
                            recycle_search.setAdapter(studentAdapter);
                        }

                        @Override
                        public void onFailure(Call<Student> call, Throwable t) {

                        }
                    });
                }
            });


        }

        return root;
    }
}