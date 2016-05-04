package com.nuklearmedicin;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Mikael on 2016-05-04.
 */
public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String title, ticker, content;

        title = "Rest1";
        ticker = "Alert!";
        content = "Du får nu vara....";

        createNotification(context, title, ticker, content);
    }

    public void createNotification(Context context, String title, String ticker, String content) {
        PendingIntent rest1Intent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder rest1Builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle(title)
                .setTicker(ticker)
                .setContentText(content);

        rest1Builder.setContentIntent(rest1Intent);
        rest1Builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);
        rest1Builder.setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, rest1Builder.build());

    }
}
