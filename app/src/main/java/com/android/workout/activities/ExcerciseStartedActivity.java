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

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
    ViewFlipper viewFlipper_pushups, viewFlipper_squats, viewFlipper_legRaise, viewFlipper_jumpingJack, viewFlipper_squatsAgain, viewFlipper_plankwithlegFit;
    public int[] image_array = {R.drawable.push_up_a,R.drawable.push_up_b,R.drawable.squats_a,R.drawable.squats_b,R.drawable.leg_raise_a,R.drawable.leg_raise_b,R.drawable.jumping_a,R.drawable.jumping_b,R.drawable.jumping_c,R.drawable.plank_with_leg_lift_a,R.drawable.plank_with_leg_lift_b,R.drawable.plank_with_leg_lift_c};
    public int[] image_array_pushUps = {R.drawable.push_up_a,R.drawable.push_up_b};
    public int[] image_array_squats = {R.drawable.squats_a,R.drawable.squats_b};
    public int[] image_array_legRaise = {R.drawable.leg_raise_a,R.drawable.leg_raise_b};
    public int[] image_array_jumpingJack = {R.drawable.jumping_a,R.drawable.jumping_b,R.drawable.jumping_c};
    public int[] image_array_plank = {R.drawable.plank_with_leg_lift_a,R.drawable.plank_with_leg_lift_b,R.drawable.plank_with_leg_lift_c};
    TextView tv_excercise_name, tv_countDown, tv_totalSet;
    ImageButton img_btn;

    @Override
    public void onBackPressed() {

            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                    .setMessage("Would you like to repeat this workout?")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            t.interrupt();
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

        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.yield();
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
//        viewFlipper_pushups.setAutoStart(true);
//        viewFlipper_pushups.stopFlipping();

        for (int i = 0; i < image_array_squats.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_squats[i]);
            viewFlipper_squats.addView(imageView);
        }
        viewFlipper_squats.setFlipInterval(1000);
//        viewFlipper_squats.setAutoStart(true);

        for (int i = 0; i < image_array_legRaise.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_legRaise[i]);
            viewFlipper_legRaise.addView(imageView);
        }
        viewFlipper_legRaise.setFlipInterval(1000);
//        viewFlipper_legRaise.setAutoStart(true);

        for (int i = 0; i < image_array_jumpingJack.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_jumpingJack[i]);
            viewFlipper_jumpingJack.addView(imageView);
        }
        viewFlipper_jumpingJack.setFlipInterval(1000);
//        viewFlipper_jumpingJack.setAutoStart(true);

        for (int i = 0; i < image_array_squats.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_squats[i]);
            viewFlipper_squatsAgain.addView(imageView);
        }
        viewFlipper_squatsAgain.setFlipInterval(1000);
//        viewFlipper_squatsAgain.setAutoStart(true);

        for (int i = 0; i < image_array_plank.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_array_plank[i]);
            viewFlipper_plankwithlegFit.addView(imageView);
        }
        viewFlipper_plankwithlegFit.setFlipInterval(1000);
