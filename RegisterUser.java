package com.kritika.pranampatro.readcycle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity {

    private EditText fname;
    private EditText lname;
    private EditText phone;
    private EditText pin;
    private Button proceed;
    String fnamest,lnamest,phonest,pinst;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.kritika.pranampatro.readcycle.R.layout.activity_register_user);

        fname = findViewById(com.kritika.pranampatro.readcycle.R.id.fnameregister);
        lname = findViewById(com.kritika.pranampatro.readcycle.R.id.lnameregister);
        phone = findViewById(com.kritika.pranampatro.readcycle.R.id.phoneregister);
        pin = findViewById(com.kritika.pranampatro.readcycle.R.id.pinregister);

            firebaseAuth = FirebaseAuth.getInstance();

        proceed = findViewById(com.kritika.pranampatro.readcycle.R.id.proceedonregister);


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fnamest = fname.getText().toString().trim();
                lnamest = lname.getText().toString().trim();
                phonest = phone.getText().toString().trim();
                pinst = pin.getText().toString().trim();

                if(fnamest.isEmpty() || lnamest.isEmpty() || phonest.isEmpty() || pinst.isEmpty())
                {
                    Toast.makeText(RegisterUser.this,"Provide inputs, then press Proceed",Toast.LENGTH_LONG).show();

                }
                else
                {
                    firebaseAuth.createUserWithEmailAndPassword(phonest,pinst).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                senduserdata();
                                Toast.makeText(RegisterUser.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterUser.this, ProfileWelcome.class));
                            } else {
                                Toast.makeText(RegisterUser.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }
    public void senduserdata()
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = firebaseDatabase.getReference("/USER");
        DatabaseReference myreff = myref.child(firebaseAuth.getUid()).child("UserDetail");
        userprofile userprofilevariable = new userprofile(fnamest,lnamest,phonest,"999");
        myreff.setValue(userprofilevariable);

    }
}
