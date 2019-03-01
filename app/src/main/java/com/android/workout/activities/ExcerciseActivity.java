package com.android.workout.activities;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.workout.R;

import java.lang.reflect.Type;

public class ExcerciseActivity extends AppCompatActivity {

    LinearLayout ll_pushups, ll_squats, ll_legraise, ll_jumpingjack, ll_squatsagain, ll_plankwithlegfit;
    String excercise = "";
    Button btn_start;
    ViewFlipper viewFlipperPushUps, viewFlipperSquats, viewFlipper_legRaise, viewFlipper_jumpingJack, viewFlipper_squatsAgain, viewFlipper_plankWithLegFit;
//    public int[] image_array_pushUps = {R.drawable.push_up_a,R.drawable.push_up_b};
//    public int[] image_array_squats = {R.drawable.squats_a,R.drawable.squats_b};
//    public int[] image_array_legRaise = {R.drawable.leg_raise_a,R.drawable.leg_raise_b};
//    public int[] image_array_jumpingJack = {R.drawable.jumping_a,R.drawable.jumping_b,R.drawable.jumping_c};
//    public int[] image_array_plank = {R.drawable.plank_with_leg_lift_a,R.drawable.plank_with_leg_lift_b,R.drawable.plank_with_leg_lift_c};
    Bundle bundle;
    int dayNo;
    TextView tv_cycles1, tv_cycles2, tv_cycles3, tv_cycles4, tv_cycles5, tv_cycles6;
    TextView tv_name1, tv_name2, tv_name3, tv_name4, tv_name5, tv_name6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise);
        bundle = getIntent().getExtras();
        dayNo = bundle.getInt("day");
        ll_pushups = findViewById(R.id.linearPushUps);
        ll_squats = findViewById(R.id.linearSquats);
        ll_legraise = findViewById(R.id.linearLegRaise);
        ll_jumpingjack = findViewById(R.id.linearJumpingJack);
        ll_squatsagain = findViewById(R.id.linearSquatsAgain);
        ll_plankwithlegfit = findViewById(R.id.linearPlankWithLegFit);
        tv_cycles1 = findViewById(R.id.firstExcerciseCycle);
        tv_cycles2 = findViewById(R.id.secondExcerciseCycle);
        tv_cycles3 = findViewById(R.id.thirdExcerciseCycle);
        tv_cycles4 = findViewById(R.id.fourthExcerciseCycle);
        tv_cycles5 = findViewById(R.id.fiveExcerciseCycle);
        tv_cycles6 = findViewById(R.id.sixExcerciseCycle);
        tv_name1 = findViewById(R.id.firstExcerciseName);
        tv_name2 = findViewById(R.id.secondExcerciseName);
        tv_name3 = findViewById(R.id.thirdExcerciseName);
        tv_name4 = findViewById(R.id.fourthExcerciseName);
        tv_name5 = findViewById(R.id.fiveExcerciseName);
        tv_name6 = findViewById(R.id.sixExcerciseName);
        btn_start = findViewById(R.id.startButton);


        final TypedArray typedArray_cycles = getResources().obtainTypedArray(R.array.cycles);
//        final TypedArray typedArray_cycles = getResources().obtainTypedArray(R.id.cycles)
        int cycles_on_day = typedArray_cycles.getResourceId(dayNo-1,-1);
        final int[] typedArray_cycles1 = getResources().getIntArray(cycles_on_day);
