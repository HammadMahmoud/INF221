package edu.uci.seal.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String username = intent.getStringExtra("U");
            Toast.makeText(context, "Welcome "+username+"!",Toast.LENGTH_LONG).show();
    }
}
