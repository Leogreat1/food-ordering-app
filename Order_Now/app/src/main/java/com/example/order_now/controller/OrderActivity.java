package com.example.foodorderapp;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    private EditText editTextItem, editTextQuantity;
    private Button buttonSubmitOrder;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        dbHelper = new DatabaseHelper(this);
        editTextItem = findViewById(R.id.editTextItem);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        buttonSubmitOrder = findViewById(R.id.buttonSubmitOrder);

        buttonSubmitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editTextItem.getText().toString();
                String quantityStr = editTextQuantity.getText().toString();

                if (item.isEmpty() || quantityStr.isEmpty()) {
                    Toast.makeText(OrderActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                int quantity = Integer.parseInt(quantityStr);

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("item", item);
                values.put("quantity", quantity);

                long newRowId = db.insert("orders", null, values);

                if (newRowId != -1) {
                    Toast.makeText(OrderActivity.this, "Order placed successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(OrderActivity.this, "Failed to place order", Toast.LENGTH_SHORT).show();
                }

                editTextItem.setText("");
                editTextQuantity.setText("");
            }
        });
    }
}
