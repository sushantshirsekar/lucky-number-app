package com.sushant.lucky_number_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeText, luckyNumber;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        welcomeText = findViewById(R.id.welcome_text);
        luckyNumber = findViewById(R.id.lucky_number);
        shareBtn = findViewById(R.id.share_btn);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        int randomNumber = generateRandomNumbers();
        String setLuckyNumber = "" + randomNumber;
        luckyNumber.setText(setLuckyNumber);

        shareBtn.setOnClickListener(v -> shareData(userName, randomNumber));
    }

    public void shareData(String userName, Integer luckyNumber){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky today!");
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is " + luckyNumber);

        startActivity(Intent.createChooser(intent, "Choose Platform!"));
    }

    public int generateRandomNumbers(){
        Random random = new Random();
        int upperLimit = 1000;
        return random.nextInt(upperLimit);
    }
}