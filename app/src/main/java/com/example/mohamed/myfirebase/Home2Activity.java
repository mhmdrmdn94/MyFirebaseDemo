package com.example.mohamed.myfirebase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home2Activity extends AppCompatActivity {


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ///////////////////

        final EditText fullname = (EditText) findViewById(R.id.addContactName);
        final EditText phone = (EditText) findViewById(R.id.addContactPhone);
        Button addButton = (Button) findViewById(R.id.addContactBtn);
        Button allContactsButton = (Button) findViewById(R.id.allContactsBtn);

        mAuth = FirebaseAuth.getInstance();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home2Activity.this, "Processing ..", Toast.LENGTH_SHORT).show();

                String cname = fullname.getText().toString();
                String cphone = phone.getText().toString();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                String userID = mAuth.getCurrentUser().getUid();
                Log.i("MyTag", "UserID = " + userID);

                DatabaseReference myRef = database.getReference("users/" + userID + "/contacts");
                myRef.child(cname).setValue(cphone);

                Log.i("MyTag", "Added Successfully");
                Toast.makeText(Home2Activity.this, "Added", Toast.LENGTH_SHORT).show();



            }
        });



        allContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home2Activity.this, "Fetching data .. ", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
