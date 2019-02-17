package com.android.workout.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.workout.R;
import com.android.workout.adapters.PagerAdapter_tips;
import com.android.workout.fragments.BlankFragment;
import com.android.workout.utils.DepthPageTransformer;

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

    public void close(View view) {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tips_layout);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        this.viewPager.setAdapter(new PagerAdapter_tips(supportFragmentManager));
        this.viewPager.setClipToPadding(false);
        this.viewPager.setPadding(80, 0, 120, 120);
        this.viewPager.setPageTransformer(true, new DepthPageTransformer());
    }

}
