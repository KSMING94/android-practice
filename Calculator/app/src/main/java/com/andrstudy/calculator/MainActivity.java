package com.andrstudy.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText number1, number2;
    private TextView result;
    private Button add, sub, mul, div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = findViewById(R.id.editTextNumber1);
        number2 = findViewById(R.id.editTextNumber2);
        result =findViewById(R.id.textViewResult);
        add = findViewById(R.id.buttonAdd);
        add.setOnClickListener(this);
        sub = findViewById(R.id.buttonSub);
        sub.setOnClickListener(this);
        mul = findViewById(R.id.buttonMulti);
        mul.setOnClickListener(this);
        div = findViewById(R.id.buttonDiv);
        div.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(number1.getText().length() < 1 || number2.getText().length() < 1)
            return;
        double n1 = Double.valueOf(number1.getText().toString());
        double n2 = Double.valueOf(number2.getText().toString());
        if(view.getId() == R.id.buttonAdd){
            result.setText(String.valueOf(n1+n2));
        } else if (view.getId() == R.id.buttonSub){
            result.setText(String.valueOf(n1-n2));
        } else if (view.getId() == R.id.buttonMulti){
            result.setText(String.valueOf(n1*n2));
        } else if(view.getId() == R.id.buttonDiv){
            if(n2 == 0)
                result.setText("Error, Divided by zero");
            else
                result.setText(String.valueOf(n1/n2));
        }
    }
}
