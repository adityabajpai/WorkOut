package com.android.workout.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.workout.R;

public class ExcerciseStartActivity extends AppCompatActivity{

    FloatingActionButton floatingActionButton_play, floatingActionButton_pause;
    MediaPlayer mySong;
    TextView tvCountDown;
    int count=10;
    TextView btn_skip;
    Thread t;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_start);
        floatingActionButton_play = findViewById(R.id.play);
        floatingActionButton_pause = findViewById(R.id.pause);
        tvCountDown = findViewById(R.id.countDown);
        btn_skip = findViewById(R.id.skipButton);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=10;i>0;i--)
//                {
//                    tvCountDown.setText(i+"");
//                    Thread.sleep(1000);
//                }
//            }
//        },1000);
        mySong = MediaPlayer.create(ExcerciseStartActivity.this,R.raw.hum);
        mySong.start();
        t = new Thread(){
            @Override
            public void run() {
                while (count>=2 && flag)
                {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count--;
                                if(count==0)
                                {
                                    startActivity(new Intent(ExcerciseStartActivity.this, ExcerciseStartedActivity.class));
                                    finish();
                                    mySong.stop();
                                }
                                tvCountDown.setText(String.valueOf(count));
                            }
                        });
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.interrupt();
                count=0;
                mySong.stop();
                startActivity(new Intent(ExcerciseStartActivity.this, ExcerciseStartedActivity.class));
                finish();
            }
        });
        floatingActionButton_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = false;
                Log.d("Hello",t.isAlive()+"");
                mySong.pause();
                floatingActionButton_pause.setVisibility(View.INVISIBLE);
                floatingActionButton_play.setVisibility(View.VISIBLE);
            }
        });
        floatingActionButton_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                try {
                    t.start();
                }catch (Exception e)
                {

                }
                mySong.start();
                floatingActionButton_pause.setVisibility(View.VISIBLE);
                floatingActionButton_play.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mySong.stop();
        finish();
    }
}
