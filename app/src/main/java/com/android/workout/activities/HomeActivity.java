package com.android.workout.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.workout.R;
import com.android.workout.database.DatabaseOperations;
import com.bumptech.glide.Glide;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout ll1, ll2, ll3, ll4, ll5, ll6, ll7, ll8, ll9,
            ll10, ll11, ll12, ll13, ll14, ll15, ll16, ll17, ll18,
            ll19, ll20, ll21, ll22, ll23, ll24, ll25, ll26, ll27, ll28, ll29, ll30;
    private float Heightincms = 0.0f;
    private EditText inches;
    private RadioButton lbs;
    private RadioButton kg;
    private RadioButton male;
    private RadioButton female;
    private SharedPreferences mSharedPreferences;
    private EditText ft;
    private EditText year;
    private EditText weight;
    private EditText months;
    private SharedPreferences.Editor prefsEditor;
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
    private SharedPreferences launchDataPreferences;
    DatabaseOperations f5639h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.width = displayMetrics.widthPixels;
        this.height = displayMetrics.heightPixels;
        this.context = this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this)
                .load(R.drawable.wo)
                .into(imageView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setLayouts();
        layoutActions();
        this.launchDataPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void layoutActions() {
        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });

        ll30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ExcerciseActivity.class));
            }
        });
    }

    private void setLayouts() {
        ll1 = findViewById(R.id.linear1);
        ll2 = findViewById(R.id.linear2);
        ll3 = findViewById(R.id.linear3);
        ll4 = findViewById(R.id.linear4);
        ll5 = findViewById(R.id.linear5);
        ll6 = findViewById(R.id.linear6);
        ll7 = findViewById(R.id.linear7);
        ll8 = findViewById(R.id.linear8);
        ll9 = findViewById(R.id.linear9);
        ll10 = findViewById(R.id.linear10);
        ll11 = findViewById(R.id.linear11);
        ll12 = findViewById(R.id.linear12);
        ll13 = findViewById(R.id.linear13);
        ll14 = findViewById(R.id.linear14);
        ll15 = findViewById(R.id.linear15);
        ll16 = findViewById(R.id.linear16);
        ll17 = findViewById(R.id.linear17);
        ll18 = findViewById(R.id.linear18);
        ll19 = findViewById(R.id.linear19);
        ll20 = findViewById(R.id.linear20);
        ll21 = findViewById(R.id.linear21);
        ll22 = findViewById(R.id.linear22);
        ll23 = findViewById(R.id.linear23);
        ll24 = findViewById(R.id.linear24);
        ll25 = findViewById(R.id.linear25);
        ll26 = findViewById(R.id.linear26);
        ll27 = findViewById(R.id.linear27);
        ll28 = findViewById(R.id.linear28);
        ll29 = findViewById(R.id.linear29);
        ll30 = findViewById(R.id.linear30);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
            Toast.makeText(HomeActivity.this, "Training Plan", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.meals_Plan) {
            Toast.makeText(HomeActivity.this, "Meals Plan", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), MealsMainActivity.class));
        } else if (id == R.id.reminder) {
            Toast.makeText(HomeActivity.this, "Reminder", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(HomeActivity.this,ReminderActivity.class));
        } else if (id == R.id.bmi_Calculator) {
            Toast.makeText(HomeActivity.this, "BMI Calculator", Toast.LENGTH_SHORT).show();
            loadCalculateActivity();
        } else if (id == R.id.language) {
            Toast.makeText(HomeActivity.this, "Language", Toast.LENGTH_SHORT).show();
            customs();
//            startActivity(new Intent(getApplicationContext(), CustomLanguageActivity.class));
        } else if (id == R.id.share) {
            Toast.makeText(HomeActivity.this, "Share", Toast.LENGTH_SHORT).show();
            shareApp();
        } else if (id == R.id.feedback) {
            Toast.makeText(HomeActivity.this, "FeedBack", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.rate_Us) {
            Toast.makeText(HomeActivity.this, "Rate Us", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.restart_Progress) {
            Toast.makeText(HomeActivity.this, "Restart Progress", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Log.e("Language changed",lang);
        Intent refresh = new Intent(this, HomeActivity.class);
        startActivity(refresh);
        finish();
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
                                                            //if (Integer.parseInt(this.f3315b.weight.getText().toString()) <= TsExtractor.TS_STREAM_TYPE_HDMV_DTS) {
                                                                int b = calculateBMI(calculateMetres(Float.parseFloat(ft.getText().toString()), Float.parseFloat(inches.getText().toString())), calculateweight(Float.parseFloat(weight.getText().toString())));
//                                                                prefsEditor = mSharedPreferences.edit();
//                                                                prefsEditor.putFloat("BMI", (float) b);
//                                                                prefsEditor.putFloat("HEIGHT", Heightincms);
//                                                                prefsEditor.apply();
                                                            Bundle bundle = new Bundle();
                                                            bundle.putFloat("BMI",(float)b);
                                                            bundle.putFloat("HEIGHT",Heightincms);
                                                                intent = new Intent(HomeActivity.this, CalculateActivity.class);
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

    void customs(){
        Dialog dialog = new Dialog(this, R.style.AppTheme);
        dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialog.getWindow().setLayout(-1, -1);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(R.layout.activity_custom_language);
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -1);
        dialog.setCancelable(true);
        this.lang_spain = dialog.findViewById(R.id.spain);
        this.lang_portugese = dialog.findViewById(R.id.brazil);
        this.lang_english = dialog.findViewById(R.id.usa);
        this.select = dialog.findViewById(R.id.select);
        this.lang_portugese.setOnClickListener(new C10204(this));
        this.lang_english.setOnClickListener(new C10215(this));
        this.lang_spain.setOnClickListener(new C10226(this));
        this.select.setOnClickListener(new C10237(this));
        dialog.show();
    }
    class C10237 implements View.OnClickListener{
        final HomeActivity homeActivity;

        public C10237(HomeActivity homeActivity) {
            this.homeActivity = homeActivity;
        }

        @Override
        public void onClick(View v) {
            if(this.homeActivity.flagbrasil){
               setLocale("kn");
            }
            else if(this.homeActivity.flagspain){
                setLocale("hi");
            }
            else{
                setLocale("en");
            }
        }
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
    private void shareApp() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", getResources().getString(R.string.app_name));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://play.google.com/store/apps/details?id=");
        stringBuilder.append(getApplicationContext().getPackageName());
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(getResources().getString(R.string.amazingapp));
        stringBuilder3.append(getResources().getString(R.string.app_name));
        stringBuilder3.append(getResources().getString(R.string.awesome));
        stringBuilder3.append("\n\n");
        stringBuilder3.append(getResources().getString(R.string.keepsfit));
        stringBuilder3.append("\n\n");
        stringBuilder3.append(getResources().getString(R.string.download));
        stringBuilder3.append("\n");
        stringBuilder3.append(stringBuilder2);
        stringBuilder2 = stringBuilder3.toString();
        intent.putExtra("android.intent.extra.TEXT", stringBuilder2);
        intent.putExtra("android.intent.extra.STREAM", stringBuilder2);
        intent.setType("text/plain");
        startActivity(intent);
    }

}
