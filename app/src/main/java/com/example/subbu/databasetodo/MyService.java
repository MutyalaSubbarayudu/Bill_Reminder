package com.example.subbu.databasetodo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Calendar;

/**
 * Created by Subbu on 01-03-2017.
 */

public class MyService extends Service {

    Context context=this;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        System.out.println("finished fully");
        super.onDestroy();
    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }







    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO do something useful

        System.out.println("enter");
       Calendar cal = Calendar.getInstance();

        cal.set(2017,2,5,17,18,1);

        Long alert=cal.getTimeInMillis();

                    Intent alertI=new Intent(MyService.this,AlarmSet.class);



                    AlarmManager am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);

                    am.set(AlarmManager.RTC_WAKEUP,alert, PendingIntent.getBroadcast(MyService.this,1,alertI,PendingIntent.FLAG_UPDATE_CURRENT));

        System.out.println("finished");


//        PendingIntent service = PendingIntent.getService(
//                getApplicationContext(),
//                1001,
//                new Intent(getApplicationContext(), AlarmSet.class),
//                PendingIntent.FLAG_ONE_SHOT);
//
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 1000, service);

        return START_STICKY;
    }

//    @Override
//    public void onTaskRemoved(Intent rootIntent) {
//        super.onTaskRemoved(rootIntent);
//
//        Log.d(TAG, "TASK REMOVED");
//
//        PendingIntent service = PendingIntent.getService(
//                getApplicationContext(),
//                1001,
//                new Intent(getApplicationContext(), MyService.class),
//                PendingIntent.FLAG_ONE_SHOT);
//
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 1000, service);
//
//    }
//    private Thread.UncaughtExceptionHandler defaultUEH;
//
//    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {
//
//        @Override
//        public void uncaughtException(Thread thread, Throwable ex) {
//            Log.d(TAG, "Uncaught exception start!");
//            ex.printStackTrace();
//
//            //Same as done in onTaskRemoved()
//            PendingIntent service = PendingIntent.getService(
//                    getApplicationContext(),
//                    1001,
//                    new Intent(getApplicationContext(), MyService.class),
//                    PendingIntent.FLAG_ONE_SHOT);
//
//            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 1000, service);
//            System.exit(2);
//        }
//    };
}
