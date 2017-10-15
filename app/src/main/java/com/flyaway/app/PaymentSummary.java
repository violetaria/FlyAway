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
    Button addCardBtn;
    SeekBar seekBar;
    TextView tvDueToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_summary);

        addCardBtn = (Button)findViewById(R.id.button2);
        addCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PaymentSchedule.class);
                startActivity(intent);
            }
        });

        tvDueToday = (TextView)findViewById(R.id.tvDueToday);
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
                Double payTodayValue = 200.00 + (progress * 300.00) / 100.00;
                tvDueToday.setText(format.format(payTodayValue) + " Due Today");
            }
        });
    }
}
