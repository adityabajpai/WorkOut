package com.android.workout.receiver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.internal.view.SupportMenu;
import android.util.Log;

import com.android.workout.R;
import com.android.workout.activities.HomeActivity;
import com.android.workout.model.Reminder_custom;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class NotificationPublisher extends BroadcastReceiver {
    private static final String PREFERENCE_LAST_NOTIF_ID = "PREFERENCE_LAST_NOTIF_ID";
    /* renamed from: a */
    static final /* synthetic */ boolean f3360a = true;
    private String TAG = "NotificationPublisher";
    private AlarmHelper alarmHelper;
    private Context context;
    private SharedPreferences sharedPreferences;
    private SimpleDateFormat startTimeFormat;


    class C15111 extends TypeToken<List<Reminder_custom>> {

        final NotificationPublisher f5150d;

        C15111(NotificationPublisher notificationPublisher) {
            this.f5150d = notificationPublisher;
        }
    }

    private int getNextNotifId() {
        int i = this.sharedPreferences.getInt(PREFERENCE_LAST_NOTIF_ID, 0) + 1;
        if (i == Integer.MAX_VALUE) {
            i = 0;
        }
        this.sharedPreferences.edit().putInt(PREFERENCE_LAST_NOTIF_ID, i).apply();
        return i;
    }

    private void startNotification(Context context) {
        PendingIntent existAlarm = this.alarmHelper.existAlarm(this.sharedPreferences.getInt(PREFERENCE_LAST_NOTIF_ID, 0));
        if (existAlarm != null) {
            existAlarm.cancel();
        }
        if (VERSION.SDK_INT < 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Intent intent = new Intent(context, HomeActivity.class);
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(ErrorDialogData.BINDER_CRASH);
            Notification build = new Builder(context).setContentIntent(PendingIntent.getActivity(context, getNextNotifId(), intent, 0))
                    .setAutoCancel(true).setWhen(System.currentTimeMillis()).setSmallIcon(R.drawable.icon_notification)
                    .setContentTitle("Hey! it's Workout time").setContentText("Let's lose some weight today.").setDefaults(1).build();
            if (f3360a || notificationManager != null) {
                notificationManager.notify(getNextNotifId(), build);
                return;
            }
            throw new AssertionError();
        }
        Intent intent2 = new Intent(context, HomeActivity.class);
        intent2.setAction("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.addFlags(ErrorDialogData.BINDER_CRASH);
        NotificationManager notificationManager2 = (NotificationManager) context.getSystemService("notification");
        String str = "my_channel_id_01";
        NotificationChannel notificationChannel = new NotificationChannel(str, "My Notifications", 4);
        notificationChannel.setDescription("Channel description");
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
        notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
        notificationChannel.enableVibration(true);
        if (f3360a || notificationManager2 != null) {
            notificationManager2.createNotificationChannel(notificationChannel);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, str);
            builder.setAutoCancel(true).setContentIntent(PendingIntent.getActivity(context, getNextNotifId(), intent2, 0))
                    .setDefaults(-1).setAutoCancel(true).setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.drawable.icon_notification).setContentTitle("Hey! it's Workout time")
                    .setContentText("Let's lose some weight today.").setDefaults(1);
            notificationManager2.notify(getNextNotifId(), builder.build());
            return;
        }
        throw new AssertionError();
    }

    void m2551a(AlarmHelper alarmHelper, Calendar calendar) {
        int parseInt;
        int parseInt2;
        int i;
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setTimeHrAndMin   ");
        stringBuilder.append(startTimeFormat().format(calendar.getTime()));
        Log.d(str, stringBuilder.toString());
        if (startTimeFormat().format(calendar.getTime()).equalsIgnoreCase("AM")) {
            parseInt = Integer.parseInt(getHourFormat().format(calendar.getTime()));
            parseInt2 = Integer.parseInt(getMinuteFormat().format(calendar.getTime()));
            i = 0;
        } else if (startTimeFormat().format(calendar.getTime()).equalsIgnoreCase("PM")) {
            parseInt = Integer.parseInt(getHourFormat().format(calendar.getTime()));
            parseInt2 = Integer.parseInt(getMinuteFormat().format(calendar.getTime()));
            i = 1;
        } else {
            return;
        }
        alarmHelper.schedulePendingIntent(parseInt, parseInt2, i, 86400000);
    }

    public SimpleDateFormat getHourFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh", Locale.ENGLISH);
        this.startTimeFormat = simpleDateFormat;
        return simpleDateFormat;
    }

    public SimpleDateFormat getMinuteFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm", Locale.ENGLISH);
        this.startTimeFormat = simpleDateFormat;
        return simpleDateFormat;
    }

    public void onReceive(Context context, Intent intent) {
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onReceive1 ==========");
        stringBuilder.append(intent.getAction());
        Log.d(str, stringBuilder.toString());
        this.context = context;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        List list = (List) new Gson().fromJson(this.sharedPreferences.getString("Reminder_customObjectList", null), new C15111(this).getType());
        Calendar instance = Calendar.getInstance();
        instance.get(Calendar.HOUR_OF_DAY);
        instance.get(Calendar.MINUTE);
        int i = instance.get(Calendar.DAY_OF_WEEK);
        if (list != null && list.size() > 0) {
            this.alarmHelper = new AlarmHelper(context);
            int i2 = 0;
            while (i2 < list.size()) {
                if (((Reminder_custom) list.get(i2)).gettime().equals(startTimeFormat().format(instance.getTime())) && ((Reminder_custom) list.get(i2)).getOnoff()) {
                    if (!(((Reminder_custom) list.get(i2)).getSun() && i == 1)) {
                        if (!((Reminder_custom) list.get(i2)).getMon() || i != 2) {
                            if (!((Reminder_custom) list.get(i2)).getTue() || i != 3) {
                                if (!((Reminder_custom) list.get(i2)).getWen() || i != 4) {
                                    if (!((Reminder_custom) list.get(i2)).getThr() || i != 5) {
                                        if (!((Reminder_custom) list.get(i2)).getFri() || i != 6) {
                                            if (((Reminder_custom) list.get(i2)).getSat() && i == 7) {
                                            }
                                            m2551a(this.alarmHelper, instance);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    startNotification(context);
                    m2551a(this.alarmHelper, instance);
                }
                i2++;
            }
            String action = intent.getAction();
            action.getClass();
            if (action.equals("android.intent.action.TIME_SET")) {
                int i3 = 0;
                while (i3 < list.size()) {
                    String str2 = this.TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("onReceive: +++++++++++++");
                    stringBuilder.append(((Reminder_custom) list.get(i3)).gettime());
                    Log.d(str2, stringBuilder.toString());
                    if (!(((Reminder_custom) list.get(i3)).gettime().toUpperCase().endsWith("AM") || ((Reminder_custom) list.get(i3)).gettime().toLowerCase().endsWith("am") || ((Reminder_custom) list.get(i3)).gettime().toUpperCase().endsWith("a.m."))) {
                        if (!((Reminder_custom) list.get(i3)).gettime().toLowerCase().endsWith("a.m.")) {
                            if (((Reminder_custom) list.get(i3)).gettime().toUpperCase().endsWith("PM") || ((Reminder_custom) list.get(i3)).gettime().toUpperCase().endsWith("pm") || ((Reminder_custom) list.get(i3)).gettime().toUpperCase().endsWith("p.m.") || ((Reminder_custom) list.get(i3)).gettime().toLowerCase().endsWith("p.m.")) {
                                this.alarmHelper.schedulePendingIntent(Integer.parseInt(((Reminder_custom) list.get(i3)).gettime().substring(0, 2)), Integer.parseInt(((Reminder_custom) list.get(i3)).gettime().substring(3, 5)), 1);
                                i3++;
                            } else {
                                i3++;
                            }
                        }
                    }
                    this.alarmHelper.schedulePendingIntent(Integer.parseInt(((Reminder_custom) list.get(i3)).gettime().substring(0, 2)), Integer.parseInt(((Reminder_custom) list.get(i3)).gettime().substring(3, 5)), 0);
                    i3++;
                }
            }
        }
    }

    public SimpleDateFormat startTimeFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
        this.startTimeFormat = simpleDateFormat;
        return simpleDateFormat;
    }
}
