package com.android.workout.model;

public class MealsItemObject {
    private String name;
    private int photo;

    public MealsItemObject(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
