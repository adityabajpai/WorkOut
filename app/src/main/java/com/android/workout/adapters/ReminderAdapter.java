package com.android.workout.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.workout.R;
import com.android.workout.model.Reminder_custom;
import com.android.workout.receiver.AlarmHelper;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ProductViewHolder> {

    SimpleDateFormat f5148a;
    private AlarmHelper alarmHelper;
    private Gson gson;
    private Context mCtx;
    private long mLastClickTime = 0;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor prefsEditor;
    private List<Reminder_custom> productList;
    private Reminder_custom reminderproduct;

    class C10427 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ReminderAdapter f3351a;

        C10427(ReminderAdapter reminderAdapter) {
            this.f3351a = reminderAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    class ProductViewHolder extends ViewHolder {
        /* renamed from: a */
        TextView f5137a;
        /* renamed from: b */
        TextView f5138b;
        /* renamed from: c */
        TextView f5139c;
        /* renamed from: d */
        TextView f5140d;
        /* renamed from: e */
        TextView f5141e;
        /* renamed from: f */
        TextView f5142f;
        /* renamed from: g */
        TextView f5143g;
        /* renamed from: h */
        TextView f5144h;
        /* renamed from: i */
        ImageView f5145i;
        /* renamed from: j */
        Switch f5146j;
        /* renamed from: k */
        final /* synthetic */ ReminderAdapter f5147k;

        public ProductViewHolder(ReminderAdapter reminderAdapter, View view) {
            super(view);
            this.f5147k = reminderAdapter;
            this.f5137a = view.findViewById(R.id.time);
            this.f5138b = view.findViewById(R.id.day1);
            this.f5139c = view.findViewById(R.id.day2);
            this.f5140d = view.findViewById(R.id.day3);
            this.f5141e = view.findViewById(R.id.day4);
            this.f5142f = view.findViewById(R.id.day5);
            this.f5143g = view.findViewById(R.id.day6);
            this.f5144h = view.findViewById(R.id.day7);
            this.f5145i = view.findViewById(R.id.timedelete);
            this.f5146j = view.findViewById(R.id.timeswitch);
        }
    }
    public ReminderAdapter(Context context, List<Reminder_custom> list, Gson gson, SharedPreferences sharedPreferences, SharedPreferences.Editor editor, AlarmHelper alarmHelper) {
        this.mCtx = context;
        this.productList = list;
        this.mSharedPreferences = sharedPreferences;
        this.prefsEditor = editor;
        this.gson = gson;
        this.alarmHelper = alarmHelper;
    }

    private void showTimePickerDialog(final Reminder_custom reminder_custom, final int i) {
        Calendar instance = Calendar.getInstance();
        new TimePickerDialog(this.mCtx, new TimePickerDialog.OnTimeSetListener() {
            /* renamed from: c */

            public void onTimeSet(TimePicker timePicker, int i, int i2) {
                if (timePicker.isShown()) {
                    Calendar instance = Calendar.getInstance();
                    instance.set(11, i);
                    instance.set(12, i2);
                    showDialog(instance, reminder_custom, i);
                }
            }
        }, instance.get(11), instance.get(12), false).show();
    }

    public SimpleDateFormat getHourFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh");
        this.f5148a = simpleDateFormat;
        return simpleDateFormat;
    }

    public int getItemCount() {
        return this.productList.size();
    }

    public SimpleDateFormat getMinuteFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");
        this.f5148a = simpleDateFormat;
        return simpleDateFormat;
    }

    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(final ProductViewHolder productViewHolder, int i) {
        this.reminderproduct = this.productList.get(i);
        productViewHolder.f5137a.setText(this.reminderproduct.gettime());
        productViewHolder.f5137a.setOnClickListener(new View.OnClickListener() {
            /* renamed from: b */

            public void onClick(View view) {
                reminderproduct = productList.get(productViewHolder.getAdapterPosition());
                showTimePickerDialog(reminderproduct, productViewHolder.getAdapterPosition());
            }
        });
        productViewHolder.f5138b.setVisibility(0);
        productViewHolder.f5139c.setVisibility(0);
        productViewHolder.f5140d.setVisibility(0);
        productViewHolder.f5141e.setVisibility(0);
        productViewHolder.f5142f.setVisibility(0);
        productViewHolder.f5143g.setVisibility(0);
        productViewHolder.f5144h.setVisibility(0);
        if (this.reminderproduct.getMon()) {
            productViewHolder.f5138b.setText(R.string.mon);
        } else {
            productViewHolder.f5138b.setVisibility(8);
        }
        if (this.reminderproduct.getTue()) {
            productViewHolder.f5139c.setText(R.string.tu);
        } else {
            productViewHolder.f5139c.setVisibility(8);
        }
        if (this.reminderproduct.getWen()) {
            productViewHolder.f5140d.setText(R.string.wed);
        } else {
            productViewHolder.f5140d.setVisibility(8);
        }
        if (this.reminderproduct.getThr()) {
            productViewHolder.f5141e.setText(R.string.thri);
        } else {
            productViewHolder.f5141e.setVisibility(8);
        }
        if (this.reminderproduct.getFri()) {
            productViewHolder.f5142f.setText(R.string.fri);
        } else {
            productViewHolder.f5142f.setVisibility(8);
        }
        if (this.reminderproduct.getSat()) {
            productViewHolder.f5143g.setText(R.string.sat);
        } else {
            productViewHolder.f5143g.setVisibility(8);
        }
        if (this.reminderproduct.getSun()) {
            productViewHolder.f5144h.setText(R.string.sun);
        } else {
            productViewHolder.f5144h.setVisibility(8);
        }
        productViewHolder.f5146j.setChecked(this.reminderproduct.getOnoff());
        productViewHolder.f5146j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* renamed from: b */
            

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                reminderproduct = productList.get(productViewHolder.getAdapterPosition());
                reminderproduct.setOnoff(z);
                String toJson = gson.toJson(productList);
                prefsEditor = mSharedPreferences.edit();
                prefsEditor.putString("Reminder_customObjectList", toJson);
                prefsEditor.apply();
            }
        });
        productViewHolder.f5145i.setOnClickListener(new View.OnClickListener() {
            /* renamed from: b */

            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - mLastClickTime >= 1000) {
                    mLastClickTime = SystemClock.elapsedRealtime();
                    removeAt(productViewHolder.getAdapterPosition());
                }
            }
        });
    }
    public SimpleDateFormat startTimeFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
        this.f5148a = simpleDateFormat;
        return simpleDateFormat;
    }

    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ProductViewHolder(this, LayoutInflater.from(this.mCtx).inflate(R.layout.layout_remindercustom_row, null));
    }

    public void removeAt(int i) {
        this.productList.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, this.productList.size());
        String toJson = this.gson.toJson(this.productList);
        this.prefsEditor = this.mSharedPreferences.edit();
        this.prefsEditor.putString("Reminder_customObjectList", toJson);
        this.prefsEditor.apply();
    }

    public void showDialog(Calendar calendar, Reminder_custom reminder_custom, int i) {
        Builder builder = new Builder(this.mCtx);
        builder.setTitle("Days");
        final ArrayList arrayList = new ArrayList();
        builder.setMultiChoiceItems(this.mCtx.getResources().getStringArray(R.array.day_list), null, new DialogInterface.OnMultiChoiceClickListener() {
            /* renamed from: b */

            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                if (z) {
                    arrayList.add(Integer.valueOf(i));
                    return;
                }
                arrayList.remove(Integer.valueOf(i));
            }
        });
        final Reminder_custom reminder_custom2 = reminder_custom;
        final Calendar calendar2 = calendar;
        final int i2 = i;
        builder.setPositiveButton(this.mCtx.getString(R.string.yes), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {
                if (arrayList.size() > 0) {
                    dialogInterface.dismiss();
                    reminder_custom2.settime(startTimeFormat().format(calendar2.getTime()));
                    reminder_custom2.setMon(false);
                    reminder_custom2.setTue(false);
                    reminder_custom2.setWen(false);
                    reminder_custom2.setThr(false);
                    reminder_custom2.setFri(false);
                    reminder_custom2.setSat(false);
                    reminder_custom2.setSun(false);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (arrayList.get(i2).equals(Integer.valueOf(0))) {
                            reminder_custom2.setMon(true);
                        } else if (arrayList.get(i2).equals(Integer.valueOf(1))) {
                            reminder_custom2.setTue(true);
                        } else if (arrayList.get(i2).equals(Integer.valueOf(2))) {
                            reminder_custom2.setWen(true);
                        } else if (arrayList.get(i2).equals(Integer.valueOf(3))) {
                            reminder_custom2.setThr(true);
                        } else if (arrayList.get(i2).equals(Integer.valueOf(4))) {
                            reminder_custom2.setFri(true);
                        } else if (arrayList.get(i2).equals(Integer.valueOf(5))) {
                            reminder_custom2.setSat(true);
                        } else if (arrayList.get(i2).equals(Integer.valueOf(6))) {
                            reminder_custom2.setSun(true);
                        }
                    }
                    reminder_custom2.setOnoff(true);
                    m4157a(alarmHelper, calendar2);
                    String toJson = gson.toJson(productList);
                    prefsEditor = mSharedPreferences.edit();
                    prefsEditor.putString("Reminder_customObjectList", toJson);
                    prefsEditor.apply();
                    notifyItemChanged(i2);
                    notifyItemRangeChanged(i2, productList.size());
                    return;
                }
                Toast.makeText(mCtx, "Please select at-least one day", 0).show();
            }
        });
        builder.setNegativeButton(this.mCtx.getString(R.string.no), new C10427(this));
        builder.create().show();
    }
    void m4157a(AlarmHelper paramAlarmHelper, Calendar paramCalendar)
    {
        int i=0;
        int j=0;
        if (startTimeFormat().format(paramCalendar.getTime()).endsWith("AM"))
        {
            i = Integer.parseInt(getHourFormat().format(paramCalendar.getTime()));
            j = Integer.parseInt(getMinuteFormat().format(paramCalendar.getTime()));
        }
        for (int k = 0;; k = 1)
        {
            paramAlarmHelper.schedulePendingIntent(i, j, k);
            i = Integer.parseInt(getHourFormat().format(paramCalendar.getTime()));
            j = Integer.parseInt(getMinuteFormat().format(paramCalendar.getTime()));
        }
    }
}
