package com.android.workout.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.workout.R;


public class ExcerciseStartedActivity extends AppCompatActivity {

    public static ProgressBar progressBar, progressBar_excercise1, progressBar_excercise2, progressBar_excercise3, progressBar_excercise4, progressBar_excercise5, progressBar_excercise6;
    Thread t, t1, t2, t3, t4, t5, t6;
    int count = 0;
    Runnable runnable;
    Handler handler;
    int max[] = {20, 20, 20, 15, 20, 30};
    String excercise_name[] = {"pushUps", "squats", "legRaise", "jumpingJack", "squatsAgain", "plankWithLegFit"};
    String ex[] = {"PUSHUPS", "SQUATS", "LEG RAISE", "JUMPING JACK", "SQUATS", "PLANK WITH LEG FIT"};
    int excercise_number = 0;
    String current_excercie = "";
    public static ViewFlipper viewFlipper_pushups, viewFlipper_squats, viewFlipper_legRaise, viewFlipper_jumpingJack, viewFlipper_squatsAgain, viewFlipper_plankwithlegFit;
    public int[] image_array = {R.drawable.push_up_a, R.drawable.push_up_b, R.drawable.squats_a, R.drawable.squats_b, R.drawable.leg_raise_a, R.drawable.leg_raise_b, R.drawable.jumping_a, R.drawable.jumping_b, R.drawable.jumping_c, R.drawable.plank_with_leg_lift_a, R.drawable.plank_with_leg_lift_b, R.drawable.plank_with_leg_lift_c};
    public int[] image_array_pushUps = {R.drawable.push_up_a, R.drawable.push_up_b};
    public int[] image_array_squats = {R.drawable.squats_a, R.drawable.squats_b};
    public int[] image_array_legRaise = {R.drawable.leg_raise_a, R.drawable.leg_raise_b};
    public int[] image_array_jumpingJack = {R.drawable.jumping_a, R.drawable.jumping_b, R.drawable.jumping_c};
    public int[] image_array_plank = {R.drawable.plank_with_leg_lift_a, R.drawable.plank_with_leg_lift_b, R.drawable.plank_with_leg_lift_c};
    public static TextView tv_excercise_name, tv_countDown, tv_totalSet;
    ImageButton img_btn;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    TextView tv_countDownNextExcercise, tv_nextExcerciseName, tv_nextExcerciseTotalSet;
    CountDownTimer c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12;
    boolean isRunningC1 = false, isRunningC2 = false, isRunningC3 = false, isRunningC4 = false, isRunningC5 = false, isRunningC6 = false;
    boolean isRunningC7 = false, isRunningC8 = false, isRunningC9 = false, isRunningC10 = false, isRunningC11 = false, isRunningC12 = false;


    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Would you like to repeat this workout?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(isRunningC1)
                        {
                            c1.cancel();
                        }
                        if(isRunningC2)
                        {
                            c2.cancel();
                        }
                        if(isRunningC3)
                        {
                            c3.cancel();
                        }
                        if(isRunningC4)
                        {
                            c4.cancel();
                        }
                        if(isRunningC5)
                        {
                            c5.cancel();
                        }
                        if(isRunningC6)
                        {
                            c6.cancel();
                        }
                        if(isRunningC7)
                        {
                            c7.cancel();
                        }
                        if(isRunningC8)
                        {
                            c8.cancel();
                        }
                        if(isRunningC9)
                        {
                            c9.cancel();
                        }
                        if(isRunningC10)
                        {
                            c10.cancel();
                        }
                        if(isRunningC11)
                        {
                            c11.cancel();
                        }
                        if(isRunningC12)
                        {
                            c12.cancel();
                        }

