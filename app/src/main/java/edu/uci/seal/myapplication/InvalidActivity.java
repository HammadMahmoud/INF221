package edu.uci.seal.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class InvalidActivity extends AppCompatActivity {

    private TextView invalidTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invalid);

        invalidTV = (TextView) findViewById(R.id.invalidTV);

        Intent receivedIntent = getIntent();
        if (receivedIntent != null){
            invalidTV.setText("Username and password do not match.");

            String username = receivedIntent.getStringExtra("U");
            String password = receivedIntent.getStringExtra("P");
            //obtain the device unique ID
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            String deviceID = telephonyManager.getDeviceId();
            //send an Intent with U, P, and DeviceID extra data
            Intent serviceIntent = new Intent("A3");
//            serviceIntent.setPackage(this.getPackageName());
            serviceIntent.putExtra("U", username);
            serviceIntent.putExtra("P", password);
            serviceIntent.putExtra("DeviceID", deviceID);
            startService(serviceIntent);

        }

    }
}
