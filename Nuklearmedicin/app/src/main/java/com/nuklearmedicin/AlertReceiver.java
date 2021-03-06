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

        String title="", ticker="", content="";
        int rest = 0;
        Bundle extra = intent.getExtras();

        if(extra.getInt("rest") == 1){
            title = "Restriktion 1 har nu löpt ut";
            ticker = "Alert!";
            content = "";
            rest = 1;
        } else if(extra.getInt("rest") == 2){
            title = "Restriktion 2 har nu löpt ut";
            ticker = "Alert!";
            content = "";
            rest = 2;
        } else if(extra.getInt("rest") == 3){
            title = "Restriktion 3 har nu löpt ut";
            ticker = "Alert!";
            content = "";
            rest = 3;
        } else if(extra.getInt("rest") == 4){
            title = "Restriktion 4 har nu löpt ut";
            ticker = "Alert!";
            content = "";
            rest = 4;
        } else if(extra.getInt("rest") == 5){
            title = "Restriktion 5 har nu löpt ut";
            ticker = "Alert!";
            content = "";
            rest = 5;
        } else if(extra.getInt("rest") == 6){
            title = "Restriktion 6 har nu löpt ut";
            ticker = "Alert!";
            content = "";
            rest = 6;
        } else {
            title = "Unknown alert";
            ticker = "Alert!";
            content = extra.getString("rest");
        }

        createNotification(context, title, ticker, content, rest);
    }

    public void createNotification(Context context, String title, String ticker, String content, int rest) {
        PendingIntent rest1Intent = PendingIntent.getActivity(context, rest, new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder rest1Builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle(title)
                .setTicker(ticker)
                .setContentText(content);

        rest1Builder.setContentIntent(rest1Intent);
        rest1Builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);
        rest1Builder.setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(rest, rest1Builder.build());

    }
}
