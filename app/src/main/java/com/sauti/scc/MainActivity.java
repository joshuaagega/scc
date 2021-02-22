package com.sauti.scc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private CoordinatorLayout mDrawerLayout;
    private NavigationView nav_view;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        ActionBar actionBar = getSupportActionBar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("SCC");

        }
        nav_view = findViewById(R.id.nav_view);

        if (nav_view != null) {
            setupDrawerContent(nav_view);
            nav_view.setItemIconTintList(null);
        }
    }
        private void setupDrawerContent ( final NavigationView navigationView){
            navigationView.getMenu().getItem(0).setChecked(true);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {

                        case R.id.app1:
                            System.out.println("Move to app");
                            String url = "https://play.google.com/store/apps/details?id=com.wallpapers_8k_Anime_Lofi.app";
                            Intent rateIntent = new Intent(Intent.ACTION_VIEW);
                            rateIntent.setData(Uri.parse(url));
                            startActivity(rateIntent);
                            break;

                        case R.id.rate:
                            System.out.println("Move to app");
                            String url5 = "https://play.google.com/store/apps/details?id=com.ohrnin.hashtags4gains";
                            Intent rateIntent5 = new Intent(Intent.ACTION_VIEW);
                            rateIntent5.setData(Uri.parse(url5));
                            startActivity(rateIntent5);
                            break;
                        case R.id.email:
                            System.out.println("Move to app");
                            String url6 = "https://sauti.cc";
                            Intent rateIntent6 = new Intent(Intent.ACTION_VIEW);
                            rateIntent6.setData(Uri.parse(url6));
                            startActivity(rateIntent6);
                            break;


//                            Intent intent = new Intent(getApplicationContext(), Admin.class);
//                            startActivity(intent);
                    }
                    item.setChecked(true);
                    mDrawerLayout.closeDrawers();
                    return true;
                }
            });
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
        int id = item.getItemId();
        if (id == R.id.notifications) {
            return true;
        }

        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume () {
        super.onResume();
        getWindow().getDecorView().setSystemUiVisibility(
                View.GONE);
    }
}