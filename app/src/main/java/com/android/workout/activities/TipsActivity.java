package com.android.workout.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.android.workout.fragments.BlankFragment;

public class TipsActivity extends AppCompatActivity {

    ViewPager viewPager;

    public class pageAdapter extends FragmentStatePagerAdapter {

        final TipsActivity tipsActivity;

        public pageAdapter(FragmentManager fm, TipsActivity tipsActivity) {
            super(fm);
            this.tipsActivity = tipsActivity;
        }

        @Override
        public Fragment getItem(int i) {
            return new BlankFragment();
        }

        @Override
        public int getCount() {
            return 10;
        }
    }

}
