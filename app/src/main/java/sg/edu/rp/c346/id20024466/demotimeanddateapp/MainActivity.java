package sg.edu.rp.c346.id20024466.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.btnDate);
        btnDisplayTime = findViewById(R.id.btnTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.btnReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                if (min < 10) {
                    tvDisplay.setText("Time is " + hour + ":0" + min);
                } else {
                    tvDisplay.setText("Time is " + hour + ":" + min);
                }
            }
        });


        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dayofmonth = dp.getDayOfMonth();
                int month = dp.getMonth();
                int year = dp.getYear();
                tvDisplay.setText("Date is " + dayofmonth + "/" + month + "/" + year);


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(12);
                tp.setCurrentMinute(0);
                dp.updateDate(2020, 0, 1 );
                tvDisplay.setText("Date and Time reset!");
            }
        });





    }
}