//        viewFlipper_plankwithlegFit.setAutoStart(true);

        t = new Thread(){
            @Override
            public void run() {


                //PUSHUPS
                progressBar.setMax(20);
                viewFlipper_pushups.startFlipping();
                tv_excercise_name.setText(ex[excercise_number]);
                while (count<20)
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
                viewFlipper_pushups.stopFlipping();
                viewFlipper_pushups.setVisibility(View.INVISIBLE);
                progressBar.setProgress(0);
                progressBar_excercise1.setProgress(20);
                tv_countDown.setText("0");
                count = 0;


                //SQUATS
                progressBar.setMax(20);
                try {
                    viewFlipper_squats.setVisibility(View.VISIBLE);
                }catch (Exception e){
                    e.printStackTrace();
                }
                viewFlipper_squats.startFlipping();
                tv_excercise_name.setText("SQUATS");
                while (count<20)
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
                viewFlipper_squats.stopFlipping();
                viewFlipper_squats.setVisibility(View.INVISIBLE);
                progressBar.setProgress(0);
                progressBar_excercise2.setProgress(20);
                tv_countDown.setText("0");
                count=0;



                progressBar.setMax(20);
                try {
                    viewFlipper_legRaise.setVisibility(View.VISIBLE);
                }catch (Exception e){
                    e.printStackTrace();
                }
                viewFlipper_legRaise.startFlipping();
                tv_excercise_name.setText("LEG RAISE");
                while (count<20)
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
                viewFlipper_legRaise.stopFlipping();
                viewFlipper_legRaise.setVisibility(View.INVISIBLE);
                progressBar.setProgress(0);
                progressBar_excercise3.setProgress(20);
                tv_countDown.setText("0");
                count=0;


                try {
                    viewFlipper_jumpingJack.setVisibility(View.VISIBLE);
                }catch (Exception e){
                    e.printStackTrace();
                }
                viewFlipper_jumpingJack.startFlipping();
                progressBar.setMax(15);
                tv_totalSet.setText("/15");
                tv_excercise_name.setText("JUMPING JACK");
                while (count<15)
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
                viewFlipper_jumpingJack.stopFlipping();
                viewFlipper_jumpingJack.setVisibility(View.INVISIBLE);
                progressBar_excercise4.setProgress(15);
                progressBar.setProgress(0);
                tv_countDown.setText("0");
                count=0;


                try {
                    viewFlipper_squatsAgain.setVisibility(View.VISIBLE);
                }catch (Exception e){
                    e.printStackTrace();
                }
                viewFlipper_squatsAgain.startFlipping();
                tv_totalSet.setText("/20");
                progressBar.setMax(20);
                tv_excercise_name.setText("SQUATS");
                while (count<20)
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
                viewFlipper_squatsAgain.stopFlipping();
                viewFlipper_squatsAgain.setVisibility(View.INVISIBLE);
                progressBar.setProgress(0);
                progressBar_excercise5.setProgress(20);
                tv_countDown.setText("0");
                count=0;



                try {
                    viewFlipper_plankwithlegFit.setVisibility(View.VISIBLE);
                }catch (Exception e){
                    e.printStackTrace();
                }
                viewFlipper_plankwithlegFit.startFlipping();
                tv_totalSet.setText("/30");
                progressBar.setMax(30);
                tv_excercise_name.setText("PLANK WITH LEG FIT");
                while (count<30)
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
                viewFlipper_plankwithlegFit.stopFlipping();
//                viewFlipper_plankwithlegFit.setVisibility(View.INVISIBLE);
                progressBar.setProgress(0);
                progressBar_excercise6.setProgress(30);
                tv_countDown.setText("0");
                t.interrupt();
                startActivity(new Intent(ExcerciseStartedActivity.this,HomeActivity.class));
            }
        };

        t.start();


        ////    private void completeExcercise(int excercise_number, final String current_excercie) {
////        if(current_excercie.equals("plankWithLegFit"))
////        {
////            progressBar_excercise1.setProgress(max[5]);
////            return;
////        }
////        else
////        {
////            Toast.makeText(ExcerciseStartedActivity.this,current_excercie+" started",Toast.LENGTH_LONG).show();
////            progressBar.setMax(max[excercise_number]);
////            final int temp = max[excercise_number];
////            Log.d("temp",temp+"");
////            Log.d("current_excercise",excercise_name[excercise_number]);
////            t = new Thread(){
////                @Override
////                public void run() {
////                    while (count<=temp)
////                    {
////                        try {
////                            Thread.sleep(1000);
////                            runOnUiThread(new Runnable() {
////                                @Override
////                                public void run() {
////                                    count++;
////                                    progressBar.setProgress(count);
////                                }
////                            });
////                        }catch (Exception e){
////                            e.printStackTrace();
////                        }
////                    }
////                }
////            };
////            t.start();
////            if(current_excercie.equals("pushUps"))
////            {
////                Log.d("msg","pushups done");
////                progressBar_excercise1.setProgress(max[0]);
////            }
////            else if(current_excercie.equals("squats"))
////            {
////                Log.d("msg","squats done");
////                progressBar_excercise1.setProgress(max[1]);
////            }
////            else if(current_excercie.equals("legRaise"))
////            {
////                Log.d("msg","legRaise done");
////                progressBar_excercise1.setProgress(max[2]);
////            }
////            else if(current_excercie.equals("jumpingJack"))
////            {
////                Log.d("msg","jumpingJack done");
////                progressBar_excercise1.setProgress(max[3]);
////            }
////            else if(current_excercie.equals("squatsAgain"))
////            {
////                Log.d("msg","squatsAgain done");
////                progressBar_excercise1.setProgress(max[4]);
////            }
////            progressBar.setProgress(0);
////            count = 0;
////            excercise_number++;
////            completeExcercise(excercise_number,excercise_name[excercise_number]);
////        }
//    }


    }
}
