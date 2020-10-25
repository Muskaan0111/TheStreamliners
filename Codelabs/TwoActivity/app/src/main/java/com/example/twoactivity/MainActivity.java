package com.example.twoactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.twoactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =MainActivity.class.getSimpleName() ;
    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivity.extra.MESSAGE";
    private EditText mesEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView mesReplyHeadTextView;
    private TextView mesReplyTextView;

   // ActivityMainBinding amb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mesEditText = findViewById(R.id.editText_main);
        mesReplyHeadTextView = findViewById(R.id.text_header_reply);
        mesReplyTextView = findViewById(R.id.text_message_reply);



    }


    public void launchSecondActivity(View view) {
        Toast.makeText(this, "Button CLicked!!", Toast.LENGTH_SHORT).show();

        // Creating a new Intent
        Intent intent =new Intent(this,SecondActivity.class);


        // Getting the string input to the intent
        String message = mesEditText.getText().toString();

        // Adding to intent
        intent.putExtra(EXTRA_MESSAGE,message);

        //Starting the activity
        startActivityForResult(intent,TEXT_REQUEST);






        //Log.d(LOG_TAG,"Button Clicked!");
        



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==TEXT_REQUEST){
            if(resultCode==RESULT_OK) {


                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_REPLY);

                mesReplyHeadTextView.setVisibility(View.VISIBLE);
                mesReplyTextView.setText(reply);
                mesReplyTextView.setVisibility(View.VISIBLE);


            }
        }
    }

}