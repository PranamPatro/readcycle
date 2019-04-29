package com.kritika.pranampatro.readcycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class EditFormUser extends AppCompatActivity {

    private EditText fname,lname,phone;
    private TextView save;
    private FirebaseAuth firebaseAuth;
    String ffname,llname,pphone,ssemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.kritika.pranampatro.readcycle.R.layout.activity_edit_form_user);
        fname = findViewById(com.kritika.pranampatro.readcycle.R.id.fnameedit);
        lname= findViewById(com.kritika.pranampatro.readcycle.R.id.lnameedit);
        phone = findViewById(com.kritika.pranampatro.readcycle.R.id.phoneedit);
        save = findViewById(com.kritika.pranampatro.readcycle.R.id.saveedit);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = firebaseDatabase.getReference("/USER").child(firebaseAuth.getUid()).child("UserDetail");

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<Map<String, String>> genericTypeIndicator = new GenericTypeIndicator<Map<String, String>>() {};
                Map<String, String> map = dataSnapshot.getValue(genericTypeIndicator );
                String sfname = map.get("userFname");
                String slname = map.get("userLname");
                String sphone = map.get("userPhone");
                ssemail = map.get("userEmail");
                fname.setText(sfname);
                lname.setText(slname);
                phone.setText(sphone);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llname = lname.getText().toString().trim();
                 ffname = fname.getText().toString().trim();
                 pphone = phone.getText().toString().trim();

                if(llname.isEmpty() || ffname.isEmpty() || pphone.isEmpty())
                {
                    Toast.makeText(EditFormUser.this,"Provide inputs, then press Proceed",Toast.LENGTH_LONG).show();

                }
                else
                {

                senduserdata();
                Toast.makeText(EditFormUser.this, "Update successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditFormUser.this, ProfileWelcome.class));



                }

            }
        });

    }
    public void senduserdata()
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = firebaseDatabase.getReference("/USER");
        DatabaseReference myreff = myref.child(firebaseAuth.getUid()).child("UserDetail");
        userprofile userprofilevariable = new userprofile(ffname,llname,ssemail,pphone);
        myreff.setValue(userprofilevariable);

    }
}
