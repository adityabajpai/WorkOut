package com.android.workout.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.android.workout.R;
import com.android.workout.fragments.MealPlanFragment;

public class MealsMainActivity extends AppCompatActivity {

    public void onBackPressed() {
        switch (getSupportFragmentManager().getBackStackEntryCount()) {
            case 0:
                super.onBackPressed();
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                finish();
                break;
            case 1:
                break;
            default:
                getFragmentManager().popBackStack();
                break;
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.meals_activity_main);
        if (bundle == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.meals_content_fragment, new MealPlanFragment());
            beginTransaction.commit();
        }
    }

}
