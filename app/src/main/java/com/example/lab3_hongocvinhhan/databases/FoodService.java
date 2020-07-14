package com.example.lab3_hongocvinhhan.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab3_hongocvinhhan.cores.Food;

import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class FoodService {
    private static DatabaseHelper databaseHelper;

    public FoodService(Context context) {
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(context);
        }
    }

    public List<Food> getFoods() {
        List<Food> foods = new LinkedList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_FOOD, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FOOD_NAME));
            int price = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_FOOD_PRICE));
            String image = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FOOD_IMAGE));

            foods.add(new Food(id, name, price, image));
        }
        cursor.close();
        db.close();

        return foods;
    }

    public void addFood(String name, int price, String image) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUMN_FOOD_NAME, name);
        values.put(DatabaseHelper.COLUMN_FOOD_IMAGE, image);
        values.put(DatabaseHelper.COLUMN_FOOD_PRICE, price);

        db.insert(DatabaseHelper.TABLE_FOOD, null, values);
        db.close();
    }

    public static String formatPrice(int price) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

        return currencyVN.format(price);
    }
}
