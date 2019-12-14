package com.srreducation.ravi.historyapp;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Ravi on 1/7/2018.
 */

public class Today_Question extends AppCompatActivity {

    TextView text;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
        setContentView(R.layout.today_question);

        AdView adView=(AdView)findViewById(R.id.bannerAdd);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("आज का सवाल");
        setSupportActionBar(toolbar);
        pd=new ProgressDialog(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    finish();
            }
        });
        text=findViewById(R.id.text);

        pd.show();
        pd.setMessage("Loading Data");
        pd.setCancelable(false);

        DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("frunt_page");
        //setting condom logo.
        modern_history.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String title = String.valueOf(dataSnapshot.child("text").getValue());
                text.setText(title);
                pd.dismiss();
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        findViewById(R.id.heading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("frunt_page");
                //setting condom logo.
                modern_history.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("text").getValue());
                        text.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        findViewById(R.id.previous).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);


                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("previous_question");
                //setting condom logo.
                modern_history.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("title").getValue());
                        text.setText(title);
                        pd.dismiss();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                               }
                });}
            });

            }
        }