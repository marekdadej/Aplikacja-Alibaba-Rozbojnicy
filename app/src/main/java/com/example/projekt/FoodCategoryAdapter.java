package com.example.projekt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class FoodCategoryAdapter extends RecyclerView.Adapter<FoodCategoryAdapter.FoodCategoryViewHolder> {

    private Context context;
    private String[] foodCategories;

    public FoodCategoryAdapter(Context context, String[] foodCategories) {
        this.context = context;
        this.foodCategories = foodCategories;
    }

    @Override
    public FoodCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.food, parent, false);
        return new FoodCategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FoodCategoryViewHolder holder, int position) {
        holder.categoryNameTextView.setText(foodCategories[position]);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FoodMenuDetail.class);
            intent.putExtra("category_name", foodCategories[position]);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return foodCategories.length;
    }

    public static class FoodCategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryNameTextView;

        public FoodCategoryViewHolder(View itemView) {
            super(itemView);
            categoryNameTextView = itemView.findViewById(R.id.name);
        }
    }
}

