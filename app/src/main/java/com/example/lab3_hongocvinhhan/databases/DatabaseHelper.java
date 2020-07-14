package com.example.lab3_hongocvinhhan.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "food_order.db";

    public static final String TABLE_FOOD = "foods";
    public static final String TABLE_USER = "users";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER_PHONE = "phoneNumber";
    public static final String COLUMN_USER_PASSWORD = "password";
    public static final String COLUMN_FOOD_NAME = "name";
    public static final String COLUMN_FOOD_PRICE = "price";
    public static final String COLUMN_FOOD_IMAGE = "image";

    private static final String CREATE_FOOD_TABLE = "CREATE TABLE " + TABLE_FOOD + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_FOOD_NAME + " TEXT,"
            + COLUMN_FOOD_PRICE + " INTEGER,"
            + COLUMN_FOOD_IMAGE + " TEXT" + ")";

    private static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_PHONE + " TEXT UNIQUE,"
            + COLUMN_USER_PASSWORD + " TEXT" + ")";

    private static final String DELETE_FOOD_TABLE = "DROP TABLE IF EXISTS " + TABLE_FOOD;
    private static final String DELETE_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FOOD_TABLE);
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_FOOD_TABLE);
        db.execSQL(DELETE_USER_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
