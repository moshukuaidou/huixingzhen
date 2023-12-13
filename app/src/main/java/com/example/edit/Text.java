package com.example.edit;

public class Text {
    private String time;
    private String weather;
    private String subject;
    private int brain_remind;
    private int speak_remind;
    private int re_think;

    private String fansi;
    private String jianhuaNeirong;

    private String sikaoNeirong;

    private int id;
    private String jiluNeirong;

    private String lianxiangNeirong;

    private int ReviewDay_1;

    private int ReviewDay_3;
    private int ReviewDay_7;

    private int ReviewDay_14;

    private int ReviewDay_21;
    private int ReviewDay_30;
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
    }

    public void setjianhuaNeirong(String jianhuaNeirong) {
        this.jianhuaNeirong = jianhuaNeirong;
    }

    public void setsikaoNeirong(String sikaoNeirong) {
        this.sikaoNeirong = sikaoNeirong;
    }

    public void setjiluNeirong(String jiluNeirong) {
        this.jiluNeirong = jiluNeirong;
    }

    public void setlianxiangNeirong(String lianxiangNeirong) {
        this.lianxiangNeirong = lianxiangNeirong;
    }


    public int getId(   ) {
        return id;
    }




    public String getFansi(   ) {
        return fansi;
    }

    public String getjianhuaNeirong(   ) {
        return  jianhuaNeirong;
    }

    public String getsikaoNeirong(   ) {
        return  sikaoNeirong;
    }

    public String getjiluNeirong(     ) {
        return jiluNeirong;
    }

    public String getlianxiangNeirong(   ) {
        return  lianxiangNeirong;
    }

    public void setBrain_remind(int brain_remind) {
        this.brain_remind = brain_remind;
    }

    public void setRe_think(int re_think) {
        this.re_think = re_think;
    }

    public void setSpeak_remind(int speak_remind) {
        this.speak_remind = speak_remind;
    }

    public int getBrain_remind() {
        return brain_remind;
    }

    public int getSpeak_remind() {
        return speak_remind;
    }

    public int getRe_think() {
        return re_think;
    }

    public void setReviewDay_1(int reviewDay_1) {
        ReviewDay_1 = reviewDay_1;
    }

    public int getReviewDay_1() {
        return ReviewDay_1;
    }

    public void setReviewDay_3(int reviewDay_3) {
        ReviewDay_3 = reviewDay_3;
    }

    public void setReviewDay_7(int reviewDay_7) {
        ReviewDay_7 = reviewDay_7;
    }

    public void setReviewDay_14(int reviewDay_14) {
        ReviewDay_14 = reviewDay_14;
    }

    public void setReviewDay_21(int reviewDay_21) {
        ReviewDay_21 = reviewDay_21;
    }

    public void setReviewDay_30(int reviewDay_30) {
        ReviewDay_30 = reviewDay_30;
    }

    public int getReviewDay_3() {
        return ReviewDay_3;
    }

    public int getReviewDay_7() {
        return ReviewDay_7;
    }

    public int getReviewDay_14() {
        return ReviewDay_14;
    }

    public int getReviewDay_21() {
        return ReviewDay_21;
    }

    public int getReviewDay_30() {
        return ReviewDay_30;
    }
}
