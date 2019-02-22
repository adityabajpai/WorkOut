package com.android.workout.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.*;

import com.android.workout.R;
import com.android.workout.utils.CustomSeekBar;
import com.android.workout.utils.ProgressItem;

import java.util.ArrayList;

public class CalculateActivity extends Activity {

    private float Heightincms = 0.0f;
    private double bmiblueSpan = 4.0d;
    private double bmigreenSpan = 7.0d;
    private float bmiorangeSpan = 10.0f;
    private float bmiredSpan;
    private CustomSeekBar bmiseekBar;
    private float bmitotalSpan = 50.0f;
    private float bmivioletSpan = 15.0f;
    private float bmiyellowSpan = 5.0f;
    private RadioButton female;
    private EditText ft;
    private TextView height_desc;
    private double heightblueSpan = 16.0d;
    private double heightgreenSpan = 8.0d;
    private float heightorangeSpan = 7.0f;
    private float heightredSpan;
    private CustomSeekBar heightseekBar;
    private float heighttotalSpan = 213.0f;
    private float heightvioletSpan = 135.0f;
    private float heightyellowSpan = 12.0f;
    private TextView hght2;
    private TextView hght4;
    private EditText inches;
    private RadioButton kg;
    private RadioButton lbs;
    private ProgressItem mProgressItem;
    private SharedPreferences mSharedPreferences;
    private RadioButton male;
    private EditText months;
    private SharedPreferences.Editor prefsEditor;
    private ArrayList<ProgressItem> progressItemList;
    private EditText weight;
    private TextView wght2;
    private TextView wght4;
    private EditText year;
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_calculate);
        this.bmiseekBar = findViewById(R.id.bmiseekBar);
        this.heightseekBar = findViewById(R.id.heightseekBar);
        this.wght2 = findViewById(R.id.wght2);
        this.wght4 = findViewById(R.id.wght4);
        this.hght2 = findViewById(R.id.hght2);
        this.hght4 = findViewById(R.id.hght4);
        this.height_desc = findViewById(R.id.height_desc);
        initDataToSeekbar();
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        findViewById(R.id.edit).setOnClickListener(new C10061(this));
        findViewById(R.id.startexc).setOnClickListener(new C10072(this));
    }

    public void imageclick(View view) {
        startActivity(new Intent(this, TipsActivity.class));
    }

    private int calculateBMI(float f, float f2) {
        return (int) (f2 / (f * f));
    }

    private float calculateHeightinCentimeter(float f) {
        return (float) ((int) (f * 100.0f));
    }

    private float calculateMetres(float f, float f2) {
        f = (float) (((double) (f + (f2 / 12.0f))) / 3.28d);
        this.Heightincms = calculateHeightinCentimeter(f);
        return f;
    }

    private float calculateweight(float f) {
        return this.lbs.isChecked() ? (float) (((double) f) * 0.453592d) : f;
    }

    private void initDataToSeekbar() {
        TextView textView = null;
        Resources resources = null;
        int i = 0;
        int i2 = 0;
        this.heightseekBar.setEnabled(true);
        this.bmiseekBar.setEnabled(true);
        this.progressItemList = new ArrayList();
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.bmivioletSpan / this.bmitotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.violet;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = ((float) (this.bmiblueSpan / ((double) this.bmitotalSpan))) * 100.0f;
        this.mProgressItem.color = R.color.blue;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = ((float) (this.bmigreenSpan / ((double) this.bmitotalSpan))) * 100.0f;
        this.mProgressItem.color = R.color.green;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.bmiyellowSpan / this.bmitotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.yellow;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.bmiorangeSpan / this.bmitotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.orange;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.bmiredSpan / this.bmitotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.red;
        this.progressItemList.add(this.mProgressItem);
        this.bmiseekBar.initData(this.progressItemList);
        float floatExtra = getIntent().getFloatExtra("BMI", 0.0f);
        this.bmiseekBar.setProgress((int) floatExtra);
        this.wght4.setText(String.valueOf(floatExtra));
        if (floatExtra >= 0.0f && floatExtra <= 15.0f) {
            this.wght2.setText(R.string.sevunderweighthead);
            textView = this.height_desc;
            resources = getResources();
            i = R.string.severelyUnderweight;
        } else if (floatExtra >= 16.0f && floatExtra <= 18.0f) {
            this.wght2.setText(R.string.underweighthead);
            textView = this.height_desc;
            resources = getResources();
            i = R.string.underweight;
        } else if (floatExtra >= 19.0f && floatExtra <= 25.0f) {
            this.wght2.setText(R.string.normalhead);
            textView = this.height_desc;
            resources = getResources();
            i = R.string.normal;
        } else if (floatExtra >= 26.0f && floatExtra <= 30.0f) {
            this.wght2.setText(R.string.overweighthead);
            textView = this.height_desc;
            resources = getResources();
            i = R.string.overweight;
        } else if (floatExtra < 31.0f || floatExtra > 40.0f) {
            if (floatExtra >= 41.0f && floatExtra <= 50.0f) {
                this.wght2.setText(R.string.severlyobese);
                textView = this.height_desc;
                resources = getResources();
                i = R.string.severelyObese;
            }
            this.bmiseekBar.invalidate();
            this.progressItemList = new ArrayList();
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = (this.heightvioletSpan / this.heighttotalSpan) * 100.0f;
            this.mProgressItem.color = R.color.violet;
            this.progressItemList.add(this.mProgressItem);
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = ((float) (this.heightblueSpan / ((double) this.heighttotalSpan))) * 100.0f;
            this.mProgressItem.color = R.color.blue;
            this.progressItemList.add(this.mProgressItem);
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = ((float) (this.heightgreenSpan / ((double) this.heighttotalSpan))) * 100.0f;
            this.mProgressItem.color = R.color.green;
            this.progressItemList.add(this.mProgressItem);
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = (this.heightyellowSpan / this.heighttotalSpan) * 100.0f;
            this.mProgressItem.color = R.color.yellow;
            this.progressItemList.add(this.mProgressItem);
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = (this.heightorangeSpan / this.heighttotalSpan) * 100.0f;
            this.mProgressItem.color = R.color.orange;
            this.progressItemList.add(this.mProgressItem);
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = (this.heightredSpan / this.heighttotalSpan) * 100.0f;
            this.mProgressItem.color = R.color.red;
            this.progressItemList.add(this.mProgressItem);
            this.heightseekBar.initData(this.progressItemList);
            floatExtra = getIntent().getFloatExtra("HEIGHT", 0.0f);
            this.heightseekBar.setProgress((int) floatExtra);
            this.hght4.setText(String.valueOf(floatExtra));
            if (floatExtra < 0.0f && floatExtra <= 135.0f) {
                textView = this.hght2;
                i2 = R.string.veryshortheight;
            } else if (floatExtra < 136.0f && floatExtra <= 150.0f) {
                textView = this.hght2;
                i2 = R.string.tooshortheight;
            } else if (floatExtra < 151.0f && floatExtra <= 158.0f) {
                textView = this.hght2;
                i2 = R.string.belowaveraheheight;
            } else if (floatExtra < 159.0f && floatExtra <= 170.0f) {
                textView = this.hght2;
                i2 = R.string.avgheight;
            } else if (floatExtra >= 171.0f || floatExtra > 178.0f) {
                if (floatExtra >= 179.0f && floatExtra <= 213.0f) {
                    textView = this.hght2;
                    i2 = R.string.extlongheight;
                }
                this.heightseekBar.invalidate();
                this.heightseekBar.setEnabled(false);
                this.bmiseekBar.setEnabled(false);
            } else {
                textView = this.hght2;
                i2 = R.string.abvavgheight;
            }
            textView.setText(i2);
            this.heightseekBar.invalidate();
            this.heightseekBar.setEnabled(false);
            this.bmiseekBar.setEnabled(false);
        } else {
            this.wght2.setText(R.string.obesehead);
            textView = this.height_desc;
            resources = getResources();
            i = R.string.obese;
        }
        textView.setText(resources.getString(i));
        this.bmiseekBar.invalidate();
        this.progressItemList = new ArrayList();
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.heightvioletSpan / this.heighttotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.violet;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = ((float) (this.heightblueSpan / ((double) this.heighttotalSpan))) * 100.0f;
        this.mProgressItem.color = R.color.blue;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = ((float) (this.heightgreenSpan / ((double) this.heighttotalSpan))) * 100.0f;
        this.mProgressItem.color = R.color.green;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.heightyellowSpan / this.heighttotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.yellow;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.heightorangeSpan / this.heighttotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.orange;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.heightredSpan / this.heighttotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.red;
        this.progressItemList.add(this.mProgressItem);
        this.heightseekBar.initData(this.progressItemList);
        floatExtra = getIntent().getFloatExtra("HEIGHT", 0.0f);
        this.heightseekBar.setProgress((int) floatExtra);
        this.hght4.setText(String.valueOf(floatExtra));
        if (floatExtra < 0.0f) {
        }
        if (floatExtra < 136.0f) {
        }
        if (floatExtra < 151.0f) {
        }
        if (floatExtra < 159.0f) {
        }
        if (floatExtra >= 171.0f) {
        }
        textView = this.hght2;
        i2 = R.string.extlongheight;
        textView.setText(i2);
        this.heightseekBar.invalidate();
        this.heightseekBar.setEnabled(false);
        this.bmiseekBar.setEnabled(false);
    }

    private void initDataToSeekbar(float f, float f2) {
        TextView textView = null;
        Resources resources = null;
        int i = 0;
        int i2 = 0;
        this.heightseekBar.setEnabled(true);
        this.bmiseekBar.setEnabled(true);
        this.progressItemList = new ArrayList();
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.bmivioletSpan / this.bmitotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.violet;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = ((float) (this.bmiblueSpan / ((double) this.bmitotalSpan))) * 100.0f;
        this.mProgressItem.color = R.color.blue;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = ((float) (this.bmigreenSpan / ((double) this.bmitotalSpan))) * 100.0f;
        this.mProgressItem.color = R.color.green;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.bmiyellowSpan / this.bmitotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.yellow;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.bmiorangeSpan / this.bmitotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.orange;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.bmiredSpan / this.bmitotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.red;
        this.progressItemList.add(this.mProgressItem);
        this.bmiseekBar.initData(this.progressItemList);
        this.bmiseekBar.setProgress((int) f);
        this.wght4.setText(String.valueOf(f));
        if (f >= 0.0f && f <= 15.0f) {
            this.wght2.setText(R.string.sevunderweighthead);
            textView = this.height_desc;
            resources = getResources();
            i = R.string.severelyUnderweight;
        } else if (f >= 16.0f && f <= 18.0f) {
            this.wght2.setText(R.string.underweighthead);
            textView = this.height_desc;
            resources = getResources();
            i = R.string.underweight;
        } else if (f >= 19.0f && f <= 25.0f) {
            this.wght2.setText(R.string.normalhead);
            textView = this.height_desc;
            resources = getResources();
            i = R.string.normal;
        } else if (f >= 26.0f && f <= 30.0f) {
            this.wght2.setText(R.string.overweighthead);
            textView = this.height_desc;
            resources = getResources();
            i = R.string.overweight;
        } else if (f < 31.0f || f > 40.0f) {
            if (f >= 41.0f && f <= 50.0f) {
                this.wght2.setText(R.string.severlyobese);
                textView = this.height_desc;
                resources = getResources();
                i = R.string.severelyObese;
            }
            this.bmiseekBar.invalidate();
            this.progressItemList = new ArrayList();
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = (this.heightvioletSpan / this.heighttotalSpan) * 100.0f;
            this.mProgressItem.color = R.color.violet;
            this.progressItemList.add(this.mProgressItem);
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = ((float) (this.heightblueSpan / ((double) this.heighttotalSpan))) * 100.0f;
            this.mProgressItem.color = R.color.blue;
            this.progressItemList.add(this.mProgressItem);
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = ((float) (this.heightgreenSpan / ((double) this.heighttotalSpan))) * 100.0f;
            this.mProgressItem.color = R.color.green;
            this.progressItemList.add(this.mProgressItem);
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = (this.heightyellowSpan / this.heighttotalSpan) * 100.0f;
            this.mProgressItem.color = R.color.yellow;
            this.progressItemList.add(this.mProgressItem);
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = (this.heightorangeSpan / this.heighttotalSpan) * 100.0f;
            this.mProgressItem.color = R.color.orange;
            this.progressItemList.add(this.mProgressItem);
            this.mProgressItem = new ProgressItem();
            this.mProgressItem.progressItemPercentage = (this.heightredSpan / this.heighttotalSpan) * 100.0f;
            this.mProgressItem.color = R.color.red;
            this.progressItemList.add(this.mProgressItem);
            this.heightseekBar.initData(this.progressItemList);
            this.heightseekBar.setProgress((int) f2);
            this.hght4.setText(String.valueOf(f2));
            if (f2 < 0.0f && f2 <= 135.0f) {
                textView = this.hght2;
                i2 = R.string.veryshortheight;
            } else if (f2 < 136.0f && f2 <= 150.0f) {
                textView = this.hght2;
                i2 = R.string.tooshortheight;
            } else if (f2 < 151.0f && f2 <= 158.0f) {
                textView = this.hght2;
                i2 = R.string.belowaveraheheight;
            } else if (f2 < 159.0f && f2 <= 170.0f) {
                textView = this.hght2;
                i2 = R.string.avgheight;
            } else if (f2 >= 171.0f || f2 > 178.0f) {
                if (f2 >= 179.0f && f2 <= 213.0f) {
                    textView = this.hght2;
                    i2 = R.string.extlongheight;
                }
                this.heightseekBar.invalidate();
                this.heightseekBar.setEnabled(false);
                this.bmiseekBar.setEnabled(false);
            } else {
                textView = this.hght2;
                i2 = R.string.abvavgheight;
            }
            textView.setText(i2);
            this.heightseekBar.invalidate();
            this.heightseekBar.setEnabled(false);
            this.bmiseekBar.setEnabled(false);
        } else {
            this.wght2.setText(R.string.obesehead);
            textView = this.height_desc;
            resources = getResources();
            i = R.string.obese;
        }
        textView.setText(resources.getString(i));
        this.bmiseekBar.invalidate();
        this.progressItemList = new ArrayList();
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.heightvioletSpan / this.heighttotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.violet;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = ((float) (this.heightblueSpan / ((double) this.heighttotalSpan))) * 100.0f;
        this.mProgressItem.color = R.color.blue;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = ((float) (this.heightgreenSpan / ((double) this.heighttotalSpan))) * 100.0f;
        this.mProgressItem.color = R.color.green;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.heightyellowSpan / this.heighttotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.yellow;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.heightorangeSpan / this.heighttotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.orange;
        this.progressItemList.add(this.mProgressItem);
        this.mProgressItem = new ProgressItem();
        this.mProgressItem.progressItemPercentage = (this.heightredSpan / this.heighttotalSpan) * 100.0f;
        this.mProgressItem.color = R.color.red;
        this.progressItemList.add(this.mProgressItem);
        this.heightseekBar.initData(this.progressItemList);
        this.heightseekBar.setProgress((int) f2);
        this.hght4.setText(String.valueOf(f2));
        if (f2 < 0.0f) {
        }
        if (f2 < 136.0f) {
        }
        if (f2 < 151.0f) {
        }
        if (f2 < 159.0f) {
        }
        if (f2 >= 171.0f) {
        }
        textView = this.hght2;
        i2 = R.string.extlongheight;
        textView.setText(i2);
        this.heightseekBar.invalidate();
        this.heightseekBar.setEnabled(false);
        this.bmiseekBar.setEnabled(false);
    }

    class C10061 implements View.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ CalculateActivity f3277a;

        C10061(CalculateActivity calculateActivity) {
            this.f3277a = calculateActivity;
        }

        public void onClick(View view) {
            this.f3277a.m2544a();
        }
    }

    class C10072 implements View.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ CalculateActivity f3278a;

        C10072(CalculateActivity calculateActivity) {
            this.f3278a = calculateActivity;
        }

        public void onClick(View view) {
            this.f3278a.finish();
        }
    }

    void m2544a(){
        final Dialog dialog = new Dialog(this, R.style.AppTheme);
        dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialog.getWindow().setLayout(-1, -1);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(R.layout.activity_customdialog_heightcheckout);
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -1);
        dialog.setCancelable(true);
        this.lbs = dialog.findViewById(R.id.lbs);
        this.kg = dialog.findViewById(R.id.kg);
        this.male = dialog.findViewById(R.id.male);
        this.female = dialog.findViewById(R.id.female);
        this.ft = dialog.findViewById(R.id.feet);
        this.inches = dialog.findViewById(R.id.inches);
        this.year = dialog.findViewById(R.id.year);
        this.months = dialog.findViewById(R.id.month);
        this.weight = dialog.findViewById(R.id.weight);
        dialog.findViewById(R.id.calculate).setOnClickListener(new View.OnClickListener() {
            CalculateActivity f3280b;
            @Override
            public void onClick(View r5) {
                int i;
                if (year.getText().toString().equals("") || months.getText().toString().equals("") || ft.getText().toString().equals("") || inches.getText().toString().equals("") || weight.getText().toString().equals("")) {

                    i = R.string.fields;
                } else {
                    if (!year.getText().toString().matches("") && Integer.parseInt(year.getText().toString()) >= 5) {
                        if (Integer.parseInt(year.getText().toString()) <= 100) {
                            if (!months.getText().toString().matches("") && Integer.parseInt(months.getText().toString()) >= 0) {
                                if (Integer.parseInt(months.getText().toString()) <= 12) {
                                    if (!ft.getText().toString().matches("") && Integer.parseInt(ft.getText().toString()) >= 2) {
                                        if (Integer.parseInt(ft.getText().toString()) <= 7) {
                                            if (!inches.getText().toString().matches("") && Integer.parseInt(inches.getText().toString()) >= 0) {
                                                if (Integer.parseInt(inches.getText().toString()) <= 12) {
                                                    Intent intent = null;
                                                    if (kg.isChecked()) {
                                                        if (!weight.getText().toString().matches("") && Integer.parseInt(weight.getText().toString()) >= 5) {
                                                            //if (Integer.parseInt(this.f3315b.weight.getText().toString()) <= TsExtractor.TS_STREAM_TYPE_HDMV_DTS) {
                                                            int b = calculateBMI(calculateMetres(Float.parseFloat(ft.getText().toString()), Float.parseFloat(inches.getText().toString())), calculateweight(Float.parseFloat(weight.getText().toString())));
//                                                                prefsEditor = mSharedPreferences.edit();
//                                                                prefsEditor.putFloat("BMI", (float) b);
//                                                                prefsEditor.putFloat("HEIGHT", Heightincms);
//                                                                prefsEditor.apply();
                                                            Bundle bundle = new Bundle();
                                                            bundle.putFloat("BMI",(float)b);
                                                            bundle.putFloat("HEIGHT",Heightincms);
                                                            intent = new Intent(CalculateActivity.this, CalculateActivity.class);
                                                            intent.putExtras(bundle);
                                                            //}
                                                        }

                                                        i = R.string.weightrange;
                                                    } else {
                                                        if (lbs.isChecked()) {
                                                            if (!weight.getText().toString().matches("") && Integer.parseInt(weight.getText().toString()) >= 11) {
                                                                if (Integer.parseInt(weight.getText().toString()) <= 286) {
                                                                    float b2 = (float) calculateBMI(calculateMetres(Float.parseFloat(ft.getText().toString()), Float.parseFloat(inches.getText().toString())), calculateweight(Float.parseFloat(weight.getText().toString())));
//                                                                    prefsEditor = mSharedPreferences.edit();
//                                                                    prefsEditor.putFloat("BMI", b2);
//                                                                    prefsEditor.putFloat("HEIGHT", Heightincms);
//                                                                    prefsEditor.apply();
                                                                    Bundle bundle = new Bundle();
                                                                    bundle.putFloat("BMI",(float)b2);
                                                                    bundle.putFloat("HEIGHT",Heightincms);
                                                                    intent = new Intent(CalculateActivity.this, CalculateActivity.class);
                                                                    intent.putExtras(bundle);
                                                                }
                                                            }

                                                            i = R.string.weightrangelb;
                                                        }
                                                    }
                                                    CalculateActivity.this.startActivity(intent);
                                                    dialog.dismiss();
                                                    finish();
                                                    return;
                                                }
                                            }

                                            i = R.string.inchrange;
                                        }
                                    }

                                    i = R.string.feetrange;
                                }
                            }

                            i = R.string.monthrange;
                        }
                    }

                    i = R.string.agerange;
                }
            }
        });
        dialog.show();
    }
}
