package com.andrstudy.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Button button;
    private View.OnClickListener buttonListenr = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView.setText("Hello");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(buttonListenr);

    }

    @Override
    public void onClick(View view) {
        textView.setText("Click");
    }
    public void onButton(View v){
        textView.setText("안녕하세요!");
    }
}