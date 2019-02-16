package com.android.workout.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.android.workout.R;
import com.android.workout.model.Reminder;

import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ViewHolder> {

	private Context context = null;
	private List<Reminder> reminders= null;
	private Reminder reminder = null;

    public ReminderAdapter(Context context, List<Reminder> reminders) {
        this.context = context;
        this.reminders = reminders;
    }

    @NonNull
	@Override
	public ReminderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder_card,parent,false);
        return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        reminder = reminders.get(viewHolder.getAdapterPosition());
//        viewHolder.reminderTimeTV.setText();
	}

	@Override
	public int getItemCount() {
		return reminders.size();
	}


	public class ViewHolder extends RecyclerView.ViewHolder{
	    public TextView reminderTimeTV,repeatTV,repeatDaysTV;
	    public Switch onOff;
	    public ImageButton deleteBtn;
		public ViewHolder(View itemView) {
			super(itemView);
			reminderTimeTV = itemView.findViewById(R.id.reminder_time);
			repeatTV = itemView.findViewById(R.id.repeat_text);
			repeatDaysTV = itemView.findViewById(R.id.repeat_days);
			onOff = itemView.findViewById(R.id.on_off_switch);
			deleteBtn = itemView.findViewById(R.id.delete_reminder);
		}
	}
}
