package com.kritika.pranampatro.readcycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateOrder extends AppCompatActivity {

    private EditText bookname;
    private EditText bookdes, phone, price;
    private CheckBox checkbox;
    private Button submit;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.kritika.pranampatro.readcycle.R.layout.activity_create_order);
        bookname = findViewById(com.kritika.pranampatro.readcycle.R.id.booknameincreate);
        bookdes = findViewById(com.kritika.pranampatro.readcycle.R.id.bookdesincreate);
        price = findViewById(com.kritika.pranampatro.readcycle.R.id.priceincreate);
        checkbox = findViewById(com.kritika.pranampatro.readcycle.R.id.checkboxincreate);
        submit =  findViewById(com.kritika.pranampatro.readcycle.R.id.submitincreate);

        firebaseAuth = FirebaseAuth.getInstance();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String booknamest, bookdesst,phonest,pricest;
                booknamest = bookname.getText().toString().trim();
                bookdesst = bookdes.getText().toString().trim();
                pricest = price.getText().toString().trim();

                if(bookdesst.isEmpty() || booknamest.isEmpty() || pricest.isEmpty())
                {
                    Toast.makeText(CreateOrder.this, "please enter the details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference myref = firebaseDatabase.getReference("/BOOKS").child(firebaseAuth.getUid());
                    bookdetail userprofilevariable = new bookdetail(booknamest,bookdesst,pricest);
                    myref.setValue(userprofilevariable);
                    Toast.makeText(CreateOrder.this, "Your Order has been placed", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreateOrder.this,ProfileWelcome.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}
