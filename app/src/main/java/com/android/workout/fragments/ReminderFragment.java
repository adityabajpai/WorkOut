package com.android.workout.fragments;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.app.AlertDialog.Builder;

import com.android.workout.R;
import com.android.workout.adapters.ReminderAdapter;
import com.android.workout.model.Reminder_custom;
import com.android.workout.receiver.AlarmHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReminderFragment extends Fragment {
    private static final String TAG = "ReminderFragment";
    /* renamed from: a */
    SimpleDateFormat f5544a;
    private AlarmHelper alarmHelper;
    private Gson gson;
    private ReminderAdapter mAdapter;
    private List<Reminder_custom> mReCu;
    private RecyclerView mRecyclerView;
    private SharedPreferences mSharedPreferences;
    private TextView noreminders;
    private SharedPreferences.Editor prefsEditor;

    class C10432 implements View.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ReminderFragment f3352a;

        C10432(ReminderFragment reminderFragment) {
            this.f3352a = reminderFragment;
        }

        public void onClick(View view) {
            this.f3352a.showTimePickerDialog();
        }
    }

    class C10443 implements TimePickerDialog.OnTimeSetListener {
        /* renamed from: a */
        final /* synthetic */ ReminderFragment f3353a;

        C10443(ReminderFragment reminderFragment) {
            this.f3353a = reminderFragment;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            if (timePicker.isShown()) {
                Calendar instance = Calendar.getInstance();
                instance.set(11, i);
                instance.set(12, i2);
                String str = ReminderFragment.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onTimeSet: ");
                stringBuilder.append(this.f3353a.startTimeFormat().format(instance.getTime()));
                Log.d(str, stringBuilder.toString());
                this.f3353a.showDialog(instance);
            }
        }
    }

    class C10476 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ReminderFragment f3359a;

        C10476(ReminderFragment reminderFragment) {
            this.f3359a = reminderFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    class C15101 extends TypeToken<List<Reminder_custom>> {
        /* renamed from: d */
        final /* synthetic */ ReminderFragment f5149d;

        C15101(ReminderFragment reminderFragment) {
            this.f5149d = reminderFragment;
        }
    }

    private void showTimePickerDialog() {
        Calendar instance = Calendar.getInstance();
        new TimePickerDialog(getActivity(), new C10443(this), instance.get(11), instance.get(12), false).show();
    }

    public SimpleDateFormat getHourFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh");
        this.f5544a = simpleDateFormat;
        return simpleDateFormat;
    }

    public SimpleDateFormat getMinuteFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");
        this.f5544a = simpleDateFormat;
        return simpleDateFormat;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_reminderfragment, viewGroup, false);
        inflate.setTag(TAG);
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.getNavigationIcon().mutate().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_IN);
        setHasOptionsMenu(true);
        this.alarmHelper = new AlarmHelper(getActivity());
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        this.mRecyclerView = (RecyclerView) inflate.findViewById(R.id.reminderlist);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.noreminders = (TextView) inflate.findViewById(R.id.noreminder);
        this.gson = new Gson();
        this.mReCu = (List) this.gson.fromJson(this.mSharedPreferences.getString("Reminder_customObjectList", null), new C15101(this).getType());
        if (this.mReCu == null || this.mReCu.size() <= 0) {
            this.mRecyclerView.setVisibility(8);
            this.noreminders.setVisibility(0);
        } else {
            this.mRecyclerView.setVisibility(0);
            this.mAdapter = new ReminderAdapter(getActivity(), this.mReCu, this.gson, this.mSharedPreferences, this.prefsEditor, this.alarmHelper);
            this.mRecyclerView.setAdapter(this.mAdapter);
            this.noreminders.setVisibility(8);
        }
        inflate.findViewById(R.id.addreminder).setOnClickListener(new C10432(this));
        return inflate;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void showDialog(final Calendar calendar) {
        Builder builder = new Builder(getActivity());
        builder.setTitle("Days");
        final ArrayList arrayList = new ArrayList();
        builder.setMultiChoiceItems(getResources().getStringArray(R.array.day_list), null, new DialogInterface.OnMultiChoiceClickListener() {
            /* renamed from: b */
            
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                if (z) {
                    arrayList.add(Integer.valueOf(i));
                    return;
                }
                if (arrayList.contains(Integer.valueOf(i))) {
                    arrayList.remove(Integer.valueOf(i));
                }
            }
        });
        builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
            /* renamed from: c */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (arrayList.size() > 0) {
                    dialogInterface.dismiss();
                    Reminder_custom reminder_custom = new Reminder_custom();
                    reminder_custom.settime(startTimeFormat().format(calendar.getTime()));
                    for (i = 0; i < arrayList.size(); i++) {
                        if (((Integer) arrayList.get(i)).equals(Integer.valueOf(0))) {
                            reminder_custom.setMon(true);
                        } else if (((Integer) arrayList.get(i)).equals(Integer.valueOf(1))) {
                            reminder_custom.setTue(true);
                        } else if (((Integer) arrayList.get(i)).equals(Integer.valueOf(2))) {
                            reminder_custom.setWen(true);
                        } else if (((Integer) arrayList.get(i)).equals(Integer.valueOf(3))) {
                            reminder_custom.setThr(true);
                        } else if (((Integer) arrayList.get(i)).equals(Integer.valueOf(4))) {
                            reminder_custom.setFri(true);
                        } else if (((Integer) arrayList.get(i)).equals(Integer.valueOf(5))) {
                            reminder_custom.setSat(true);
                        } else if (((Integer) arrayList.get(i)).equals(Integer.valueOf(6))) {
                            reminder_custom.setSun(true);
                        }
                    }
                    m4641a(alarmHelper, calendar);
                    reminder_custom.setOnoff(true);
                    if (mReCu == null || mReCu.size() <= 0) {
                        mReCu = new ArrayList();
                    }
                    mReCu.add(reminder_custom);
                    String toJson = gson.toJson(mReCu);
                    prefsEditor = mSharedPreferences.edit();
                    prefsEditor.putString("Reminder_customObjectList", toJson);
                    prefsEditor.apply();
                    mRecyclerView.setVisibility(0);
                    mAdapter = new ReminderAdapter(getActivity(), mReCu, gson, mSharedPreferences, prefsEditor, alarmHelper);
                    mRecyclerView.setAdapter(mAdapter);
                    noreminders.setVisibility(8);
                    return;
                }
                Toast.makeText(getActivity(), "Please select at-least one day", 0).show();
            }
        });
        builder.setNegativeButton(getString(R.string.no), new C10476(this));
        builder.create().show();
    }

    public SimpleDateFormat startTimeFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
        this.f5544a = simpleDateFormat;
        return simpleDateFormat;
    }

    void m4641a(AlarmHelper paramAlarmHelper, Calendar paramCalendar)
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
            i = Integer.parseInt(getHourFormat().format(paramCalendar.getTime()));
            j = Integer.parseInt(getMinuteFormat().format(paramCalendar.getTime()));
            paramAlarmHelper.schedulePendingIntent(i, j, k);
            break;
        }
    }
}
