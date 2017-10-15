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
    final static Integer MAX_SEEK_VALUE = 100;
    final static Double MIN_SERVICE_FEE = 200.00;
    Button addCardBtn;
    SeekBar seekBar;
    TextView tvDueToday;
    TextView tvWeeklyPayments;
    Double totalPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_summary);

        // TODO - get total payment from calling activity
        totalPayment = 1200.00;

        addCardBtn = (Button)findViewById(R.id.button2);
        addCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PaymentSchedule.class);
                startActivity(intent);
            }
        });

        tvDueToday = (TextView)findViewById(R.id.tvDueToday);
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
                Double payTodayValue = MIN_SERVICE_FEE + (progress * 300.00) / 100.00;
                tvDueToday.setText(format.format(payTodayValue) + " Due Today");

                Double weeklyPayment = (totalPayment - payTodayValue) / 6;
                tvWeeklyPayments.setText(format.format(weeklyPayment) + " Every Other Week");

            }
        });
    }
}
