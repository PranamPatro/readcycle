package com.kritika.pranampatro.readcycle;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


public class Profile extends Fragment {


    private TextView name,email,phone;
    private FirebaseAuth firebaseAuth;
    String sfname;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(com.kritika.pranampatro.readcycle.R.layout.fragment_profile, container, false);

        name = view.findViewById(com.kritika.pranampatro.readcycle.R.id.nametop);
        email = view.findViewById(com.kritika.pranampatro.readcycle.R.id.email);
        phone = view.findViewById(com.kritika.pranampatro.readcycle.R.id.phone);

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

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        name.setText("uyiuyiuyui");
//        email.setText(semail);
//        phone.setText(sphone);
        return inflater.inflate(com.kritika.pranampatro.readcycle.R.layout.fragment_profile, container, false);

    }
}
