package com.example.foodorderapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class databaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FoodOrder.db";
    private static final int DATABASE_VERSION = 1;

    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT UNIQUE, password TEXT)";
        String CREATE_ORDERS_TABLE = "CREATE TABLE orders (id INTEGER PRIMARY KEY AUTOINCREMENT, user_id INTEGER, item TEXT, quantity INTEGER, FOREIGN KEY(user_id) REFERENCES users(id))";
        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_ORDERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS orders");
        onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        db.insert("users", null, values);
        db.close();
    }

    public User getUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("users", new String[]{"id", "email", "password"}, "email=? AND password=?", new String[]{email, password}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            User user = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            cursor.close();
            return user;
        }
        return null;
    }

    public void addOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", order.getUserId());
        values.put("item", order.getItem());
        values.put("quantity", order.getQuantity());
        db.insert("orders", null, values);
        db.close();
    }

    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("orders", new String[]{"id", "user_id", "item", "quantity"}, "user_id=?", new String[]{String.valueOf(userId)}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Order order = new Order(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3));
                orders.add(order);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return orders;
    }
}
