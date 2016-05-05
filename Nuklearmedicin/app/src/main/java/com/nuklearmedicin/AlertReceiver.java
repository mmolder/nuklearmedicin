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
            title = "Rest1";
            ticker = "Alert!";
            content = "Du får nu vara....";
            rest = 1;
        } else if(extra.getInt("rest") == 2){
            title = "Rest2";
            ticker = "Alert!";
            content = "Sluta upp med...";
            rest = 2;
        } else if(extra.getInt("rest") == 3){
            title = "Rest3";
            ticker = "Alert!";
            content = "Hjääälp!!!!";
            rest = 3;
        } else if(extra.getInt("rest") == 4){
            title = "Rest4";
            ticker = "Alert!";
            content = "Lägg ner!";
            rest = 4;
        } else if(extra.getInt("rest") == 5){
            title = "Rest5";
            ticker = "Alert!";
            content = "Res på!";
            rest = 5;
        } else if(extra.getInt("rest") == 6){
            title = "Rest6";
            ticker = "Alert!";
            content = "Toalett";
            rest = 6;
        } else {
            title = "Ingen av dem";
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
