package com.android.workout.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.workout.fragments.Tipsfragment;

public class PagerAdapter_tips extends FragmentStatePagerAdapter {
    public PagerAdapter_tips(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment tipsfragment = new Tipsfragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pos", i);
        tipsfragment.setArguments(bundle);
        return tipsfragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
