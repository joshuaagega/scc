package com.sauti.scc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class    MainActivity extends AppCompatActivity {
private BottomNavigationView bottomview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        bottomview = findViewById(R.id.navigation);
        bottomview.setItemIconTintList(null);

        ActionBar actionBar = getSupportActionBar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("SCC");

        }
        bottomview.setOnNavigationItemSelectedListener(new
         BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                 switch (item.getItemId()){
                     case R.id.calls:
                            onCall(null);
                         return true;

                     case R.id.chats:
                         String url2 = "https://sauti.cc/new-page-3";
                         Intent rateIntent2 = new Intent(Intent.ACTION_VIEW);
                         rateIntent2.setData(Uri.parse(url2));
                         startActivity(rateIntent2);
                         return true;
                     case R.id.about:
                         String url = "https://sauti.cc/faqs";
                         Intent rateIntent = new Intent(Intent.ACTION_VIEW);
                         rateIntent.setData(Uri.parse(url));
                         startActivity(rateIntent);
                         return true;

                 }

                 return true;
             }
         });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }


    @Override
    public void onResume () {
        super.onResume();
        getWindow().getDecorView().setSystemUiVisibility(
                View.GONE);
    }
    public void onCall(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:+254 710 772884"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    10);
            return;
        }else {
            try{
                startActivity(callIntent);
            }
            catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
            }
        }
    }
}