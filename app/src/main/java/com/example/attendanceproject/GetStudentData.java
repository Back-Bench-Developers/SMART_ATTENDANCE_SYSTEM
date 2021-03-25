package com.example.attendanceproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetStudentData {
    private List<GetStudentData.Datum> data = null;

    public List<GetStudentData.Datum> getData() {
        return data;
    }

    public void setData(List<GetStudentData.Datum> data) {
        this.data = data;
    }

    public List<Count> count=null;

    public List<Count> getCount() {
        return count;
    }

    public void setCount(List<Count> count) {
        this.count = count;
    }

    public static class Datum {
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
        @SerializedName("count")
        @Expose
        private String count;


        public Datum(String stdname, String rollnum, String department, String stdyear, String section1)
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

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
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

    public static class Count {
        @SerializedName("ece")
        @Expose
        public String ece;

        @SerializedName("ece2")
        @Expose
        public String ece2;
        @SerializedName("ece3")
        @Expose
        public String ece3;
        @SerializedName("ece4")
        @Expose
        public String ece4;

        public Count(String ece, String ece2, String ece3, String ece4) {
            this.ece = ece;
            this.ece2 = ece2;
            this.ece3 = ece3;
            this.ece4 = ece4;
        }

        public String getEce2() {
            return ece2;
        }

        public void setEce2(String ece2) {
            this.ece2 = ece2;
        }

        public String getEce3() {
            return ece3;
        }

        public void setEce3(String ece3) {
            this.ece3 = ece3;
        }

        public String getEce4() {
            return ece4;
        }

        public void setEce4(String ece4) {
            this.ece4 = ece4;
        }

        public String getEce() {
            return ece;
        }

        public void setEce(String ece) {
            this.ece = ece;
        }
    }
}
