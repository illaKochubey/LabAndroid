package com.example.user.lab11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        String size = intent.getStringExtra(MainActivity.EXTRA_SIZE);


        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(text);
        textView.setTextSize(Float.parseFloat(size));
    }

    @Override
    public void onClick(View v) {

    }
}
