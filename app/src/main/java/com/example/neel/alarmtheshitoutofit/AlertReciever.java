package com.example.neel.alarmtheshitoutofit;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by neel on 14/05/2016.
 */
public class AlertReciever extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {

        createNotification(context,"Times up","5 Seconds has Passed","Alert");
    }

    public void createNotification(Context context,String msg,String msgTxt,String mss){

        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,new Intent(context,MainActivity.class),0);


        NotificationCompat.Builder builder= new NotificationCompat.Builder(context)
                .setContentTitle(msg)
                .setTicker(msgTxt)
                .setSmallIcon(R.drawable.warning)
                .setContentText(mss);


        builder.setContentIntent(pendingIntent);
        builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        builder.setAutoCancel(true);

        NotificationManager manager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1,builder.build());
    }

}
