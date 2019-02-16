package com.android.workout.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Diet {
    private Integer dayNo;
    private ArrayList<String> breakfast;
    private ArrayList<String> lunch;
    private ArrayList<String> snack;
    private ArrayList<String> dinner;
}
