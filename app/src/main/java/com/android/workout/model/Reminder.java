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

    public Reminder(String alarmTime, String repeatDays) {
        this.alarmTime = alarmTime;
        this.repeatDays = repeatDays;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Boolean getSwitchButton() {
        return switchButton;
    }

    public void setSwitchButton(Boolean switchButton) {
        this.switchButton = switchButton;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getRepeatDays() {
        return repeatDays;
    }

    public void setRepeatDays(String repeatDays) {
        this.repeatDays = repeatDays;
    }
}
