package com.example.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private Button buttonOrderItem, buttonViewOrders, buttonPay;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        userId = 1; // Replace with actual logic to get the logged-in user's ID

        buttonOrderItem = findViewById(R.id.buttonOrderItem);
        buttonViewOrders = findViewById(R.id.buttonViewOrders);
        buttonPay = findViewById(R.id.buttonPay);

        buttonOrderItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        buttonViewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, OrderHistoryActivity.class);
                startActivity(intent);
            }
        });

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }
}
