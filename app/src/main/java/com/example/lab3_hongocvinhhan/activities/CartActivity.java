package com.example.lab3_hongocvinhhan.activities;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab3_hongocvinhhan.R;
import com.example.lab3_hongocvinhhan.adapters.FoodCartAdapter;
import com.example.lab3_hongocvinhhan.cores.Cart;
import com.example.lab3_hongocvinhhan.databases.UserService;

public class CartActivity extends MenuActivity {
    private ListView foodListView;
    private Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        foodListView = findViewById(R.id.foodList);
        orderButton = findViewById(R.id.orderButton);

        FoodCartAdapter adapter = new FoodCartAdapter(this, R.layout.food_row, Cart.getFoods());
        foodListView.setAdapter(adapter);

        orderButton.setOnClickListener(v -> {
            if (Cart.getFoods().isEmpty()) return;

            try {
                String message = Cart.getCartInfo();
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(UserService.user.getPhoneNumber(), null, message, null, null);

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                Cart.clear();
                foodListView.setAdapter(adapter);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Order Sent Failure", Toast.LENGTH_LONG).show();
            }
        });
    }
}