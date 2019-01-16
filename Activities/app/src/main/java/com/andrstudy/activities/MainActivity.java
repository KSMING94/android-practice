package com.andrstudy.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQ_NUM = 1;
    public static final int RESULT_OK = 11;
    public static final int RESULT_NG = 12;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQ_NUM){
            if(resultCode == RESULT_OK){
                if(data != null) {
                    String result = data.getStringExtra("result");
                    if(result != null)
                        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this, "null result", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(this, "null data", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Result NG", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button second = findViewById(R.id.buttonSecond);
        second.setOnClickListener(this);
        Button third = findViewById(R.id.buttonThird);
        third.setOnClickListener(this);
    }
    //Log.i/w/e - information/warning/error
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Mainactivity", "onDestroy() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Mainactivity", "onStop() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Mainactivity", "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Mainactivity", "onResume() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Mainactivity", "onStart() called");
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonSecond){
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("message", "Hello!");
            startActivity(intent);
        } else if(view.getId() == R.id.buttonThird){
            Intent intent = new Intent(this, ThirdActivity.class);
            intent.putExtra("message", "Hi!");
            startActivityForResult(intent, REQ_NUM);
        }
    }
    public void sendSMS(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:010-4524-5468"));
        intent.putExtra("sms_body", "Hello!!");
        startActivity(intent);
    }
    public void sendMail(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"kgbsibbi@naver.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hello");
        intent.putExtra(Intent.EXTRA_TEXT, "This is mail body");
        startActivity(Intent.createChooser(intent, "Select Mail Application"));
    }

    public void Button(View view){

    }
}
