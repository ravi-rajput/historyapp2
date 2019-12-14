package com.srreducation.ravi.historyapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;
RelativeLayout r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9,i10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
        setContentView(R.layout.activity_main);

//        MobileAds.initialize(this, "YOUR_ADMOB_APP_ID");

        AdView adView=(AdView)findViewById(R.id.bannerAdd);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);

r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);
        r5=findViewById(R.id.r5);
        r6=findViewById(R.id.r6);
        r7=findViewById(R.id.r7);
        r8=findViewById(R.id.r8);
        r9=findViewById(R.id.r9);
        r10=findViewById(R.id.r10);


        Animation shake1 = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        r1.startAnimation(shake1);
        r2.startAnimation(shake1);
        r3.startAnimation(shake1);
        r4.startAnimation(shake1);
        r5.startAnimation(shake1);
        r6.startAnimation(shake1);
        r7.startAnimation(shake1);
        r8.startAnimation(shake1);
        r9.startAnimation(shake1);
        r10.startAnimation(shake1);


        i1=findViewById(R.id.i1);
        i2=findViewById(R.id.i2);
        i3=findViewById(R.id.i3);
        i4=findViewById(R.id.i4);
        i5=findViewById(R.id.i5);
        i6=findViewById(R.id.i6);
        i7=findViewById(R.id.i7);
        i8=findViewById(R.id.i8);
        i9=findViewById(R.id.i9);
        i10=findViewById(R.id.i10);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
toolbar.setTitle("GK GuruJi: 1 Lakh Questions");
        setSupportActionBar(toolbar);


        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,History.class);
                startActivity(i);

            }});


        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Geography.class);
                startActivity(i);

            }});

        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Indian_Polity.class);
                startActivity(i);

            }});

        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Economy.class);
                startActivity(i);

            }});

        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Scince.class);
                startActivity(i);

            }});

        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Ecology.class);
                startActivity(i);

            }});

        r7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,vividh.class);
                startActivity(i);

            }});

        r8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Current_Affaires.class);
                startActivity(i);

            }});

        r9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Question_Paper.class);
                startActivity(i);

            }});

        r10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Today_Question.class);
                startActivity(i);

            }});


                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            finish();
        } else {
            Toast.makeText(MainActivity.this, "Tap back again to exit", Toast.LENGTH_SHORT).show();
        }

        mBackPressed = System.currentTimeMillis();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_app_gallary) {
            Intent i = new Intent(MainActivity.this, Other_Data.class);
            i.putExtra("name1", "app_gallery");
            i.putExtra("name2", "apps");
            i.putExtra("name3", "a_g_hint");
            i.putExtra("name4", "a_g_text");
            startActivity(i);

        } else if (id == R.id.nav_youtube) {
            Intent i=new Intent(this,Google_Search.class);
            i.putExtra("data","https://www.youtube.com/user/sangram226/videos");

            startActivity(i);
        } else if (id == R.id.nav_share) {


            Intent share = new Intent(android.content.Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.srreducation.ravi.historyapp");
            startActivity(share);
            startActivity(Intent.createChooser(share, "Send app link using:"));
        }
  else if (id == R.id.nav_disclaimer) {
            Intent i = new Intent(this, Disclaimer.class);
            startActivity(i);
        }
            else if (id == R.id.nav_contact) {
            Intent i=new Intent(this,Contact.class);
            startActivity(i);
        }
        else if (id == R.id.nav_google) {
            Intent i=new Intent(this,Google_Search.class);
            i.putExtra("data","https://www.google.co.in");
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
   }
