package com.example.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDishActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_dish);

        resultTextView = findViewById(R.id.resultTextView);
        Button randomDishButton = findViewById(R.id.randomDishButton);
        Button randomDessertButton = findViewById(R.id.randomDessertButton);
        Button randomDrinkButton = findViewById(R.id.randomDrinkButton);
        Button randomAlcoholButton = findViewById(R.id.randomAlcoholButton);
        Button randomBackToHome = findViewById(R.id.randomBackToHome);
        random = new Random();

        randomDishButton.setOnClickListener(v -> pickRandomFood(getAllDishes()));
        randomDessertButton.setOnClickListener(v -> pickRandomFood(FoodMenuDetail.getDessertList()));
        randomDrinkButton.setOnClickListener(v -> pickRandomFood(FoodMenuDetail.getDrinkList()));
        randomAlcoholButton.setOnClickListener(v -> pickRandomAlcohol(DrinkMenuDetail.getAllDrink()));
        randomBackToHome.setOnClickListener(v -> finish());

    }

    private List<Food> getAllDishes() {
        List<Food> allDishes = new ArrayList<>();
        String[] categories = FoodMenuActivity.getFoodCategories();

        if (categories != null) {
            for (String category : categories) {
                switch (category) {
                    case "Kebab":
                        allDishes.addAll(FoodMenuDetail.getKebabList());
                        break;
                    case "Talerz":
                        allDishes.addAll(FoodMenuDetail.getPlateList());
                        break;
                    case "Sałatki":
                        allDishes.addAll(FoodMenuDetail.getSaladList());
                        break;
                }
            }
        }
        return allDishes;
    }

    private void pickRandomFood(List<Food> foodList) {
        if (foodList == null || foodList.isEmpty()) {
            resultTextView.setText("Brak dostępnych pozycji.");
            return;
        }

        Food randomFood = foodList.get(random.nextInt(foodList.size()));
        String resultText = "Nazwa: " + randomFood.getName() + "\n" +
                "Składniki: " + randomFood.getDescription() + "\n" +
                "Cena: " + randomFood.getSize();
        resultTextView.setText(resultText);
    }

    private void pickRandomAlcohol(List<Alko> alcoholList) {
        if (alcoholList == null || alcoholList.isEmpty()) {
            resultTextView.setText("Brak dostępnych pozycji.");
            return;
        }

        Alko randomAlcohol = alcoholList.get(random.nextInt(alcoholList.size()));
        String resultText = "Nazwa: " + randomAlcohol.getName() + "\n" +
                "Składniki: " + randomAlcohol.getDescription() + "\n" +
                "Cena: " + randomAlcohol.getPrice();
        resultTextView.setText(resultText);
    }
}
