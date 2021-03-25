package com.example.attendanceproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attendancedata {
    private List<Attendancedata.Datum1> data = null;

    public List<Attendancedata.Datum1> getData() {
        return data;
    }

    public void setData(List<Attendancedata.Datum1> data) {
        this.data = data;
    }

    private class Datum1 {
        @SerializedName("india_date")
        @Expose
        public String india_date;

        @SerializedName("stdname")
        @Expose
        public String stdname;

        @SerializedName("rollnum")
        @Expose
        public String rollnum;

        @SerializedName("first_period")
        @Expose
        public String first_period;

        public Datum1(String india_date, String stdname, String rollnum, String first_period) {
            this.india_date = india_date;
            this.stdname = stdname;
            this.rollnum = rollnum;
            this.first_period = first_period;
        }

        public String getRollnum() {
            return rollnum;
        }

        public void setRollnum(String rollnum) {
            this.rollnum = rollnum;
        }

        public String getFirst_period() {
            return first_period;
        }

        public void setFirst_period(String first_period) {
            this.first_period = first_period;
        }

        public String getStdname() {
            return stdname;
        }

        public void setStdname(String stdname) {
            this.stdname = stdname;
        }

        public String getIndia_date() {
            return india_date;
        }

        public void setIndia_date(String india_date) {
            this.india_date = india_date;
        }
    }
}
