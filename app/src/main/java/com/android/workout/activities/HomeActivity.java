package com.android.workout.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.workout.R;
import com.android.workout.adapters.HomeAdapter;
import com.android.workout.adapters.WorkoutData;
import com.android.workout.database.DatabaseOperations;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private float Heightincms = 0.0f;
    private EditText inches;
    private RadioButton lbs;
    private RadioButton kg;
    private RadioButton male;
    private RadioButton female;
    private EditText ft;
    private EditText year;
    private EditText weight;
    private EditText months;
    private RadioButton lang_spain;
    private RadioButton lang_english;
    private RadioButton lang_portugese;
    private Button select;
    private boolean flagbrasil=false;
    private boolean flagusa=false;
    private boolean flagspain=false;
    public int width;
    public int height;
    private Context context;
    DatabaseOperations databaseOperations;
    ArrayList<String> arrayList;
    RecyclerView recyclerView;
    private HomeAdapter adapter;
    private List<WorkoutData> homeList;
    private TextView textView;
    private TextView allProgess;
    private TextView daysLeftView;
    ProgressBar allProgressBar;
    private static final String Locale_Preference = "Locale Preference";
    private static final String Locale_KeyValue = "Saved Locale";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPreferences = getSharedPreferences(Locale_Preference, Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.width = displayMetrics.widthPixels;
        this.height = displayMetrics.heightPixels;
        this.context = this;
        loadLocale();
        databaseOperations = new DatabaseOperations(context);
        if(databaseOperations.CheckDBEmpty()==0){
            Log.e("HomeActivity","database was empty");
            databaseOperations.insertExcALLDayData();
        }
        allProgess = findViewById(R.id.progressStatus);
        allProgressBar = findViewById(R.id.mainProgressBar);
        daysLeftView = findViewById(R.id.daysleft);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this)
                .load(R.drawable.wo)
                .into(imageView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        homeList = databaseOperations.getAllDaysProgress();
        int totalProgressApp = 0,totalCompleteDays=0;
        for(WorkoutData workoutData:homeList){
            int x = (int)Math.ceil(workoutData.getProgress());
            totalProgressApp += x;
            if(x == 100){
                totalCompleteDays++;
            }
        }
        totalProgressApp = (totalProgressApp)/32;
        if(totalProgressApp == 100){
            restartProgress();
        }
        daysLeftView.setText((30-totalCompleteDays)+ getResources().getString(R.string.dayleft));
        allProgess.setText(totalProgressApp+"%");
        allProgressBar.setProgress(totalProgressApp);
        adapter = new HomeAdapter(getApplicationContext(), homeList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getResources().getString(R.string.exitapp))
                    .setCancelable(false)
                    .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            HomeActivity.this.finish();
                            finish();
                        }
                    })
                    .setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        loadLocale();
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.tip) {
            startActivity(new Intent(getApplicationContext(), TipsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.training_Plan) {
            //
        } else if (id == R.id.meals_Plan) {
            startActivity(new Intent(getApplicationContext(), MealsMainActivity.class));
            finish();
        } else if (id == R.id.reminder) {
            startActivity(new Intent(HomeActivity.this, AlarmMainActivity.class));
            finish();
        } else if (id == R.id.bmi_Calculator) {
            loadCalculateActivity();
        } else if (id == R.id.language) {
            customs();
        } else if (id == R.id.share) {
            shareUS();
        } else if (id == R.id.feedback) {
            getFeedback();
        } else if (id == R.id.rate_Us) {
            rateUs();
        } else if (id == R.id.restart_Progress) {
            restartProgress();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void restartProgress(){
        databaseOperations.deleteTable();
        databaseOperations.insertExcALLDayData();
        allProgess.setText("0%");
        allProgressBar.setProgress(0);
        adapter.notifyDataSetChanged();
        recreate();
    }

    private void rateUs() {
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://play.google.com/store/apps/details?id=com.android.workout"));
        startActivity(viewIntent);
    }

    private void getFeedback() {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","email@email.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack on 30-Day Wight Loss");
        intent.putExtra(Intent.EXTRA_TEXT, "message");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }

    private void loadCalculateActivity() {
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
            @Override
            public void onClick(View v) {
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
                                                                int b = calculateBMI(calculateMetres(Float.parseFloat(ft.getText().toString()), Float.parseFloat(inches.getText().toString())), calculateweight(Float.parseFloat(weight.getText().toString())));
                                                            Bundle bundle = new Bundle();
                                                            bundle.putFloat("BMI",(float)b);
                                                            bundle.putFloat("HEIGHT",Heightincms);
                                                                intent = new Intent(HomeActivity.this, CalculateActivity.class);
                                                                intent.putExtras(bundle);
                                                        }
                                                        
                                                        i = R.string.weightrange;
                                                    } else {
                                                        if (lbs.isChecked()) {
                                                            if (!weight.getText().toString().matches("") && Integer.parseInt(weight.getText().toString()) >= 11) {
                                                                if (Integer.parseInt(weight.getText().toString()) <= 286) {
                                                                    float b2 = (float) calculateBMI(calculateMetres(Float.parseFloat(ft.getText().toString()), Float.parseFloat(inches.getText().toString())), calculateweight(Float.parseFloat(weight.getText().toString())));
                                                                    Bundle bundle = new Bundle();
                                                                    bundle.putFloat("BMI",(float)b2);
                                                                    bundle.putFloat("HEIGHT",Heightincms);
                                                                    intent = new Intent(HomeActivity.this, CalculateActivity.class);
                                                                    intent.putExtras(bundle);
                                                                }
                                                            }
                                                            
                                                            i = R.string.weightrangelb;
                                                        }
                                                    }
                                                    HomeActivity.this.startActivity(intent);
                                                    dialog.dismiss();
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
//                Toast.makeText(getApplicationContext(), i, Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
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

    Dialog dialogLanguage;
    void customs(){
        dialogLanguage = new Dialog(this, R.style.AppTheme);
        dialogLanguage.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialogLanguage.getWindow().setLayout(-1, -1);
        dialogLanguage.requestWindowFeature(1);
        dialogLanguage.getWindow().setFlags(1024, 1024);
        dialogLanguage.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialogLanguage.setContentView(R.layout.activity_custom_language);
        dialogLanguage.setCancelable(false);
        dialogLanguage.getWindow().setLayout(-1, -1);
        dialogLanguage.setCancelable(true);
        this.lang_spain = dialogLanguage.findViewById(R.id.spain);
        this.lang_portugese = dialogLanguage.findViewById(R.id.brazil);
        this.lang_english = dialogLanguage.findViewById(R.id.usa);
        this.select = dialogLanguage.findViewById(R.id.select);
        String language = sharedPreferences.getString(Locale_KeyValue, "");
        if(language.equals("es")){
            lang_spain.setChecked(true);
        }else if(language.equals("pt")){
            lang_portugese.setChecked(true);
        }else{
            lang_english.setChecked(true);
        }
        this.lang_portugese.setOnClickListener(new C10204(this));
        this.lang_english.setOnClickListener(new C10215(this));
        this.lang_spain.setOnClickListener(new C10226(this));
        this.select.setOnClickListener(new C10237(this));
        dialogLanguage.show();
    }
    class C10237 implements View.OnClickListener{
        final HomeActivity homeActivity;

        public C10237(HomeActivity homeActivity) {
            this.homeActivity = homeActivity;
        }

        @Override
        public void onClick(View v) {
            if(this.homeActivity.flagbrasil){
               changeLocale("pt");
            }
            else if(this.homeActivity.flagspain){
                changeLocale("es");
            }
            else{
                changeLocale("en");
            }
            dialogLanguage.dismiss();
//            finish();
//            adapter.notifyDataSetChanged();
            recreate();
        }
    }
    public void changeLocale(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        Locale myLocale = new Locale(lang);//Set Selected Locale
        saveLocale(lang);//Save the selected locale
        Locale.setDefault(myLocale);//set new locale as default
        Configuration config = new Configuration();//get Configuration
        config.locale = myLocale;//set config locale as selected locale
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());//Update the config
        Log.e("Language changed",lang);
//        adapter.notifyDataSetChanged();
    }

    public void saveLocale(String lang) {
        editor.putString(Locale_KeyValue, lang);
        editor.commit();
    }

    //Get locale method in preferences
    public void loadLocale() {
        String language = sharedPreferences.getString(Locale_KeyValue, "");
        changeLocale(language);
    }
    class C10204 implements View.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeActivity f3310a;

        C10204(HomeActivity HomeActivity) {
            this.f3310a = HomeActivity;
        }

        public void onClick(View view) {
            if (this.f3310a.lang_portugese.isChecked()) {
                if (this.f3310a.flagbrasil) {
                    this.f3310a.flagbrasil = false;
                    this.f3310a.lang_portugese.setChecked(false);
                    this.f3310a.lang_english.setChecked(false);
                    this.f3310a.lang_spain.setChecked(false);
                } else {
                    this.f3310a.lang_portugese.setChecked(true);
                    this.f3310a.lang_english.setChecked(false);
                    this.f3310a.lang_spain.setChecked(false);
                    this.f3310a.flagbrasil = true;
                    this.f3310a.flagusa = false;
                    this.f3310a.flagspain = false;
                }
            }
        }
    }

    /* renamed from: com.outthinking.weightlossformen.activities.HomeActivity$5 */
    class C10215 implements View.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeActivity f3311a;

        C10215(HomeActivity HomeActivity) {
            this.f3311a = HomeActivity;
        }

        public void onClick(View view) {
            if (this.f3311a.lang_english.isChecked()) {
                if (this.f3311a.flagusa) {
                    this.f3311a.flagusa = false;
                    this.f3311a.lang_portugese.setChecked(false);
                    this.f3311a.lang_english.setChecked(false);
                    this.f3311a.lang_spain.setChecked(false);
                } else {
                    this.f3311a.lang_english.setChecked(true);
                    this.f3311a.lang_portugese.setChecked(false);
                    this.f3311a.lang_spain.setChecked(false);
                    this.f3311a.flagusa = true;
                    this.f3311a.flagbrasil = false;
                    this.f3311a.flagspain = false;
                }
            }
        }
    }

    /* renamed from: com.outthinking.weightlossformen.activities.HomeActivity$6 */
    class C10226 implements View.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeActivity f3312a;

        C10226(HomeActivity HomeActivity) {
            this.f3312a = HomeActivity;
        }

        public void onClick(View view) {
            if (this.f3312a.lang_spain.isChecked()) {
                if (this.f3312a.flagspain) {
                    this.f3312a.flagspain = false;
                    this.f3312a.lang_spain.setChecked(false);
                    this.f3312a.lang_english.setChecked(false);
                    this.f3312a.lang_portugese.setChecked(false);
                } else {
                    this.f3312a.lang_spain.setChecked(true);
                    this.f3312a.lang_portugese.setChecked(false);
                    this.f3312a.lang_english.setChecked(false);
                    this.f3312a.flagspain = true;
                    this.f3312a.flagbrasil = false;
                    this.f3312a.flagusa = false;
                }
            }
        }
    }

    private void shareUS()
    {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://play.google.com/store/apps/details?id=");
        stringBuilder.append(getApplicationContext().getPackageName());
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(getResources().getString(R.string.amazingapp));
        stringBuilder3.append(" "+getResources().getString(R.string.app_name));
        stringBuilder3.append(" "+getResources().getString(R.string.awesome));
        stringBuilder3.append("\n\n");
        stringBuilder3.append(getResources().getString(R.string.keepsfit));
        stringBuilder3.append("\n\n");
        stringBuilder3.append(getResources().getString(R.string.download));
        stringBuilder3.append("\n");
        stringBuilder3.append(stringBuilder2);
        stringBuilder2 = stringBuilder3.toString();
        sharingIntent.setType("text/plain");
        String shareBody = "Here is the share content body";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "WorkOut");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, stringBuilder2);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

}
