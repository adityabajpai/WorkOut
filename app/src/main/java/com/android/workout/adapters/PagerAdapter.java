package com.android.workout.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
        String str;
        String str2;
        switch (i) {
            case 0:
                this.f5543c = new TabFragmentWeek();
                this.f5542b = new Bundle();
                bundle = this.f5542b;
                str = "WEEK";
                str2 = "WEEK1";
                break;
            case 1:
                this.f5543c = new TabFragmentWeek();
                this.f5542b = new Bundle();
                bundle = this.f5542b;
                str = "WEEK";
                str2 = "WEEK2";
                break;
            case 2:
                this.f5543c = new TabFragmentWeek();
                this.f5542b = new Bundle();
                bundle = this.f5542b;
                str = "WEEK";
                str2 = "WEEK3";
                break;
            case 3:
                this.f5543c = new TabFragmentWeek();
                this.f5542b = new Bundle();
                bundle = this.f5542b;
                str = "WEEK";
                str2 = "WEEK4";
                break;
            case 4:
                this.f5543c = new TabFragmentWeek();
                this.f5542b = new Bundle();
                bundle = this.f5542b;
                str = "WEEK";
                str2 = "WEEK5";
                break;
            default:
                return null;
        }
        bundle.putString(str, str2);
        this.f5543c.setArguments(this.f5542b);
        return this.f5543c;
    }
}
