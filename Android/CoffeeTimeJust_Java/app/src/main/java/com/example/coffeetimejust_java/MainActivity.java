package com.example.coffeetimejust_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    int quantity=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitOrder(View view) {
        TextView nameTextView = (TextView) findViewById(R.id.editTextTextPersonName);
       String s= nameTextView.getText().toString();
          String message="Hey "+s+"!\n"+"Total Bill:$ "+(quantity*10)+"\nThank You!";
          //displayName("Muskaan");
          displayMessage(message);
       // displayPrice(quantity*5);
    }

    private void getMessage() {
        TextView nameTextView = (TextView) findViewById(R.id.editTextTextPersonName);
       System.out.println ((String) nameTextView.getText());


    }

    private void displayMessage(String message) {
        TextView priceTextView=(TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void incrementOrder(View view) {

        quantity++;
        display(quantity);

    }
    public void decrementOrder(View view) {

        quantity--;
        display(quantity);

    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayName(String name) {
        TextView nameTextView = (TextView) findViewById(R.id.editTextTextPersonName);
        nameTextView.setText(name);
    }

    private void displayPrice(int number){
        TextView priceTextView=(TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));



    }
}