package com.kritika.pranampatro.readcycle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class ProfileWelcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.kritika.pranampatro.readcycle.R.layout.activity_profile_welcome);

        BottomNavigationView bottomview = findViewById(com.kritika.pranampatro.readcycle.R.id.navigationView);

        bottomview.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(com.kritika.pranampatro.readcycle.R.id.fragmentcontainer,
                new HomeFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragement = null;
                    switch (menuItem.getItemId())
                    {
                        case com.kritika.pranampatro.readcycle.R.id.navigation_home:
                            selectedFragement = new HomeFragment();
                            break;
                        case com.kritika.pranampatro.readcycle.R.id.navigation_bookshelve:
                            selectedFragement = new BookShelve();
                            break;
                        case com.kritika.pranampatro.readcycle.R.id.navigation_signout:
                            selectedFragement = new Signout();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(com.kritika.pranampatro.readcycle.R.id.fragmentcontainer,
                            selectedFragement).commit();

                    return true;
                }
            };
}
