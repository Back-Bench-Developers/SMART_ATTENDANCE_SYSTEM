package com.example.attendanceproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attendancedata2 {
    public List<Atten> sheet=null;

    public List<Atten> getAttens() {
        return sheet;
    }

    public void setAttens(List<Atten> sheet) {
        this.sheet = sheet;
    }

    public  class Atten {
        @SerializedName("rollnum")
        @Expose
        public String rollnum;

        @SerializedName("first_period")
        @Expose
        public String first_period;

        @SerializedName("sec_period")
        @Expose
        public String sec_period;

        @SerializedName("third_period")
        @Expose
        public String third_period;

        @SerializedName("fourt_period")
        @Expose
        public String fourt_period;

        @SerializedName("fifth_period")
        @Expose
        public String fifth_period;

        @SerializedName("six_period")
        @Expose
        public String six_period;

        @SerializedName("seven_period")
        @Expose
        public String seven_period;

        @SerializedName("eight_period")
        @Expose
        public String eight_period;

        @SerializedName("india_date")
        @Expose
        public String india_date;
        public Atten(String rollnum, String first_period, String sec_period, String third_period, String fourt_period, String fifth_period, String six_period, String seven_period, String eight_period) {
            this.rollnum = rollnum;
            this.first_period = first_period;
            this.sec_period = sec_period;
            this.third_period = third_period;
            this.fourt_period = fourt_period;
            this.fifth_period = fifth_period;
            this.six_period = six_period;
            this.seven_period = seven_period;
            this.eight_period = eight_period;
        }

        public String getIndia_date() {
            return india_date;
        }

        public void setIndia_date(String india_date) {
            this.india_date = india_date;
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

        public String getSec_period() {
            return sec_period;
        }

        public void setSec_period(String sec_period) {
            this.sec_period = sec_period;
        }

        public String getThird_period() {
            return third_period;
        }

        public void setThird_period(String third_period) {
            this.third_period = third_period;
        }

        public String getFourt_period() {
            return fourt_period;
        }

        public void setFourt_period(String fourt_period) {
            this.fourt_period = fourt_period;
        }

        public String getFifth_period() {
            return fifth_period;
        }

        public void setFifth_period(String fifth_period) {
            this.fifth_period = fifth_period;
        }

        public String getSix_period() {
            return six_period;
        }

        public void setSix_period(String six_period) {
            this.six_period = six_period;
        }

        public String getSeven_period() {
            return seven_period;
        }

        public void setSeven_period(String seven_period) {
            this.seven_period = seven_period;
        }

        public String getEight_period() {
            return eight_period;
        }

        public void setEight_period(String eight_period) {
            this.eight_period = eight_period;
        }
    }
}
