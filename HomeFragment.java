package com.kritika.pranampatro.readcycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    private CardView createorder;
    private CardView faq,complaint,bought,sold,profile;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(com.kritika.pranampatro.readcycle.R.layout.fragment_homee, container, false);

        createorder = view.findViewById(com.kritika.pranampatro.readcycle.R.id.createorder);
        faq = view.findViewById(com.kritika.pranampatro.readcycle.R.id.faq);
        complaint = view.findViewById(com.kritika.pranampatro.readcycle.R.id.complaint);
        bought = view.findViewById(com.kritika.pranampatro.readcycle.R.id.bought);
        sold = view.findViewById(com.kritika.pranampatro.readcycle.R.id.sold);
        profile = view.findViewById(com.kritika.pranampatro.readcycle.R.id.profile);


        createorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CreateOrder.class);
                startActivity(intent);
            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getActivity(),FAQ.class);
                startActivity(intent);
            }
        });
        complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getActivity(),Complaint.class);
                startActivity(intent);
            }
        });
        bought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getActivity(),TotalBoughtFinal.class);
                startActivity(intent);
            }
        });

        sold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getActivity(),TotalSoldFinal.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getActivity(),BookselveFinal.class);
                startActivity(intent);
            }
        });


        return view;

    }
}

