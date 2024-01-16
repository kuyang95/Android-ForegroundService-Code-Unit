/*
 * Copyright (C) 2021. Rivo. All rights reserved.
 *
 * Created by Pang on 2021/4/19
 */

package com.example.foregroundservicecodeunit;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

public class ForegroundNotification {

    final int FOREGROUND_NOTIFICATION_ID = 101;
    private static final String FOREGROUND_NOTIFICATION_CHANNEL_ID = "foregroundService";

    private final NotificationManager mNM;
    private NotificationCompat.Builder mBuilder;

    public ForegroundNotification(@NonNull Context context) {
        mNM = (NotificationManager) context.getSystemService(Service.NOTIFICATION_SERVICE);
    }

    public Notification buildForegroundNotification(Context context) {
            mBuilder = createNotification(context);
          //  service.startForeground(FOREGROUND_NOTIFICATION_ID, mBuilder.build());
        return mBuilder.build();
    }

    public void stopForegroundService(@NonNull Service service) {
            mNM.cancel(FOREGROUND_NOTIFICATION_ID);
            service.stopForeground(true);

            mBuilder = null;

    }

    private NotificationCompat.Builder createNotification(@NonNull Context context) {

        Intent intent = new Intent(context, MainActivity.class);
        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            flags |= PendingIntent.FLAG_IMMUTABLE;
        }
        PendingIntent pi = PendingIntent.getActivity(context, 0, intent, flags);

        Resources r = context.getResources();

        String channelId = FOREGROUND_NOTIFICATION_CHANNEL_ID;
        NotificationCompat.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    r.getString(R.string.app_name),
                    NotificationManager.IMPORTANCE_LOW);
            channel.setShowBadge(false);
            mNM.createNotificationChannel(channel);
            builder = new NotificationCompat.Builder(context, channelId);
        } else {
            builder = new NotificationCompat.Builder(context, channelId)
                    .setPriority(Notification.PRIORITY_LOW);
        }

        int iconId = R.mipmap.ic_launcher_round;
        builder.setTicker(r.getString(R.string.app_name))
                .setSmallIcon(iconId)
                .setContentTitle(r.getString(R.string.app_name))
                .setContentText("Test")
                .setAutoCancel(false)
                .setOngoing(true)
                .setContentIntent(pi)
                .setShowWhen(false);

        return builder;
    }
}
