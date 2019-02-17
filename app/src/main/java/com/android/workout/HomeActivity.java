package com.android.workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout ll1, ll2, ll3, ll4, ll5, ll6, ll7, ll8, ll9, ll10, ll11, ll12, ll13, ll14, ll15, ll16, ll17, ll18, ll19, ll20, ll21, ll22, ll23, ll24, ll25, ll26, ll27, ll28, ll29, ll30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView imageView = findViewById(R.id.imageView);
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



        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        ll30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ExcerciseActivity.class));
            }
        });

        Glide.with(this)
                .load(R.drawable.wo)
                .into(imageView);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.training_Plan) {
            Toast.makeText(HomeActivity.this,"Training Plan",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.meals_Plan) {
            Toast.makeText(HomeActivity.this,"Meals Plan",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.reminder) {
            Toast.makeText(HomeActivity.this,"Reminder",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.bmi_Calculator) {
            Toast.makeText(HomeActivity.this,"BMI Calculator",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.language) {
            Toast.makeText(HomeActivity.this,"Language",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.share) {
            Toast.makeText(HomeActivity.this,"Share",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.feedback) {
            Toast.makeText(HomeActivity.this,"FeedBack",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.rate_Us) {
            Toast.makeText(HomeActivity.this,"Rate Us",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.restart_Progress) {
            Toast.makeText(HomeActivity.this,"Restart Progress",Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
