package com.kritika.pranampatro.readcycle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText phoneedit;
    private EditText pinedit;
    private Button proceedloginpage;
    private TextView registerloginpage;
    private FirebaseAuth firebaseauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.kritika.pranampatro.readcycle.R.layout.activity_main);

        phoneedit = findViewById(com.kritika.pranampatro.readcycle.R.id.phoneonlogin);
        pinedit = findViewById(com.kritika.pranampatro.readcycle.R.id.pinonlogin);
        proceedloginpage = findViewById(com.kritika.pranampatro.readcycle.R.id.proceedonlogin);
        registerloginpage = findViewById(com.kritika.pranampatro.readcycle.R.id.registerhereonlogin);

        firebaseauth = FirebaseAuth.getInstance();

        FirebaseUser user= firebaseauth.getCurrentUser();

        // this part will execute only if the user is logged in
//        if(user!= null)
//        {
//            finish();
//            startActivity(new Intent(MainActivity.this,ProfileWelcome.class));
//        }

        proceedloginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result = false;
                String phone = phoneedit.getText().toString().trim();
                String pin = pinedit.getText().toString().trim();

                if(phone.isEmpty() || pin.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter the required field to proceed",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    firebaseauth.signInWithEmailAndPassword(phone,pin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, ProfileWelcome.class));
                            } else {
                                Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        registerloginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterUser.class);
                startActivity(intent);
            }
        });

    }
}
