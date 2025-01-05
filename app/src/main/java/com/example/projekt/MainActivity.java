package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.viewFoodMenuButton).setOnClickListener(this::goToFoodMenu);
        findViewById(R.id.viewDrinkMenuButton).setOnClickListener(this::goToDrinkMenu);
        findViewById(R.id.randomDishButton).setOnClickListener(this::goToRandomDish);
        findViewById(R.id.tipCalculatorButton).setOnClickListener(this::goToTipCalculator);
    }

    public void goToFoodMenu(View view) {
        Intent intent = new Intent(this, FoodMenuActivity.class);
        startActivity(intent);
    }

    public void goToDrinkMenu(View view) {
        Intent intent = new Intent(this, DrinkMenuActivity.class);
        startActivity(intent);
    }

    public void goToRandomDish(View view) {
        Intent intent = new Intent(this, RandomDishActivity.class);
        startActivity(intent);
    }

    public void goToTipCalculator(View view) {
        Intent intent = new Intent(this, TipCalculatorActivity.class);
        startActivity(intent);
    }
}
