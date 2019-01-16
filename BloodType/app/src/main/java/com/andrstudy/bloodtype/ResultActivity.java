package com.andrstudy.bloodtype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button ok = findViewById(R.id.OkButton);
        ok.setOnClickListener(this);
        Button ng = findViewById(R.id.NgButton);
        ng.setOnClickListener(this);

        TextView title = (TextView)findViewById(R.id.textViewTitle);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        if(message != null)
            title.setText(message);

        setResult(MainActivity.RESULT_NG);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.OkButton){
            Intent data = new Intent();
            data.putExtra("result", "만족");
            setResult(MainActivity.RESULT_OK, data);
            finish();

        }else if(view.getId() == R.id.NgButton){
            Intent data = new Intent();
            data.putExtra("result", "불만족");
            setResult(MainActivity.RESULT_NG, data);
            finish();
        }

    }
}
