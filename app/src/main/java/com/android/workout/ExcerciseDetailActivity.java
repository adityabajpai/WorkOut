package com.android.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExcerciseDetailActivity extends AppCompatActivity {

    TextView excercise_detail_text;
    String excercise = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_detail);
        excercise_detail_text = findViewById(R.id.excercise_text);
        Bundle bundle = getIntent().getExtras();
        excercise = bundle.getString("excercise");
        if(excercise.equals("pushups"))
        {
            excercise_detail_text.setText(R.string.string_pushups);
        }
        else if(excercise.equals("squats"))
        {
            excercise_detail_text.setText(R.string.string_squats);
        }
        else if(excercise.equals("legraise"))
        {
            excercise_detail_text.setText(R.string.string_legRaise);
        }
        else if(excercise.equals("jumpingjack"))
        {
            excercise_detail_text.setText(R.string.string_jumpingJack);
        }
        else if(excercise.equals("squatsagain"))
        {
            excercise_detail_text.setText(R.string.string_squats);
        }
        else if(excercise.equals("plankwithlegfit"))
        {
            excercise_detail_text.setText(R.string.string_planWithLegFit);
        }
    }
}
