package com.flyaway.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class PaymentSchedule extends AppCompatActivity {
    TextView tvPayTodayValue;
    TextView tvPayment1;
    TextView tvPayment2;
    TextView tvPayment3;
    TextView tvPayment4;
    TextView tvPayment5;
    TextView tvPayment6;
    TextView tvTotalPaymentValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_schedule);
        Bundle bundle = getIntent().getExtras();
        Double weeklyPayment = bundle.getDouble(PaymentSummary.WEEKLY_PAYMEMNT);
        Double todaysPayment = bundle.getDouble(PaymentSummary.TODAYS_PAYMENT);
        Double totalPayment = bundle.getDouble(PaymentSummary.TOTAL_PAYMENT);

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());

        tvPayTodayValue = (TextView) findViewById(R.id.tvPayTodayValue);
        tvPayTodayValue.setText(format.format(todaysPayment));

        tvPayment1 = (TextView) findViewById(R.id.tvPayment1);
        tvPayment1.setText(format.format(weeklyPayment));

        tvPayment2 = (TextView) findViewById(R.id.tvPayment2);
        tvPayment2.setText(format.format(weeklyPayment));

        tvPayment3 = (TextView) findViewById(R.id.tvPayment3);
        tvPayment3.setText(format.format(weeklyPayment));

        tvPayment4 = (TextView) findViewById(R.id.tvPayment4);
        tvPayment4.setText(format.format(weeklyPayment));

        tvPayment5 = (TextView) findViewById(R.id.tvPayment5);
        tvPayment5.setText(format.format(weeklyPayment));

        tvPayment6 = (TextView) findViewById(R.id.tvPayment6);
        tvPayment6.setText(format.format(weeklyPayment));

        tvTotalPaymentValue = (TextView) findViewById(R.id.tvTotalPaymentValue);
        tvTotalPaymentValue.setText(format.format(totalPayment));
    }
}
