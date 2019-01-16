package com.andrstudy.permissions;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements OnBTStatusMessage {

    private MyReceiver receiver;
    private TextView textView;
    private IntentFilter intentFilter;
    private LocationManager locationManager;
    private BluetoothAdapter bluetoothAdapter;
    private ToggleButton toggleButton;
    private LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            String strLocation = "LAT:"+location.getLatitude();
            strLocation += "LNG:" + location.getLatitude();
            textView.setText(strLocation);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        TextView textView = findViewById(R.id.textView);

        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter.isEnabled()){
            toggleButton.setChecked(true);
        }else{
            toggleButton.setChecked(false);
        }

        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        MyReceiver receiver = new MyReceiver(this);
        this.registerReceiver(receiver, filter);textView = (TextView)findViewById(R.id.textView);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            initLocationManager();
        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1001);
        }

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        this.unregisterReceiver(receiver);
    }

    private void initLocationManager() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try{
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 10, listener);
        }catch(SecurityException e){
            Toast.makeText(this, "권한이 필요합니다.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1001) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                initLocationManager();
            else
                Toast.makeText(this, "권한이 필요합니다.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBTStatusMessage(int status) {
        if(status == BluetoothAdapter.STATE_ON){
            toggleButton.setChecked(true);
        }else if(status == BluetoothAdapter.STATE_ON){
            toggleButton.setChecked(false);
        }
    }

}
