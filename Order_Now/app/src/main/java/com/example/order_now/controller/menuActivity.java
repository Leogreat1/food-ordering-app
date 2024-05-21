package com.example.foodorderapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private TextView textViewItem;
    private Button buttonOrderItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textViewItem = findViewById(R.id.textViewItem);
        buttonOrderItem = findViewById(R.id.buttonOrderItem);

        buttonOrderItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement order logic
                // For example, add the item to an order list
            }
        });
    }
}
