package com.android.workout.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.workout.R;

public class ExcerciseDetailActivity extends AppCompatActivity {

    TextView excercise_detail_text;
    String excercise = "";
    public int[] image_array_pushUps = {R.drawable.push_up_a,R.drawable.push_up_b};
    public int[] image_array_squats = {R.drawable.squats_a,R.drawable.squats_b};
    public int[] image_array_legRaise = {R.drawable.leg_raise_a,R.drawable.leg_raise_b};
    public int[] image_array_jumpingJack = {R.drawable.jumping_a,R.drawable.jumping_b,R.drawable.jumping_c};
    public int[] image_array_plank = {R.drawable.plank_with_leg_lift_a,R.drawable.plank_with_leg_lift_b,R.drawable.plank_with_leg_lift_c};
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_detail);
        excercise_detail_text = findViewById(R.id.excercise_text);
        viewFlipper = findViewById(R.id.imageView);
        Bundle bundle = getIntent().getExtras();
        excercise = bundle.getString("excercise");
        if(excercise.equals("pushups"))
        {
            excercise_detail_text.setText(R.string.desc_pushups);
            for (int i = 0; i < image_array_pushUps.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(image_array_pushUps[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
        }
        else if(excercise.equals("squats"))
        {
            for (int i = 0; i < image_array_squats.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(image_array_squats[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_squats);
        }
        else if(excercise.equals("legraise"))
        {
            for (int i = 0; i < image_array_legRaise.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(image_array_legRaise[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_leg_raise);
        }
        else if(excercise.equals("jumpingjack"))
        {
            for (int i = 0; i < image_array_jumpingJack.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(image_array_jumpingJack[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_jumping_jacks);
        }
        else if(excercise.equals("squatsagain"))
        {
            for (int i = 0; i < image_array_squats.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(image_array_squats[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_squats);
        }
        else if(excercise.equals("plankwithlegfit"))
        {
            for (int i = 0; i < image_array_plank.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(image_array_plank[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_plank_with_leg_lift);
        }
    }
}
