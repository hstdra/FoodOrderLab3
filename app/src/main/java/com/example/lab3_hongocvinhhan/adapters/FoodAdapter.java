package com.example.lab3_hongocvinhhan.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab3_hongocvinhhan.R;
import com.example.lab3_hongocvinhhan.cores.Food;
import com.example.lab3_hongocvinhhan.databases.FoodService;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {
    protected List<Food> foods;

    public FoodAdapter(@NonNull Context context, int resource, @NonNull List<Food> objects) {
        super(context, resource, objects);
        this.foods = objects;
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = convertView == null ? layoutInflater.inflate(R.layout.food_row, parent, false) : convertView;

        Food food = foods.get(position);

        TextView name = view.findViewById(R.id.foodName);
        TextView price = view.findViewById(R.id.foodPrice);
        TextView quantity = view.findViewById(R.id.foodQuantity);
        ImageButton plus = view.findViewById(R.id.plusKey);
        ImageButton subtract = view.findViewById(R.id.subKey);

        name.setText(food.getName());

        price.setText(String.format("Price: %s", FoodService.formatPrice(food.getPrice())));
        quantity.setText(String.format("Quantity: %d", food.getQuantity()));

        plus.setOnClickListener(v -> {
            food.plus(1);
            notifyDataSetChanged();
        });

        subtract.setOnClickListener(v -> {
            food.subtract();
            notifyDataSetChanged();
        });

        return view;
    }
}

