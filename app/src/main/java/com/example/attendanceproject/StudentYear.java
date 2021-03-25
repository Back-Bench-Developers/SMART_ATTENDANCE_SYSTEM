package com.example.attendanceproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentYear {
    public List<YearI> yearI=null;
    public List<YearII> yearII=null;
    public List<YearIII> yearIII=null;
    public List<YearIV> yearIV=null;

    public List<YearI> getYearI() {
        return yearI;
    }

    public void setYearI(List<YearI> yearI) {
        this.yearI = yearI;
    }

    public List<YearII> getYearII() {
        return yearII;
    }

    public void setYearII(List<YearII> yearII) {
        this.yearII = yearII;
    }

    public List<YearIII> getYearIII() {
        return yearIII;
    }

    public void setYearIII(List<YearIII> yearIII) {
        this.yearIII = yearIII;
    }

    public List<YearIV> getYearIV() {
        return yearIV;
    }

    public void setYearIV(List<YearIV> yearIV) {
        this.yearIV = yearIV;
    }

    public static class YearI {
        @SerializedName("stdname")
        @Expose
        private String stdname;
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

        public YearI(String stdname, String rollnum, String department, String stdyear, String section1) {
            this.stdname = stdname;
            this.rollnum = rollnum;
            this.department = department;
            this.stdyear = stdyear;
            this.section1 = section1;
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

        public String getStdyear() {
            return stdyear;
        }

        public void setStdyear(String stdyear) {
            this.stdyear = stdyear;
        }

        public String getSection1() {
            return section1;
        }

        public void setSection1(String section1) {
            this.section1 = section1;
        }
    }

    public static class YearII {
        @SerializedName("stdname")
        @Expose
        private String stdname;
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

        public YearII(String stdname, String rollnum, String department, String stdyear, String section1) {
            this.stdname = stdname;
            this.rollnum = rollnum;
            this.department = department;
            this.stdyear = stdyear;
            this.section1 = section1;
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

        public String getStdyear() {
            return stdyear;
        }

        public void setStdyear(String stdyear) {
            this.stdyear = stdyear;
        }

        public String getSection1() {
            return section1;
        }

        public void setSection1(String section1) {
            this.section1 = section1;
        }
    }

    public static class YearIII {
        @SerializedName("stdname")
        @Expose
        private String stdname;
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

        public YearIII(String stdname, String rollnum, String department, String stdyear, String section1) {
            this.stdname = stdname;
            this.rollnum = rollnum;
            this.department = department;
            this.stdyear = stdyear;
            this.section1 = section1;
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

        public String getStdyear() {
            return stdyear;
        }

        public void setStdyear(String stdyear) {
            this.stdyear = stdyear;
        }

        public String getSection1() {
            return section1;
        }

        public void setSection1(String section1) {
            this.section1 = section1;
        }
    }

    public static class YearIV {
        @SerializedName("stdname")
        @Expose
        private String stdname;
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

        public YearIV(String stdname, String rollnum, String department, String stdyear, String section1) {
            this.stdname = stdname;
            this.rollnum = rollnum;
            this.department = department;
            this.stdyear = stdyear;
            this.section1 = section1;
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

        public String getStdyear() {
            return stdyear;
        }

        public void setStdyear(String stdyear) {
            this.stdyear = stdyear;
        }

        public String getSection1() {
            return section1;
        }

        public void setSection1(String section1) {
            this.section1 = section1;
        }
    }
}
