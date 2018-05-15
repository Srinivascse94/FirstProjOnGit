package com.example.android_srinivas.timeanddate;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.app.DialogFragment;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        // Get the widgets reference from XML layout
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
       // final TextView tv = (TextView) findViewById(R.id.tv);
        DatePicker dp = (DatePicker) findViewById(R.id.dp);

        // Get a new Calendar instance
        Calendar calendar = Calendar.getInstance();
        // Get the Calendar current year, month and day of month
        int year = calendar.get(calendar.YEAR);
        final int month = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);
        // Myday is  good dayh

        /*
            init(int year, int monthOfYear, int dayOfMonth,
                DatePicker.OnDateChangedListener onDateChangedListener)

            Initialize the state of DatePicker.
         */
        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Do something when the date changed from date picker object

                // Create a Date variable/object with user chosen date
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(0);
                cal.set(year, monthOfYear, dayOfMonth, 0, 0, 0);
                Date chosenDate = cal.getTime();

                // Format the date
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
                String formattedDate = df.format(chosenDate);

               // tv.setText("Your selected date is\n");
                //tv.setText(tv.getText() + formattedDate);
            }
        });
    }
}