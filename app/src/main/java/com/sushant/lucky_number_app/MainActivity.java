package com.sushant.lucky_number_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textView);
        editText = findViewById(R.id.edit_text);
        btn = findViewById(R.id.genrate_lucky_number);

        btn.setOnClickListener(v -> {
            String userName = editText.getText().toString();

            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("userName", userName);
            startActivity(intent);
        });
    }
}