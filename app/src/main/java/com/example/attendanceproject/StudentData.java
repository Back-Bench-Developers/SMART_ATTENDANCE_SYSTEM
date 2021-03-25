package com.example.attendanceproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentData {
    @SerializedName("stdname")
    @Expose
    public String stdname;
    @SerializedName("rollnum")
    @Expose
    private String rollnum;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("stdyear")
    @Expose
    private String stdyear;
    @SerializedName("section1")
    @Expose
    private String section1;

    public  StudentData(String stdname, String rollnum, String department, String stdyear, String section1)
    {
        this.stdname=stdname;
        this.rollnum=rollnum;
        this.department=department;
        this.stdyear=stdyear;
        this.section1=section1;
    }

    public String getRollnum() {
        return rollnum;
    }

    public String getDepartment() {
        return department;
    }

    public String getSection1() {
        return section1;
    }

    public String getStdname() {
        return stdname;
    }

    public String getStdyear() {
        return stdyear;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRollnum(String rollnum) {
        this.rollnum = rollnum;
    }

    public void setSection1(String section1) {
        this.section1 = section1;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }

    public void setStdyear(String stdyear) {
        this.stdyear = stdyear;
    }
}
