package com.omug.android_login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    TextView username, password;
    Button login;
    public static ArrayList<Client> clientList=new ArrayList<>();
    public static String userNameNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fillClient();

        username = findViewById(R.id.txtUser);
        password = findViewById(R.id.txtPassword);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new ButtonsEvent());


    }

    private void fillClient() {
        clientList.add(new Client("Omairys Uzcategui", "Eglinton Avenue West", "omairys", "123456"));
        clientList.add(new Client("Rick Sanchez", "C-137", "rick", "123456"));
        clientList.add(new Client("Homer Simpson", "742 Evergreen Terrace", "homer", "123456"));

    }

    private class ButtonsEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            if(validLogin(user,pass)){
                userNameNext =  user;
                Intent productIntent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(productIntent);
            }else{
                Toast.makeText(getBaseContext(),"Invalid username or password",Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean validLogin(String user, String pass) {
        for(Client cln:clientList)
            if(cln.getUsername().equalsIgnoreCase(user) && cln.getPassword().equals(pass))
                return true;
        return false;
    }
}