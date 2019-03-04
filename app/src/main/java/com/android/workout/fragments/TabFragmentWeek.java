package com.android.workout.fragments;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.android.workout.R;

public class TabFragmentWeek extends Fragment implements OnClickListener{
    private static final String TAG = "TabFragmentWeek";

    private Button mBtnStdDiet;
    private Button mBtnVegDiet;

    private LinearLayout mLayoutStdDiet;
    private LinearLayout mLayoutVegDiet;

    private String mWeekNumber;

    private ScrollView scrollweekstddietfood;
    private ScrollView scrollweekvegdietfood;

    private CheckBox std_check1;
    private CheckBox std_check10;
    private CheckBox std_check11;
    private CheckBox std_check12;
    private CheckBox std_check13;
    private CheckBox std_check14;
    private CheckBox std_check15;
    private CheckBox std_check16;
    private CheckBox std_check17;
    private CheckBox std_check18;
    private CheckBox std_check19;
    private CheckBox std_check2;
    private CheckBox std_check20;
    private CheckBox std_check21;
    private CheckBox std_check22;
    private CheckBox std_check3;
    private CheckBox std_check4;
    private CheckBox std_check5;
    private CheckBox std_check6;
    private CheckBox std_check7;
    private CheckBox std_check8;
    private CheckBox std_check9;

    private String stddiet;
    private String stddietcheckbox1;
    private String stddietcheckbox10;
    private String stddietcheckbox11;
    private String stddietcheckbox12;
    private String stddietcheckbox13;
    private String stddietcheckbox14;
    private String stddietcheckbox15;
    private String stddietcheckbox16;
    private String stddietcheckbox17;
    private String stddietcheckbox18;
    private String stddietcheckbox19;
    private String stddietcheckbox2;
    private String stddietcheckbox20;
    private String stddietcheckbox21;
    private String stddietcheckbox22;
    private String stddietcheckbox3;
    private String stddietcheckbox4;
    private String stddietcheckbox5;
    private String stddietcheckbox6;
    private String stddietcheckbox7;
    private String stddietcheckbox8;
    private String stddietcheckbox9;

    private CheckBox veg_check1;
    private CheckBox veg_check10;
    private CheckBox veg_check11;
    private CheckBox veg_check12;
    private CheckBox veg_check13;
    private CheckBox veg_check14;
    private CheckBox veg_check15;
    private CheckBox veg_check16;
    private CheckBox veg_check17;
    private CheckBox veg_check18;
    private CheckBox veg_check19;
    private CheckBox veg_check2;
    private CheckBox veg_check20;
    private CheckBox veg_check3;
    private CheckBox veg_check4;
    private CheckBox veg_check5;
    private CheckBox veg_check6;
    private CheckBox veg_check7;
    private CheckBox veg_check8;
    private CheckBox veg_check9;

    private String vegdiet;
    private String vegdietcheckbox1;
    private String vegdietcheckbox10;
    private String vegdietcheckbox11;
    private String vegdietcheckbox12;
    private String vegdietcheckbox13;
    private String vegdietcheckbox14;
    private String vegdietcheckbox15;
    private String vegdietcheckbox16;
    private String vegdietcheckbox17;
    private String vegdietcheckbox18;
    private String vegdietcheckbox19;
    private String vegdietcheckbox2;
    private String vegdietcheckbox20;
    private String vegdietcheckbox3;
    private String vegdietcheckbox4;
    private String vegdietcheckbox5;
    private String vegdietcheckbox6;
    private String vegdietcheckbox7;
    private String vegdietcheckbox8;
    private String vegdietcheckbox9;

