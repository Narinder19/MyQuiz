package com.example.android.myquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        String s = getIntent().getStringExtra("score");

        TextView textView = findViewById(R.id.score);
        textView.setText(s);
    }

    public void submit(View view)
    {
        Intent mainIntent = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }
}
