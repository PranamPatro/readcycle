package com.kritika.pranampatro.readcycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class BookselveFinal extends AppCompatActivity {

    // this is for editng the user details page
    //not for edit book shelve page

    private TextView name,email,phone;
    private FirebaseAuth firebaseAuth;
    private Button edit;
    String sfname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.kritika.pranampatro.readcycle.R.layout.activity_bookselve_final);
        name = findViewById(com.kritika.pranampatro.readcycle.R.id.nametop);
        email = findViewById(com.kritika.pranampatro.readcycle.R.id.email);
        phone = findViewById(com.kritika.pranampatro.readcycle.R.id.phone);
        edit= findViewById(com.kritika.pranampatro.readcycle.R.id.edit);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = firebaseDatabase.getReference("/USER").child(firebaseAuth.getUid()).child("UserDetail");

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<Map<String, String>> genericTypeIndicator = new GenericTypeIndicator<Map<String, String>>() {};
                Map<String, String> map = dataSnapshot.getValue(genericTypeIndicator );
                sfname = map.get("userFname");
                String slname = map.get("userLname");
                String semail = map.get("userEmail");
                String sphone = map.get("userPhone");
                Log.d("naasdme",name.getText().toString());
                name.setText(sfname);
                email.setText(semail);
                phone.setText(sphone);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BookselveFinal.this,EditFormUser.class);
                startActivity(intent);
            }
        });

    }
}
