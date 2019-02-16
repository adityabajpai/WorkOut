package com.android.workout.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reminder {

    private String alarmTime;
    private Boolean switchButton;
    private String repeat;
    private String repeatDays;

}
