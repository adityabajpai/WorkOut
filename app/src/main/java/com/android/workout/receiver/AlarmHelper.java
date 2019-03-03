package com.android.workout.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import java.util.Calendar;

public class AlarmHelper {
    private static final String PREFERENCE_LAST_REQUEST_CODE = "PREFERENCE_LAST_REQUEST_CODE";
    private static final String TAG = "AlarmMainActivity";
    private AlarmManager alarmManager;
    private Context context;
    private SharedPreferences sharedPreferences;

    public AlarmHelper(Context context) {
        this.context = context;
        this.alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    private int getNextRequestCode() {
        int i = this.sharedPreferences.getInt(PREFERENCE_LAST_REQUEST_CODE, 0) + 1;
        if (i == Integer.MAX_VALUE) {
            i = 0;
        }
        this.sharedPreferences.edit().putInt(PREFERENCE_LAST_REQUEST_CODE, i).apply();
        return i;
    }

    private PendingIntent getPendingIntent() {
        Intent intent = new Intent("com.android.workout.reciever.NOTIFY_ACTION");
        intent.setClass(this.context, NotificationPublisher.class);
        intent.setFlags(ErrorDialogData.BINDER_CRASH);
        return PendingIntent.getBroadcast(this.context, getNextRequestCode(), intent, 134217728);
    }

    private void setBootReceiverEnabled(int i) {
        Log.d(TAG, "setBootReceiverEnabled: ");
        this.context.getPackageManager().setComponentEnabledSetting(new ComponentName(this.context, BootReceiver.class), i, 1);
    }

    public PendingIntent existAlarm(int i) {
        Intent intent = new Intent("com.android.workout.reciever.NOTIFY_ACTION");
        intent.setClass(this.context, NotificationPublisher.class);
        return PendingIntent.getBroadcast(this.context, i, intent, ErrorDialogData.DYNAMITE_CRASH);
    }

    public boolean isAlarmScheduled(int i) {
        Intent intent = new Intent("com.android.workout.reciever.NOTIFY_ACTION");
        intent.setClass(this.context, NotificationPublisher.class);
        return PendingIntent.getBroadcast(this.context, i, intent, ErrorDialogData.DYNAMITE_CRASH) != null;
    }

    public void schedulePendingIntent(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, i);
        instance.set(12, i2);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.set(9, i3);
        schedulePendingIntent(instance.getTimeInMillis(), getPendingIntent());
    }

    public void schedulePendingIntent(int i, int i2, int i3, long j) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, i);
        instance.set(12, i2);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.set(9, i3);
        schedulePendingIntent(instance.getTimeInMillis(), getPendingIntent(), j);
    }

    public void schedulePendingIntent(long j, PendingIntent pendingIntent) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("schedulePendingIntent: ");
        stringBuilder.append(j);
        stringBuilder.append("/");
        stringBuilder.append(pendingIntent);
        Log.d(str, stringBuilder.toString());
        if (VERSION.SDK_INT >= 23) {
            this.alarmManager.setExactAndAllowWhileIdle(0, j, pendingIntent);
        } else if (VERSION.SDK_INT >= 19) {
            this.alarmManager.setExact(0, j, pendingIntent);
        } else {
            this.alarmManager.set(0, j, pendingIntent);
        }
        setBootReceiverEnabled(1);
    }

    public void schedulePendingIntent(long j, PendingIntent pendingIntent, long j2) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("schedulePendingIntent: ");
        stringBuilder.append(j);
        stringBuilder.append("/");
        stringBuilder.append(pendingIntent);
        Log.d(str, stringBuilder.toString());
        if (VERSION.SDK_INT >= 23) {
            this.alarmManager.setExactAndAllowWhileIdle(0, j + j2, pendingIntent);
        } else if (VERSION.SDK_INT >= 19) {
            this.alarmManager.setExact(0, j + j2, pendingIntent);
        } else {
            this.alarmManager.set(0, j + j2, pendingIntent);
        }
        setBootReceiverEnabled(1);
    }

    public void unschedulePendingIntent() {
        PendingIntent pendingIntent = getPendingIntent();
        pendingIntent.cancel();
        this.alarmManager.cancel(pendingIntent);
    }
}

