package com.android.workout.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.workout.R;
import com.android.workout.activities.ExcerciseActivity;
import com.android.workout.model.Home;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context = null;
    private List<Home> homes = null;

    public HomeAdapter(Context context, List<Home> homes) {
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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Home home =homes.get(viewHolder.getAdapterPosition());
        viewHolder.tv1.setText(home.getDay1());
        viewHolder.tv2.setText(home.getDay2());
        viewHolder.tv3.setText(home.getDay3());
        viewHolder.tv_progress1.setText(home.getProgress1());
        viewHolder.tv_progress2.setText(home.getProgress2());
        viewHolder.tv_progress3.setText(home.getProgress3());
        viewHolder.progressBar1.setProgress(Integer.parseInt(home.getProgress1()));
        viewHolder.progressBar2.setProgress(Integer.parseInt(home.getProgress2()));
        viewHolder.progressBar3.setProgress(Integer.parseInt(home.getProgress3()));
        viewHolder.ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ExcerciseActivity.class));
            }
        });
        viewHolder.ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ExcerciseActivity.class));
            }
        });
        viewHolder.ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ExcerciseActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return homes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv1, tv2, tv3;
        private TextView tv_progress1, tv_progress2, tv_progress3;
        private ProgressBar progressBar1, progressBar2, progressBar3;
        private LinearLayout ll1,ll2, ll3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.text1);
            tv2 = itemView.findViewById(R.id.text2);
            tv3 = itemView.findViewById(R.id.text3);
            tv_progress1 = itemView.findViewById(R.id.percent1);
            tv_progress2 = itemView.findViewById(R.id.percent2);
            tv_progress3 = itemView.findViewById(R.id.percent3);
            progressBar1 = itemView.findViewById(R.id.seek1);
            progressBar2 = itemView.findViewById(R.id.seek2);
            progressBar3 = itemView.findViewById(R.id.seek3);
            ll1 = itemView.findViewById(R.id.linear1);
            ll2 = itemView.findViewById(R.id.linear2);
            ll3 = itemView.findViewById(R.id.linear3);
        }
    }
}
