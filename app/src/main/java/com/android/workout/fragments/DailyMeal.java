package com.android.workout.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class DailyMeal extends Fragment {
    private static final String TAG = "DailyMeal";
    Context context;
    private Boolean vegdietenabled;
    private Boolean stddietenabled;
    private Button mBtnStdDiet;
    private Button mBtnVegDiet;
    private LinearLayout mLayoutStdDiet;
    private LinearLayout mLayoutVegDiet;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor prefsEditor;
    private int screenHeight;
    private int screenWidth;
    private ScrollView scrollstddietfood;
    private ScrollView scrollvegdietfood;
    private Boolean complete;
    private FloatingActionButton completed;
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getActivity();
    }
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            getFragmentManager().popBackStack();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
