package com.example.lab3_hongocvinhhan.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab3_hongocvinhhan.R;
import com.example.lab3_hongocvinhhan.cores.Cart;
import com.example.lab3_hongocvinhhan.cores.Food;

import java.util.List;

public class FoodCartAdapter extends FoodAdapter {
    public FoodCartAdapter(@NonNull Context context, int resource, @NonNull List<Food> objects) {
        super(context, resource, objects);
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        Food food = super.foods.get(position);

        ImageButton subtract = view.findViewById(R.id.subKey);
        ImageButton remove = view.findViewById(R.id.submitKey);
        remove.setImageResource(R.mipmap.delete);

        remove.setOnClickListener(v -> {
            Cart.removeFood(food);
            notifyDataSetChanged();
        });

        subtract.setOnClickListener(v -> {
            if (food.getQuantity() == 1) {
                Cart.removeFood(food);
            } else {
                food.subtract();
            }

            notifyDataSetChanged();
        });

        return view;
    }
}

