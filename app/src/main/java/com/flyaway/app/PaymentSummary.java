package com.flyaway.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;
import java.text.NumberFormat;

public class PaymentSummary extends AppCompatActivity {
    final static String WEEKLY_PAYMEMNT = "WEEKLY_PAYMENT";
    final static String TODAYS_PAYMENT = "TODAYS_PAYMENT";
    final static String TOTAL_PAYMENT = "TOTAL_PAYMENT";


    final static Integer MAX_SEEK_VALUE = 100;
    final static Double MIN_SERVICE_FEE = 200.00;
    Button addCardBtn;
    SeekBar seekBar;
    TextView tvDueToday;
    TextView tvWeeklyPayments;
    TextView tvViewPaymentSchedule;
    Double totalPayment;
    Double payTodayValue;
    Double weeklyPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_summary);

        // TODO - get total payment from calling activity
        totalPayment = 1250.00;
        payTodayValue = 200.00;
        weeklyPayment = (totalPayment - payTodayValue) / 6;
        
        tvViewPaymentSchedule = (TextView)findViewById(R.id.tvPayment3);
        tvViewPaymentSchedule.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PaymentSchedule.class);
                intent.putExtra(WEEKLY_PAYMEMNT, weeklyPayment);
                intent.putExtra(TODAYS_PAYMENT, payTodayValue);
                intent.putExtra(TOTAL_PAYMENT, totalPayment);
                startActivity(intent);
            }
        });

        addCardBtn = (Button)findViewById(R.id.button2);
        addCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TravelerInfo.class);
                startActivity(intent);
            }
        });

        tvDueToday = (TextView)findViewById(R.id.tvDate5);
        tvWeeklyPayments = (TextView)findViewById(R.id.tvWeeklyPayments);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(MAX_SEEK_VALUE);
        seekBar.setProgress(0);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
                payTodayValue = MIN_SERVICE_FEE + (progress * 300.00) / 100.00;
                tvDueToday.setText(format.format(payTodayValue) + " Due Today");

                weeklyPayment = (totalPayment - payTodayValue) / 6;
                tvWeeklyPayments.setText(format.format(weeklyPayment) + " Every Other Week");

            }
        });
    }
}
