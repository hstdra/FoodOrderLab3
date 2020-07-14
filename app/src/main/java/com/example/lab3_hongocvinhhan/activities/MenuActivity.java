package com.example.lab3_hongocvinhhan.activities;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab3_hongocvinhhan.R;

public class MenuActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(this, HomeActivity.class));
                break;

            case R.id.cart:
                startActivity(new Intent(this, CartActivity.class));
                break;

            case R.id.logout:
                startActivity(new Intent(this, MainActivity.class));
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}