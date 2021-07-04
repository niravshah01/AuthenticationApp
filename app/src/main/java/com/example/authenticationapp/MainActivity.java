package com.example.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth fauth;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logout);
        fauth = FirebaseAuth.getInstance();

        if(fauth.getCurrentUser()==null){
            Intent intent = new Intent(MainActivity.this, LoginAct.class);
            startActivity(intent);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fauth.signOut();
                Intent intent1 = new Intent(MainActivity.this, LoginAct.class);
                startActivity(intent1);
            }
        });
    }
}