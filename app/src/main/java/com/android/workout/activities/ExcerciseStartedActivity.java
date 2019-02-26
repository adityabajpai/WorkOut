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
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.workout.R;
import com.android.workout.adapters.WorkoutData;
import com.android.workout.database.DatabaseOperations;


public class ExcerciseStartedActivity extends AppCompatActivity {

    public static ProgressBar progressBar, progressBar_excercise1, progressBar_excercise2, progressBar_excercise3, progressBar_excercise4, progressBar_excercise5, progressBar_excercise6;
    Thread t, t1, t2, t3, t4, t5, t6;
    private DatabaseOperations databaseOperations;
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
    ImageButton img_btn_pause, img_btn_play;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    TextView tv_countDownNextExcercise, tv_nextExcerciseName, tv_nextExcerciseTotalSet;
    CountDownTimer c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12;
    boolean isRunningC1 = false, isRunningC2 = false, isRunningC3 = false, isRunningC4 = false, isRunningC5 = false, isRunningC6 = false;
    boolean isRunningC7 = false, isRunningC8 = false, isRunningC9 = false, isRunningC10 = false, isRunningC11 = false, isRunningC12 = false;
    long totalTime42 = 42000, totalTime32 = 32000, totalTime30 = 30000, totalTime62 = 62000, totalTime10 = 10000;
    long display_time, display_time1, display_time3, display_time5, display_time7, display_time9, display_time11;
    boolean isPausedC1 = false;
    boolean isCanceledC1 =false;

    boolean isPausedC3 = false;
    boolean isCanceledC3 =false;

    boolean isPausedC5 = false;
    boolean isCanceledC5 =false;

    boolean isPausedC7 = false;
    boolean isCanceledC7 =false;

    boolean isPausedC9 = false;
    boolean isCanceledC9 =false;

    boolean isPausedC11 = false;
    boolean isCanceledC11 =false;
    long progress;
    long progress1;

