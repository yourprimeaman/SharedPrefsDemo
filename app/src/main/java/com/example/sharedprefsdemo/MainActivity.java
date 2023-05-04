package com.example.sharedprefsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        SharedPreferences sp = getSharedPreferences("MyPref",MODE_PRIVATE);
        String editValue = sp.getString("name","Null");
        textView.setText(editValue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editText.getText().toString();

                SharedPreferences sp = getSharedPreferences("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor spe = sp.edit();
                spe.putString("name", value);
                spe.apply();
                textView.setText(value);
            }
        });

    }
}