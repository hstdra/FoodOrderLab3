package com.example.lab3_hongocvinhhan.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab3_hongocvinhhan.R;
import com.example.lab3_hongocvinhhan.cores.Cart;
import com.example.lab3_hongocvinhhan.cores.Food;

import java.util.List;

public class FoodHomeAdapter extends FoodAdapter {
    public FoodHomeAdapter(@NonNull Context context, int resource, @NonNull List<Food> objects) {
        super(context, resource, objects);
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        Food food = super.foods.get(position);

        ImageButton addToCart = view.findViewById(R.id.submitKey);

        addToCart.setOnClickListener(v -> {
            if (food.getQuantity() > 0) {
                Cart.addFood(food);
                Toast.makeText(getContext(), String.format("%s x %d is added to cart!", food.getName(), food.getQuantity()), Toast.LENGTH_SHORT).show();

                food.reset();
                notifyDataSetChanged();
            }
        });

        return view;
    }
}

