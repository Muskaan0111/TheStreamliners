package com.example.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    private EditText mesReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mesReply = findViewById(R.id.editText_second);


        // Getting the intent
        Intent intent=getIntent();

        // Extracting the string
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);







    }

    public void returnReply(View view) {
        //Getting the reply
        String reply = mesReply.getText().toString();
        // Creating a reply intent
        Intent replyIntent = new Intent();
        //Sending the intent
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);
        //Finishing the activity
        finish();


    }
}