package com.example.attendanceproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Studentcount {
    private List<Count> count = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Studentcount() {
    }

    /**
     *
     * @param count
     */
    public Studentcount(List<Count> count) {
        super();
        this.count = count;
    }

    public List<Count> getCount() {
        return count;
    }

    public void setCount(List<Count> count) {
        this.count = count;
    }

    public static class Count {

        @SerializedName("ece")
        @Expose
        private String ece;
        @SerializedName("eee")
        @Expose
        private Integer eee;
        @SerializedName("it")
        @Expose
        private Integer it;
        @SerializedName("cse")
        @Expose
        private Integer cse;
        @SerializedName("mech")
        @Expose
        private Integer mech;
        @SerializedName("auto")
        @Expose
        private Integer auto;

        /**
         * No args constructor for use in serialization
         *
         */
        public Count() {
        }

        /**
         *
         * @param auto
         * @param eee
         * @param cse
         * @param ece
         * @param it
         * @param mech
         */
        public Count(String ece, Integer eee, Integer it, Integer cse, Integer mech, Integer auto) {
            super();
            this.ece = ece;
            this.eee = eee;
            this.it = it;
            this.cse = cse;
            this.mech = mech;
            this.auto = auto;
        }

        public String getEce() {
            return ece;
        }

        public void setEce(String ece) {
            this.ece = ece;
        }

        public Integer getEee() {
            return eee;
        }

        public void setEee(Integer eee) {
            this.eee = eee;
        }

        public Integer getIt() {
            return it;
        }

        public void setIt(Integer it) {
            this.it = it;
        }

        public Integer getCse() {
            return cse;
        }

        public void setCse(Integer cse) {
            this.cse = cse;
        }

        public Integer getMech() {
            return mech;
        }

        public void setMech(Integer mech) {
            this.mech = mech;
        }

        public Integer getAuto() {
            return auto;
        }

        public void setAuto(Integer auto) {
            this.auto = auto;
        }

    }

}