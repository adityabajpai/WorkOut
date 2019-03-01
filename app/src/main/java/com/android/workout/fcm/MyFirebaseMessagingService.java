package com.android.workout.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;

import com.android.workout.activities.HomeActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import com.android.workout.R;
import com.android.workout.utils.Constants;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "Weightlossformen";

    private void sendNotification(String str, String str2, String str3, String str4) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(Constants.APP_PACKAGE_NAME, str);
        intent.putExtra(Constants.APP_BANNER_URL, str2);
        intent.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 1073741824);
        String string = getString(R.string.default_notification_channel_id);
        Builder contentIntent = new Builder(this, string).setSmallIcon(R.drawable.icon_notification).setContentTitle(str4).setContentText(str3).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(activity);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(string, "Channel human readable title", 3));
        }
        notificationManager.notify(0, contentIntent.build());
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("From: ");
        stringBuilder.append(remoteMessage.getFrom());
        Log.d(str, stringBuilder.toString());
        String str2 = null;
        if (remoteMessage.getData().size() > 0) {
            str = TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Message data payload: ");
            stringBuilder2.append(remoteMessage.getData());
            Log.d(str, stringBuilder2.toString());
            Map data = remoteMessage.getData();
            if (data.containsKey(Constants.APP_PACKAGE_NAME)) {
                str2 = (String) data.get(Constants.APP_PACKAGE_NAME);
                str = (String) data.get(Constants.APP_BANNER_URL);
                if (remoteMessage.getNotification() != null) {
                    String str3 = TAG;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Message Notification Body: ");
                    stringBuilder3.append(remoteMessage.getNotification().getBody());
                    Log.d(str3, stringBuilder3.toString());
                }
                sendNotification(str2, str, remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle());
            }
        }
        str = null;
        if (remoteMessage.getNotification() != null) {
            String str32 = TAG;
            StringBuilder stringBuilder32 = new StringBuilder();
            stringBuilder32.append("Message Notification Body: ");
            stringBuilder32.append(remoteMessage.getNotification().getBody());
            Log.d(str32, stringBuilder32.toString());
        }
        sendNotification(str2, str, remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle());
    }
}
