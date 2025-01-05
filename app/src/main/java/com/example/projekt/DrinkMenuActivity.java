package com.example.projekt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DrinkMenuActivity extends AppCompatActivity {

    private TextView DrinkMenuTitle;
    private RecyclerView DrinkRecyclerView;
    private Button DrinkBackToHome;

    private final String[] drinkCategories = {"Piwo", "Wódka", "Whisky", "Wino", "Drinki", "Rum", "Gin", "Tequila", "Likiery i inne"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu);

        DrinkMenuTitle = findViewById(R.id.DrinkMenuTitle);
        DrinkRecyclerView = findViewById(R.id.DrinkRecyclerView);
        DrinkBackToHome = findViewById(R.id.DrinkBackToHome);

        DrinkMenuTitle.setText("Alkohole");

        DrinkCategoryAdapter adapter = new DrinkCategoryAdapter(this, drinkCategories);
        DrinkRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DrinkRecyclerView.setAdapter(adapter);

        DrinkBackToHome.setOnClickListener(v -> finish());
    }
}
