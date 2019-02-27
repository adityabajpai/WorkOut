package com.android.workout.adapters;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
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
import com.android.workout.database.DatabaseOperations;
import com.android.workout.model.Home;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context = null;
    private List<WorkoutData> homes = null;

    public HomeAdapter(Context context, List<WorkoutData> homes) {
        this.context = context;
        this.homes = homes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        WorkoutData home =homes.get(viewHolder.getAdapterPosition());
        viewHolder.tv1.setText(home.getDay());
        viewHolder.tv_progress1.setText(((int)home.getProgress())+"%");
        viewHolder.progressBar1.setProgress((int)home.getProgress());
        viewHolder.ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("my day ",""+(viewHolder.getAdapterPosition()+1));
                Bundle bundle  = new Bundle();
                bundle.putInt("day",viewHolder.getAdapterPosition()+1);
                Intent intent = new Intent(context,ExcerciseActivity.class);
                intent.putExtras(bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
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
