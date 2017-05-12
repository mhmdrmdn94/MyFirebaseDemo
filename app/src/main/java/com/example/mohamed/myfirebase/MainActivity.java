package com.example.mohamed.myfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = (Button) findViewById(R.id.homeLoginBtn);
        Button signupBtn = (Button) findViewById(R.id.homeSigninBtn);

       loginBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this, "To Login Page", Toast.LENGTH_SHORT).show();

               Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
               startActivity(loginIntent);

           }
       });


        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "To Signin Page", Toast.LENGTH_SHORT).show();

                Intent signupIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(signupIntent);
            }
        });

    }
}
