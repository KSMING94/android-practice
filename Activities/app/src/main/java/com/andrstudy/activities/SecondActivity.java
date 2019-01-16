package com.andrstudy.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button finish = findViewById(R.id.buttonFinish);
        finish.setOnClickListener(this);
        TextView title = findViewById(R.id.textViewTitle);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonFinish){
            finish();
        }

    }
}
