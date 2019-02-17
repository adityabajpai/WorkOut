package com.android.workout.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.workout.R;

public class ExcerciseStartedActivity extends AppCompatActivity {

    ProgressBar progressBar, progressBar_excercise1, progressBar_excercise2, progressBar_excercise3, progressBar_excercise4, progressBar_excercise5, progressBar_excercise6;
    Thread t, t1, t2, t3, t4, t5, t6;
    int count = 0;
    Runnable runnable;
    Handler handler;
    int max[] = {20,20,20,15,20,30};
    String excercise_name[] = {"pushUps","squats","legRaise","jumpingJack","squatsAgain","plankWithLegFit"};
    String ex[] = {"PUSHUPS","SQUATS","LEG RAISE","JUMPING JACK","SQUATS","PLANK WITH LEG FIT"};
    int excercise_number = 0;
    String current_excercie = "";
    ViewFlipper viewFlipper;
    public int[] image_array_pushUps = {R.drawable.push_up_a,R.drawable.push_up_b};
    public int[] image_array_squats = {R.drawable.squats_a,R.drawable.squats_b};
    public int[] image_array_legRaise = {R.drawable.leg_raise_a,R.drawable.leg_raise_b};
    public int[] image_array_jumpingJack = {R.drawable.jumping_a,R.drawable.jumping_b,R.drawable.jumping_c};
    public int[] image_array_plank = {R.drawable.plank_with_leg_lift_a,R.drawable.plank_with_leg_lift_b,R.drawable.plank_with_leg_lift_c};
    TextView tv_excercise_name, tv_countDown;
    ImageButton img_btn;

    @Override
    public void onBackPressed() {

            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                    .setMessage("Would you like to repeat this workout?")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(ExcerciseStartedActivity.this, ExcerciseActivity.class));
                            finish();
                        }
                    }).setNegativeButton("no", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_started);

        progressBar = findViewById(R.id.progress_bar);
        progressBar_excercise1 = findViewById(R.id.progress_bar_excercise1);
        progressBar_excercise1.setMax(20);
        progressBar_excercise2 = findViewById(R.id.progress_bar_excercise2);
        progressBar_excercise2.setMax(20);
        progressBar_excercise3 = findViewById(R.id.progress_bar_excercise3);
        progressBar_excercise3.setMax(20);
        progressBar_excercise4 = findViewById(R.id.progress_bar_excercise4);
        progressBar_excercise4.setMax(15);
        progressBar_excercise5 = findViewById(R.id.progress_bar_excercise5);
        progressBar_excercise5.setMax(20);
        progressBar_excercise6 = findViewById(R.id.progress_bar_excercise6);
        progressBar_excercise6.setMax(30);
        viewFlipper = findViewById(R.id.flipper);
        tv_excercise_name = findViewById(R.id.name);
        tv_countDown = findViewById(R.id.countDown);
        img_btn = findViewById(R.id.button);

        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        for (int i = 0; i < image_array_pushUps.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_pushUps[i]);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(1000);
        viewFlipper.setAutoStart(true);
        viewFlipper.stopFlipping();


//        for (int i = 0; i < image_array_squats.length; i++) {
//            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(image_array_squats[i]);
//            viewFlipper.addView(imageView);
//        }
//        viewFlipper.setFlipInterval(500);
//        viewFlipper.setAutoStart(true);
//
//        for (int i = 0; i < image_array_legRaise.length; i++) {
//            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(image_array_legRaise[i]);
//            viewFlipper.addView(imageView);
//        }
//        viewFlipper.setFlipInterval(500);
//        viewFlipper.setAutoStart(true);
//
//        for (int i = 0; i < image_array_jumpingJack.length; i++) {
//            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(image_array_jumpingJack[i]);
//            viewFlipper.addView(imageView);
//        }
//        viewFlipper.setFlipInterval(500);
//        viewFlipper.setAutoStart(true);
//
//        for (int i = 0; i < image_array_squats.length; i++) {
//            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(image_array_squats[i]);
//            viewFlipper.addView(imageView);
//        }
//        viewFlipper.setFlipInterval(500);
//        viewFlipper.setAutoStart(true);
//
//        for (int i = 0; i < image_array_plank.length; i++) {
//            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(image_array_plank[i]);
//            viewFlipper.addView(imageView);
//        }
//        viewFlipper.setFlipInterval(500);
//        viewFlipper.setAutoStart(true);

        t = new Thread(){
            @Override
            public void run() {
                progressBar.setMax(20);
                tv_excercise_name.setText(ex[excercise_number]);
                while (count<=18)
                {
                    try {
                        Thread.sleep(2000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                tv_countDown.setText(String.valueOf(count));
                                progressBar.setProgress(count);
                            }
                        });
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                progressBar.setProgress(0);
                progressBar_excercise1.setProgress(20);
                tv_countDown.setText("0");
                t.interrupt();
                t1.start();
            }
        };


        t1 = new Thread(){
            @Override
            public void run() {
                progressBar.setMax(20);
                while (count<=20)
                {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                progressBar.setProgress(count);
                            }
                        });
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                progressBar.setProgress(0);
                progressBar_excercise1.setProgress(20);
                t.interrupt();
            }
        };

        t2 = new Thread(){
            @Override
            public void run() {
                progressBar.setMax(20);
                while (count<=20)
                {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                progressBar.setProgress(count);
                            }
                        });
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                progressBar.setProgress(0);
                progressBar_excercise1.setProgress(20);
                t1.interrupt();
            }
        };

        t3 = new Thread(){
            @Override
            public void run() {
                progressBar.setMax(15);
                while (count<=15)
                {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                progressBar.setProgress(count);
                            }
                        });
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                progressBar.setProgress(0);
                progressBar_excercise1.setProgress(20);
                t2.interrupt();
            }
        };


        t4 = new Thread(){
            @Override
            public void run() {
                progressBar.setMax(20);
                while (count<=20)
                {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                progressBar.setProgress(count);
                            }
                        });
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                progressBar.setProgress(0);
                progressBar_excercise1.setProgress(20);
                t3.interrupt();
            }
        };


        t5 = new Thread(){
            @Override
            public void run() {
                progressBar.setMax(30);
                while (count<=30)
                {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                progressBar.setProgress(count);
                            }
                        });
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                progressBar.setProgress(0);
                progressBar_excercise1.setProgress(20);
                t4.interrupt();
            }
        };

        t.start();

    }
}
