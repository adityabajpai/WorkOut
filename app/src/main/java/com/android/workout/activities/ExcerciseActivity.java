package com.android.workout.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.android.workout.R;

public class ExcerciseActivity extends AppCompatActivity {

    LinearLayout ll_pushups, ll_squats, ll_legraise, ll_jumpingjack, ll_squatsagain, ll_plankwithlegfit;
    String excercise = "";
    Button btn_start;
    ViewFlipper viewFlipperPushUps, viewFlipperSquats, viewFlipper_legRaise, viewFlipper_jumpingJack, viewFlipper_squatsAgain, viewFlipper_plankWithLegFit;
    public int[] image_array_pushUps = {R.drawable.push_up_a,R.drawable.push_up_b};
    public int[] image_array_squats = {R.drawable.squats_a,R.drawable.squats_b};
    public int[] image_array_legRaise = {R.drawable.leg_raise_a,R.drawable.leg_raise_b};
    public int[] image_array_jumpingJack = {R.drawable.jumping_a,R.drawable.jumping_b,R.drawable.jumping_c};
    public int[] image_array_plank = {R.drawable.plank_with_leg_lift_a,R.drawable.plank_with_leg_lift_b,R.drawable.plank_with_leg_lift_c};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise);
        ll_pushups = findViewById(R.id.linearPushUps);
        ll_squats = findViewById(R.id.linearSquats);
        ll_legraise = findViewById(R.id.linearLegRaise);
        ll_jumpingjack = findViewById(R.id.linearJumpingJack);
        ll_squatsagain = findViewById(R.id.linearSquatsAgain);
        ll_plankwithlegfit = findViewById(R.id.linearPlankWithLegFit);
        btn_start = findViewById(R.id.startButton);
        viewFlipperPushUps = (ViewFlipper) findViewById(R.id.viewFlipperPushUps);
        for (int i = 0; i < image_array_pushUps.length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_pushUps[i]); // set image in ImageView
            viewFlipperPushUps.addView(imageView); // add the created ImageView in ViewFlipper
        }
//        // Declare in and out animations and load them using AnimationUtils class
//        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
//        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
//        // set the animation type's to ViewFlipper
//        viewFlipperPushUps.setInAnimation(in);
//        viewFlipperPushUps.setOutAnimation(out);
        // set interval time for flipping between views
        viewFlipperPushUps.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipperPushUps.setAutoStart(true);
        viewFlipperSquats = findViewById(R.id.viewFlipperSquats);
        for (int i = 0; i < image_array_squats.length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_squats[i]); // set image in ImageView
            viewFlipperSquats.addView(imageView); // add the created ImageView in ViewFlipper
        }
        viewFlipperSquats.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipperSquats.setAutoStart(true);

        viewFlipper_legRaise = findViewById(R.id.viewFlipperLegRaise);
        for (int i = 0; i < image_array_legRaise.length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_legRaise[i]); // set image in ImageView
            viewFlipper_legRaise.addView(imageView); // add the created ImageView in ViewFlipper
        }
        viewFlipper_legRaise.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipper_legRaise.setAutoStart(true);



        viewFlipper_jumpingJack = findViewById(R.id.viewFlipperJumpingJack);
        for (int i = 0; i < image_array_jumpingJack.length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_jumpingJack[i]); // set image in ImageView
            viewFlipper_jumpingJack.addView(imageView); // add the created ImageView in ViewFlipper
        }
        viewFlipper_jumpingJack.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipper_jumpingJack.setAutoStart(true);




        viewFlipper_squatsAgain = findViewById(R.id.viewFlipperSquatsAgain);
        for (int i = 0; i < image_array_squats.length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_squats[i]); // set image in ImageView
            viewFlipper_squatsAgain.addView(imageView); // add the created ImageView in ViewFlipper
        }
        viewFlipper_squatsAgain.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipper_squatsAgain.setAutoStart(true);


        viewFlipper_plankWithLegFit = findViewById(R.id.viewFlipperPlankWithLegFit);
        for (int i = 0; i < image_array_plank.length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_plank[i]); // set image in ImageView
            viewFlipper_plankWithLegFit.addView(imageView); // add the created ImageView in ViewFlipper
        }
        viewFlipper_plankWithLegFit.setFlipInterval(500);
        // set auto start for flipping between views
        viewFlipper_plankWithLegFit.setAutoStart(true);



        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExcerciseActivity.this, ExcerciseStartActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ll_pushups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excercise = "pushups";
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
                excercise = "squats";
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
                excercise = "legraise";
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
                excercise = "jumpingjack";
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
                excercise = "squatsagain";
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
                excercise = "plankwithlegfit";
                Log.d("excercise",excercise);
                Bundle bundle = new Bundle();
                bundle.putString("excercise",excercise);
                Intent intent = new Intent(ExcerciseActivity.this,ExcerciseDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