    private Boolean week_stddietcheckbox1;
    private Boolean week_stddietcheckbox10;
    private Boolean week_stddietcheckbox11;
    private Boolean week_stddietcheckbox12;
    private Boolean week_stddietcheckbox13;
    private Boolean week_stddietcheckbox14;
    private Boolean week_stddietcheckbox15;
    private Boolean week_stddietcheckbox16;
    private Boolean week_stddietcheckbox17;
    private Boolean week_stddietcheckbox18;
    private Boolean week_stddietcheckbox19;
    private Boolean week_stddietcheckbox2;
    private Boolean week_stddietcheckbox20;
    private Boolean week_stddietcheckbox21;
    private Boolean week_stddietcheckbox22;
    private Boolean week_stddietcheckbox3;
    private Boolean week_stddietcheckbox4;
    private Boolean week_stddietcheckbox5;
    private Boolean week_stddietcheckbox6;
    private Boolean week_stddietcheckbox7;
    private Boolean week_stddietcheckbox8;
    private Boolean week_stddietcheckbox9;
    private Boolean week_stddietenabled;
    private Boolean week_vegdietcheckbox1;
    private Boolean week_vegdietcheckbox10;
    private Boolean week_vegdietcheckbox11;
    private Boolean week_vegdietcheckbox12;
    private Boolean week_vegdietcheckbox13;
    private Boolean week_vegdietcheckbox14;
    private Boolean week_vegdietcheckbox15;
    private Boolean week_vegdietcheckbox16;
    private Boolean week_vegdietcheckbox17;
    private Boolean week_vegdietcheckbox18;
    private Boolean week_vegdietcheckbox19;
    private Boolean week_vegdietcheckbox2;
    private Boolean week_vegdietcheckbox20;
    private Boolean week_vegdietcheckbox3;
    private Boolean week_vegdietcheckbox4;
    private Boolean week_vegdietcheckbox5;
    private Boolean week_vegdietcheckbox6;
    private Boolean week_vegdietcheckbox7;
    private Boolean week_vegdietcheckbox8;
    private Boolean week_vegdietcheckbox9;
    private Boolean week_vegdietenabled;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor prefsEditor;


    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        mWeekNumber = getArguments().getString("WEEK");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.tab_fragment_week, viewGroup, false);
        inflate.setTag(TAG);
        initViews(inflate);
        if (mWeekNumber.equals("WEEK1")) {
            stddiet = "WEEK_1_STDDIET";
            vegdiet = "WEEK_1_VEGDIET";
            stddietcheckbox1 = "WEEK1_STD_CHECKBOX1";
            stddietcheckbox2 = "WEEK1_STD_CHECKBOX2";
            stddietcheckbox3 = "WEEK1_STD_CHECKBOX3";
            stddietcheckbox4 = "WEEK1_STD_CHECKBOX4";
            stddietcheckbox5 = "WEEK1_STD_CHECKBOX5";
            stddietcheckbox6 = "WEEK1_STD_CHECKBOX6";
            stddietcheckbox7 = "WEEK1_STD_CHECKBOX7";
            stddietcheckbox8 = "WEEK1_STD_CHECKBOX8";
            stddietcheckbox9 = "WEEK1_STD_CHECKBOX9";
            stddietcheckbox10 = "WEEK1_STD_CHECKBOX10";
            stddietcheckbox11 = "WEEK1_STD_CHECKBOX11";
            stddietcheckbox12 = "WEEK1_STD_CHECKBOX12";
            stddietcheckbox13 = "WEEK1_STD_CHECKBOX13";
            stddietcheckbox14 = "WEEK1_STD_CHECKBOX14";
            stddietcheckbox15 = "WEEK1_STD_CHECKBOX15";
            stddietcheckbox16 = "WEEK1_STD_CHECKBOX16";
            stddietcheckbox17 = "WEEK1_STD_CHECKBOX17";
            stddietcheckbox18 = "WEEK1_STD_CHECKBOX18";
            stddietcheckbox19 = "WEEK1_STD_CHECKBOX19";
            stddietcheckbox20 = "WEEK1_STD_CHECKBOX20";
            stddietcheckbox21 = "WEEK1_STD_CHECKBOX21";
            stddietcheckbox22 = "WEEK1_STD_CHECKBOX22";
            vegdietcheckbox1 = "WEEK1_VEG_CHECKBOX1";
            vegdietcheckbox2 = "WEEK1_VEG_CHECKBOX2";
            vegdietcheckbox3 = "WEEK1_VEG_CHECKBOX3";
            vegdietcheckbox4 = "WEEK1_VEG_CHECKBOX4";
            vegdietcheckbox5 = "WEEK1_VEG_CHECKBOX5";
            vegdietcheckbox6 = "WEEK1_VEG_CHECKBOX6";
            vegdietcheckbox7 = "WEEK1_VEG_CHECKBOX7";
            vegdietcheckbox8 = "WEEK1_VEG_CHECKBOX8";
            vegdietcheckbox9 = "WEEK1_VEG_CHECKBOX9";
            vegdietcheckbox10 = "WEEK1_VEG_CHECKBOX10";
            vegdietcheckbox11 = "WEEK1_VEG_CHECKBOX11";
            vegdietcheckbox12 = "WEEK1_VEG_CHECKBOX12";
            vegdietcheckbox13 = "WEEK1_VEG_CHECKBOX13";
            vegdietcheckbox14 = "WEEK1_VEG_CHECKBOX14";
            vegdietcheckbox15 = "WEEK1_VEG_CHECKBOX15";
            vegdietcheckbox16 = "WEEK1_VEG_CHECKBOX16";
            vegdietcheckbox17 = "WEEK1_VEG_CHECKBOX17";
            vegdietcheckbox18 = "WEEK1_VEG_CHECKBOX18";
            vegdietcheckbox19 = "WEEK1_VEG_CHECKBOX19";
            str = "WEEK1_VEG_CHECKBOX20";
        } else if (mWeekNumber.equals("WEEK2")) {
            stddiet = "WEEK_2_STDDIET";
            vegdiet = "WEEK_2_VEGDIET";
            stddietcheckbox1 = "WEEK2_STD_CHECKBOX1";
            stddietcheckbox2 = "WEEK2_STD_CHECKBOX2";
            stddietcheckbox3 = "WEEK2_STD_CHECKBOX3";
            stddietcheckbox4 = "WEEK2_STD_CHECKBOX4";
            stddietcheckbox5 = "WEEK2_STD_CHECKBOX5";
            stddietcheckbox6 = "WEEK2_STD_CHECKBOX6";
            stddietcheckbox7 = "WEEK2_STD_CHECKBOX7";
            stddietcheckbox8 = "WEEK2_STD_CHECKBOX8";
            stddietcheckbox9 = "WEEK2_STD_CHECKBOX9";
            stddietcheckbox10 = "WEEK2_STD_CHECKBOX10";
            stddietcheckbox11 = "WEEK2_STD_CHECKBOX11";
            stddietcheckbox12 = "WEEK2_STD_CHECKBOX12";
            stddietcheckbox13 = "WEEK2_STD_CHECKBOX13";
            stddietcheckbox14 = "WEEK2_STD_CHECKBOX14";
            stddietcheckbox15 = "WEEK2_STD_CHECKBOX15";
            stddietcheckbox16 = "WEEK2_STD_CHECKBOX16";
            stddietcheckbox17 = "WEEK2_STD_CHECKBOX17";
            stddietcheckbox18 = "WEEK2_STD_CHECKBOX18";
            stddietcheckbox19 = "WEEK2_STD_CHECKBOX19";
            stddietcheckbox20 = "WEEK2_STD_CHECKBOX20";
            stddietcheckbox21 = "WEEK2_STD_CHECKBOX21";
            stddietcheckbox22 = "WEEK2_STD_CHECKBOX22";
            vegdietcheckbox1 = "WEEK2_VEG_CHECKBOX1";
            vegdietcheckbox2 = "WEEK2_VEG_CHECKBOX2";
            vegdietcheckbox3 = "WEEK2_VEG_CHECKBOX3";
            vegdietcheckbox4 = "WEEK2_VEG_CHECKBOX4";
            vegdietcheckbox5 = "WEEK2_VEG_CHECKBOX5";
            vegdietcheckbox6 = "WEEK2_VEG_CHECKBOX6";
            vegdietcheckbox7 = "WEEK2_VEG_CHECKBOX7";
            vegdietcheckbox8 = "WEEK2_VEG_CHECKBOX8";
            vegdietcheckbox9 = "WEEK2_VEG_CHECKBOX9";
            vegdietcheckbox10 = "WEEK2_VEG_CHECKBOX10";
            vegdietcheckbox11 = "WEEK2_VEG_CHECKBOX11";
            vegdietcheckbox12 = "WEEK2_VEG_CHECKBOX12";
            vegdietcheckbox13 = "WEEK2_VEG_CHECKBOX13";
            vegdietcheckbox14 = "WEEK2_VEG_CHECKBOX14";
            vegdietcheckbox5 = "WEEK2_VEG_CHECKBOX15";
            vegdietcheckbox16 = "WEEK2_VEG_CHECKBOX16";
            vegdietcheckbox17 = "WEEK2_VEG_CHECKBOX17";
            vegdietcheckbox18 = "WEEK2_VEG_CHECKBOX18";
            vegdietcheckbox19 = "WEEK2_VEG_CHECKBOX19";
            str = "WEEK2_VEG_CHECKBOX20";
        } else if (mWeekNumber.equals("WEEK3")) {
            stddiet = "WEEK_3_STDDIET";
            vegdiet = "WEEK_3_VEGDIET";
            stddietcheckbox1 = "WEEK3_STD_CHECKBOX1";
            stddietcheckbox2 = "WEEK3_STD_CHECKBOX2";
            stddietcheckbox3 = "WEEK3_STD_CHECKBOX3";
            stddietcheckbox4 = "WEEK3_STD_CHECKBOX4";
            stddietcheckbox5 = "WEEK3_STD_CHECKBOX5";
            stddietcheckbox6 = "WEEK3_STD_CHECKBOX6";
            stddietcheckbox7 = "WEEK3_STD_CHECKBOX7";
            stddietcheckbox8 = "WEEK3_STD_CHECKBOX8";
            stddietcheckbox9 = "WEEK3_STD_CHECKBOX9";
            stddietcheckbox10 = "WEEK3_STD_CHECKBOX10";
            stddietcheckbox11 = "WEEK3_STD_CHECKBOX11";
            stddietcheckbox12 = "WEEK3_STD_CHECKBOX12";
            stddietcheckbox13 = "WEEK3_STD_CHECKBOX13";
            stddietcheckbox14 = "WEEK3_STD_CHECKBOX14";
            stddietcheckbox15 = "WEEK3_STD_CHECKBOX15";
            stddietcheckbox16 = "WEEK3_STD_CHECKBOX16";
            stddietcheckbox17 = "WEEK3_STD_CHECKBOX17";
            stddietcheckbox18 = "WEEK3_STD_CHECKBOX18";
            stddietcheckbox19 = "WEEK3_STD_CHECKBOX19";
            stddietcheckbox20 = "WEEK3_STD_CHECKBOX20";
            stddietcheckbox21 = "WEEK3_STD_CHECKBOX21";
            stddietcheckbox22 = "WEEK3_STD_CHECKBOX22";
            vegdietcheckbox1 = "WEEK3_VEG_CHECKBOX1";
            vegdietcheckbox2 = "WEEK3_VEG_CHECKBOX2";
            vegdietcheckbox3 = "WEEK3_VEG_CHECKBOX3";
            vegdietcheckbox4 = "WEEK3_VEG_CHECKBOX4";
            vegdietcheckbox5 = "WEEK3_VEG_CHECKBOX5";
            vegdietcheckbox6 = "WEEK3_VEG_CHECKBOX6";
            vegdietcheckbox7 = "WEEK3_VEG_CHECKBOX7";
            vegdietcheckbox8 = "WEEK3_VEG_CHECKBOX8";
            vegdietcheckbox9 = "WEEK3_VEG_CHECKBOX9";
            vegdietcheckbox10 = "WEEK3_VEG_CHECKBOX10";
            vegdietcheckbox11 = "WEEK3_VEG_CHECKBOX11";
            vegdietcheckbox12 = "WEEK3_VEG_CHECKBOX12";
            vegdietcheckbox13 = "WEEK3_VEG_CHECKBOX13";
            vegdietcheckbox14 = "WEEK3_VEG_CHECKBOX14";
            vegdietcheckbox15 = "WEEK3_VEG_CHECKBOX15";
            vegdietcheckbox16 = "WEEK3_VEG_CHECKBOX16";
            vegdietcheckbox17 = "WEEK3_VEG_CHECKBOX17";
            vegdietcheckbox18 = "WEEK3_VEG_CHECKBOX18";
            vegdietcheckbox19 = "WEEK3_VEG_CHECKBOX19";
            str = "WEEK3_VEG_CHECKBOX20";
        } else if (mWeekNumber.equals("WEEK4")) {
            stddiet = "WEEK_4_STDDIET";
            vegdiet = "WEEK_4_VEGDIET";
            stddietcheckbox1 = "WEEK4_STD_CHECKBOX1";
            stddietcheckbox2 = "WEEK4_STD_CHECKBOX2";
            stddietcheckbox3 = "WEEK4_STD_CHECKBOX3";
            stddietcheckbox4 = "WEEK4_STD_CHECKBOX4";
            stddietcheckbox5 = "WEEK4_STD_CHECKBOX5";
            stddietcheckbox6 = "WEEK4_STD_CHECKBOX6";
            stddietcheckbox7 = "WEEK4_STD_CHECKBOX7";
            stddietcheckbox8 = "WEEK4_STD_CHECKBOX8";
            stddietcheckbox9 = "WEEK4_STD_CHECKBOX9";
            stddietcheckbox10 = "WEEK4_STD_CHECKBOX10";
            stddietcheckbox11 = "WEEK4_STD_CHECKBOX11";
            stddietcheckbox12 = "WEEK4_STD_CHECKBOX12";
            stddietcheckbox13 = "WEEK4_STD_CHECKBOX13";
            stddietcheckbox14 = "WEEK4_STD_CHECKBOX14";
            stddietcheckbox15 = "WEEK4_STD_CHECKBOX15";
            stddietcheckbox16 = "WEEK4_STD_CHECKBOX16";
            stddietcheckbox17 = "WEEK4_STD_CHECKBOX17";
            stddietcheckbox18 = "WEEK4_STD_CHECKBOX18";
            stddietcheckbox19 = "WEEK4_STD_CHECKBOX19";
            stddietcheckbox20 = "WEEK4_STD_CHECKBOX20";
            stddietcheckbox21 = "WEEK4_STD_CHECKBOX21";
            stddietcheckbox22 = "WEEK4_STD_CHECKBOX22";
            vegdietcheckbox1 = "WEEK4_VEG_CHECKBOX1";
            vegdietcheckbox2 = "WEEK4_VEG_CHECKBOX2";
            vegdietcheckbox3 = "WEEK4_VEG_CHECKBOX3";
            vegdietcheckbox4 = "WEEK4_VEG_CHECKBOX4";
            vegdietcheckbox5 = "WEEK4_VEG_CHECKBOX5";
            vegdietcheckbox6 = "WEEK4_VEG_CHECKBOX6";
            vegdietcheckbox7 = "WEEK4_VEG_CHECKBOX7";
            vegdietcheckbox8 = "WEEK4_VEG_CHECKBOX8";
            vegdietcheckbox9 = "WEEK4_VEG_CHECKBOX9";
            vegdietcheckbox10 = "WEEK4_VEG_CHECKBOX10";
            vegdietcheckbox11 = "WEEK4_VEG_CHECKBOX11";
            vegdietcheckbox12 = "WEEK4_VEG_CHECKBOX12";
            vegdietcheckbox13 = "WEEK4_VEG_CHECKBOX13";
            vegdietcheckbox14 = "WEEK4_VEG_CHECKBOX14";
            vegdietcheckbox15 = "WEEK4_VEG_CHECKBOX15";
            vegdietcheckbox16 = "WEEK4_VEG_CHECKBOX16";
            vegdietcheckbox17 = "WEEK4_VEG_CHECKBOX17";
            vegdietcheckbox18 = "WEEK4_VEG_CHECKBOX18";
            vegdietcheckbox19 = "WEEK4_VEG_CHECKBOX19";
            str = "WEEK4_VEG_CHECKBOX20";
        } else {
            if (mWeekNumber.equals("WEEK5")) {
                stddiet = "WEEK_5_STDDIET";
                vegdiet = "WEEK_5_VEGDIET";
                stddietcheckbox1 = "WEEK5_STD_CHECKBOX1";
                stddietcheckbox2 = "WEEK5_STD_CHECKBOX2";
                stddietcheckbox3 = "WEEK5_STD_CHECKBOX3";
                stddietcheckbox4 = "WEEK5_STD_CHECKBOX4";
                stddietcheckbox5 = "WEEK5_STD_CHECKBOX5";
                stddietcheckbox6 = "WEEK5_STD_CHECKBOX6";
                stddietcheckbox7 = "WEEK5_STD_CHECKBOX7";
                stddietcheckbox8 = "WEEK5_STD_CHECKBOX8";
                stddietcheckbox9 = "WEEK5_STD_CHECKBOX9";
                stddietcheckbox10 = "WEEK5_STD_CHECKBOX10";
                stddietcheckbox11 = "WEEK5_STD_CHECKBOX11";
                stddietcheckbox12 = "WEEK5_STD_CHECKBOX12";
                stddietcheckbox13 = "WEEK5_STD_CHECKBOX13";
                stddietcheckbox14 = "WEEK5_STD_CHECKBOX14";
                stddietcheckbox15 = "WEEK5_STD_CHECKBOX15";
                stddietcheckbox16 = "WEEK5_STD_CHECKBOX16";
                stddietcheckbox17 = "WEEK5_STD_CHECKBOX17";
                stddietcheckbox18 = "WEEK5_STD_CHECKBOX18";
                stddietcheckbox19 = "WEEK5_STD_CHECKBOX19";
                stddietcheckbox20 = "WEEK5_STD_CHECKBOX20";
                stddietcheckbox21 = "WEEK5_STD_CHECKBOX21";
                stddietcheckbox22 = "WEEK5_STD_CHECKBOX22";
                vegdietcheckbox1 = "WEEK5_VEG_CHECKBOX1";
                vegdietcheckbox2 = "WEEK5_VEG_CHECKBOX2";
                vegdietcheckbox3 = "WEEK5_VEG_CHECKBOX3";
                vegdietcheckbox4 = "WEEK5_VEG_CHECKBOX4";
                vegdietcheckbox5 = "WEEK5_VEG_CHECKBOX5";
                vegdietcheckbox6 = "WEEK5_VEG_CHECKBOX6";
                vegdietcheckbox7 = "WEEK5_VEG_CHECKBOX7";
                vegdietcheckbox8 = "WEEK5_VEG_CHECKBOX8";
                vegdietcheckbox9 = "WEEK5_VEG_CHECKBOX9";
                vegdietcheckbox10 = "WEEK5_VEG_CHECKBOX10";
                vegdietcheckbox11 = "WEEK5_VEG_CHECKBOX11";
                vegdietcheckbox12 = "WEEK5_VEG_CHECKBOX12";
                vegdietcheckbox13 = "WEEK5_VEG_CHECKBOX13";
                vegdietcheckbox14 = "WEEK5_VEG_CHECKBOX14";
                vegdietcheckbox15 = "WEEK5_VEG_CHECKBOX15";
                vegdietcheckbox16 = "WEEK5_VEG_CHECKBOX16";
                vegdietcheckbox17 = "WEEK5_VEG_CHECKBOX17";
                vegdietcheckbox18 = "WEEK5_VEG_CHECKBOX18";
                vegdietcheckbox19 = "WEEK5_VEG_CHECKBOX19";
                str = "WEEK5_VEG_CHECKBOX20";
            }
            week_stddietenabled = mSharedPreferences.getBoolean(stddiet, false);
            week_vegdietenabled = mSharedPreferences.getBoolean(vegdiet, false);
            week_stddietcheckbox1 = mSharedPreferences.getBoolean(stddietcheckbox1, false);
            week_stddietcheckbox2 = mSharedPreferences.getBoolean(stddietcheckbox2, false);
            week_stddietcheckbox3 = mSharedPreferences.getBoolean(stddietcheckbox3, false);
            week_stddietcheckbox4 = mSharedPreferences.getBoolean(stddietcheckbox4, false);
            week_stddietcheckbox5 = mSharedPreferences.getBoolean(stddietcheckbox5, false);
            week_stddietcheckbox6 = mSharedPreferences.getBoolean(stddietcheckbox6, false);
            week_stddietcheckbox7 = mSharedPreferences.getBoolean(stddietcheckbox7, false);
            week_stddietcheckbox8 = mSharedPreferences.getBoolean(stddietcheckbox8, false);
            week_stddietcheckbox9 = mSharedPreferences.getBoolean(stddietcheckbox9, false);
            week_stddietcheckbox10 = mSharedPreferences.getBoolean(stddietcheckbox10, false);
            week_stddietcheckbox11 = mSharedPreferences.getBoolean(stddietcheckbox11, false);
            week_stddietcheckbox12 = mSharedPreferences.getBoolean(stddietcheckbox12, false);
            week_stddietcheckbox13 = mSharedPreferences.getBoolean(stddietcheckbox13, false);
            week_stddietcheckbox14 = mSharedPreferences.getBoolean(stddietcheckbox14, false);
            week_stddietcheckbox15 = mSharedPreferences.getBoolean(stddietcheckbox15, false);
            week_stddietcheckbox16 = mSharedPreferences.getBoolean(stddietcheckbox16, false);
            week_stddietcheckbox17 = mSharedPreferences.getBoolean(stddietcheckbox17, false);
            week_stddietcheckbox18 = mSharedPreferences.getBoolean(stddietcheckbox18, false);
            week_stddietcheckbox19 = mSharedPreferences.getBoolean(stddietcheckbox19, false);
            week_stddietcheckbox20 = mSharedPreferences.getBoolean(stddietcheckbox20, false);
            week_stddietcheckbox21 = mSharedPreferences.getBoolean(stddietcheckbox21, false);
            week_stddietcheckbox22 = mSharedPreferences.getBoolean(stddietcheckbox22, false);
            std_check1.setChecked(week_stddietcheckbox1);
            std_check2.setChecked(week_stddietcheckbox2);
            std_check3.setChecked(week_stddietcheckbox3);
            std_check4.setChecked(week_stddietcheckbox4);
            std_check5.setChecked(week_stddietcheckbox5);
            std_check6.setChecked(week_stddietcheckbox6);
            std_check7.setChecked(week_stddietcheckbox7);
            std_check8.setChecked(week_stddietcheckbox8);
            std_check9.setChecked(week_stddietcheckbox9);
            std_check10.setChecked(week_stddietcheckbox10);
            std_check11.setChecked(week_stddietcheckbox11);
            std_check12.setChecked(week_stddietcheckbox12);
            std_check13.setChecked(week_stddietcheckbox13);
            std_check14.setChecked(week_stddietcheckbox14);
            std_check15.setChecked(week_stddietcheckbox15);
            std_check16.setChecked(week_stddietcheckbox16);
            std_check17.setChecked(week_stddietcheckbox17);
            std_check18.setChecked(week_stddietcheckbox18);
            std_check19.setChecked(week_stddietcheckbox19);
            std_check20.setChecked(week_stddietcheckbox20);
            std_check21.setChecked(week_stddietcheckbox21);
            std_check22.setChecked(week_stddietcheckbox22);
            week_vegdietcheckbox1 = mSharedPreferences.getBoolean(vegdietcheckbox1, false);
            week_vegdietcheckbox2 = mSharedPreferences.getBoolean(vegdietcheckbox2, false);
            week_vegdietcheckbox3 = mSharedPreferences.getBoolean(vegdietcheckbox3, false);
            week_vegdietcheckbox4 = mSharedPreferences.getBoolean(vegdietcheckbox4, false);
            week_vegdietcheckbox5 = mSharedPreferences.getBoolean(vegdietcheckbox5, false);
            week_vegdietcheckbox6 = mSharedPreferences.getBoolean(vegdietcheckbox6, false);
            week_vegdietcheckbox7 = mSharedPreferences.getBoolean(vegdietcheckbox7, false);
            week_vegdietcheckbox8 = mSharedPreferences.getBoolean(vegdietcheckbox8, false);
            week_vegdietcheckbox9 = mSharedPreferences.getBoolean(vegdietcheckbox9, false);
            week_vegdietcheckbox10 = mSharedPreferences.getBoolean(vegdietcheckbox10, false);
            week_vegdietcheckbox11 = mSharedPreferences.getBoolean(vegdietcheckbox11, false);
            week_vegdietcheckbox12 = mSharedPreferences.getBoolean(vegdietcheckbox12, false);
            week_vegdietcheckbox13 = mSharedPreferences.getBoolean(vegdietcheckbox13, false);
            week_vegdietcheckbox14 = mSharedPreferences.getBoolean(vegdietcheckbox14, false);
            week_vegdietcheckbox15 = mSharedPreferences.getBoolean(vegdietcheckbox15, false);
            week_vegdietcheckbox16 = mSharedPreferences.getBoolean(vegdietcheckbox16, false);
            week_vegdietcheckbox17 = mSharedPreferences.getBoolean(vegdietcheckbox17, false);
            week_vegdietcheckbox18 = mSharedPreferences.getBoolean(vegdietcheckbox18, false);
            week_vegdietcheckbox19 = mSharedPreferences.getBoolean(vegdietcheckbox19, false);
            week_vegdietcheckbox20 = mSharedPreferences.getBoolean(vegdietcheckbox20, false);
            veg_check1.setChecked(week_vegdietcheckbox1);
            veg_check2.setChecked(week_vegdietcheckbox2);
            veg_check3.setChecked(week_vegdietcheckbox3);
            veg_check4.setChecked(week_vegdietcheckbox4);
            veg_check5.setChecked(week_vegdietcheckbox5);
            veg_check6.setChecked(week_vegdietcheckbox6);
            veg_check7.setChecked(week_vegdietcheckbox7);
            veg_check8.setChecked(week_vegdietcheckbox8);
            veg_check9.setChecked(week_vegdietcheckbox9);
            veg_check10.setChecked(week_vegdietcheckbox10);
            veg_check11.setChecked(week_vegdietcheckbox11);
            veg_check12.setChecked(week_vegdietcheckbox12);
            veg_check13.setChecked(week_vegdietcheckbox13);
            veg_check14.setChecked(week_vegdietcheckbox14);
            veg_check15.setChecked(week_vegdietcheckbox15);
            veg_check16.setChecked(week_vegdietcheckbox16);
            veg_check17.setChecked(week_vegdietcheckbox17);
            veg_check18.setChecked(week_vegdietcheckbox18);
            veg_check19.setChecked(week_vegdietcheckbox19);
            veg_check20.setChecked(week_vegdietcheckbox20);
//            if (!week_stddietenabled && !week_vegdietenabled) {
//                mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorAccent));
//                mBtnVegDiet.setTextColor(getResources().getColor(R.color.black));
//                scrollweekstddietfood.setVisibility(0);
//                scrollweekvegdietfood.setVisibility(4);
//            } else if (week_stddietenabled && week_vegdietenabled) {
//                mBtnStdDiet.setTextColor(getResources().getColor(R.color.black));
//                mBtnVegDiet.setTextColor(getResources().getColor(R.color.colorAccent));
//                scrollweekstddietfood.setVisibility(View.INVISIBLE);
//                scrollweekvegdietfood.setVisibility(View.VISIBLE);
//            } else if (!(week_stddietenabled || week_vegdietenabled)) {
//                mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorAccent));
//                mBtnVegDiet.setTextColor(getResources().getColor(R.color.black));
//                scrollweekstddietfood.setVisibility(0);
//                scrollweekvegdietfood.setVisibility(4);
//            }

            if(week_stddietenabled && !week_vegdietenabled){
                mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorAccent));
                mBtnVegDiet.setTextColor(getResources().getColor(R.color.black));
                scrollweekstddietfood.setVisibility(View.VISIBLE);
                scrollweekvegdietfood.setVisibility(View.INVISIBLE);
            }else{
                mBtnStdDiet.setTextColor(getResources().getColor(R.color.black));
                mBtnVegDiet.setTextColor(getResources().getColor(R.color.colorAccent));
                scrollweekstddietfood.setVisibility(View.INVISIBLE);
                scrollweekvegdietfood.setVisibility(View.VISIBLE);
            }

            mBtnStdDiet.setOnClickListener(new C10521());
            mBtnVegDiet.setOnClickListener(new C10532());

            setEventListeners();

            return inflate;
        }

        vegdietcheckbox20 = str;
        week_stddietenabled = mSharedPreferences.getBoolean(stddiet, false);
        week_vegdietenabled = mSharedPreferences.getBoolean(vegdiet, false);
        week_stddietcheckbox1 = mSharedPreferences.getBoolean(stddietcheckbox1, false);
        week_stddietcheckbox2 = mSharedPreferences.getBoolean(stddietcheckbox2, false);
        week_stddietcheckbox3 = mSharedPreferences.getBoolean(stddietcheckbox3, false);
        week_stddietcheckbox4 = mSharedPreferences.getBoolean(stddietcheckbox4, false);
        week_stddietcheckbox5 = mSharedPreferences.getBoolean(stddietcheckbox5, false);
        week_stddietcheckbox6 = mSharedPreferences.getBoolean(stddietcheckbox6, false);
        week_stddietcheckbox7 = mSharedPreferences.getBoolean(stddietcheckbox7, false);
        week_stddietcheckbox8 = mSharedPreferences.getBoolean(stddietcheckbox8, false);
        week_stddietcheckbox9 = mSharedPreferences.getBoolean(stddietcheckbox9, false);
        week_stddietcheckbox10 = mSharedPreferences.getBoolean(stddietcheckbox10, false);
        week_stddietcheckbox11 = mSharedPreferences.getBoolean(stddietcheckbox11, false);
        week_stddietcheckbox12 = mSharedPreferences.getBoolean(stddietcheckbox12, false);
        week_stddietcheckbox13 = mSharedPreferences.getBoolean(stddietcheckbox13, false);
        week_stddietcheckbox14 = mSharedPreferences.getBoolean(stddietcheckbox14, false);
        week_stddietcheckbox15 = mSharedPreferences.getBoolean(stddietcheckbox15, false);
        week_stddietcheckbox16 = mSharedPreferences.getBoolean(stddietcheckbox16, false);
        week_stddietcheckbox17 = mSharedPreferences.getBoolean(stddietcheckbox17, false);
        week_stddietcheckbox18 = mSharedPreferences.getBoolean(stddietcheckbox18, false);
        week_stddietcheckbox19 = mSharedPreferences.getBoolean(stddietcheckbox19, false);
        week_stddietcheckbox20 = mSharedPreferences.getBoolean(stddietcheckbox20, false);
        week_stddietcheckbox21 = mSharedPreferences.getBoolean(stddietcheckbox21, false);
        week_stddietcheckbox22 = mSharedPreferences.getBoolean(stddietcheckbox22, false);
        std_check1.setChecked(week_stddietcheckbox1);
        std_check2.setChecked(week_stddietcheckbox2);
        std_check3.setChecked(week_stddietcheckbox3);
        std_check4.setChecked(week_stddietcheckbox4);
        std_check5.setChecked(week_stddietcheckbox5);
        std_check6.setChecked(week_stddietcheckbox6);
        std_check7.setChecked(week_stddietcheckbox7);
        std_check8.setChecked(week_stddietcheckbox8);
        std_check9.setChecked(week_stddietcheckbox9);
        std_check10.setChecked(week_stddietcheckbox10);
        std_check11.setChecked(week_stddietcheckbox11);
        std_check12.setChecked(week_stddietcheckbox12);
        std_check13.setChecked(week_stddietcheckbox13);
        std_check14.setChecked(week_stddietcheckbox14);
        std_check15.setChecked(week_stddietcheckbox15);
        std_check16.setChecked(week_stddietcheckbox16);
        std_check17.setChecked(week_stddietcheckbox17);
        std_check18.setChecked(week_stddietcheckbox18);
        std_check19.setChecked(week_stddietcheckbox19);
        std_check20.setChecked(week_stddietcheckbox20);
        std_check21.setChecked(week_stddietcheckbox21);
        std_check22.setChecked(week_stddietcheckbox22);
        week_vegdietcheckbox1 = mSharedPreferences.getBoolean(vegdietcheckbox1, false);
        week_vegdietcheckbox2 = mSharedPreferences.getBoolean(vegdietcheckbox2, false);
        week_vegdietcheckbox3 = mSharedPreferences.getBoolean(vegdietcheckbox3, false);
        week_vegdietcheckbox4 = mSharedPreferences.getBoolean(vegdietcheckbox4, false);
        week_vegdietcheckbox5 = mSharedPreferences.getBoolean(vegdietcheckbox5, false);
        week_vegdietcheckbox6 = mSharedPreferences.getBoolean(vegdietcheckbox6, false);
        week_vegdietcheckbox7 = mSharedPreferences.getBoolean(vegdietcheckbox7, false);
        week_vegdietcheckbox8 = mSharedPreferences.getBoolean(vegdietcheckbox8, false);
        week_vegdietcheckbox9 = mSharedPreferences.getBoolean(vegdietcheckbox9, false);
        week_vegdietcheckbox10 = mSharedPreferences.getBoolean(vegdietcheckbox10, false);
        week_vegdietcheckbox11 = mSharedPreferences.getBoolean(vegdietcheckbox11, false);
        week_vegdietcheckbox12 = mSharedPreferences.getBoolean(vegdietcheckbox12, false);
        week_vegdietcheckbox13 = mSharedPreferences.getBoolean(vegdietcheckbox13, false);
        week_vegdietcheckbox14 = mSharedPreferences.getBoolean(vegdietcheckbox14, false);
        week_vegdietcheckbox15 = mSharedPreferences.getBoolean(vegdietcheckbox15, false);
        week_vegdietcheckbox16 = mSharedPreferences.getBoolean(vegdietcheckbox16, false);
        week_vegdietcheckbox17 = mSharedPreferences.getBoolean(vegdietcheckbox17, false);
        week_vegdietcheckbox18 = mSharedPreferences.getBoolean(vegdietcheckbox18, false);
        week_vegdietcheckbox19 = mSharedPreferences.getBoolean(vegdietcheckbox19, false);
        week_vegdietcheckbox20 = mSharedPreferences.getBoolean(vegdietcheckbox20, false);
        veg_check1.setChecked(week_vegdietcheckbox1);
        veg_check2.setChecked(week_vegdietcheckbox2);
        veg_check3.setChecked(week_vegdietcheckbox3);
        veg_check4.setChecked(week_vegdietcheckbox4);
        veg_check5.setChecked(week_vegdietcheckbox5);
        veg_check6.setChecked(week_vegdietcheckbox6);
        veg_check7.setChecked(week_vegdietcheckbox7);
        veg_check8.setChecked(week_vegdietcheckbox8);
        veg_check9.setChecked(week_vegdietcheckbox9);
        veg_check10.setChecked(week_vegdietcheckbox10);
        veg_check11.setChecked(week_vegdietcheckbox11);
        veg_check12.setChecked(week_vegdietcheckbox12);
        veg_check13.setChecked(week_vegdietcheckbox13);
        veg_check14.setChecked(week_vegdietcheckbox14);
        veg_check15.setChecked(week_vegdietcheckbox15);
        veg_check16.setChecked(week_vegdietcheckbox16);
        veg_check17.setChecked(week_vegdietcheckbox17);
        veg_check18.setChecked(week_vegdietcheckbox18);
        veg_check19.setChecked(week_vegdietcheckbox19);
        veg_check20.setChecked(week_vegdietcheckbox20);

        mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorAccent));
        mBtnVegDiet.setTextColor(getResources().getColor(R.color.black));

        scrollweekstddietfood.setVisibility(View.VISIBLE);
        scrollweekvegdietfood.setVisibility(View.INVISIBLE);

        mBtnStdDiet.setOnClickListener(new C10521());
        mBtnVegDiet.setOnClickListener(new C10532());

        setEventListeners();

        return inflate;
    }

    private void initViews(View inflate) {

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        prefsEditor = mSharedPreferences.edit();
        scrollweekstddietfood = inflate.findViewById(R.id.scrollweekstddietfood);
        scrollweekvegdietfood = inflate.findViewById(R.id.scrollweekvegdietfood);
        mBtnStdDiet = inflate.findViewById(R.id.weekStddiet);
        mBtnVegDiet = inflate.findViewById(R.id.weekvegdiet);
        mLayoutStdDiet = inflate.findViewById(R.id.weekstddietfood);
        mLayoutVegDiet = inflate.findViewById(R.id.weekvegdietfood);
        std_check1 = inflate.findViewById(R.id.stddietfoodcheckBox1);
        std_check2 = inflate.findViewById(R.id.stddietfoodcheckBox2);
        std_check3 = inflate.findViewById(R.id.stddietfoodcheckBox3);
        std_check4 = inflate.findViewById(R.id.stddietfoodcheckBox4);
        std_check5 = inflate.findViewById(R.id.stddietfoodcheckBox5);
        std_check6 = inflate.findViewById(R.id.stddietfoodcheckBox6);
        std_check7 = inflate.findViewById(R.id.stddietfoodcheckBox7);
        std_check8 = inflate.findViewById(R.id.stddietfoodcheckBox8);
        std_check9 = inflate.findViewById(R.id.stddietfoodcheckBox9);
        std_check10 = inflate.findViewById(R.id.stddietfoodcheckBox10);
        std_check11 = inflate.findViewById(R.id.stddietfoodcheckBox11);
        std_check12 = inflate.findViewById(R.id.stddietfoodcheckBox12);
        std_check13 = inflate.findViewById(R.id.stddietfoodcheckBox13);
        std_check14 = inflate.findViewById(R.id.stddietfoodcheckBox14);
        std_check15 = inflate.findViewById(R.id.stddietfoodcheckBox15);
        std_check16 = inflate.findViewById(R.id.stddietfoodcheckBox16);
        std_check17 = inflate.findViewById(R.id.stddietfoodcheckBox17);
        std_check18 = inflate.findViewById(R.id.stddietfoodcheckBox18);
        std_check19 = inflate.findViewById(R.id.stddietfoodcheckBox19);
        std_check20 = inflate.findViewById(R.id.stddietfoodcheckBox20);
        std_check21 = inflate.findViewById(R.id.stddietfoodcheckBox21);
        std_check22 = inflate.findViewById(R.id.stddietfoodcheckBox22);
        veg_check1 = inflate.findViewById(R.id.vegdietfoodcheckBox1);
        veg_check2 = inflate.findViewById(R.id.vegdietfoodcheckBox2);
        veg_check3 = inflate.findViewById(R.id.vegdietfoodcheckBox3);
        veg_check4 = inflate.findViewById(R.id.vegdietfoodcheckBox4);
        veg_check5 = inflate.findViewById(R.id.vegdietfoodcheckBox5);
        veg_check6 = inflate.findViewById(R.id.vegdietfoodcheckBox6);
        veg_check7 = inflate.findViewById(R.id.vegdietfoodcheckBox7);
        veg_check8 = inflate.findViewById(R.id.vegdietfoodcheckBox8);
        veg_check9 = inflate.findViewById(R.id.vegdietfoodcheckBox9);
        veg_check10 = inflate.findViewById(R.id.vegdietfoodcheckBox10);
        veg_check11 = inflate.findViewById(R.id.vegdietfoodcheckBox11);
        veg_check12 = inflate.findViewById(R.id.vegdietfoodcheckBox12);
        veg_check13 = inflate.findViewById(R.id.vegdietfoodcheckBox13);
        veg_check14 = inflate.findViewById(R.id.vegdietfoodcheckBox14);
        veg_check15 = inflate.findViewById(R.id.vegdietfoodcheckBox15);
        veg_check16 = inflate.findViewById(R.id.vegdietfoodcheckBox16);
        veg_check17 = inflate.findViewById(R.id.vegdietfoodcheckBox17);
        veg_check18 = inflate.findViewById(R.id.vegdietfoodcheckBox18);
        veg_check19 = inflate.findViewById(R.id.vegdietfoodcheckBox19);
        veg_check20 = inflate.findViewById(R.id.vegdietfoodcheckBox20);

    }

    class C10521 implements OnClickListener {

        public void onClick(View view) {

            week_stddietenabled = mSharedPreferences.getBoolean(stddiet,false);

            if (!week_stddietenabled) {
                mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorAccent));
                mBtnVegDiet.setTextColor(getResources().getColor(R.color.black));
                scrollweekstddietfood.setVisibility(View.VISIBLE);
                scrollweekvegdietfood.setVisibility(View.INVISIBLE);
                prefsEditor.putBoolean(stddiet, true);
                prefsEditor.putBoolean(vegdiet, false);
            }
            prefsEditor.commit();
        }
    }

    class C10532 implements OnClickListener {

        public void onClick(View view) {
            week_vegdietenabled = mSharedPreferences.getBoolean(vegdiet, false);
            if (!week_vegdietenabled) {
                mBtnVegDiet.setTextColor(getResources().getColor(R.color.colorAccent));
                scrollweekvegdietfood.setVisibility(View.VISIBLE);
                mBtnStdDiet.setTextColor(getResources().getColor(R.color.black));
                scrollweekstddietfood.setVisibility(View.INVISIBLE);
                prefsEditor.putBoolean(vegdiet, true);
                prefsEditor.putBoolean(stddiet, false);
            }
            prefsEditor.commit();
        }
    }

    private void setEventListeners() {
        std_check1.setOnClickListener(this);
        std_check2.setOnClickListener(this);
        std_check3.setOnClickListener(this);
        std_check4.setOnClickListener(this);
        std_check5.setOnClickListener(this);
        std_check6.setOnClickListener(this);
        std_check7.setOnClickListener(this);
        std_check8.setOnClickListener(this);
        std_check9.setOnClickListener(this);
        std_check10.setOnClickListener(this);
        std_check11.setOnClickListener(this);
        std_check12.setOnClickListener(this);
        std_check13.setOnClickListener(this);
        std_check14.setOnClickListener(this);
        std_check15.setOnClickListener(this);
        std_check16.setOnClickListener(this);
        std_check17.setOnClickListener(this);
        std_check18.setOnClickListener(this);
        std_check19.setOnClickListener(this);
        std_check20.setOnClickListener(this);
        std_check21.setOnClickListener(this);
        std_check22.setOnClickListener(this);
        veg_check1.setOnClickListener(this);
        veg_check2.setOnClickListener(this);
        veg_check3.setOnClickListener(this);
        veg_check4.setOnClickListener(this);
        veg_check5.setOnClickListener(this);
        veg_check6.setOnClickListener(this);
        veg_check7.setOnClickListener(this);
        veg_check8.setOnClickListener(this);
        veg_check9.setOnClickListener(this);
        veg_check10.setOnClickListener(this);
        veg_check11.setOnClickListener(this);
        veg_check12.setOnClickListener(this);
        veg_check13.setOnClickListener(this);
        veg_check14.setOnClickListener(this);
        veg_check15.setOnClickListener(this);
        veg_check16.setOnClickListener(this);
        veg_check17.setOnClickListener(this);
        veg_check18.setOnClickListener(this);
        veg_check19.setOnClickListener(this);
        veg_check20.setOnClickListener(this);
        std_check1.setText(getResources().getString(R.string.Skimmedmilk));
        std_check2.setText(getResources().getString(R.string.Eggs));
        std_check3.setText(getResources().getString(R.string.greekyogurt));
        std_check4.setText(getResources().getString(R.string.Brownbread));
        std_check5.setText(getResources().getString(R.string.Oatmealcookies));
        std_check6.setText(getResources().getString(R.string.Pineappleorgrapes));
        std_check7.setText(getResources().getString(R.string.Applewatermelonpapayastrawberry));
        std_check8.setText(getResources().getString(R.string.FishTunaorsalmon));
        std_check9.setText(getResources().getString(R.string.Chickenbreasts));
        std_check10.setText(getResources().getString(R.string.LeanBeef));
        std_check11.setText(getResources().getString(R.string.Carrotcucumbercabbagetomatobeansspinachlettuce));
        std_check12.setText(getResources().getString(R.string.Redrice));
        std_check13.setText(getResources().getString(R.string.Oats));
        std_check14.setText(getResources().getString(R.string.pasta));
        std_check15.setText(getResources().getString(R.string.Almonds));
        std_check16.setText(getResources().getString(R.string.Walnuts));
        std_check17.setText(getResources().getString(R.string.cornflakes));
        std_check18.setText(getResources().getString(R.string.Wheatforwraps));
        std_check19.setText(getResources().getString(R.string.greenteapowder));
        std_check20.setText(getResources().getString(R.string.Amlajuice));
        std_check21.setText(getResources().getString(R.string.Lemon));
        std_check22.setText(getResources().getString(R.string.honey));
        veg_check1.setText(getResources().getString(R.string.Skimmedmilk));
        veg_check2.setText(getResources().getString(R.string.Eggs));
        veg_check3.setText(getResources().getString(R.string.greekyogurt));
        veg_check4.setText(getResources().getString(R.string.Brownbread));
        veg_check5.setText(getResources().getString(R.string.Oatmealcookies));
        veg_check6.setText(getResources().getString(R.string.Pineappleorgrapes));
        veg_check7.setText(getResources().getString(R.string.Applewatermelonpapayastrawberry));
        veg_check8.setText(getResources().getString(R.string.Carrotcucumbercabbagetomatobeansspinachlettuce));
        veg_check9.setText(getResources().getString(R.string.Mushroom));
        veg_check10.setText(getResources().getString(R.string.Redrice));
        veg_check11.setText(getResources().getString(R.string.Oats));
        veg_check12.setText(getResources().getString(R.string.Pasta));
        veg_check13.setText(getResources().getString(R.string.Almonds));
        veg_check14.setText(getResources().getString(R.string.Walnuts));
        veg_check15.setText(getResources().getString(R.string.cornflakes));
        veg_check16.setText(getResources().getString(R.string.Wheatforwraps));
        veg_check17.setText(getResources().getString(R.string.Greentea));
        veg_check18.setText(getResources().getString(R.string.Amlajuice));
        veg_check19.setText(getResources().getString(R.string.Lemonjuice));
        veg_check20.setText(getResources().getString(R.string.honey));
    }

    public void onClick(View paramView1)
    {
        int i = paramView1.getId();
        String paramView = "";
        boolean status = false;
        SharedPreferences.Editor localEditor = prefsEditor;
        localEditor.putBoolean(paramView, status);
        switch (i)
        {
            default:
                switch (i)
                {
                    default:
                        return;
                    case R.id.vegdietfoodcheckBox9:
                        week_vegdietcheckbox9 = mSharedPreferences.getBoolean(vegdietcheckbox9, false);
                        if (!week_vegdietcheckbox9)
                        {
                            veg_check9.setChecked(true);
                            localEditor = prefsEditor;
                            status = true;
                            paramView = vegdietcheckbox9;
                        }
                        else
                        {
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox9;
                            status  = false;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox8:
                        week_vegdietcheckbox8 = mSharedPreferences.getBoolean(vegdietcheckbox8, false);
                        if (!week_vegdietcheckbox8.booleanValue())
                        {
                            veg_check8.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox8;
                            status = true;
                        }
                        else
                        {
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox8;
                            status = false;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox7:
                        week_vegdietcheckbox7 = mSharedPreferences.getBoolean(vegdietcheckbox7, false);
                        if (!week_vegdietcheckbox7.booleanValue())
                        {
                            veg_check7.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox7;
                            status = true;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox7;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox6:
                        week_vegdietcheckbox6 = mSharedPreferences.getBoolean(vegdietcheckbox6, false);
                        if (!week_vegdietcheckbox6.booleanValue())
                        {
                            status = true;
                            veg_check6.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox6;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox6;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox5:
                        week_vegdietcheckbox5 = mSharedPreferences.getBoolean(vegdietcheckbox5, false);
                        if (!week_vegdietcheckbox5.booleanValue())
                        {
                            status = true;
                            veg_check5.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox5;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox5;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox4:
                        week_vegdietcheckbox4 = mSharedPreferences.getBoolean(vegdietcheckbox4, false);
                        if (!week_vegdietcheckbox4.booleanValue())
                        {
                            status = false;
                            veg_check4.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox4;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox4;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox3:
                        week_vegdietcheckbox3 = mSharedPreferences.getBoolean(vegdietcheckbox3, false);
                        if (!week_vegdietcheckbox3.booleanValue())
                        {
                            status = true;
                            veg_check3.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox3;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox3;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox20:
                        week_vegdietcheckbox20 = mSharedPreferences.getBoolean(vegdietcheckbox20, false);
                        if (!week_vegdietcheckbox20.booleanValue())
                        {
                            status = true;
                            veg_check20.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox20;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox20;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox2:
                        week_vegdietcheckbox2 = mSharedPreferences.getBoolean(vegdietcheckbox2, false);
                        if (!week_vegdietcheckbox2.booleanValue())
                        {
                            status = true;
                            veg_check2.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox2;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox2;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox19:
                        week_vegdietcheckbox19 = mSharedPreferences.getBoolean(vegdietcheckbox19, false);
                        if (!week_vegdietcheckbox19.booleanValue())
                        {
                            status = true;
                            veg_check19.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox19;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox19;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox18:
                        week_vegdietcheckbox18 = mSharedPreferences.getBoolean(vegdietcheckbox18, false);
                        if (!week_vegdietcheckbox18.booleanValue())
                        {
                            status = true;
                            veg_check18.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox18;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox18;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox17:
                        week_vegdietcheckbox17 = mSharedPreferences.getBoolean(vegdietcheckbox17, false);
                        if (!week_vegdietcheckbox17.booleanValue())
                        {
                            status = true;
                            veg_check17.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox17;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox17;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox16:
                        week_vegdietcheckbox16 = mSharedPreferences.getBoolean(vegdietcheckbox16, false);
                        if (!week_vegdietcheckbox16.booleanValue())
                        {
                            status = true;
                            veg_check16.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox16;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox16;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox15:
                        week_vegdietcheckbox15 = mSharedPreferences.getBoolean(vegdietcheckbox15, false);
                        if (!week_vegdietcheckbox15.booleanValue())
                        {
                            status = true;
                            veg_check15.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox15;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox15;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox14:
                        week_vegdietcheckbox14 = mSharedPreferences.getBoolean(vegdietcheckbox14, false);
                        if (!week_vegdietcheckbox14.booleanValue())
                        {
                            status = true;
                            veg_check14.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox14;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox14;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox13:
                        week_vegdietcheckbox13 = mSharedPreferences.getBoolean(vegdietcheckbox13, false);
                        if (!week_vegdietcheckbox13.booleanValue())
                        {
                            status = true;
                            veg_check13.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox13;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox13;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox12:
                        week_vegdietcheckbox12 = mSharedPreferences.getBoolean(vegdietcheckbox12, false);
                        if (!week_vegdietcheckbox12.booleanValue())
                        {
                            status = true;
                            veg_check12.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox12;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox12;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox11:
                        week_vegdietcheckbox11 = mSharedPreferences.getBoolean(vegdietcheckbox11, false);
                        if (!week_vegdietcheckbox11.booleanValue())
                        {
                            status = true;
                            veg_check11.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox11;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox11;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox10:
                        week_vegdietcheckbox10 = mSharedPreferences.getBoolean(vegdietcheckbox10, false);
                        if (!week_vegdietcheckbox10.booleanValue())
                        {
                            status = true;
                            veg_check10.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox10;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox10;
                        }
                        break;
                    case R.id.vegdietfoodcheckBox1:
                        week_vegdietcheckbox1 = mSharedPreferences.getBoolean(vegdietcheckbox1, false);
                        if (!week_vegdietcheckbox1.booleanValue())
                        {
                            status = true;
                            veg_check1.setChecked(true);
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox1;
                        }
                        else
                        {
                            status = false;
                            localEditor = prefsEditor;
                            paramView = vegdietcheckbox1;
                        }
                        break;
                }
                break;
            case R.id.stddietfoodcheckBox9:
                week_stddietcheckbox9 = mSharedPreferences.getBoolean(stddietcheckbox9, false);
                if (!week_stddietcheckbox9.booleanValue())
                {
                    status = true;
                    std_check9.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox9;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox9;
                }
                break;
            case R.id.stddietfoodcheckBox8:
                week_stddietcheckbox8 = mSharedPreferences.getBoolean(stddietcheckbox8, false);
                if (!week_stddietcheckbox8.booleanValue())
                {
                    status = true;
                    std_check8.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox8;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox8;
                }
                break;
            case R.id.stddietfoodcheckBox7:
                week_stddietcheckbox7 = mSharedPreferences.getBoolean(stddietcheckbox7, false);
                if (!week_stddietcheckbox7.booleanValue())
                {
                    status = true;
                    std_check7.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox7;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox7;
                }
                break;
            case R.id.stddietfoodcheckBox6:
                week_stddietcheckbox6 = mSharedPreferences.getBoolean(stddietcheckbox6, false);
                if (!week_stddietcheckbox6.booleanValue())
                {
                    status = true;
                    std_check6.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox6;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox6;
                }
                break;
            case R.id.stddietfoodcheckBox5:
                week_stddietcheckbox5 = mSharedPreferences.getBoolean(stddietcheckbox5, false);
                if (!week_stddietcheckbox5.booleanValue())
                {
                    status = true;
                    std_check5.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox5;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox5;
                }
                break;
            case R.id.stddietfoodcheckBox4:
                week_stddietcheckbox4 = mSharedPreferences.getBoolean(stddietcheckbox4, false);
                if (!week_stddietcheckbox4.booleanValue())
                {
                    status = true;
                    std_check4.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox4;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox4;
                }
                break;
            case R.id.stddietfoodcheckBox3:
                week_stddietcheckbox3 = mSharedPreferences.getBoolean(stddietcheckbox3, false);
                if (!week_stddietcheckbox3.booleanValue())
                {
                    status = true;
                    std_check3.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox3;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox3;
                }
                break;
            case R.id.stddietfoodcheckBox22:
                week_stddietcheckbox22 = mSharedPreferences.getBoolean(stddietcheckbox22, false);
                if (!week_stddietcheckbox22.booleanValue())
                {
                    status = true;
                    std_check22.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox22;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox22;
                }
                break;
            case R.id.stddietfoodcheckBox21:
                week_stddietcheckbox21 = mSharedPreferences.getBoolean(stddietcheckbox21, false);
                if (!week_stddietcheckbox21.booleanValue())
                {
                    status = true;
                    std_check21.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox21;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox21;
                }
                break;
            case R.id.stddietfoodcheckBox20:
                week_stddietcheckbox20 = mSharedPreferences.getBoolean(stddietcheckbox20, false);
                if (!week_stddietcheckbox20.booleanValue())
                {
                    status = true;
                    std_check20.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox20;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox20;
                }
                break;
            case R.id.stddietfoodcheckBox2:
                week_stddietcheckbox2 = mSharedPreferences.getBoolean(stddietcheckbox2, false);
                if (!week_stddietcheckbox2.booleanValue())
                {
                    status = true;
                    std_check2.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox2;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox2;
                }
                break;
            case R.id.stddietfoodcheckBox19:
                week_stddietcheckbox19 = mSharedPreferences.getBoolean(stddietcheckbox19, false);
                if (!week_stddietcheckbox19.booleanValue())
                {
                    status = true;
                    std_check19.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox19;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox19;
                }
                break;
            case R.id.stddietfoodcheckBox18:
                week_stddietcheckbox18 = mSharedPreferences.getBoolean(stddietcheckbox18, false);
                if (!week_stddietcheckbox18.booleanValue())
                {
                    status = true;
                    std_check18.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox18;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox18;
                }
                break;
            case R.id.stddietfoodcheckBox17:
                week_stddietcheckbox17 = mSharedPreferences.getBoolean(stddietcheckbox17, false);
                if (!week_stddietcheckbox17.booleanValue())
                {
                    status = true;
                    std_check17.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox17;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox17;
                }
                break;
            case R.id.stddietfoodcheckBox16:
                week_stddietcheckbox16 = mSharedPreferences.getBoolean(stddietcheckbox16, false);
                if (!week_stddietcheckbox16.booleanValue())
                {
                    status = true;
                    std_check16.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox16;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox16;
                }
                break;
            case R.id.stddietfoodcheckBox15:
                week_stddietcheckbox15 = mSharedPreferences.getBoolean(stddietcheckbox15, false);
                if (!week_stddietcheckbox15.booleanValue())
                {
                    status = true;
                    std_check15.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox15;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox15;
                }
                break;
            case R.id.stddietfoodcheckBox14:
                week_stddietcheckbox14 = mSharedPreferences.getBoolean(stddietcheckbox14, false);
                if (!week_stddietcheckbox14.booleanValue())
                {
                    status = true;
                    std_check14.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox14;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox14;
                }
                break;
            case R.id.stddietfoodcheckBox13:
                week_stddietcheckbox13 = mSharedPreferences.getBoolean(stddietcheckbox13, false);
                if (!week_stddietcheckbox13.booleanValue())
                {
                    status = true;
                    std_check13.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox13;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox13;
                }
                break;
            case R.id.stddietfoodcheckBox12:
                week_stddietcheckbox12 = mSharedPreferences.getBoolean(stddietcheckbox12, false);
                if (!week_stddietcheckbox12.booleanValue())
                {
                    status = true;
                    std_check12.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox12;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox12;
                }
                break;
            case R.id.stddietfoodcheckBox11:
                week_stddietcheckbox11 = mSharedPreferences.getBoolean(stddietcheckbox11, false);
                if (!week_stddietcheckbox11.booleanValue())
                {
                    status = true;
                    std_check11.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox11;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox11;
                }
                break;
            case R.id.stddietfoodcheckBox10:
                week_stddietcheckbox10 = mSharedPreferences.getBoolean(stddietcheckbox10, false);
                if (!week_stddietcheckbox10.booleanValue())
                {
                    status = true;
                    std_check10.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox10;
                }
                else
                {
                    status = false;
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox10;
                }
                break;
            case R.id.stddietfoodcheckBox1:
                week_stddietcheckbox1 = mSharedPreferences.getBoolean(stddietcheckbox1, false);
                if (!week_stddietcheckbox1.booleanValue()) {
                    std_check1.setChecked(true);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox1;
                    status = true;
                    Log.e("box1",""+status);
                } else {

                    std_check1.setChecked(false);
                    status = false;
                    Log.e("box1",""+status);
                    localEditor = prefsEditor;
                    paramView = stddietcheckbox10;

                }
                break;
        }
        localEditor.putBoolean(paramView, status);
        localEditor.commit();
    }
}