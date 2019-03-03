package com.android.workout.activities;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.workout.R;

import java.util.Locale;

public class ExcerciseDetailActivity extends AppCompatActivity {

    TextView excercise_detail_text;
    String excercise = "";
    public int[] image_array_pushUps = {R.drawable.push_up_a,R.drawable.push_up_b};
    public int[] image_array_squats = {R.drawable.squats_a,R.drawable.squats_b};
    public int[] image_array_legRaise = {R.drawable.leg_raise_a,R.drawable.leg_raise_b};
    public int[] image_array_jumpingJack = {R.drawable.jumping_a,R.drawable.jumping_b,R.drawable.jumping_c};
    public int[] image_array_plank = {R.drawable.plank_with_leg_lift_a,R.drawable.plank_with_leg_lift_b,R.drawable.plank_with_leg_lift_c};

    public int[] highknees = {R.drawable.high_knees_a,R.drawable.high_knees_b};
    public int[] basic_crunches = {R.drawable.basic_crunches_a,R.drawable.basic_crunches_b};
    public int[] bench_dips = {R.drawable.bench_dips_a,R.drawable.bench_dips_b};
    public int[] alternator_heel_touch = {R.drawable.alternater_hell_touches_a,R.drawable.alternater_hell_touches_b,R.drawable.alternater_hell_touches_c};
    public int[] arm_crunches = {R.drawable.arm_reaching_crunches_a,R.drawable.arm_reaching_crunches_b};
    public int[] bicycle_crunches = {R.drawable.bicyle_crunches_a,R.drawable.bicyle_crunches_b,R.drawable.bicyle_crunches_c};
    public int[] flutter_kicks = {R.drawable.flutter_kicks_a,R.drawable.flutter_kicks_b,R.drawable.flutter_kicks_c,R.drawable.flutter_kicks_d};
    public int[] leg_up_crunches = {R.drawable.leg_up_crunches_a,R.drawable.leg_up_crunches_b};
    public int[] lunge = {R.drawable.lunge_a,R.drawable.lunge_b,R.drawable.lunge_c};
    public int[] v_crunches = {R.drawable.v_crunches_a,R.drawable.v_crunches_b};
    public int[] vertical_leg_crunches = {R.drawable.vertical_leg_crunches_a,R.drawable.vertical_leg_crunches_b};
    ViewFlipper viewFlipper;

    private static Locale myLocale;

    private static final String Locale_Preference = "Locale Preference";
    private static final String Locale_KeyValue = "Saved Locale";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_detail);
        excercise_detail_text = findViewById(R.id.excercise_text);
        viewFlipper = findViewById(R.id.imageView);
        Bundle bundle = getIntent().getExtras();
        excercise = bundle.getString("excercise");
        Log.e("excercise",excercise);
    }

    public void changeLocale(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);//Set Selected Locale
        saveLocale(lang);//Save the selected locale
        Locale.setDefault(myLocale);//set new locale as default
        Configuration config = new Configuration();//get Configuration
        config.locale = myLocale;//set config locale as selected locale
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());//Update the config
        setFlippingViews();//Update texts according to locale
    }

    //Save locale method in preferences
    public void saveLocale(String lang) {
        editor.putString(Locale_KeyValue, lang);
        editor.commit();
    }

    //Get locale method in preferences
    public void loadLocale() {
        String language = sharedPreferences.getString(Locale_KeyValue, "");
        changeLocale(language);
    }

    private void setFlippingViews() {
        if(excercise.equals("PUSHUPS"))
        {
            for (int i = 0; i < image_array_pushUps.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(image_array_pushUps[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            Log.e("enterd","entrerd");
            excercise_detail_text.setText(getResources().getString(R.string.desc_pushups));
        }
        else if(excercise.equals("SQUATS"))
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
        else if(excercise.equals("LEG RAISE"))
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
        else if(excercise.equals("JUMPING JACK")) {
            for (int i = 0; i < image_array_jumpingJack.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(image_array_jumpingJack[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_jumping_jacks);
        }
        else if(excercise.equals("PLANK WITH LEG FIT"))
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
        else if(excercise.equals("HIGH KNEES"))
        {
            for (int i = 0; i < highknees.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(highknees[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_high_knees);
        }
        else if(excercise.equals("BASIC CRUNCHES"))
        {
            for (int i = 0; i < basic_crunches.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(basic_crunches[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_basic_crunches);
        }
        else if(excercise.equals("BENCH DIPS"))
        {
            for (int i = 0; i < bench_dips.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(bench_dips[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_bench_dips);
        }
        else if(excercise.equals("ALTERNATER HEEL TOUCH"))
        {
            for (int i = 0; i < alternator_heel_touch.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(alternator_heel_touch[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_alternater_heeltouch);
        }
        else if(excercise.equals("ARM CRUNCHES"))
        {
            for (int i = 0; i < arm_crunches.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(arm_crunches[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_arm_crunches);
        }
        else if(excercise.equals("BICYCLE CRUNCHES"))
        {
            for (int i = 0; i < bicycle_crunches.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(bicycle_crunches[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_bicycle_crunches);
        }
        else if(excercise.equals("FLUTTER KICKS"))
        {
            for (int i = 0; i < flutter_kicks.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(flutter_kicks[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_flutter_kicks);
        }
        else if(excercise.equals("LEG UP CRUNCHES"))
        {
            for (int i = 0; i < leg_up_crunches.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(leg_up_crunches[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_leg_up_crunches);
        }
        else if(excercise.equals("LUNGE"))
        {
            for (int i = 0; i < lunge.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(lunge[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_lunge);
        }
        else if(excercise.equals("V CRUNCHES"))
        {
            for (int i = 0; i < v_crunches.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(v_crunches[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_v_crunches);
        }
        else if(excercise.equals("VERTICAL LEG CRUNCHES"))
        {
            for (int i = 0; i < vertical_leg_crunches.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(vertical_leg_crunches[i]);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(500);
            viewFlipper.setAutoStart(true);
            excercise_detail_text.setText(R.string.desc_vertical_leg_crunches);
        }
    }
}
