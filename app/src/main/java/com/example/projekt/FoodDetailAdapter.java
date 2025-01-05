package com.example.projekt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodDetailAdapter extends RecyclerView.Adapter<FoodDetailAdapter.FoodDetailViewHolder> {

    private ArrayList<Food> foodList;

    public FoodDetailAdapter(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public FoodDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food, parent, false);
        return new FoodDetailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FoodDetailViewHolder holder, int position) {
        Food foodItem = foodList.get(position);

        holder.nameTextView.setText(foodItem.getName());
        holder.ingredientsTextView.setText(foodItem.getDescription());
        holder.priceTextView.setText(foodItem.getSize());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodDetailViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView ingredientsTextView;
        TextView priceTextView;

        public FoodDetailViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            ingredientsTextView = itemView.findViewById(R.id.ingredients);
            priceTextView = itemView.findViewById(R.id.price);
        }
    }
}


