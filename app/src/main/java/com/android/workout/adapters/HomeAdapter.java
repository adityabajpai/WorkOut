package com.android.workout.adapters;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.workout.R;
import com.android.workout.activities.ExcerciseActivity;
import com.android.workout.activities.HomeActivity;
import com.android.workout.activities.RestDayActivity;
import com.android.workout.database.DatabaseOperations;
import com.android.workout.model.Home;

import java.util.List;
import java.util.Locale;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context = null;
    private List<WorkoutData> homes = null;
    private static final String Locale_Preference = "Locale Preference";
    private static final String Locale_KeyValue = "Saved Locale";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public HomeAdapter(Context context, List<WorkoutData> homes) {
        this.context = context;
        this.homes = homes;
        sharedPreferences = context.getSharedPreferences(Locale_Preference, Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        loadLocale();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card,viewGroup,false);
        return new ViewHolder(view);
    }

    public void changeLocale(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        Locale myLocale = new Locale(lang);//Set Selected Locale
        saveLocale(lang);//Save the selected locale
        Locale.setDefault(myLocale);//set new locale as default
        Configuration config = new Configuration();//get Configuration
        config.locale = myLocale;//set config locale as selected locale
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());//Update the config
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

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final WorkoutData home =homes.get(viewHolder.getAdapterPosition());
        if((i+1)%4==0){
            viewHolder.tv1.setText(context.getResources().getString(R.string.restday));
            viewHolder.tv_progress1.setVisibility(View.INVISIBLE);
            viewHolder.progressBar1.setVisibility(View.INVISIBLE);

        }else{
            viewHolder.tv1.setText(context.getResources().getString(R.string.day)+" "+(i+1));
            viewHolder.tv_progress1.setText(((int)Math.ceil(home.getProgress())+"%"));
            viewHolder.progressBar1.setProgress((int)Math.ceil(home.getProgress()));
        }
        if((int)home.getProgress()==100){
            Log.e("true","true");
//            viewHolder.ll1.setEnabled(false);
            viewHolder.ll1.setClickable(false);
            viewHolder.tv_progress1.setClickable(false);
//            viewHolder.tv_progress1.setEnabled(false);
//            viewHolder.progressBar1.setEnabled(false);
            viewHolder.progressBar1.setClickable(false);
        }
        viewHolder.ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((int)home.getProgress()==100){
                    Log.e("true","true1");
                }

                else if(viewHolder.getAdapterPosition()+1==4 || viewHolder.getAdapterPosition()+1==8 || viewHolder.getAdapterPosition()+1==12 || viewHolder.getAdapterPosition()+1==16 || viewHolder.getAdapterPosition()+1==20 || viewHolder.getAdapterPosition()+1==24 || viewHolder.getAdapterPosition()+1==28)
                {
                    Log.e("my day ",""+(viewHolder.getAdapterPosition()+1));
                    Intent intent = new Intent(context, RestDayActivity.class);
//                    intent.putExtras(bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else
                {
                    Log.e("my day ",""+(viewHolder.getAdapterPosition()+1));
                    Bundle bundle  = new Bundle();
                    bundle.putInt("day",viewHolder.getAdapterPosition()+1);
                    Intent intent = new Intent(context,ExcerciseActivity.class);
                    intent.putExtras(bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
        viewHolder.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHolder.getAdapterPosition()+1==4 || viewHolder.getAdapterPosition()+1==8 || viewHolder.getAdapterPosition()+1==12 || viewHolder.getAdapterPosition()+1==16 || viewHolder.getAdapterPosition()+1==20 || viewHolder.getAdapterPosition()+1==24 || viewHolder.getAdapterPosition()+1==28)
                {
                    Log.e("my day ",""+(viewHolder.getAdapterPosition()+1));
                    Intent intent = new Intent(context, RestDayActivity.class);
//                    intent.putExtras(bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else
                {
                    Log.e("my day ",""+(viewHolder.getAdapterPosition()+1));
                    Bundle bundle  = new Bundle();
                    bundle.putInt("day",viewHolder.getAdapterPosition()+1);
                    Intent intent = new Intent(context,ExcerciseActivity.class);
                    intent.putExtras(bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
        viewHolder.tv_progress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHolder.getAdapterPosition()+1==4 || viewHolder.getAdapterPosition()+1==8 || viewHolder.getAdapterPosition()+1==12 || viewHolder.getAdapterPosition()+1==16 || viewHolder.getAdapterPosition()+1==20 || viewHolder.getAdapterPosition()+1==24 || viewHolder.getAdapterPosition()+1==28)
                {
                    Log.e("my day ",""+(viewHolder.getAdapterPosition()+1));
                    Intent intent = new Intent(context, RestDayActivity.class);
//                    intent.putExtras(bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else
                {
                    Log.e("my day ",""+(viewHolder.getAdapterPosition()+1));
                    Bundle bundle  = new Bundle();
                    bundle.putInt("day",viewHolder.getAdapterPosition()+1);
                    Intent intent = new Intent(context,ExcerciseActivity.class);
                    intent.putExtras(bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
        viewHolder.progressBar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHolder.getAdapterPosition()+1==4 || viewHolder.getAdapterPosition()+1==8 || viewHolder.getAdapterPosition()+1==12 || viewHolder.getAdapterPosition()+1==16 || viewHolder.getAdapterPosition()+1==20 || viewHolder.getAdapterPosition()+1==24 || viewHolder.getAdapterPosition()+1==28)
                {
                    Log.e("my day ",""+(viewHolder.getAdapterPosition()+1));
                    Intent intent = new Intent(context, RestDayActivity.class);
//                    intent.putExtras(bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else
                {
                    Log.e("my day ",""+(viewHolder.getAdapterPosition()+1));
                    Bundle bundle  = new Bundle();
                    bundle.putInt("day",viewHolder.getAdapterPosition()+1);
                    Intent intent = new Intent(context,ExcerciseActivity.class);
                    intent.putExtras(bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return homes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv1;
        private TextView tv_progress1;
        private ProgressBar progressBar1;
        private LinearLayout ll1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.text1);
            tv_progress1 = itemView.findViewById(R.id.percent1);
            progressBar1 = itemView.findViewById(R.id.seek1);
            ll1 = itemView.findViewById(R.id.linear1);
        }
    }
}
