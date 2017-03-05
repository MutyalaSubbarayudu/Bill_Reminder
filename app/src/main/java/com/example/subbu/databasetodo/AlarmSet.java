package com.example.subbu.databasetodo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Subbu on 01-03-2017.
 */




    public class AlarmSet extends BroadcastReceiver {





    @Override
        public void onReceive(Context context, Intent intent) {

        createNotify(context,"Reminder","check it out...!","alert");



    }
    public void createNotify(Context context, String msg, String msgText, String msgAlert){

        PendingIntent pi=PendingIntent.getActivity(context,0,new Intent(context,MyService.class),0);


        NotificationCompat.Builder nicene= (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.asset2hdpi)
                .setContentTitle(msg)
                .setContentText(msgText)
                .setTicker(msgAlert);

        nicene.setContentIntent(pi);


        nicene.setDefaults(NotificationCompat.DEFAULT_LIGHTS);

        nicene.setAutoCancel(true);

        NotificationManager nmNew=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        nmNew.notify(1,nicene.build());




    }





}



