package com.example.foodorderapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    private EditText editTextCardNumber, editTextExpiryDate, editTextCVC;
    private Button buttonPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        editTextCardNumber = findViewById(R.id.editTextCardNumber);
        editTextExpiryDate = findViewById(R.id.editTextExpiryDate);
        editTextCVC = findViewById(R.id.editTextCVC);
        buttonPay = findViewById(R.id.buttonPay);

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processPayment();
            }
        });
    }

    private void processPayment() {
        String cardNumber = editTextCardNumber.getText().toString().trim();
        String expiryDate = editTextExpiryDate.getText().toString().trim();
        String[] expiryParts = expiryDate.split("/");
        int expMonth = Integer.parseInt(expiryParts[0]);
        int expYear = Integer.parseInt(expiryParts[1]);
        String cvc = editTextCVC.getText().toString().trim();

        if (cardNumber.isEmpty() || expiryDate.isEmpty() || cvc.isEmpty() || expiryParts.length != 2) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simulate payment processing
        boolean paymentSuccess = true; // This would be the result of a real payment processing
        if (paymentSuccess) {
            Toast.makeText(this, "Payment successful!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Payment failed. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}
