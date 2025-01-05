package com.example.projekt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DrinkDetailAdapter extends RecyclerView.Adapter<DrinkDetailAdapter.DrinkDetailViewHolder> {

    private final ArrayList<Alko> alkoList;

    public DrinkDetailAdapter(ArrayList<Alko> alkoList) {
        this.alkoList = alkoList;
    }

    @Override
    public DrinkDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.alko, parent, false);
        return new DrinkDetailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DrinkDetailViewHolder holder, int position) {
        Alko alkoItem = alkoList.get(position);

        holder.nameTextView.setText(alkoItem.getName());
        holder.ingredientsTextView.setText(alkoItem.getDescription());
        holder.priceTextView.setText(alkoItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return alkoList.size();
    }

    public static class DrinkDetailViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView ingredientsTextView;
        TextView priceTextView;

        public DrinkDetailViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.DrinkName);
            ingredientsTextView = itemView.findViewById(R.id.DrinkIngredients);
            priceTextView = itemView.findViewById(R.id.DrinkPrice);
        }
    }
}