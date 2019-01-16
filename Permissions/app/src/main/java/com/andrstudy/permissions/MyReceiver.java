package com.andrstudy.permissions;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MyReceiver extends BroadcastReceiver {

    private OnBTStatusMessage handler;
    private ToggleButton toggleButton;

    @Override
    public void onReceive(Context context, Intent intent) {
        int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);
        String strState = "";
        switch(state){
            case BluetoothAdapter.STATE_ON:
                strState = "ON"; break;
            case BluetoothAdapter.STATE_OFF:
                strState = "OFF"; break;
        }
        Toast.makeText(context, "bt "+strState, Toast.LENGTH_SHORT).show();
        this.handler.onBTStatusMessage(state);
    }

    public MyReceiver(ToggleButton toggleButton){
        this.toggleButton = toggleButton;
    }

    public MyReceiver(){
    }

    public MyReceiver(OnBTStatusMessage handler){
        this.handler = handler;
    }
}
