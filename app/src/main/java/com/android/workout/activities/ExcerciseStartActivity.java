package com.android.workout.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.workout.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExcerciseStartActivity extends AppCompatActivity{

    FloatingActionButton floatingActionButton_play, floatingActionButton_pause;
    MediaPlayer mySong;
    TextView tvCountDown;
    //    int count=10;
    TextView btn_skip;
    //    Thread t;
    long totaltime;
    CountDownTimer c1;
    boolean c1_isRunning = true;
    long play_time, pause_time, diff;
    long sec;
    SimpleDateFormat timeFormat;
    Calendar calendar;
    String status = "";
    long display_time;
    boolean c1_isPaused = false;
    boolean c1_isCanceled =false;
    Bundle  bundle;
    int dayNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_start);
        bundle = getIntent().getExtras();
        dayNo = bundle.getInt("day");
        floatingActionButton_play = findViewById(R.id.play);
        floatingActionButton_pause = findViewById(R.id.pause);
        tvCountDown = findViewById(R.id.countDown);
        btn_skip = findViewById(R.id.skipButton);
        calendar = Calendar.getInstance();
        timeFormat = new SimpleDateFormat("ss");
        mySong = MediaPlayer.create(ExcerciseStartActivity.this,R.raw.hum);
        mySong.start();
//        t = new Thread(){
//            @Override
//            public void run() {
//                while (count>=2)
//                {
//                    try {
//                        Thread.sleep(1000);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                count--;
//                                if(count==0)
//                                {
//                                    startActivity(new Intent(ThreadActivity.this, MainActivity.class));
//                                    finish();
//                                    mySong.stop();
//                                }
//                                tvCountDown.setText(String.valueOf(count));
//                            }
//                        });
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        t.start();
        totaltime = 11000;
        c1 = new CountDownTimer(totaltime,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(c1_isPaused || c1_isCanceled)
                {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                }
                else
                {
                    c1_isRunning = true;
                    display_time = millisUntilFinished;
                    tvCountDown.setText("" + display_time / 1000);
                }
            }

            @Override
            public void onFinish() {
                c1_isRunning = false;
                c1.cancel();
                mySong.stop();
                bundle = new Bundle();
                bundle.putInt("day",dayNo);
                startActivity(new Intent(ExcerciseStartActivity.this, ExcerciseStartedActivity.class).putExtras(bundle));
                finish();
            }
        }.start();
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1_isRunning)
                {
                    c1.cancel();
                }
                c1_isCanceled = true;
                mySong.stop();
                bundle = new Bundle();
                bundle.putInt("day",dayNo);
                startActivity(new Intent(ExcerciseStartActivity.this, ExcerciseStartedActivity.class).putExtras(bundle));
                finish();
            }
        });
        floatingActionButton_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySong.pause();
                pause_time = System.currentTimeMillis();
                c1_isRunning = false;
                c1_isPaused = true;
//                pause_time = calendar.get(Calendar.SECOND);
//                Toast.makeText(ThreadActivity.this, pause_time+"", Toast.LENGTH_SHORT).show();
                floatingActionButton_pause.setVisibility(View.INVISIBLE);
                floatingActionButton_play.setVisibility(View.VISIBLE);
            }
        });
        floatingActionButton_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySong.start();
                play_time = System.currentTimeMillis();
//                play_time = calendar.get(Calendar.SECOND);
                diff = play_time - pause_time;
                System.out.println("Duration: " + timeFormat.format(diff));
                totaltime = (display_time)+1;
                c1_isPaused = false;
                c1_isCanceled = false;
                long millisInFuture = totaltime;
                long countDownInterval = 1000;
                new CountDownTimer(totaltime,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if(c1_isPaused || c1_isCanceled)
                        {
                            //If the user request to cancel or paused the
                            //CountDownTimer we will cancel the current instance
                            cancel();
                        }
                        else
                        {
                            c1_isRunning = true;
                            display_time = millisUntilFinished;
                            tvCountDown.setText("" + display_time / 1000);
                        }
                    }

                    @Override
                    public void onFinish() {
                        c1_isRunning = false;
                        c1.cancel();
                        mySong.stop();
                        startActivity(new Intent(ExcerciseStartActivity.this, ExcerciseStartedActivity.class));
                        finish();
                    }
                }.start();
                long temp = Long.parseLong(timeFormat.format(diff));
                sec = temp*1000;
//                Toast.makeText(ExcerciseStartActivity.this, sec+"", Toast.LENGTH_SHORT).show();
                floatingActionButton_pause.setVisibility(View.VISIBLE);
                floatingActionButton_play.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mySong.stop();
        if(c1_isRunning)
        {
            c1.cancel();
        }
        finish();
    }
}
