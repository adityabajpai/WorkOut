package com.android.workout.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.android.workout.fragments.TabFragmentWeek;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int f5541a;
    Bundle f5542b;
    TabFragmentWeek f5543c;

    public PagerAdapter(FragmentManager fragmentManager, int i) {
        super(fragmentManager);
        this.f5541a = i;
    }

    public int getCount() {
        return this.f5541a;
    }

    public Fragment getItem(int i) {
        Bundle bundle;
        String str="WEEK";
        String str2 = "WEEK1";
        Log.e("week from adapter",""+i);
        switch (i) {
            case 0:
                this.f5543c = new TabFragmentWeek();
                this.f5542b = new Bundle();
                bundle = this.f5542b;
                str = "WEEK";
                str2 = "WEEK1";
                bundle.putString(str, str2);
                this.f5543c.setArguments(bundle);
                return this.f5543c;
            case 1:
                this.f5543c = new TabFragmentWeek();
                this.f5542b = new Bundle();
                bundle = this.f5542b;
                str = "WEEK";
                str2 = "WEEK2";
                bundle.putString(str, str2);
                this.f5543c.setArguments(bundle);
                return this.f5543c;
            case 2:
                this.f5543c = new TabFragmentWeek();
                this.f5542b = new Bundle();
                bundle = this.f5542b;
                str = "WEEK";
                str2 = "WEEK3";
                bundle.putString(str, str2);
                this.f5543c.setArguments(bundle);
                return this.f5543c;
            case 3:
                this.f5543c = new TabFragmentWeek();
                this.f5542b = new Bundle();
                bundle = this.f5542b;
                str = "WEEK";
                str2 = "WEEK4";
                bundle.putString(str, str2);
                this.f5543c.setArguments(bundle);
                return this.f5543c;
            case 4:
                this.f5543c = new TabFragmentWeek();
                this.f5542b = new Bundle();
                bundle = this.f5542b;
                str = "WEEK";
                str2 = "WEEK5";
                bundle.putString(str, str2);
                this.f5543c.setArguments(bundle);
                return this.f5543c;
            default:
                return null;
        }
    }
}
