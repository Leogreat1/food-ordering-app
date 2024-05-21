package com.example.foodorderapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {

    private ListView listViewOrders;
    private DatabaseHelper dbHelper;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        dbHelper = new DatabaseHelper(this);

        userId = 1; // Replace this with actual logic to get the logged-in user's ID

        listViewOrders = findViewById(R.id.listViewOrders);
        loadOrders();
    }

    private void loadOrders() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("orders", new String[]{"item", "quantity"}, "user_id=?", new String[]{String.valueOf(userId)}, null, null, null);

        ArrayList<String> orders = new ArrayList<>();
        while (cursor.moveToNext()) {
            String item = cursor.getString(cursor.getColumnIndex("item"));
            int quantity = cursor.getInt(cursor.getColumnIndex("quantity"));
            orders.add(item + " - Quantity: " + quantity);
        }
        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orders);
        listViewOrders.setAdapter(adapter);
    }
}
