package com.andrstudy.server;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private Button button;
    private EditText editText;
    private EditText editText2;
    private ProgressBar progressBar;
    private String user_id, user_pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        editText=(EditText)findViewById(R.id.editTextUserid);
        editText2=(EditText)findViewById(R.id.editTextPassword);

        button=(Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (v.getId()==R.id.button){
                    try {
                        URL url = new URL("http://172.26.1.6/../../2018_11_15.php");
                        new AsyncTask<URL, Integer, String>(){
                            @Override
                            protected void onProgressUpdate(Integer... values) {
                                if (values.length>0){//사용자가 몇개를 줄지 모르니깐 항상 체크해준다
                                    Log.i("http", String.valueOf(values[0]));
                                }
                            }

                            @Override
                            protected void onPreExecute() {
                                super.onPreExecute();
                                user_id = editText.getText().toString();
                                user_pw = editText2.getText().toString();
                                progressBar.setVisibility(View.VISIBLE);
                            }

                            @Override
                            protected String doInBackground(URL... params) {
                                int i=0;
                                String result = new String();
                                if (params == null || params.length<1){
                                    return null;
                                }
                                try {
                                    publishProgress(i++);
                                    HttpURLConnection connection = (HttpURLConnection)params[0].openConnection();
                                    Log.i("http", "connected");
                                    //connection.setRequestMethod("GET");//getㅂ방식
                                    connection.setRequestMethod("POST");//post방식
                                    connection.setDoOutput(true);//쓰기모드 POST강제실행
                                    connection.setDoInput(true);//읽기모드
                                    connection.setUseCaches(false);
                                    connection.setDefaultUseCaches(false);

                                    publishProgress(i++);

                                    OutputStream os =connection.getOutputStream();
                                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                                    writer.write("user_id="+user_id+"&user_pw="+user_pw);
                                    writer.flush();
                                    Log.i(user_pw, user_id);
                                    InputStream is = connection.getInputStream();
                                    StringBuilder builder = new StringBuilder();
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                                    String line;
                                    while ((line = reader.readLine()) != null){
                                        builder.append(line+"\n");
                                        publishProgress(i++);
                                    }
                                    result = builder.toString();Log.i("http", "result"+result);
                                    publishProgress(i++);
                                }catch (IOException me){
                                    me.printStackTrace();
                                }
                                return result;
                            }

                            @Override
                            protected void onPostExecute(String s) {
                                super.onPostExecute(s);
                                progressBar.setVisibility(View.GONE);
                            }

                        }.execute(url);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}