                        progressBar_excercise1.setProgress(0);
                        progressBar_excercise2.setProgress(0);
                        progressBar_excercise3.setProgress(0);
                        progressBar_excercise4.setProgress(0);
                        progressBar_excercise5.setProgress(0);
                        progressBar_excercise6.setProgress(0);
                        progressBar.setProgress(0);
                        startActivity(new Intent(ExcerciseStartedActivity.this, ExcerciseActivity.class));
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_started);

        PowerManager powerManager = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
        @SuppressLint("InvalidWakeLockTag") final PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Lock");
        wakeLock.acquire();
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
        progressBar_excercise1.setProgress(0);
        progressBar_excercise2.setProgress(0);
        progressBar_excercise3.setProgress(0);
        progressBar_excercise4.setProgress(0);
        progressBar_excercise5.setProgress(0);
        progressBar_excercise6.setProgress(0);
        progressBar.setProgress(0);
        viewFlipper_pushups = findViewById(R.id.flipper_pushups);
        viewFlipper_squats = findViewById(R.id.flipper_squats);
        viewFlipper_legRaise = findViewById(R.id.flipper_legRaise);
        viewFlipper_jumpingJack = findViewById(R.id.flipper_jumpingjack);
        viewFlipper_squatsAgain = findViewById(R.id.flipper_squatsAgain);
        viewFlipper_plankwithlegFit = findViewById(R.id.flipper_plankwithlegFit);
        tv_excercise_name = findViewById(R.id.name);
        tv_countDown = findViewById(R.id.countDown);
        tv_totalSet = findViewById(R.id.totalset);
        img_btn = findViewById(R.id.button);
        relativeLayout = findViewById(R.id.excerciselayout);
        linearLayout = findViewById(R.id.nextExcericseBeforeStart);
        tv_countDownNextExcercise = findViewById(R.id.countDownNextExcercise);
        tv_nextExcerciseName = findViewById(R.id.nextExcerciseName);
        tv_nextExcerciseTotalSet = findViewById(R.id.nextExcerciTotalSet);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRunningC1)
                {
                    
                }
            }
        });

        viewFlipper_squats.setVisibility(View.INVISIBLE);
        viewFlipper_legRaise.setVisibility(View.INVISIBLE);
        viewFlipper_jumpingJack.setVisibility(View.INVISIBLE);
        viewFlipper_squatsAgain.setVisibility(View.INVISIBLE);
        viewFlipper_plankwithlegFit.setVisibility(View.INVISIBLE);
        int check = 0;
        for (int i = 0; i < image_array_pushUps.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_pushUps[i]);
            viewFlipper_pushups.addView(imageView);
        }
        viewFlipper_pushups.setFlipInterval(1000);
        viewFlipper_pushups.setAutoStart(true);
