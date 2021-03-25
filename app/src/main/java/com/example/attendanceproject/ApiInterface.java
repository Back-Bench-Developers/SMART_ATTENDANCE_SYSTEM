package com.example.attendanceproject;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {



    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("/Attendance/insert.php")
    Call<Data> registration(@Field("user_name") String user_name,
                            @Field("dob") String dob,
                            @Field("emailid") String emailid,
                            @Field("pass_word") String pass_word,
                            @Field("confirmpassword") String confirmpassword,
                            @Field("gender") String gender
                            );


    @GET("/Attendance/readececount.php")
    Call<Studentcount> getcount();

    @GET("/Attender/product/studentcount.php?")
    Call<GetStudentData> getStudentdata(@Query("flag") String flag);

    @GET("/Attender/product/studentcount.php?")
    Call<StudentYear> getStudentdatabyyear(@Query("flag") String flag);

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("/Attender/product/createAttendance.php")
    Call<Attendancedata> insertdata(@Field("stdname") String stdname);

    @Headers("Accept: application/json")
    @PUT("/Attender/product/updateAttendance.php")
    Call<Attendancedata1> updatedata(@Body Attendancedata1 a);


    @GET("/api/product/read_one.php?")
    Call<GetStudentData> getbysectionece(@Query("stdyear") String stdyear);

    @GET("/Attender/product/attendancesheet.php?")
    Call<Attendancedata2> getsheet(@Query("rollnum") String rollnum);

    @GET("/Attender/product/read_studentdata.php?")
    Call<Student> getstudentdetails(@Query("rollnum") String rollnum,@Query("department") String department);

    @GET("/api/product/readoneece.php?")
    Call<GetStudentData> getbysectioneee(@Query("stdyear") String stdyear);

    @GET("/api/product/readoneit.php?")
    Call<GetStudentData> getbysectionit(@Query("stdyear") String stdyear);

    @GET("/api/product/read_cse.php?")
    Call<GetStudentData> getbysectioncse(@Query("stdyear") String stdyear);

    @GET("/api/product/read_auto.php?")
    Call<GetStudentData> getbysectionauto(@Query("stdyear") String stdyear);

    @GET("/api/product/read_mech.php?")
    Call<GetStudentData> getbysectionmech(@Query("stdyear") String stdyear);


    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("/api/product/create.php")
    Call<Data> registrationname(@Field("user_name") String user_name,
                            @Field("dob") String dob,
                            @Field("emailid") String emailid,
                            @Field("pass_word") String pass_word,
                            @Field("confirmpassword") String confirmpassword,
                            @Field("gender") String gender
    );

    @Headers("Accept: application/json")
    @POST("/api/product/create.php")
    Call<Data> postStudentDetails(@Body Data d );

    @Headers("Accept: application/json")
    @POST("/api/product/postStudent.php")
    Call<StudentData> postStudentDetails(@Body StudentData d );

    @Headers("Accept: application/json")
    @POST("/Attender/product/create.php")
    Call<AttenderData> postattenderdetails(@Body AttenderData data);

    @Headers("Accept: application/json")
    @POST("/api/product/postecestudent.php")
    Call<StudentData> posteceStudentDetails(@Body StudentData d );

    @Headers("Accept: application/json")
    @POST("/api/product/posteeestudent.php")
    Call<StudentData> posteeeStudentDetails(@Body StudentData d );

    @Headers("Accept: application/json")
    @POST("/api/product/postcsestudent.php")
    Call<StudentData> postcseStudentDetails(@Body StudentData d );

    @Headers("Accept: application/json")
    @POST("/api/product/postitstudent.php")
    Call<StudentData> postitStudentDetails(@Body StudentData d );

    @Headers("Accept: application/json")
    @POST("/api/product/postmechstudent.php")
    Call<StudentData> postmechStudentDetails(@Body StudentData d );

    @Headers("Accept: application/json")
    @POST("/api/product/postautostudent.php")
    Call<StudentData> postautoStudentDetails(@Body StudentData d );

    @GET("/Attendance/get.php")
    Call<GetData> getlist();

    @GET("/Attendance/studentsdetail.php")
    Call<GetStudentData> getdata();

    @GET("/Attendance/eceget.php")
    Call<GetStudentData> getecedata();

    @GET("/Attendance/eeeget.php")
    Call<GetStudentData> geteeedata();

    @GET("/Attendance/cseget.php")
    Call<GetStudentData> getcsedata();

    @GET("/Attendance/itget.php")
    Call<GetStudentData> getitdata();

    @GET("/Attendance/mechget.php")
    Call<GetStudentData> getmechdata();

    @GET("/Attendance/autoget.php")
    Call<GetStudentData> getautodata();




    @GET("/Attendance/getdata.php")
    Call<GetStudentData> getdatabydepartment(@Field("ecedata") String ecedata);

    /*
    @FormUrlEncoded
    @POST("/Android/post.php")
    Call<Data> add(
            @Field("user_name") String user_name,
            @Field("dob") String dob,
            @Field("emailid") String emailid
    );

    @FormUrlEncoded
    @POST("/Android/add.php")
    Call<Data> addallvalues(
            @Field("user_name") String user_name,
            @Field("dob") String dob,
            @Field("emailid") String emailid,
            @Field("pass_word") String pass_word,
            @Field("confirmpassword") String confirmpassword,
            @Field("gender") Integer gender
    );*/
}
