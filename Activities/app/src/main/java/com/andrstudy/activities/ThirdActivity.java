package com.andrstudy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button finish = (Button) findViewById(R.id.buttonFinish);
        finish.setOnClickListener(this);
// default result is NG
        setResult(MainActivity.RESULT_NG);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonFinish) {
            Intent data = new Intent();
            data.putExtra("result", "me too");
            setResult(MainActivity.RESULT_OK, data);
            finish();
        }
    }
}