//        viewFlipper_pushups.stopFlipping();

        for (int i = 0; i < image_array_squats.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_squats[i]);
            viewFlipper_squats.addView(imageView);
        }
        viewFlipper_squats.setFlipInterval(1000);
        viewFlipper_squats.setAutoStart(true);

        for (int i = 0; i < image_array_legRaise.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_legRaise[i]);
            viewFlipper_legRaise.addView(imageView);
        }
        viewFlipper_legRaise.setFlipInterval(1000);
        viewFlipper_legRaise.setAutoStart(true);

        for (int i = 0; i < image_array_jumpingJack.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_jumpingJack[i]);
            viewFlipper_jumpingJack.addView(imageView);
        }
        viewFlipper_jumpingJack.setFlipInterval(1000);
        viewFlipper_jumpingJack.setAutoStart(true);

        for (int i = 0; i < image_array_squats.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_squats[i]);
            viewFlipper_squatsAgain.addView(imageView);
        }
        viewFlipper_squatsAgain.setFlipInterval(1000);
        viewFlipper_squatsAgain.setAutoStart(true);

        for (int i = 0; i < image_array_plank.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_plank[i]);
            viewFlipper_plankwithlegFit.addView(imageView);
        }
        viewFlipper_plankwithlegFit.setFlipInterval(1000);
        viewFlipper_plankwithlegFit.setAutoStart(true);

        c1 = new CountDownTimer(42000, 2000) {

            public void onTick(long millisUntilFinished) {
                isRunningC1 = true;
                progressBar.setMax(20);
                long progress = ((42000 - millisUntilFinished) / 1000) / 2;
                progressBar.setProgress((int) progress);
                tv_countDown.setText(((42000 - millisUntilFinished) / 1000) / 2 + "");
            }

            public void onFinish() {
                isRunningC2 = false;
                c1.cancel();
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);

                c2 = new CountDownTimer(30000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        isRunningC2 = true;
                        tv_countDownNextExcercise.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        isRunningC2 = false;
                        c2.cancel();
                        linearLayout.setVisibility(View.INVISIBLE);
                        relativeLayout.setVisibility(View.VISIBLE);
                        viewFlipper_pushups.setVisibility(View.INVISIBLE);
                        viewFlipper_squats.setVisibility(View.VISIBLE);
                        progressBar_excercise1.setProgress(20);
                        progressBar.setProgress(0);
                        c3 = new CountDownTimer(42000, 2000) {
                            public void onTick(long millisUntilFinished) {
                                isRunningC3 = true;
                                progressBar.setMax(20);
                                long progress = ((42000 - millisUntilFinished) / 1000) / 2;
                                progressBar.setProgress((int) progress);
                                tv_countDown.setText(((42000 - millisUntilFinished) / 1000) / 2 + "");
                            }

                            public void onFinish() {
                                isRunningC3 = false;
                                c3.cancel();
                                relativeLayout.setVisibility(View.INVISIBLE);
                                linearLayout.setVisibility(View.VISIBLE);
                                tv_nextExcerciseName.setText("LEG RAISE");
                                c4 = new CountDownTimer(30000, 1000) {
                                    public void onTick(long millisUntilFinished) {
                                        isRunningC4 = true;
                                        tv_countDownNextExcercise.setText("" + millisUntilFinished / 1000);
                                    }
                                    public void onFinish() {
                                        isRunningC4 = false;
                                        c4.cancel();
                                        linearLayout.setVisibility(View.INVISIBLE);
                                        relativeLayout.setVisibility(View.VISIBLE);
                                        viewFlipper_squats.stopFlipping();
                                        viewFlipper_squats.setVisibility(View.INVISIBLE);
                                        viewFlipper_legRaise.setVisibility(View.VISIBLE);
                                        progressBar_excercise2.setProgress(20);
                                        progressBar.setProgress(0);
                                        c5 = new CountDownTimer(42000, 2000) {

                                            public void onTick(long millisUntilFinished) {
                                                isRunningC5 = true;
                                                progressBar.setMax(20);
                                                long progress = ((42000 - millisUntilFinished) / 1000) / 2;
                                                progressBar.setProgress((int) progress);
                                                tv_countDown.setText(((42000 - millisUntilFinished) / 1000) / 2 + "");
                                            }

                                            public void onFinish() {
                                                isRunningC5 = false;
                                                c5.cancel();
                                                relativeLayout.setVisibility(View.INVISIBLE);
                                                linearLayout.setVisibility(View.VISIBLE);
                                                tv_nextExcerciseName.setText("JUMPING JACK");
                                                tv_nextExcerciseTotalSet.setText("x15");
                                                c6 = new CountDownTimer(30000, 1000) {
                                                    @Override
                                                    public void onTick(long millisUntilFinished) {
                                                        isRunningC6= true;
                                                        tv_countDownNextExcercise.setText("" + millisUntilFinished / 1000);
                                                    }

                                                    @Override
                                                    public void onFinish() {
                                                        isRunningC6 = false;
                                                        c6.cancel();
                                                        //                                viewFlipper_squats.stopFlipping();
                                                        linearLayout.setVisibility(View.INVISIBLE);
                                                        relativeLayout.setVisibility(View.VISIBLE);
                                                        viewFlipper_legRaise.setVisibility(View.INVISIBLE);
                                                        viewFlipper_jumpingJack.setVisibility(View.VISIBLE);
//                                viewFlipper_jumpingJack.startFlipping();
                                                        progressBar_excercise3.setProgress(20);
                                                        progressBar.setProgress(0);
                                                        tv_totalSet.setText("/15");
                                                        c7 = new CountDownTimer(32000, 2000) {

                                                            public void onTick(long millisUntilFinished) {
                                                                isRunningC7 =true;
                                                                progressBar.setMax(15);
                                                                long progress = ((32000 - millisUntilFinished) / 1000) / 2;
                                                                progressBar.setProgress((int) progress);
                                                                tv_countDown.setText(((32000 - millisUntilFinished) / 1000) / 2 + "");
                                                            }

                                                            public void onFinish() {
                                                                isRunningC7 = false;
                                                                c7.cancel();
                                                                relativeLayout.setVisibility(View.INVISIBLE);
                                                                linearLayout.setVisibility(View.VISIBLE);
                                                                tv_nextExcerciseName.setText("SQUATS");
                                                                tv_nextExcerciseTotalSet.setText("x20");
                                                                c8 = new CountDownTimer(30000, 1000) {
                                                                    @Override
                                                                    public void onTick(long millisUntilFinished) {
                                                                        isRunningC8 = true;
                                                                        tv_countDownNextExcercise.setText("" + millisUntilFinished / 1000);
                                                                    }

                                                                    @Override
                                                                    public void onFinish() {
                                                                        isRunningC8 = false;
                                                                        c8.cancel();
                                                                        linearLayout.setVisibility(View.INVISIBLE);
                                                                        relativeLayout.setVisibility(View.VISIBLE);
                                                                        viewFlipper_jumpingJack.stopFlipping();
                                                                        viewFlipper_jumpingJack.setVisibility(View.INVISIBLE);
                                                                        viewFlipper_squatsAgain.setVisibility(View.VISIBLE);
//                                        viewFlipper_squatsAgain.startFlipping();
                                                                        progressBar_excercise4.setProgress(15);
                                                                        progressBar.setProgress(0);
                                                                        tv_totalSet.setText("/20");
                                                                        c9 = new CountDownTimer(42000, 2000) {

                                                                            public void onTick(long millisUntilFinished) {
                                                                                isRunningC9=true;
                                                                                progressBar.setMax(20);
                                                                                long progress = ((42000 - millisUntilFinished) / 1000) / 2;
                                                                                progressBar.setProgress((int) progress);
                                                                                tv_countDown.setText(((42000 - millisUntilFinished) / 1000) / 2 + "");
                                                                            }

                                                                            public void onFinish() {
                                                                                isRunningC9 = false;
                                                                                c9.cancel();
                                                                                relativeLayout.setVisibility(View.INVISIBLE);
                                                                                linearLayout.setVisibility(View.VISIBLE);
                                                                                tv_nextExcerciseName.setText("PLANK WITH LEG FIT");
                                                                                tv_nextExcerciseTotalSet.setText("x30");
                                                                                c10 = new CountDownTimer(30000, 1000) {
                                                                                    @Override
                                                                                    public void onTick(long millisUntilFinished) {
                                                                                        isRunningC10 = true;
                                                                                        tv_countDownNextExcercise.setText("" + millisUntilFinished / 1000);
                                                                                    }

                                                                                    @Override
                                                                                    public void onFinish() {
                                                                                        isRunningC10 = false;
                                                                                        c10.cancel();
                                                                                        //                                                viewFlipper_squatsAgain.stopFlipping();
                                                                                        linearLayout.setVisibility(View.INVISIBLE);
                                                                                        relativeLayout.setVisibility(View.VISIBLE);
                                                                                        viewFlipper_squatsAgain.setVisibility(View.INVISIBLE);
                                                                                        viewFlipper_plankwithlegFit.setVisibility(View.VISIBLE);
//                                                viewFlipper_plankwithlegFit.startFlipping();
                                                                                        progressBar_excercise5.setProgress(20);
                                                                                        progressBar.setProgress(0);
                                                                                        tv_totalSet.setText("/30");
                                                                                        c11 = new CountDownTimer(62000, 2000) {

                                                                                            public void onTick(long millisUntilFinished) {
                                                                                                isRunningC11 = true;
                                                                                                progressBar.setMax(30);
                                                                                                long progress = ((62000 - millisUntilFinished) / 1000) / 2;
                                                                                                progressBar.setProgress((int) progress);
                                                                                                tv_countDown.setText(((62000 - millisUntilFinished) / 1000) / 2 + "");
                                                                                            }

                                                                                            public void onFinish() {
                                                                                                isRunningC11 = false;
                                                                                                c11.cancel();
                                                                                                relativeLayout.setVisibility(View.INVISIBLE);
                                                                                                linearLayout.setVisibility(View.VISIBLE);
                                                                                                c12 = new CountDownTimer(10000, 1000) {
                                                                                                    @Override
                                                                                                    public void onTick(long millisUntilFinished) {
                                                                                                        isRunningC12= true;
                                                                                                        tv_nextExcerciseTotalSet.setVisibility(View.INVISIBLE);
                                                                                                        tv_nextExcerciseName.setText("TODAY EXCERCISE DONE");
                                                                                                        tv_countDownNextExcercise.setText("" + millisUntilFinished / 1000);
                                                                                                    }

                                                                                                    @Override
                                                                                                    public void onFinish() {
                                                                                                        isRunningC12 = false;
                                                                                                        c12.cancel();
                                                                                                        progressBar_excercise6.setProgress(30);
                                                                                                        startActivity(new Intent(ExcerciseStartedActivity.this,HomeActivity.class));
                                                                                                        finish();
                                                                                                        progressBar_excercise1.setProgress(0);
                                                                                                        progressBar_excercise2.setProgress(0);
                                                                                                        progressBar_excercise3.setProgress(0);
                                                                                                        progressBar_excercise4.setProgress(0);
                                                                                                        progressBar_excercise5.setProgress(0);
                                                                                                        progressBar_excercise6.setProgress(0);
                                                                                                        wakeLock.release();
                                                                                                    }
                                                                                                }.start();
                                                                                            }
                                                                                        }.start();
                                                                                    }
                                                                                }.start();
                                                                            }
                                                                        }.start();
                                                                    }
                                                                }.start();
                                                            }
                                                        }.start();
                                                    }
                                                }.start();
                                            }
                                        }.start();
                                    }
                                }.start();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();

    }
}