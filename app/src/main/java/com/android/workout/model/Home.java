package com.android.workout.model;

public class Home {
    private String day1;
    private String progress1;
    private String day2;
    private String progress2;
    private String day3;
    private String progress3;

    public Home(String day1, String progress1, String day2, String progress2, String day3, String progress3) {
        this.day1 = day1;
        this.progress1 = progress1;
        this.day2 = day2;
        this.progress2 = progress2;
        this.day3 = day3;
        this.progress3 = progress3;
    }

    public String getDay1() {
        return day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public String getProgress1() {
        return progress1;
    }

    public void setProgress1(String progress1) {
        this.progress1 = progress1;
    }

    public String getDay2() {
        return day2;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    public String getProgress2() {
        return progress2;
    }

    public void setProgress2(String progress2) {
        this.progress2 = progress2;
    }

    public String getDay3() {
        return day3;
    }

    public void setDay3(String day3) {
        this.day3 = day3;
    }

    public String getProgress3() {
        return progress3;
    }

    public void setProgress3(String progress3) {
        this.progress3 = progress3;
    }
}
