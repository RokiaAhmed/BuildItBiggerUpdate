package com.udacity.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        TextView textView = findViewById(R.id.tv_joke);

        if (getIntent().getExtras().containsKey("joke")){
            textView.setText(getIntent().getExtras().getString("joke"));
        }
    }
}
