package com.android.workout.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import java.util.Locale;


public class ExcerciseStartedActivity extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    public static ProgressBar progressBar, progressBar_excercise1, progressBar_excercise2, progressBar_excercise3, progressBar_excercise4, progressBar_excercise5, progressBar_excercise6;
    Thread t, t1, t2, t3, t4, t5, t6;
    private DatabaseOperations databaseOperations;
    int count = 0;
    private TextToSpeech tts;
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
    Button btn_skip;
    TextView tv_countDownNextExcercise, tv_nextExcerciseName, tv_nextExcerciseTotalSet;
    CountDownTimer c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12;
    boolean isRunningC1 = false, isRunningC2 = false, isRunningC3 = false, isRunningC4 = false, isRunningC5 = false, isRunningC6 = false;
    boolean isRunningC7 = false, isRunningC8 = false, isRunningC9 = false, isRunningC10 = false, isRunningC11 = false, isRunningC12 = false;
    long totalTime42 = 42000, totalTime32 = 32000, totalTime30 = 30000, totalTime62 = 62000, totalTime10 = 10000;
    long display_time, display_time1, display_time3, display_time5, display_time7, display_time9, display_time11;
    boolean isPausedC1 = false;
    boolean isCanceledC1 = false;
    boolean first = true;

    boolean isPausedC3 = false;
    boolean isCanceledC3 = false;
    boolean third = true;

    boolean isPausedC5 = false;
    boolean isCanceledC5 = false;
    boolean fifth = true;

    boolean isPausedC7 = false;
    boolean isCanceledC7 = false;
    boolean seventh = true;

    boolean isPausedC9 = false;
    boolean isCanceledC9 = false;
    boolean ninth = true;

    boolean isPausedC11 = false;
    boolean isCanceledC11 = false;
    boolean eleventh = true;

    long progress;
    long progress_stored;

    WorkoutData workoutData = new WorkoutData();
    Bundle bundle;
    int dayNo;
    String day_details = "";

    long totaltime1, totaltime3, totaltime5, totaltime7, totaltime9, totaltime11;
    String name1, name3, name5, name7, name9, name11;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor prefsEditor;




    @Override
    public void onBackPressed() {

        if (isRunningC1) {
            isPausedC1 = true;
            viewFlipper_pushups.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C1",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            first = true;
            Log.e("Progress paused", "" + progress_stored);
//            Toast.makeText(ExcerciseStartedActivity.this, "C1", Toast.LENGTH_SHORT).show();
        } else if (isRunningC3) {
            isPausedC3 = true;
            viewFlipper_squats.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C3",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            third = true;
//            Toast.makeText(ExcerciseStartedActivity.this, "C3", Toast.LENGTH_SHORT).show();
        } else if (isRunningC5) {
            isPausedC5 = true;
            viewFlipper_legRaise.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C5",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            fifth = true;
//            Toast.makeText(ExcerciseStartedActivity.this, "C5", Toast.LENGTH_SHORT).show();
        } else if (isRunningC7) {
            isPausedC7 = true;
            viewFlipper_jumpingJack.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C7",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            seventh = true;
//            Toast.makeText(ExcerciseStartedActivity.this, "C7", Toast.LENGTH_SHORT).show();
        } else if (isRunningC9) {
            isPausedC9 = true;
            viewFlipper_squatsAgain.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C9",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            ninth = true;
//            Toast.makeText(ExcerciseStartedActivity.this, "C9", Toast.LENGTH_SHORT).show();
        } else if (isRunningC11) {
            isPausedC11 = true;
            viewFlipper_plankwithlegFit.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C11",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            eleventh = true;
//            Toast.makeText(ExcerciseStartedActivity.this, "C11", Toast.LENGTH_SHORT).show();
        }
        img_btn_pause.setVisibility(View.INVISIBLE);
        img_btn_play.setVisibility(View.VISIBLE);
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage(getResources().getString(R.string.repeatworkout))
                .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (isRunningC1) {
                            c1.cancel();
                            Log.e("C1", "C1 cancelled");
                        }
                        if (isRunningC2) {
                            c2.cancel();
                            Log.e("C2", "C2 cancelled");
                        }
                        if (isRunningC3) {
                            c3.cancel();
                            Log.e("C3", "C3 cancelled");
                        }
                        if (isRunningC4) {
                            c4.cancel();
                            Log.e("C4", "C4 cancelled");
                        }
                        if (isRunningC5) {
                            c5.cancel();
                            Log.e("C5", "C5 cancelled");
                        }
                        if (isRunningC6) {
                            c6.cancel();
                            Log.e("C6", "C6 cancelled");
                        }
                        if (isRunningC7) {
                            c7.cancel();
                            Log.e("C7", "C7 cancelled");
                        }
                        if (isRunningC8) {
                            c8.cancel();
                            Log.e("C8", "C8 cancelled");
                        }
                        if (isRunningC9) {
                            c9.cancel();
                            Log.e("C9", "C9 cancelled");
                        }
                        if (isRunningC10) {
                            c10.cancel();
                            Log.e("C10", "C10 cancelled");
                        }
                        if (isRunningC11) {
                            c11.cancel();
                            Log.e("C11", "C11 cancelled");
                        }
                        if (isRunningC12) {
                            c12.cancel();
                            Log.e("C12", "C12 cancelled");
                        }

                        progressBar_excercise1.setProgress(0);
                        progressBar_excercise2.setProgress(0);
                        progressBar_excercise3.setProgress(0);
                        progressBar_excercise4.setProgress(0);
                        progressBar_excercise5.setProgress(0);
                        progressBar_excercise6.setProgress(0);
                        progressBar.setProgress(0);
                        int check = databaseOperations.insertExcDayData(workoutData.getDay(), workoutData.getProgress());
                        Log.e("value inserted", "" + check);
                        Bundle bundle1 = new Bundle();
                        bundle1.putInt("day", dayNo);
                        startActivity(new Intent(ExcerciseStartedActivity.this, ExcerciseActivity.class).putExtras(bundle1));
                        finish();
                    }
                }).setNegativeButton(getResources().getString(R.string.no), null).show();
    }

    int totalDayCyclesXX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_started);
        bundle = getIntent().getExtras();
        dayNo = bundle.getInt("day");
        day_details = "day" + dayNo + "Excercise";
        workoutData.setDay("Day " + dayNo);
        tts = new TextToSpeech(this, this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prefsEditor = mSharedPreferences.edit();
        databaseOperations = new DatabaseOperations(getApplicationContext());
        workoutData.setProgress(0.0f);
        PowerManager powerManager = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
        @SuppressLint("InvalidWakeLockTag") final PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Lock");
        wakeLock.acquire(10 * 60 * 1000L /*10 minutes*/);
        progressBar = findViewById(R.id.progress_bar);
        final TypedArray typedArray_cycles = getResources().obtainTypedArray(R.array.cycles);
        int cycles_on_day = typedArray_cycles.getResourceId(dayNo - 1, -1);
        final int[] typedArray_cycles1 = getResources().getIntArray(cycles_on_day);
        totaltime1 = (typedArray_cycles1[0] * 2000) + 2000;
        totaltime3 = (typedArray_cycles1[1] * 2000) + 2000;
        totaltime5 = (typedArray_cycles1[2] * 2000) + 2000;
        totaltime7 = (typedArray_cycles1[3] * 2000) + 2000;
        totaltime9 = (typedArray_cycles1[4] * 2000) + 2000;
        totaltime11 = (typedArray_cycles1[5] * 2000) + 2000;
        Log.e("totaltime", totaltime1 + " " + totaltime3 + " " + totaltime5 + " " + totaltime7 + " " + totaltime9 + " " + totaltime11);

        final TypedArray typedArray_name = getResources().obtainTypedArray(R.array.names);
        int names_on_day = typedArray_name.getResourceId(dayNo - 1, -1);
        final String[] typedArray_names1 = getResources().getStringArray(names_on_day);
        name1 = (typedArray_names1[0]);
        name3 = (typedArray_names1[1]);
        name5 = (typedArray_names1[2]);
        name7 = (typedArray_names1[3]);
        name9 = (typedArray_names1[4]);
        name11 = (typedArray_names1[5]);
        progressBar_excercise1 = findViewById(R.id.progress_bar_excercise1);
        progressBar_excercise1.setMax((int) ((totaltime1 - 2000) / 2000));
        progressBar_excercise2 = findViewById(R.id.progress_bar_excercise2);
        progressBar_excercise2.setMax((int) ((totaltime3 - 2000) / 2000));
        progressBar_excercise3 = findViewById(R.id.progress_bar_excercise3);
        progressBar_excercise3.setMax((int) ((totaltime5 - 2000) / 2000));
        progressBar_excercise4 = findViewById(R.id.progress_bar_excercise4);
        progressBar_excercise4.setMax((int) ((totaltime7 - 2000) / 2000));
        progressBar_excercise5 = findViewById(R.id.progress_bar_excercise5);
        progressBar_excercise5.setMax((int) ((totaltime9 - 2000) / 2000));
        progressBar_excercise6 = findViewById(R.id.progress_bar_excercise6);
        progressBar_excercise6.setMax((int) ((totaltime11 - 2000) / 2000));
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
        btn_skip = findViewById(R.id.skip);
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunningC2) {
                    c2.onFinish();
                } else if (isRunningC4) {
                    c4.onFinish();
                } else if (isRunningC6) {
                    c6.onFinish();
                } else if (isRunningC8) {
                    c8.onFinish();
                } else if (isRunningC10) {
                    c10.onFinish();
                } else if (isRunningC12) {
                    c12.onFinish();
                }
            }
        });
        img_btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunningC1) {
                    isPausedC1 = true;
                    viewFlipper_pushups.stopFlipping();
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C1",Toast.LENGTH_LONG).show();
                    progress_stored = progress;
                    first = true;
                    Log.e("Progress paused", "" + progress_stored);
//                    Toast.makeText(ExcerciseStartedActivity.this, "C1", Toast.LENGTH_SHORT).show();
                } else if (isRunningC3) {
                    isPausedC3 = true;
                    viewFlipper_squats.stopFlipping();
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C3",Toast.LENGTH_LONG).show();
                    progress_stored = progress;
                    third = true;
//                    Toast.makeText(ExcerciseStartedActivity.this, "C3", Toast.LENGTH_SHORT).show();
                } else if (isRunningC5) {
                    isPausedC5 = true;
                    viewFlipper_legRaise.stopFlipping();
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C5",Toast.LENGTH_LONG).show();
                    progress_stored = progress;
                    fifth = true;
//                    Toast.makeText(ExcerciseStartedActivity.this, "C5", Toast.LENGTH_SHORT).show();
                } else if (isRunningC7) {
                    isPausedC7 = true;
                    viewFlipper_jumpingJack.stopFlipping();
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C7",Toast.LENGTH_LONG).show();
                    progress_stored = progress;
                    seventh = true;
//                    Toast.makeText(ExcerciseStartedActivity.this, "C7", Toast.LENGTH_SHORT).show();
                } else if (isRunningC9) {
                    isPausedC9 = true;
                    viewFlipper_squatsAgain.stopFlipping();
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C9",Toast.LENGTH_LONG).show();
                    progress_stored = progress;
                    ninth = true;
//                    Toast.makeText(ExcerciseStartedActivity.this, "C9", Toast.LENGTH_SHORT).show();
                } else if (isRunningC11) {
                    isPausedC11 = true;
                    viewFlipper_plankwithlegFit.stopFlipping();
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C11",Toast.LENGTH_LONG).show();
                    progress_stored = progress;
                    eleventh = true;
//                    Toast.makeText(ExcerciseStartedActivity.this, "C11", Toast.LENGTH_SHORT).show();
                }
                img_btn_pause.setVisibility(View.INVISIBLE);
                img_btn_play.setVisibility(View.VISIBLE);
            }
        });

        img_btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPausedC1) {
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Played C1",Toast.LENGTH_LONG).show();
                    isPausedC1 = false;
                    isCanceledC1 = false;
                    img_btn_play.setVisibility(View.INVISIBLE);
                    img_btn_pause.setVisibility(View.VISIBLE);
                    Log.e("Visibility", "done");
                    final long millisInFuture = display_time1;
                    progressBar.setProgress((int) progress_stored);
                    Log.e("progressBar", "done");
                    Log.e("DISPLAYtIME 1", display_time1 + "");
                    new CountDownTimer(display_time1, 2000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if (isPausedC1 || isCanceledC1) {
                                //If the user request to cancel or paused the
                                //CountDownTimer we will cancel the current instance
                                cancel();
                            } else {
                                Log.e("else", "done");
                                isRunningC1 = true;
                                viewFlipper_pushups.startFlipping();
                                progressBar.setMax((int) ((totaltime1 - 2000) / 2000));
                                display_time1 = millisUntilFinished;
                                if (first) {
                                    Log.e("first", "done");
                                    progress = ((totaltime1 - display_time1) / 1000) / 2;
                                    progressBar.setProgress((int) (progress_stored + progress));
                                    tv_countDown.setText((int) (progress_stored + progress) + "");
                                    speakOut();
                                    Log.e("Progress played", "" + progress + progress_stored);
                                    first = false;
                                }
                                progress = ((totaltime1 - display_time1) / 1000) / 2;
                                progressBar.setProgress((int) (progress));
                                tv_countDown.setText((int) (progress) + "");
                                speakOut();
                                Log.e("Progress played", "" + progress);
                            }
                        }

                        @Override
                        public void onFinish() {
                            isRunningC1 = false;
                            c1.cancel();
                            workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime1 - 2000) / 2000) * 100)
                                    / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                            Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                            relativeLayout.setVisibility(View.INVISIBLE);
                            linearLayout.setVisibility(View.VISIBLE);
                            c2.start();
                            tv_nextExcerciseName.setText(name3);
                            tv_nextExcerciseTotalSet.setText("x" + ((totaltime3 - 2000) / 2000));
                            speakOut1();
                        }
                    }.start();
                } else if (isPausedC3) {
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Played C3",Toast.LENGTH_LONG).show();
                    isPausedC3 = false;
                    isCanceledC3 = false;
                    img_btn_play.setVisibility(View.INVISIBLE);
                    img_btn_pause.setVisibility(View.VISIBLE);
                    Log.e("Visibility third", "done");
                    final long millisInFuture = display_time3;
                    progressBar.setProgress((int) progress_stored);
                    Log.e("progressBar third", "done");
                    Log.e("DISPLAYtIME third", display_time3 + "");
                    new CountDownTimer(display_time3, 2000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if (isPausedC3 || isCanceledC3) {
                                //If the user request to cancel or paused the
                                //CountDownTimer we will cancel the current instance
                                cancel();
                            } else {
                                Log.e("else third", "done");
                                isRunningC3 = true;
                                viewFlipper_squats.startFlipping();
                                progressBar.setMax((int) ((totaltime3 - 2000) / 2000));
                                display_time3 = millisUntilFinished;
                                if (third) {
                                    Log.e("third", "done");
                                    progress = ((totaltime3 - display_time3) / 1000) / 2;
                                    progressBar.setProgress((int) (progress_stored + progress));
                                    tv_countDown.setText((int) (progress_stored + progress) + "");
                                    speakOut();
                                    Log.e("Progress played third", "" + progress + progress_stored);
                                    third = false;
                                }
                                progress = ((totaltime3 - display_time3) / 1000) / 2;
                                progressBar.setProgress((int) (progress));
                                tv_countDown.setText((int) (progress) + "");
                                speakOut();
                                Log.e("Progress played third", "" + progress);
                            }
                        }

                        @Override
                        public void onFinish() {
                            isRunningC3 = false;
                            c3.cancel();
                            workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime3 - 2000) / 2000) * 100)
                                    / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                            Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                            relativeLayout.setVisibility(View.INVISIBLE);
                            linearLayout.setVisibility(View.VISIBLE);
                            tv_nextExcerciseName.setText(name5);
                            tv_nextExcerciseTotalSet.setText("x" + ((totaltime5 - 2000) / 2000));
                            speakOut1();
                            c4.start();
                        }
                    }.start();
                } else if (isPausedC5) {
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Played C5",Toast.LENGTH_LONG).show();
                    isPausedC5 = false;
                    isCanceledC5 = false;
                    img_btn_play.setVisibility(View.INVISIBLE);
                    img_btn_pause.setVisibility(View.VISIBLE);
                    Log.e("Visibility FIVE", "done");
                    final long millisInFuture = display_time5;
                    progressBar.setProgress((int) progress_stored);
                    Log.e("progressBar FIVE", "done");
                    Log.e("DISPLAYtIME FIVE", display_time5 + "");
                    new CountDownTimer(display_time5, 2000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if (isPausedC5 || isCanceledC5) {
                                //If the user request to cancel or paused the
                                //CountDownTimer we will cancel the current instance
                                cancel();
                            } else {
                                Log.e("else FIVE", "done");
                                isRunningC5 = true;
                                viewFlipper_legRaise.startFlipping();
                                progressBar.setMax((int) ((totaltime5 - 2000) / 2000));
                                display_time5 = millisUntilFinished;
                                if (fifth) {
                                    Log.e("FIVE", "done");
                                    progress = ((totaltime5 - display_time5) / 1000) / 2;
                                    progressBar.setProgress((int) (progress_stored + progress));
                                    tv_countDown.setText((int) (progress_stored + progress) + "");
                                    Log.e("Progress played FIVE", "" + progress + progress_stored);
                                    speakOut();
                                    fifth = false;
                                }
                                progress = ((totaltime5 - display_time5) / 1000) / 2;
                                progressBar.setProgress((int) (progress));
                                tv_countDown.setText((int) (progress) + "");
                                Log.e("Progress played FIVE", "" + progress);
                                speakOut();
                            }
                        }

                        @Override
                        public void onFinish() {
                            isRunningC5 = false;
                            c5.cancel();
                            workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime5 - 2000) / 2000) * 100)
                                    / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                            Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                            relativeLayout.setVisibility(View.INVISIBLE);
                            linearLayout.setVisibility(View.VISIBLE);
                            tv_nextExcerciseName.setText(name7);
                            tv_nextExcerciseTotalSet.setText("x" + ((totaltime7 - 2000) / 2000));
                            speakOut1();
                            c6.start();
                        }
                    }.start();
                } else if (isPausedC7) {
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Played C7",Toast.LENGTH_LONG).show();
                    isPausedC7 = false;
                    isCanceledC7 = false;
                    img_btn_play.setVisibility(View.INVISIBLE);
                    img_btn_pause.setVisibility(View.VISIBLE);
                    Log.e("Visibility SEVEN", "done");
                    final long millisInFuture = display_time7;
                    progressBar.setProgress((int) progress_stored);
                    Log.e("progressBar SEVEN", "done");
                    Log.e("DISPLAYtIME SEVEN", display_time7 + "");
                    new CountDownTimer(display_time7, 2000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if (isPausedC7 || isCanceledC7) {
                                //If the user request to cancel or paused the
                                //CountDownTimer we will cancel the current instance
                                cancel();
                            } else {
                                Log.e("else SEVEN", "done");
                                isRunningC7 = true;
                                viewFlipper_jumpingJack.startFlipping();
                                progressBar.setMax((int) ((totaltime7 - 2000) / 2000));
                                display_time7 = millisUntilFinished;
                                if (seventh) {
                                    Log.e("SEVEN", "done");
                                    progress = ((totaltime7 - display_time7) / 1000) / 2;
                                    progressBar.setProgress((int) (progress_stored + progress));
                                    tv_countDown.setText((int) (progress_stored + progress) + "");
                                    speakOut();
                                    Log.e("Progress played SEVEN", "" + progress + progress_stored);
                                    seventh = false;
                                }
                                progress = ((totaltime7 - display_time7) / 1000) / 2;
                                progressBar.setProgress((int) (progress));
                                tv_countDown.setText((int) (progress) + "");
                                speakOut();
                                Log.e("Progress played SEVEN", "" + progress);
                            }
                        }

                        @Override
                        public void onFinish() {
                            isRunningC7 = false;
                            c7.cancel();
                            workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime7 - 2000) / 2000) * 100)
                                    / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                            Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                            relativeLayout.setVisibility(View.INVISIBLE);
                            linearLayout.setVisibility(View.VISIBLE);
                            tv_nextExcerciseName.setText(name9);
                            tv_nextExcerciseTotalSet.setText("x" + ((totaltime9 - 2000) / 2000));
                            speakOut1();
                            c8.start();
                        }
                    }.start();
                } else if (isPausedC9) {
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Played C9",Toast.LENGTH_LONG).show();
                    isPausedC9 = false;
                    isCanceledC9 = false;
                    img_btn_play.setVisibility(View.INVISIBLE);
                    img_btn_pause.setVisibility(View.VISIBLE);
                    Log.e("Visibility NINE", "done");
                    final long millisInFuture = display_time9;
                    progressBar.setProgress((int) progress_stored);
                    Log.e("progressBar NINE", "done");
                    Log.e("DISPLAYtIME NINE", display_time9 + "");
                    new CountDownTimer(display_time9, 2000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if (isPausedC9 || isCanceledC9) {
                                //If the user request to cancel or paused the
                                //CountDownTimer we will cancel the current instance
                                cancel();
                            } else {
                                Log.e("else NINE", "done");
                                isRunningC9 = true;
                                viewFlipper_squatsAgain.startFlipping();
                                progressBar.setMax((int) ((totaltime9 - 2000) / 2000));
                                display_time9 = millisUntilFinished;
                                if (ninth) {
                                    Log.e("NINE", "done");
                                    progress = ((totaltime9 - display_time9) / 1000) / 2;
                                    progressBar.setProgress((int) (progress_stored + progress));
                                    tv_countDown.setText((int) (progress_stored + progress) + "");
                                    speakOut();
                                    Log.e("Progress played NINE", "" + progress + progress_stored);
                                    ninth = false;
                                }
                                progress = ((totaltime9 - display_time9) / 1000) / 2;
                                progressBar.setProgress((int) (progress));
                                tv_countDown.setText((int) (progress) + "");
                                speakOut();
                                Log.e("Progress played NINE", "" + progress);
                            }
                        }

                        @Override
                        public void onFinish() {
                            isRunningC9 = false;
                            c9.cancel();
                            workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime9 - 2000) / 2000) * 100)
                                    / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                            Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                            relativeLayout.setVisibility(View.INVISIBLE);
                            linearLayout.setVisibility(View.VISIBLE);
                            tv_nextExcerciseName.setText(name11);
                            tv_nextExcerciseTotalSet.setText("x" + ((totaltime11 - 2000) / 2000));
                            speakOut1();
                            c10.start();
                        }
                    }.start();
                } else if (isPausedC11) {
//                    Toast.makeText(ExcerciseStartedActivity.this,"Excercise Played C11",Toast.LENGTH_LONG).show();
                    isPausedC11 = false;
                    isCanceledC11 = false;
                    img_btn_play.setVisibility(View.INVISIBLE);
                    img_btn_pause.setVisibility(View.VISIBLE);
                    Log.e("Visibility ELEVEN", "done");
                    final long millisInFuture = display_time11;
                    progressBar.setProgress((int) progress_stored);
                    Log.e("progressBar ELEVEN", "done");
                    Log.e("DISPLAYtIME ELEVEN", display_time11 + "");
                    new CountDownTimer(display_time11, 2000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if (isPausedC11 || isCanceledC11) {
                                //If the user request to cancel or paused the
                                //CountDownTimer we will cancel the current instance
                                cancel();
                            } else {
                                Log.e("else ELEVEN", "done");
                                isRunningC11 = true;
                                viewFlipper_plankwithlegFit.startFlipping();
                                progressBar.setMax((int) ((totaltime11 - 2000) / 2000));
                                display_time11 = millisUntilFinished;
                                if (eleventh) {
                                    Log.e("ELEVEN", "done");
                                    progress = ((totaltime11 - display_time11) / 1000) / 2;
                                    progressBar.setProgress((int) (progress_stored + progress));
                                    tv_countDown.setText((int) (progress_stored + progress) + "");
                                    speakOut();
                                    Log.e("Progress played ELEVEN", "" + progress + progress_stored);
                                    eleventh = false;
                                }
                                progress = ((totaltime11 - display_time11) / 1000) / 2;
                                progressBar.setProgress((int) (progress));
                                tv_countDown.setText((int) (progress) + "");
                                speakOut();
                                Log.e("Progress played ELEVEN", "" + progress);
                            }
                        }

                        @Override
                        public void onFinish() {
                            isRunningC11 = false;
                            c11.cancel();
                            workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime11 - 2000) / 2000) * 100)
                                    / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                            Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                            relativeLayout.setVisibility(View.INVISIBLE);
                            linearLayout.setVisibility(View.VISIBLE);
                            speakOut2();
                            c12.start();
                        }
                    }.start();
                }
            }
        });

        viewFlipper_squats.setVisibility(View.INVISIBLE);
        viewFlipper_legRaise.setVisibility(View.INVISIBLE);
        viewFlipper_jumpingJack.setVisibility(View.INVISIBLE);
        viewFlipper_squatsAgain.setVisibility(View.INVISIBLE);
        viewFlipper_plankwithlegFit.setVisibility(View.INVISIBLE);
        int check = 0;
        //typedArray_total main hr din ki array hain
        final TypedArray typedArray_totalDays = getResources().obtainTypedArray(R.array.total);
        int day_no_from_array = typedArray_totalDays.getResourceId(dayNo - 1, -1);
        Log.e("day_no_from_array", day_no_from_array + "");
        final TypedArray typedArray1 = getResources().obtainTypedArray(day_no_from_array);
        final int temp1 = typedArray1.getResourceId(0, -1);
        final TypedArray testArrayIcon1 = getResources().obtainTypedArray(temp1);
        for (int i = 0; i < getResources().getStringArray(temp1).length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon1.getResourceId(i, -1));
            viewFlipper_pushups.addView(imageView);
        }
        viewFlipper_pushups.setFlipInterval(1000);
        viewFlipper_pushups.setAutoStart(true);
