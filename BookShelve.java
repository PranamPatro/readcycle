package com.kritika.pranampatro.readcycle;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


public class BookShelve extends Fragment {

    private FirebaseAuth firebaseAuth;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<listlayoutforbooklist> listitems;

    String Bookname, Bookprice;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(com.kritika.pranampatro.readcycle.R.layout.fragment_book_shelve, container, false);

        recyclerView = view.findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        String[] lang = {"Abc","asdadasdas"};
        recyclerView.setAdapter(new SampleAdapter(lang));


        return inflater.inflate(com.kritika.pranampatro.readcycle.R.layout.fragment_book_shelve, container, false);
    }
}
