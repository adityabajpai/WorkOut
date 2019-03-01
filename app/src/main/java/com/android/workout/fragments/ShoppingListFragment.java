package com.android.workout.fragments;

import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.android.workout.R;
import com.android.workout.adapters.PagerAdapter;

public class ShoppingListFragment extends Fragment {
    private static final String TAG = "ShoppingListFragment";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_shoppinglist, viewGroup, false);
        inflate.setTag(TAG);
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.getNavigationIcon().mutate().setColorFilter(getResources().getColor(R.color.black), Mode.SRC_IN);
        setHasOptionsMenu(true);
        TabLayout tabLayout = (TabLayout) inflate.findViewById(R.id.tab_layout);
        tabLayout.setTabTextColors(getResources().getColor(R.color.black), getResources().getColor(R.color.colorAccent));
        tabLayout.addTab(tabLayout.newTab().setText( R.string.week1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.week2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.week3));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.week4));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.week5));
//        tabLayout.addTab(tabLayout.newTab().setText((CharSequence) "WEEK 4"));
//        tabLayout.addTab(tabLayout.newTab().setText((CharSequence) "WEEK 5"));
        tabLayout.setTabGravity(0);
        final ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.pager);
        viewPager.setAdapter(new PagerAdapter(getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new OnTabSelectedListener() {
            /* renamed from: b */

            public void onTabReselected(Tab tab) {
            }

            public void onTabSelected(Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(Tab tab) {
            }
        });
        return inflate;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            getFragmentManager().popBackStack();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