//        viewFlipper_pushups.stopFlipping();

        final int temp2 = typedArray1.getResourceId(1, -1);
        final TypedArray testArrayIcon2 = getResources().obtainTypedArray(temp2);
//        final TypedArray testArrayIcon2 = getResources().obtainTypedArray(R.array.squats);
        for (int i = 0; i < getResources().getStringArray(temp2).length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon2.getResourceId(i, -1));
            viewFlipper_squats.addView(imageView);
        }
        viewFlipper_squats.setFlipInterval(1000);
        viewFlipper_squats.setAutoStart(true);

        final int temp3 = typedArray1.getResourceId(2, -1);
        final TypedArray testArrayIcon3 = getResources().obtainTypedArray(temp3);
//        final TypedArray testArrayIcon3 = getResources().obtainTypedArray(R.array.leg_raise);
        for (int i = 0; i < getResources().getStringArray(temp3).length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon3.getResourceId(i, -1));
            viewFlipper_legRaise.addView(imageView);
        }
        viewFlipper_legRaise.setFlipInterval(1000);
        viewFlipper_legRaise.setAutoStart(true);

        final int temp4 = typedArray1.getResourceId(3, -1);
        final TypedArray testArrayIcon4 = getResources().obtainTypedArray(temp4);
//        final TypedArray testArrayIcon4 = getResources().obtainTypedArray(R.array.jumping_jacks);
        for (int i = 0; i < getResources().getStringArray(temp4).length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon4.getResourceId(i, -1));
            viewFlipper_jumpingJack.addView(imageView);
        }
        viewFlipper_jumpingJack.setFlipInterval(1000);
        viewFlipper_jumpingJack.setAutoStart(true);


        final int temp5 = typedArray1.getResourceId(4, -1);
        final TypedArray testArrayIcon5 = getResources().obtainTypedArray(temp5);