//        for(int i=0;i<typedArray_cycles1.length;i++)
//        {
//            Toast.makeText(ExcerciseActivity.this,typedArray_cycles1[i]+"",Toast.LENGTH_SHORT).show();
//        }
        tv_cycles1.setText("x"+typedArray_cycles1[0]+"");
        tv_cycles2.setText("x"+typedArray_cycles1[1]+"");
        tv_cycles3.setText("x"+typedArray_cycles1[2]+"");
        tv_cycles4.setText("x"+typedArray_cycles1[3]+"");
        tv_cycles5.setText("x"+typedArray_cycles1[4]+"");
        tv_cycles6.setText("x"+typedArray_cycles1[5]+"");

        final TypedArray typedArray_name = getResources().obtainTypedArray(R.array.names);
        int names_on_day = typedArray_name.getResourceId(dayNo-1,-1);
        final String[] typedArray_names1 = getResources().getStringArray(names_on_day);
        tv_name1.setText(typedArray_names1[0]);
        tv_name2.setText(typedArray_names1[1]);
        tv_name3.setText(typedArray_names1[2]);
        tv_name4.setText(typedArray_names1[3]);
        tv_name5.setText(typedArray_names1[4]);
        tv_name6.setText(typedArray_names1[5]);


        final TypedArray typedArray_totalDays = getResources().obtainTypedArray(R.array.total);
        int day_no_from_array = typedArray_totalDays.getResourceId(dayNo-1,-1);
        final TypedArray typedArray1 = getResources().obtainTypedArray(day_no_from_array);
        final int temp1 = typedArray1.getResourceId(0,-1);
        final TypedArray testArrayIcon1 = getResources().obtainTypedArray(temp1);
        viewFlipperPushUps = (ViewFlipper) findViewById(R.id.viewFlipperPushUps);
        for (int i = 0; i < getResources().getStringArray(temp1).length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon1.getResourceId(i,-1)); // set image in ImageView
            viewFlipperPushUps.addView(imageView); // add the created ImageView in ViewFlipper
        }
        viewFlipperPushUps.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipperPushUps.setAutoStart(true);

        final int temp2 = typedArray1.getResourceId(1,-1);
        final TypedArray testArrayIcon2 = getResources().obtainTypedArray(temp2);
        viewFlipperSquats = findViewById(R.id.viewFlipperSquats);
        for (int i = 0; i < getResources().getStringArray(temp2).length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon2.getResourceId(i,-1)); // set image in ImageView
            viewFlipperSquats.addView(imageView); // add the created ImageView in ViewFlipper
        }
        viewFlipperSquats.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipperSquats.setAutoStart(true);


        final int temp3 = typedArray1.getResourceId(2,-1);
        final TypedArray testArrayIcon3 = getResources().obtainTypedArray(temp3);
        viewFlipper_legRaise = findViewById(R.id.viewFlipperLegRaise);
        for (int i = 0; i < getResources().getStringArray(temp3).length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon3.getResourceId(i,-1)); // set image in ImageView
            viewFlipper_legRaise.addView(imageView); // add the created ImageView in ViewFlipper
        }
        viewFlipper_legRaise.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipper_legRaise.setAutoStart(true);



        final int temp4 = typedArray1.getResourceId(3,-1);
        final TypedArray testArrayIcon4 = getResources().obtainTypedArray(temp4);
        viewFlipper_jumpingJack = findViewById(R.id.viewFlipperJumpingJack);
        for (int i = 0; i < getResources().getStringArray(temp4).length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon4.getResourceId(i,-1)); // set image in ImageView
            viewFlipper_jumpingJack.addView(imageView); // add the created ImageView in ViewFlipper
        }
        viewFlipper_jumpingJack.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipper_jumpingJack.setAutoStart(true);



        final int temp5 = typedArray1.getResourceId(4,-1);
        final TypedArray testArrayIcon5 = getResources().obtainTypedArray(temp5);
        viewFlipper_squatsAgain = findViewById(R.id.viewFlipperSquatsAgain);
        for (int i = 0; i < getResources().getStringArray(temp5).length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon5.getResourceId(i,-1)); // set image in ImageView
            viewFlipper_squatsAgain.addView(imageView); // add the created ImageView in ViewFlipper
        }
        viewFlipper_squatsAgain.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipper_squatsAgain.setAutoStart(true);


        final int temp10 = typedArray1.getResourceId(5,-1);
        final TypedArray testArrayIcon10 = getResources().obtainTypedArray(temp10);
        viewFlipper_plankWithLegFit = findViewById(R.id.viewFlipperPlankWithLegFit);
        for (int i = 0; i < getResources().getStringArray(temp10).length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon10.getResourceId(i,-1)); // set image in ImageView
            viewFlipper_plankWithLegFit.addView(imageView); // add the created ImageView in ViewFlipper
        }
        viewFlipper_plankWithLegFit.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipper_plankWithLegFit.setAutoStart(true);



        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle = new Bundle();
                bundle.putInt("day",dayNo);
                Intent intent = new Intent(ExcerciseActivity.this, ExcerciseStartActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        ll_pushups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excercise = tv_name1.getText()+"";
                Log.d("excercise",excercise);
                Bundle bundle = new Bundle();
                bundle.putString("excercise",excercise);
                Intent intent = new Intent(ExcerciseActivity.this, ExcerciseDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        ll_squats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excercise = tv_name2.getText()+"";
                Log.d("excercise",excercise);
                Bundle bundle = new Bundle();
                bundle.putString("excercise",excercise);
                Intent intent = new Intent(ExcerciseActivity.this,ExcerciseDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        ll_legraise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excercise = tv_name3.getText()+"";
                Log.d("excercise",excercise);
                Bundle bundle = new Bundle();
                bundle.putString("excercise",excercise);
                Intent intent = new Intent(ExcerciseActivity.this,ExcerciseDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        ll_jumpingjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excercise = tv_name4.getText()+"";
                Log.d("excercise",excercise);
                Bundle bundle = new Bundle();
                bundle.putString("excercise",excercise);
                Intent intent = new Intent(ExcerciseActivity.this,ExcerciseDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        ll_squatsagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excercise = tv_name5.getText()+"";
                Log.d("excercise",excercise);
                Bundle bundle = new Bundle();
                bundle.putString("excercise",excercise);
                Intent intent = new Intent(ExcerciseActivity.this,ExcerciseDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        ll_plankwithlegfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excercise = tv_name6.getText()+"";
                Log.d("excercise",excercise);
                Bundle bundle = new Bundle();
                bundle.putString("excercise",excercise);
                Intent intent = new Intent(ExcerciseActivity.this,ExcerciseDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
    }
}
