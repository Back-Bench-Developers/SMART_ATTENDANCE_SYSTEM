package com.example.attendanceproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Data {

//    @SerializedName("id")
//    @Expose
//    private String id;
    @SerializedName("user_name")
    @Expose
    public String user_name;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("emailid")
    @Expose
    private String emailid;
    @SerializedName("pass_word")
    @Expose
    private String pass_word;
    @SerializedName("confirmpassword")
    @Expose
    private String confirmpassword;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("staffPost")
    @Expose
    private String staffPost;
    @SerializedName("co_ordinator_year")
    @Expose
    private String co_ordinator_year;
    @SerializedName("co_ordinator_sec")
    @Expose
    private String co_ordinator_sec;

    public Data(String user_name, String dob, String emailid, String pass_word, String confirmpassword, String gender, String staffPost, String co_ordinator_year, String co_ordinator_sec) {
        this.user_name = user_name;
        this.dob = dob;
        this.emailid = emailid;
        this.pass_word = pass_word;
        this.confirmpassword = confirmpassword;
        this.gender = gender;
        this.staffPost = staffPost;
        this.co_ordinator_year = co_ordinator_year;
        this.co_ordinator_sec = co_ordinator_sec;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
    @Expose
    private String message;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @SerializedName("success")
    @Expose
    private boolean success;

    Data(String user_name, String dob, String emailid, String pass_word, String confirmpassword, String gender)
    {
        this.user_name=user_name;
        this.dob=dob;
        this.emailid=emailid;
        this.pass_word=pass_word;
        this.confirmpassword=confirmpassword;
        this.gender=gender;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getName() {
        return user_name;
    }

    public void setName(String name) {
        this.user_name = user_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassWord() {
        return pass_word;
    }

    public void setPassWord(String passWord) {
        this.pass_word = pass_word;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
