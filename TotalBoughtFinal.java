package com.kritika.pranampatro.readcycle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TotalBoughtFinal extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    String Bookname, Bookprice;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<listlayoutforbooklist> listitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.kritika.pranampatro.readcycle.R.layout.activity_total_bought_final);
        recyclerView = findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        String[] lang = {"Abc","asdadasdas"};
//        recyclerView.setAdapter(new SampleAdapter(lang));


        listitems = new ArrayList<>();


        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = firebaseDatabase.getReference("/BOOKS");

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    GenericTypeIndicator<Map<String, String>> genericTypeIndicator = new GenericTypeIndicator<Map<String, String>>() {};
                    Map<String, String> map = dataSnapshot1.getValue(genericTypeIndicator );
                    Bookname = map.get("bookname");
                    Bookprice = map.get("bookprice");

                    Log.d("name", Bookname);
                    Log.d("price", Bookprice);
                    listlayoutforbooklist listitem = new listlayoutforbooklist(
                            Bookname,Bookprice);

                    listitems.add(listitem);
                    adapter = new MyAdapterForBookList(listitems,TotalBoughtFinal.this);

                }
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
