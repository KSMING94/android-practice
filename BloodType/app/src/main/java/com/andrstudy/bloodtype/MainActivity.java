package com.andrstudy.bloodtype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//activity가 interface를 구현
//1. implements View.OnClickListener
//2. onClick 함수 추가
//3. onClick에 기능 추가
//4. button의 clickListener를 this로 등록
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int REQ_NUM = 3 ;
    public static final int RESULT_OK = 11;
    public static final int RESULT_NG = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button a = findViewById(R.id.buttonA);
        a.setOnClickListener(this);
        Button b = findViewById(R.id.buttonB);
        b.setOnClickListener(this);
        Button ab = findViewById(R.id.buttonAB);
        ab.setOnClickListener(this);
        Button o = findViewById(R.id.buttonO);
        o.setOnClickListener(this);
    }

    @Override
    //ResultActivity의 실행결과를 onActivityResult 메서드로 전달받는다
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_NUM) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    String result = data.getStringExtra("result");
                    if (result != null)
                        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this, "null result", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(this, "null data", Toast.LENGTH_SHORT).show();
            } else if(resultCode == RESULT_NG)  {
                if (data != null) {
                    String result = data.getStringExtra("result");
                    if (result != null)
                        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this, "null result", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(this, "null data", Toast.LENGTH_SHORT).show();
            }else
            Toast.makeText(this, "Result NG", Toast.LENGTH_SHORT).show();
         }
    }

    //메소드의 이름은 자유롭게 정의할수 있음
    //public void와 View는 항상 지켜줘야 함
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonA){
            //Intent : activity를 서로 호출하기 위한 필요한 통신 장치(activity간의 인수와 리턴값 전달 도구)
            //Intent intent = new Intent( MainActivity 자신, 호출할 class)
            //Intent의 종류 : 호출 대상 component 분명 명시 > 명시적(Explicit intent)
            //               호출 대상 component 불분명 명시 > 암시적(Implicit intent)
            //intent를 통하여 다른 application의 component--
            //--(acticity,service,broadcast receiver, content provider)를 활성화 시켜준다
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("message", "Atype"); //extra에 값 저장(전달하는 인수 이름, 값)
            startActivityForResult(intent, REQ_NUM);  //REQ_NUM는 호출한 대상을 나타내는 식별자
        }else if(view.getId() == R.id.buttonB){
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("message", "Btype");
            startActivityForResult(intent, REQ_NUM);
        }else if(view.getId() == R.id.buttonAB){
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("message", "ABtype");
            startActivityForResult(intent, REQ_NUM);
        }else{
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("message", "Otype");
            startActivityForResult(intent, REQ_NUM);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop() called");
    }
}
