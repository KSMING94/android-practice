package com.andrstudy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        Intent intent = getIntent();
        if (intent.getType().equals("text/plain")) {
            setResult(Activity.RESULT_OK);
            String text = intent.getStringExtra(Intent.EXTRA_TEXT);
            if (text != null)
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
}