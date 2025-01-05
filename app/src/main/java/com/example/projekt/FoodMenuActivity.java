package com.example.projekt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FoodMenuActivity extends AppCompatActivity {

    private TextView menuTitle;
    private RecyclerView foodRecyclerView;
    private Button backToHome;

    private static String[] foodCategories = {"Kebab", "Talerz", "Sałatki", "Desery", "Napoje"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        menuTitle = findViewById(R.id.menuTitle);
        foodRecyclerView = findViewById(R.id.foodRecyclerView);
        backToHome = findViewById(R.id.backToHome);

        menuTitle.setText("Menu");

        FoodCategoryAdapter adapter = new FoodCategoryAdapter(this, foodCategories);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        foodRecyclerView.setAdapter(adapter);

        backToHome.setOnClickListener(v -> finish());
    }

    public static String[] getFoodCategories() {
        return foodCategories;
    }
}


