package com.example.attendanceproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttenderData {
    @SerializedName("stdname")
    @Expose
    public String stdname;
    @SerializedName("rollnum")
    @Expose
    private String rollnum;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("password_")
    @Expose
    private String password_;

    public AttenderData(String stdname, String rollnum, String department, String password_) {
        this.stdname = stdname;
        this.rollnum = rollnum;
        this.department = department;
        this.password_ = password_;
    }

    public String getStdname() {
        return stdname;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }

    public String getRollnum() {
        return rollnum;
    }

    public void setRollnum(String rollnum) {
        this.rollnum = rollnum;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword_() {
        return password_;
    }

    public void setPassword_(String password_) {
        this.password_ = password_;
    }
}
