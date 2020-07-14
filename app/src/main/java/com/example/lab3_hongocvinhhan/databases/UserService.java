package com.example.lab3_hongocvinhhan.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab3_hongocvinhhan.cores.User;

public class UserService {
    private static DatabaseHelper databaseHelper;
    public static User user;

    public UserService(Context context) {
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(context);
        }
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_USER, null, "phoneNumber = ?", new String[]{phoneNumber}, null, null, null);

        try {
            if (cursor.moveToNext()) {
                String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_PASSWORD));
                return new User(phoneNumber, password);
            }

            return null;
        } finally {
            cursor.close();
            db.close();
        }
    }

    public void addUser(String phoneNumber, String password) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUMN_USER_PHONE, phoneNumber);
        values.put(DatabaseHelper.COLUMN_USER_PASSWORD, password);

        db.insert(DatabaseHelper.TABLE_USER, null, values);
        db.close();
    }
}
