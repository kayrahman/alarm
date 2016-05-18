package com.example.neel.alarmtheshitoutofit;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {


    Button showNoti;
    NotificationManager notificationManager;

    boolean isNotificActive=false;
    int notifId=33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showNoti=(Button)findViewById(R.id.showNoti);





    }


    public void showNotification(View view){

        NotificationCompat.Builder builder= new NotificationCompat.Builder(this)
                .setContentTitle("Message")
                .setContentText("New Message")
                .setTicker("Alert Message")
                .setSmallIcon(R.drawable.warning)
                ;


        Intent moreIntent=new Intent(this,MoreInfo.class);
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MoreInfo.class);
        stackBuilder.addNextIntent(moreIntent);

        PendingIntent pendingIntent=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notifId,builder.build());

        isNotificActive=true;


    }

    public void showAlarm(View view) {
        Long alertTime=new GregorianCalendar().getTimeInMillis()+5*1000;
        Intent alertIntent=new Intent(this,AlertReciever.class);
        AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,alertTime,PendingIntent.getBroadcast(this,1,alertIntent,PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
