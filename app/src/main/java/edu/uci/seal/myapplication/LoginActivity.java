package edu.uci.seal.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements Button.OnClickListener{

    private Button loginBTN;
    private EditText usernameET;
    private EditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBTN = (Button) findViewById(R.id.loginBTN);
        loginBTN.setOnClickListener(this);
        usernameET = (EditText) findViewById(R.id.usernameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
    }

        @Override
        public void onClick(View v) {
            //check if the login is valid
            String username =  usernameET.getText().toString();
            String password = passwordET.getText().toString();
            boolean checkResult = checkLogin(username, password);

            if(checkResult){//if valid: start validActivity
                //send the username
                Intent validIntent = new Intent(this, ValidActivity.class);
                validIntent.putExtra("U", username);
                startActivity(validIntent);
            }else{//else: start invalidActivity
                //send the username and password
                Intent invalidIntent = new Intent("A1");
                invalidIntent.putExtra("U", username);
                invalidIntent.putExtra("P", password);
                startActivity(invalidIntent);
            }
        }
        private boolean checkLogin(String username, String password){
            if("inf221".equals(username) && "inf221".equals(password)){
                return true;
            }else{
                return false;
            }
        }
}
