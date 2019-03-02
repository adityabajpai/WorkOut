package com.android.workout.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.workout.R;
import com.android.workout.fragments.DailyMeal;
import com.android.workout.model.MealsItemObject;

import java.util.List;

public class MealsAdapter extends Adapter<MealsAdapter.MealsRecyclerViewHolders> {
    private Context context;
    private List<MealsItemObject> itemList;
    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor prefsEditor = this.mSharedPreferences.edit();

    class MealsRecyclerViewHolders extends ViewHolder implements View.OnClickListener{
        public CardView cardview1;
        public TextView countryName;
        final MealsAdapter mealsAdapter;

        public MealsRecyclerViewHolders(MealsAdapter mealsAdapter, View view) {
            super(view);
            this.mealsAdapter = mealsAdapter;
            view.setOnClickListener(this);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
//            layoutParams.setMargins(5, 5, 5, 5);
//            weight = 1.0f;
            this.cardview1 = view.findViewById(R.id.cardviewone);
            this.cardview1.setLayoutParams(layoutParams);
            this.countryName = view.findViewById(R.id.row_day);
        }
        public void onClick(View view) {
            Fragment dailyMeal = new DailyMeal();
            Bundle bundle = new Bundle();
            bundle.putInt("DAY", getAdapterPosition() + 1);
            dailyMeal.setArguments(bundle);
            FragmentTransaction beginTransaction = ((AppCompatActivity) this.mealsAdapter.context).getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.meals_content_fragment, dailyMeal);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
        }
    }
    public MealsAdapter(Context context, List<MealsItemObject> list) {
        this.itemList = list;
        this.context = context;
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public int getItemCount() {
        return this.itemList.size();
    }

    public void onBindViewHolder(MealsRecyclerViewHolders mealsRecyclerViewHolders, int i) {

        mealsRecyclerViewHolders.countryName.setText(this.itemList.get(i).getName());
        i++;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DAY_");
        stringBuilder.append(i);
        stringBuilder.append("_CHECKED");
        if (Boolean.valueOf(this.mSharedPreferences.getBoolean(stringBuilder.toString(), false)).booleanValue()) {
            mealsRecyclerViewHolders.cardview1.setCardBackgroundColor(this.context.getResources().getColor(R.color.colorAccent));
            mealsRecyclerViewHolders.countryName.setTextColor(this.context.getResources().getColor(R.color.white));
        }
    }

    public MealsRecyclerViewHolders onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MealsRecyclerViewHolders(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.meals_days_row, null));
    }

}
