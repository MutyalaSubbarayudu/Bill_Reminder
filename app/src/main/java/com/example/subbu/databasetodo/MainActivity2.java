package com.example.subbu.databasetodo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import static com.example.subbu.databasetodo.R.id.date;

public class MainActivity2 extends AppCompatActivity {



    private Context context;
    Button btnDatePicker, btnTimePicker,submit;
    EditText txtDate, txtTime,cashTxt;
    TextView name;
    int mYear, mMonth, mDay, mHour, mMinute;
    TextView txt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnDatePicker=(Button)findViewById(date);
        btnTimePicker=(Button)findViewById(R.id.time);
        txtDate=(EditText)findViewById(R.id.date_txt);
        txtTime=(EditText)findViewById(R.id.time_txt);
        cashTxt=(EditText)findViewById(R.id.cash_txt);
        submit=(Button)findViewById(R.id.submit);
        txt=(TextView)findViewById(R.id.txt);
        name=(TextView) findViewById(R.id.name);
        name.setText(getIntent().getStringExtra("val"));



        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick(btnDatePicker);
            }
        });
        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick(btnTimePicker);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                txt.setText("Remainder Set !");


                Intent i=new Intent(MainActivity2.this,MyService.class);
                startService(i);
//                    Toast.makeText(getApplicationContext(),"details"+mYear+mMonth+mDay+mHour+mMinute,Toast.LENGTH_SHORT).show();

//                    Calendar calendar = Calendar.getInstance();
//
//                    calendar.set(mYear,mMonth,mDay,mHour,mMinute,1);
//
//                    Long alert=calendar.getTimeInMillis();
//
//                    Intent alertI=new Intent(MainActivity2.this,AlarmSet.class);
//
//
//
//                    AlarmManager am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
//
//                    am.set(AlarmManager.RTC_WAKEUP,alert, PendingIntent.getBroadcast(MainActivity2.this,1,alertI,PendingIntent.FLAG_UPDATE_CURRENT));



//                Intent i=new Intent(MainActivity2.this,Notif.class);
//                PendingIntent pi=PendingIntent.getActivity(MainActivity2.this,0,i,0);

//                Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
//cal.add(Calendar.SECOND, 10);


//                cal.set(Calendar.DATE,date);  //1-31
//                cal.set(Calendar.MONTH,month);  //first month is 0!!! January is zero!!!
//                cal.set(Calendar.YEAR,year);//year...
//
//                cal.set(Calendar.HOUR_OF_DAY, hour);  //HOUR
//                cal.set(Calendar.MINUTE, min);       //MIN
//                cal.set(Calendar.SECOND, 10);       //SEC


// Create a new PendingIntent and add it to the AlarmManager


//or if you start an Activity
//PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0,intent, 0);

//                AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pi);



//                        Notification noti=new Notification.Builder(MainActivity2.this)
//                        .setTicker("Ticker Title")
//                        .setContentTitle(name.getText().toString())
//                        .setContentText("On "+txtDate.getText()+"  at "+txtTime.getText())
//                        .setSmallIcon(R.drawable.logo).setContentIntent(pi).getNotification();
//
//
//                noti.flags=Notification.FLAG_AUTO_CANCEL;
//                NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//                nm.notify(0,noti);





            }
        });


    }

    public void onclick(View v) {

        if (v == btnDatePicker) {

            // Process to get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);

            mMonth = c.get(Calendar.MONTH);

            mDay = c.get(Calendar.DAY_OF_MONTH);


            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // Display Selected date in textbox

                            mYear=year;
                            mMonth=monthOfYear;
                            mDay=dayOfMonth;
                            txtDate.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            dpd.show();
        }
        if (v == btnTimePicker) {

            // Process to get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);

            mMinute = c.get(Calendar.MINUTE);


            // Launch Time Picker Dialog
            TimePickerDialog tpd = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            // Display Selected time in textbox
                            mHour=hourOfDay;
                            mMinute=minute;
                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            tpd.show();
        }


    }
    public void submit(View v)
    {
        Toast.makeText(getApplicationContext(), "Alarm set", Toast.LENGTH_SHORT).show();
    }
}

