package edu.uci.seal.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        if ("A3".equals(intent.getAction())){
            //this Intent is coming from validActivity
            String username = intent.getStringExtra("U");
            String password = intent.getStringExtra("P");
            String deviceID = intent.getStringExtra("DeviceID");

            Log.i("MyServiceTAG", "Invalid login<"+username+", "+password+"> on device "+deviceID);
        }

        return START_STICKY;
    }
}