//        final TypedArray testArrayIcon5 = getResources().obtainTypedArray(R.array.squats);
        for (int i = 0; i < getResources().getStringArray(temp5).length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon5.getResourceId(i, -1));
            viewFlipper_squatsAgain.addView(imageView);
        }
        viewFlipper_squatsAgain.setFlipInterval(1000);
        viewFlipper_squatsAgain.setAutoStart(true);


        final TypedArray testArrayIcon6 = getResources().obtainTypedArray(R.array.plank_with_leg_lift);
        for (int i = 0; i < getResources().getStringArray(R.array.plank_with_leg_lift).length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(testArrayIcon6.getResourceId(i, -1));
            viewFlipper_plankwithlegFit.addView(imageView);
        }
        viewFlipper_plankwithlegFit.setFlipInterval(1000);
        viewFlipper_plankwithlegFit.setAutoStart(true);
        tv_totalSet.setText("/" + (int) ((totaltime1 - 2000) / 2000));

        c1 = new CountDownTimer(totaltime1, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (isPausedC1 || isCanceledC1) {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                } else {
                    isRunningC1 = true;
                    progressBar.setMax((int) ((totaltime1 - 2000) / 2000));
                    display_time1 = millisUntilFinished;
                    progress = ((totaltime1 - display_time1) / 1000) / 2;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText(((totaltime1 - display_time1) / 1000) / 2 + "");
                    speakOut();
                }
            }

            @Override
            public void onFinish() {
                isRunningC1 = false;
                c1.cancel();
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                tv_nextExcerciseName.setText(name3);
                tv_nextExcerciseTotalSet.setText("x" + ((totaltime3 - 2000) / 2000));
                workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime1 - 2000) / 2000) * 100)
                        / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                speakOut1();
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
                tv_totalSet.setText("/" + (int) ((totaltime3 - 2000) / 2000));
                progressBar_excercise1.setProgress((int) ((totaltime1 - 2000) / 2000));
                progressBar.setProgress(0);
                c3.start();
            }
        };
        c3 = new CountDownTimer(totaltime3, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (isPausedC3 || isCanceledC3) {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                } else {
                    isRunningC3 = true;
                    progressBar.setMax((int) (((totaltime3) - 2000) / 2000));
                    display_time3 = millisUntilFinished;
                    progress = (((totaltime3) - display_time3) / 1000) / 2;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText((((totaltime3) - display_time3) / 1000) / 2 + "");
                    speakOut();
                }
            }

            @Override
            public void onFinish() {
                isRunningC3 = false;
                c3.cancel();
                workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime3 - 2000) / 2000) * 100)
                        / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                tv_nextExcerciseName.setText(name5);
                tv_nextExcerciseTotalSet.setText("x" + ((totaltime5 - 2000) / 2000));
                speakOut1();
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
                tv_totalSet.setText("/" + (int) ((totaltime5 - 2000) / 2000));
                progressBar_excercise2.setProgress((int) ((totaltime3 - 2000) / 2000));
                progressBar.setProgress(0);
                c5.start();
            }
        };
        c5 = new CountDownTimer(totaltime5, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (isPausedC5 || isCanceledC5) {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                } else {

                    isRunningC5 = true;
                    progressBar.setMax((int) ((totaltime5 - 2000) / 2000));
                    display_time5 = millisUntilFinished;
                    progress = ((totaltime5 - display_time5) / 1000) / 2;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText(((totaltime5 - display_time5) / 1000) / 2 + "");
                    speakOut();
                }
            }

            @Override
            public void onFinish() {
                isRunningC5 = false;
                c5.cancel();
                workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime5 - 2000) / 2000) * 100)
                        / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                tv_nextExcerciseName.setText(name7);
                tv_nextExcerciseTotalSet.setText("x" + ((totaltime7 - 2000) / 2000));
                speakOut1();
                c6.start();
            }
        };
        c6 = new CountDownTimer(totalTime30, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                isRunningC6 = true;
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
                progressBar_excercise3.setProgress((int) ((totaltime5 - 2000) / 2000));
                progressBar.setProgress(0);
                tv_totalSet.setText("/" + (int) ((totaltime7 - 2000) / 2000));
                c7.start();
            }
        };
        c7 = new CountDownTimer(totaltime7, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (isPausedC7 || isCanceledC7) {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                } else {

                    isRunningC7 = true;
                    progressBar.setMax((int) ((totaltime7 - 2000) / 2000));
                    display_time7 = millisUntilFinished;
                    progress = ((totaltime7 - display_time7) / 1000) / 2;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText(((totaltime7 - display_time7) / 1000) / 2 + "");
                    speakOut();
                }
            }

            @Override
            public void onFinish() {
                isRunningC7 = false;
                c7.cancel();
                workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime7 - 2000) / 2000) * 100)
                        / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                tv_nextExcerciseName.setText(name9);
                tv_nextExcerciseTotalSet.setText("x" + ((totaltime9 - 2000) / 2000));
                speakOut1();
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
                progressBar_excercise4.setProgress((int) ((totaltime7 - 2000) / 2000));
                progressBar.setProgress(0);
                tv_totalSet.setText("/" + (int) ((totaltime9 - 2000) / 2000));
                c9.start();
            }
        };
        c9 = new CountDownTimer(totaltime9, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (isPausedC9 || isCanceledC9) {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                } else {

                    isRunningC9 = true;
                    progressBar.setMax((int) ((totaltime9 - 2000) / 2000));
                    display_time9 = millisUntilFinished;
                    progress = ((totaltime9 - display_time9) / 1000) / 2;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText(((totaltime9 - display_time9) / 1000) / 2 + "");
                    speakOut();
                }
            }

            @Override
            public void onFinish() {
                isRunningC9 = false;
                c9.cancel();
                workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime9 - 2000) / 2000) * 100)
                        / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                tv_nextExcerciseName.setText(name11);
                tv_nextExcerciseTotalSet.setText("x" + ((totaltime11 - 2000) / 2000));
                speakOut1();
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
                progressBar_excercise5.setProgress((int) ((totaltime9 - 2000) / 2000));
                progressBar.setProgress(0);
                tv_totalSet.setText("/" + ((totaltime11 - 2000) / 2000));
                c11.start();
            }
        };
        c11 = new CountDownTimer(totaltime11, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (isPausedC11 || isCanceledC11) {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                } else {

                    isRunningC11 = true;
                    progressBar.setMax((int) ((totaltime11 - 2000) / 2000));
                    display_time11 = millisUntilFinished;
                    long progress = ((totaltime11 - display_time11) / 1000) / 2;
                    progressBar.setProgress((int) progress);
                    tv_countDown.setText(((totaltime11 - display_time11) / 1000) / 2 + "");
                    speakOut();
                }
            }

            @Override
            public void onFinish() {
                isRunningC11 = false;
                c11.cancel();
                workoutData.setProgress(workoutData.getProgress() + ((float) (((totaltime11 - 2000) / 2000) * 100)
                        / (((totaltime1 + totaltime3 + totaltime5 + totaltime7 + totaltime9 + totaltime11) - (2000 * 6)) / 2000)));
                Log.e("Current progress" + dayNo, "" + workoutData.getProgress());
                relativeLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                speakOut2();
                c12.start();
            }
        };
        c12 = new CountDownTimer(totalTime10, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                isRunningC12 = true;
                btn_skip.setVisibility(View.INVISIBLE);
                tv_nextExcerciseTotalSet.setVisibility(View.INVISIBLE);
                tv_nextExcerciseName.setText(R.string.excercise_done);
                display_time = millisUntilFinished;
                tv_countDownNextExcercise.setText("" + display_time / 1000);

            }

            @Override
            public void onFinish() {
                isRunningC12 = false;
                int check = databaseOperations.insertExcDayData(workoutData.getDay(), workoutData.getProgress());
                Log.e("value inserted", "" + check);
                c12.cancel();
                progressBar_excercise6.setProgress((int) ((totaltime11 - 2000) / 1000));
                startActivity(new Intent(ExcerciseStartedActivity.this, HomeActivity.class));
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

    @Override
    protected void onPause() {
        super.onPause();
        if (isRunningC1) {
            isPausedC1 = true;
            viewFlipper_pushups.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C1",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            first = true;
            Log.e("Progress paused", "" + progress_stored);
//            Toast.makeText(ExcerciseStartedActivity.this, "C1", Toast.LENGTH_SHORT).show();
        } else if (isRunningC3) {
            isPausedC3 = true;
            viewFlipper_squats.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C3",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            third = true;
//            Toast.makeText(ExcerciseStartedActivity.this, "C3", Toast.LENGTH_SHORT).show();
        } else if (isRunningC5) {
            isPausedC5 = true;
            viewFlipper_legRaise.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C5",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            fifth = true;
//            Toast.makeText(ExcerciseStartedActivity.this, "C5", Toast.LENGTH_SHORT).show();
        } else if (isRunningC7) {
            isPausedC7 = true;
            viewFlipper_jumpingJack.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C7",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            seventh = true;
//            Toast.makeText(ExcerciseStartedActivity.this, "C7", Toast.LENGTH_SHORT).show();
        } else if (isRunningC9) {
            isPausedC9 = true;
            viewFlipper_squatsAgain.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C9",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            ninth = true;
//            Toast.makeText(ExcerciseStartedActivity.this, "C9", Toast.LENGTH_SHORT).show();
        } else if (isRunningC11) {
            isPausedC11 = true;
            viewFlipper_plankwithlegFit.stopFlipping();
//            Toast.makeText(ExcerciseStartedActivity.this,"Excercise Paused C11",Toast.LENGTH_LONG).show();
            progress_stored = progress;
            eleventh = true;
//            Toast.makeText(ExcerciseStartedActivity.this, "C11", Toast.LENGTH_SHORT).show();
        }
        img_btn_pause.setVisibility(View.INVISIBLE);
        img_btn_play.setVisibility(View.VISIBLE);

    }

    @Override
    public void onDestroy() {
// Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
//                buttonSpeak.setEnabled(true);
                speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speakOut() {
//        int c = Integer.parseInt()
        if (!tv_countDown.getText().equals("0")) {
            String text = tv_countDown.getText().toString();
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    private void speakOut1() {
//        int c = Integer.parseInt()
        String text = tv_nextExcerciseName.getText().toString();
        tts.speak("Next Excercise is "+text, TextToSpeech.QUEUE_FLUSH, null);
    }


    private void speakOut2() {
//        int c = Integer.parseInt()
//        String text = tv_nextExcerciseName.getText().toString();
        tts.speak("You are done for the day", TextToSpeech.QUEUE_FLUSH, null);
    }

}
