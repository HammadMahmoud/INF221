package edu.uci.seal.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ValidActivity extends AppCompatActivity {

    private TextView validTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valid);

        validTV = (TextView) findViewById(R.id.validTV);
        //get the extra data from the received Intent

        Intent receivedIntent = getIntent();
        if(receivedIntent != null){
            //get the username
            String username = receivedIntent.getStringExtra("U");
            validTV.setText("You have successfully logged in.");
            //send broadcast Intent
            Intent broadcastIntent = new Intent("A2");
            broadcastIntent.putExtra("U", username);
            sendBroadcast(broadcastIntent);
        }





    }
}
