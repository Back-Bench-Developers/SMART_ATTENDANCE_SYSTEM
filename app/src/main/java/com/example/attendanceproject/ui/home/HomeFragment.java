package com.example.attendanceproject.ui.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.attendanceproject.Api;
import com.example.attendanceproject.ApiInterface;
import com.example.attendanceproject.Data;
import com.example.attendanceproject.Login;
import com.example.attendanceproject.R;
import com.example.attendanceproject.Registration;
import com.example.attendanceproject.SessionManagement;
import com.example.attendanceproject.StudentData;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment  {

    private HomeViewModel homeViewModel;
    TextInputLayout Add_User,Add_User_rollnum;
    Spinner department,year,section;
    Button Save;

    SharedPreferences.Editor editor;
    SharedPreferences sharedpreferences;
    String department1,year1,sec,dept;

    public static final String[] department_name={"ECE","EEE","IT","CSE","MECH","AUTO"};
    public static final String[] year_name={"I","II","III","IV"};
    public static final String[] section_name={"A","B","C"};

    String name;
    String rollnum;
    String createdby;

    /*@Override
    public void onStart() {
        super.onStart();
        checkSession();
    }

    private void checkSession() {

    }
*/
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });*/

        Add_User=root.findViewById(R.id.Add_User);
        Add_User_rollnum=root.findViewById(R.id.Add_User_rollnum);
//        department=(Spinner)root.findViewById(R.id.department);
        year=(Spinner)root.findViewById(R.id.year);
        section=(Spinner)root.findViewById(R.id.section);
        Save=(Button)root.findViewById(R.id.Save);

        SessionManagement sessionManagement=new SessionManagement(root.getContext());
        dept=sessionManagement.getdeptname();
//        Toast.makeText(root.getContext(),"dept in dashboard is : => "+dept,Toast.LENGTH_LONG).show();
//        Login login=new Login();
//       createdby=login.getName(getContext());



       /* ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_spinner_item,department_name);
        department.setAdapter(arrayAdapter);

        department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    department1="ECE";
                }
                if (position==1)
                {
                    department1="EEE";
                }
                if (position==2)
                {
                    department1="IT";
                }
                if (position==3)
                {
                    department1="CSE";
                }
                if (position==4)
                {
                    department1="MECH";
                }
                if (position==5)
                {
                    department1="AUTO";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                department1="ECE";
            }
        });*/

        department1=dept;

        ArrayAdapter<String> arrayAdapter1 =new ArrayAdapter<String>(root.getContext(),R.layout.userspinner,year_name);
        year.setAdapter(arrayAdapter1);

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    year1="I";
                }
                if (position==1)
                {
                    year1="II";
                }
                if (position==2)
                {
                    year1="III";
                }
                if (position==3)
                {
                    year1="IV";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<String>(root.getContext(),R.layout.spinnerview,section_name);
        section.setAdapter(arrayAdapter2);

        section.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    sec="A";
                }
                if (position==1)
                {
                    sec="B";
                }
                if (position==2)
                {
                    sec="C";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name =Add_User.getEditText().getText().toString();
                rollnum=Add_User_rollnum.getEditText().getText().toString();

                Toast.makeText(root.getContext(),createdby+" "+name+" "+rollnum+" "+department1+" "+year1+" "+sec,Toast.LENGTH_LONG).show();
                ApiInterface apiInterface= Api.getClient().create(ApiInterface.class);
//                Data data=new Data(name,dob,mail,password,confirmpassword,gender);
                StudentData studentData=new StudentData(name,rollnum,department1,year1,sec);
//                Call<StudentData> call=apiInterface.postStudentDetails(studentData);
                Call<StudentData> call = null;
                if (dept.equals("ECE"))
                {
                    call=apiInterface.posteceStudentDetails(studentData);
                }
                else if (dept.equals("EEE"))
                {
                    call=apiInterface.posteeeStudentDetails(studentData);
                }
                else if (dept.equals("CSE"))
                {
                    call=apiInterface.postcseStudentDetails(studentData);
                }
                else if (dept.equals("IT"))
                {
                    call=apiInterface.postitStudentDetails(studentData);
                }
                else if (dept.equals("MECH"))
                {
                    call=apiInterface.postmechStudentDetails(studentData);
                }
                else if (dept.equals("AUTO"))
                {
                    call=apiInterface.postautoStudentDetails(studentData);
                }

                call.enqueue(new Callback<StudentData>() {
                    @Override
                    public void onResponse(@NotNull Call<StudentData> call, @NotNull Response<StudentData> response) {
                        Toast.makeText(root.getContext(),"hai"+" "+name+" ",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<StudentData> call, Throwable t) {
                        Toast.makeText(root.getContext(),t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        Log.e("msg",t.getLocalizedMessage());
                        call.cancel();
                    }
                });
            }
        });
        return root;
    }
}