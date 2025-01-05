package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText serviceCostEditText;
    private RadioGroup tipPercentageGroup;
    private Switch roundUpSwitch;
    private TextView tipResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        serviceCostEditText = findViewById(R.id.serviceCostEditText);
        tipPercentageGroup = findViewById(R.id.tipPercentageGroup);
        roundUpSwitch = findViewById(R.id.roundUpSwitch);
        tipResultTextView = findViewById(R.id.tipResultTextView);
        Button calculateButton = findViewById(R.id.calculateButton);
        Button calculatorBackToHome = findViewById(R.id.calculatorBackToHome);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });

        calculatorBackToHome.setOnClickListener(v -> finish());
    }

    private void calculateTip() {
        String costString = serviceCostEditText.getText().toString();
        if (costString.isEmpty()) {
            tipResultTextView.setText("Wprowadź kwotę rachunku!");
            return;
        }

        double cost = Double.parseDouble(costString);
        int selectedTipPercentage = getSelectedTipPercentage();
        double tip = cost * selectedTipPercentage / 100;

        if (roundUpSwitch.isChecked()) {
            tip = Math.ceil(tip);
        } else {
            tip = new BigDecimal(tip).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }

        tipResultTextView.setText("Wysokość napiwku: " + tip + " zł");
    }

    private int getSelectedTipPercentage() {
        int selectedId = tipPercentageGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.tipOption30) {
            return 30;
        } else if (selectedId == R.id.tipOption25) {
            return 25;
        } else if (selectedId == R.id.tipOption20) {
            return 20;
        } else if (selectedId == R.id.tipOption15) {
            return 15;
        } else if (selectedId == R.id.tipOption10) {
            return 10;
        } else if (selectedId == R.id.tipOption5) {
            return 5;
        }
        return 0;
    }
}
