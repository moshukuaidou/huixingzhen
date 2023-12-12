package com.example.edit;

public class Text {
    private String time;
    private String weather;
    private String subject;
    private int feiman_condition;
    private String fansi;
    private String jianhuaNeirong;

    private String sikaoNeirong;

    private int id;
    private String jiluNeirong;

    private String lianxiangNeirong;

    private String ReviewDay;



    public Text() {
        // Default constructor
    }

    // Add getters and setters for each variable

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setId(int id) {
        this.id = id;
    }




    public void setFansi(String fansi) {
        this.fansi = fansi;
    };

    public void setjianhuaNeirong(String jianhuaNeirong) {
        this.jianhuaNeirong = jianhuaNeirong;
    };

    public void setsikaoNeirong(String sikaoNeirong) {
        this.sikaoNeirong = sikaoNeirong;
    };

    public void setjiluNeirong(String jiluNeirong) {
        this.jiluNeirong = jiluNeirong;
    };

    public void setlianxiangNeirong(String lianxiangNeirong) {
        this.lianxiangNeirong = lianxiangNeirong;
    };





    public int getId(   ) {
        return id;
    }
    public void setReviewDay(String ReviewDay) {
        this.ReviewDay = ReviewDay;
    }

    public String getReviewDay(   ) {
        return ReviewDay;
    }


    public String getFansi(   ) {
        return fansi;
    };

    public String getjianhuaNeirong(   ) {
        return  jianhuaNeirong;
    };

    public String getsikaoNeirong(   ) {
        return  sikaoNeirong;
    };

    public String getjiluNeirong(     ) {
        return jiluNeirong;
    };

    public String getlianxiangNeirong(   ) {
        return  lianxiangNeirong;
    };

    public void setFeiman_condition(int feiman_condition) {
        this.feiman_condition = feiman_condition;
    }

    public int getFeiman_condition() {
        return feiman_condition;
    }
    
}
