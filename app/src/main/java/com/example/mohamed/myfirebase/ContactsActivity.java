package com.example.mohamed.myfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {


    private ListView contactsListView;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        contactsListView = (ListView) findViewById(R.id.contactslistveiw);

        final ArrayList<Contact> contacts = new ArrayList<>();
        //contacts.add(new Contact("MoMo", "123456789"));
        //contacts.add(new Contact("Salah", "98765432"));


        mAuth = FirebaseAuth.getInstance();
        String userID = mAuth.getCurrentUser().getUid();
        database = FirebaseDatabase.getInstance();

        myRef = database.getReference("users/" + userID);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> dataSnapshots = dataSnapshot.child("contacts").getChildren();

                while (dataSnapshots.iterator().hasNext()){

                    DataSnapshot snapshot = dataSnapshots.iterator().next();
                    Contact retrievedContact = snapshot.getValue(Contact.class);
                    contacts.add(retrievedContact);
                }

                Log.i("MyTag", "Contatcs Loaded Successfully ..");

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("MyTag", "Failed to retrieve data ..");
            }
        });


        ListCustomAdapter adapter = new ListCustomAdapter(ContactsActivity.this, contacts );
        contactsListView.setAdapter(adapter);


    }
}
