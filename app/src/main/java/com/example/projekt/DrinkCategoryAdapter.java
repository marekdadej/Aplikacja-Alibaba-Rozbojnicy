package com.example.projekt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class DrinkCategoryAdapter extends RecyclerView.Adapter<DrinkCategoryAdapter.DrinkCategoryViewHolder> {

    private Context context;
    private String[] drinkCategories;

    public DrinkCategoryAdapter(Context context, String[] drinkCategories) {
        this.context = context;
        this.drinkCategories = drinkCategories;
    }

    @Override
    public DrinkCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.alko, parent, false);
        return new DrinkCategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DrinkCategoryViewHolder holder, int position) {

        holder.categoryNameTextView.setText(drinkCategories[position]);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DrinkMenuDetail.class);
            intent.putExtra("category_name", drinkCategories[position]);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return drinkCategories.length;
    }

    public static class DrinkCategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryNameTextView;

        public DrinkCategoryViewHolder(View itemView) {
            super(itemView);
            categoryNameTextView = itemView.findViewById(R.id.DrinkName);
        }
    }
}

