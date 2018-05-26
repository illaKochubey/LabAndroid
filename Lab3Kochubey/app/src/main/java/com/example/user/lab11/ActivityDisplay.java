package com.example.user.lab11;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ActivityDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        String size = intent.getStringExtra(MainActivity.EXTRA_SIZE);


        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(text);
        textView.setTextSize(Float.parseFloat(size));

    }

}
