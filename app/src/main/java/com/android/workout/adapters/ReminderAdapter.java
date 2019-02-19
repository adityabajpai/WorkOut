package com.android.workout.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.workout.R;
import com.android.workout.activities.ReminderActivity;
import com.android.workout.model.Reminder;

import java.util.List;

import static android.support.design.widget.BaseTransientBottomBar.BaseCallback.DISMISS_EVENT_TIMEOUT;
import static android.support.design.widget.Snackbar.Callback.DISMISS_EVENT_ACTION;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ViewHolder> {

	private Context context = null;
	private List<Reminder> reminders= null;

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
	public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Reminder reminder = reminders.get(viewHolder.getAdapterPosition());
//        int size = viewHolder.getAdapterPosition();
        viewHolder.reminderTimeTV.setText(reminder.getAlarmTime());
        viewHolder.repeatDaysTV.setText(reminder.getRepeatDays());
        viewHolder.onOff.setChecked(true);
        viewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				reminders.remove(viewHolder.getAdapterPosition());
				notifyDataSetChanged();
				Snackbar snack = Snackbar.make(v, "Deleted", 3000);
				snack.setAction("Undo", new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						reminders.add(viewHolder.getAdapterPosition(),reminder);
						notifyDataSetChanged();
					}
				});
				snack.setActionTextColor(Color.GREEN);

				snack.show();
			}
		});
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