    WorkoutData workoutData = new WorkoutData();
    Bundle bundle;
    int dayNo ;


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
                        int check = databaseOperations.insertExcDayData(workoutData.getDay(),workoutData.getProgress());
                        Log.e("value inserted",""+check);
                        Bundle bundle1 = new Bundle();
                        bundle1.putInt("day",dayNo);
                        startActivity(new Intent(ExcerciseStartedActivity.this, ExcerciseActivity.class).putExtras(bundle1));
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_started);
        bundle = getIntent().getExtras();
        dayNo = bundle.getInt("day");
        workoutData.setDay("Day "+dayNo);
        databaseOperations = new DatabaseOperations(getApplicationContext());
        workoutData.setProgress(0.0f);
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
        img_btn_pause = findViewById(R.id.button_pause);
        img_btn_play = findViewById(R.id.button_play);
        relativeLayout = findViewById(R.id.excerciselayout);
        linearLayout = findViewById(R.id.nextExcericseBeforeStart);
        tv_countDownNextExcercise = findViewById(R.id.countDownNextExcercise);
        tv_nextExcerciseName = findViewById(R.id.nextExcerciseName);
        tv_nextExcerciseTotalSet = findViewById(R.id.nextExcerciTotalSet);
        img_btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRunningC1)
                {
                    isPausedC1 = true;
                    viewFlipper_pushups.stopFlipping();
                    Toast.makeText(ExcerciseStartedActivity.this, "C1", Toast.LENGTH_SHORT).show();
                }
                else if(isRunningC3)
                {
                    isPausedC3 = true;
                    viewFlipper_squats.stopFlipping();
                    Toast.makeText(ExcerciseStartedActivity.this, "C3", Toast.LENGTH_SHORT).show();
                }
                else if(isRunningC5)
                {
                    isPausedC5 = true;
                    viewFlipper_legRaise.stopFlipping();
                    Toast.makeText(ExcerciseStartedActivity.this, "C5", Toast.LENGTH_SHORT).show();
                }
                else if(isRunningC7)
                {
                    isPausedC7 = true;
                    viewFlipper_jumpingJack.stopFlipping();
                    Toast.makeText(ExcerciseStartedActivity.this, "C7", Toast.LENGTH_SHORT).show();
                }
                else if(isRunningC9)
                {
                    isPausedC9 = true;
                    viewFlipper_squatsAgain.stopFlipping();
                    Toast.makeText(ExcerciseStartedActivity.this, "C9", Toast.LENGTH_SHORT).show();
                }
                else if(isRunningC11)
                {
                    isPausedC11 = true;
                    viewFlipper_plankwithlegFit.stopFlipping();
                    Toast.makeText(ExcerciseStartedActivity.this, "C11", Toast.LENGTH_SHORT).show();
                }
                img_btn_pause.setVisibility(View.INVISIBLE);
                img_btn_play.setVisibility(View.VISIBLE);
            }
        });

        img_btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPausedC1)
                {
                    isPausedC1 = false;
                    isCanceledC1 = false;
                    img_btn_play.setVisibility(View.INVISIBLE);
                    img_btn_pause.setVisibility(View.VISIBLE);
                    final long millisInFuture = display_time1;
                    new CountDownTimer(millisInFuture, 2000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(isPausedC1 || isCanceledC1)
                            {
                                //If the user request to cancel or paused the
                                //CountDownTimer we will cancel the current instance
                                cancel();
                            }
                            else
                            {
                                isRunningC1 = true;
                                progressBar.setMax(20);
                                display_time1 = millisUntilFinished;
                                progress = ((millisInFuture - display_time1) / 1000) / 2;
                                progressBar.setProgress((int) progress);
                                tv_countDown.setText(((millisInFuture - display_time1) / 1000) / 2 + "");
                            }
                        }

                        @Override
                        public void onFinish() {
                            isRunningC1 = false;
                            c1.cancel();
                            relativeLayout.setVisibility(View.INVISIBLE);
                            linearLayout.setVisibility(View.VISIBLE);
                            c2.start();
                        }
                    }.start();
                }
                else if(isPausedC3)
                {

                }
                else if(isPausedC5)
                {

                }
                else if(isPausedC7)
                {

                }
                else if(isPausedC9)
                {

                }
                else if(isPausedC11)
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

        c1 = new CountDownTimer(totalTime42, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(isPausedC1 || isCanceledC1)
                {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                }
                else
                {
                    isRunningC1 = true;
                    progressBar.setMax(20);
                    display_time1 = millisUntilFinished;
                    progress = ((totalTime42 - display_time1) / 1000) / 2;
                    progress1 = progress;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText(((totalTime42 - display_time1) / 1000) / 2 + "");
                }
            }

            @Override
            public void onFinish() {
                isRunningC1 = false;
                c1.cancel();
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                c2.start();
            }
        }.start();
        c2 = new CountDownTimer(totalTime30, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                isRunningC2 = true;
                display_time = millisUntilFinished;
                tv_countDownNextExcercise.setText("" + display_time / 1000);
            }

            @Override
            public void onFinish() {
                isRunningC2 = false;
                c2.cancel();
                linearLayout.setVisibility(View.INVISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);
                viewFlipper_pushups.setVisibility(View.INVISIBLE);
                viewFlipper_squats.setVisibility(View.VISIBLE);
                progressBar_excercise1.setProgress(20);
                progressBar.setProgress(0);
                c3.start();
            }
        };
        c3 = new CountDownTimer(totalTime42, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(isPausedC3 || isCanceledC3)
                {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                }
                else
                {
                    isRunningC3 = true;
                    progressBar.setMax(20);
                    display_time3 = millisUntilFinished;
                    long progress = ((totalTime42 - display_time3) / 1000) / 2;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText(((totalTime42 - display_time3) / 1000) / 2 + "");
                }
            }

            @Override
            public void onFinish() {
                isRunningC3 = false;
                c3.cancel();
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                tv_nextExcerciseName.setText("LEG RAISE");
                c4.start();
            }
        };
        c4 = new CountDownTimer(totalTime30, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                isRunningC4 = true;
                display_time = millisUntilFinished;
                tv_countDownNextExcercise.setText("" + display_time / 1000);

            }

            @Override
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
                c5.start();
            }
        };
        c5 = new CountDownTimer(totalTime42, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(isPausedC5 || isCanceledC5)
                {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                }
                else
                {
                    isRunningC5 = true;
                    progressBar.setMax(20);
                    display_time5 = millisUntilFinished;
                    long progress = ((totalTime42 - display_time5) / 1000) / 2;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText(((totalTime42 - display_time5) / 1000) / 2 + "");
                }
            }

            @Override
            public void onFinish() {
                isRunningC5 = false;
                c5.cancel();
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                tv_nextExcerciseName.setText("JUMPING JACK");
                tv_nextExcerciseTotalSet.setText("x15");
                c6.start();
            }
        };
        c6 = new CountDownTimer(totalTime30, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                isRunningC6= true;
                display_time = millisUntilFinished;
                tv_countDownNextExcercise.setText("" + display_time / 1000);

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
                c7.start();
            }
        };
        c7 = new CountDownTimer(totalTime32, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(isPausedC7 || isCanceledC7)
                {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                }
                else
                {
                    isRunningC7 =true;
                    progressBar.setMax(15);
                    display_time7 = millisUntilFinished;
                    long progress = ((totalTime32 - display_time7) / 1000) / 2;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText(((totalTime32 - display_time7) / 1000) / 2 + "");
                }
            }

            @Override
            public void onFinish() {
                isRunningC7 = false;
                c7.cancel();
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                tv_nextExcerciseName.setText("SQUATS");
                tv_nextExcerciseTotalSet.setText("x20");
                c8.start();
            }
        };
        c8 = new CountDownTimer(totalTime30, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                isRunningC8 = true;
                display_time = millisUntilFinished;
                tv_countDownNextExcercise.setText("" + display_time / 1000);

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
                c9.start();
            }
        };
        c9 = new CountDownTimer(totalTime42, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(isPausedC9 || isCanceledC9)
                {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                }
                else
                {
                    isRunningC9=true;
                    progressBar.setMax(20);
                    display_time9 = millisUntilFinished;
                    long progress = ((totalTime42 - display_time9) / 1000) / 2;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText(((totalTime42 - display_time9) / 1000) / 2 + "");
                }
            }

            @Override
            public void onFinish() {
                isRunningC9 = false;
                c9.cancel();
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                tv_nextExcerciseName.setText("PLANK WITH LEG FIT");
                tv_nextExcerciseTotalSet.setText("x30");
                c10.start();
            }
        };
        c10 = new CountDownTimer(totalTime30, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                isRunningC10 = true;
                display_time = millisUntilFinished;
                tv_countDownNextExcercise.setText("" + display_time / 1000);

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
                c11.start();
            }
        };
        c11 = new CountDownTimer(totalTime62, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(isPausedC11 || isCanceledC11)
                {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                }
                else
                {
                    isRunningC11 = true;
                    progressBar.setMax(30);
                    display_time11 = millisUntilFinished;
                    long progress = ((totalTime62 - display_time11) / 1000) / 2;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText(((totalTime62 - display_time11) / 1000) / 2 + "");
                }
            }

            @Override
            public void onFinish() {
                isRunningC11 = false;
                c11.cancel();
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                c12.start();
            }
        };
        c12 = new CountDownTimer(totalTime10, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                isRunningC12= true;
                tv_nextExcerciseTotalSet.setVisibility(View.INVISIBLE);
                tv_nextExcerciseName.setText("TODAY EXCERCISE DONE");
                display_time = millisUntilFinished;
                tv_countDownNextExcercise.setText("" + display_time / 1000);

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
        };
    }
}