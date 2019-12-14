package com.srreducation.ravi.historyapp;

/**
 * Created by Ravi on 12/31/2017.
 */

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Ravi on 11/10/2017.
 */

public class Question_Paper extends AppCompatActivity {

    RelativeLayout upsc,ssc,railway,others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
        setContentView(R.layout.question_paper);


        final InterstitialAd mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.Interstitial));
        AdRequest adRequestInter = new AdRequest.Builder().build();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mInterstitialAd.show();
            }
        });
        mInterstitialAd.loadAd(adRequestInter);



        AdView adView=(AdView)findViewById(R.id.bannerAdd);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Question Papers");
        setSupportActionBar(toolbar);

        upsc=findViewById(R.id.upsc);
        others=findViewById(R.id.others);
        ssc=findViewById(R.id.ssc);
        railway=findViewById(R.id.railway);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        upsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Question_Paper.this, Other_Data.class);
                i.putExtra("name1", "question_papers");
                i.putExtra("name2", "upsc");
                i.putExtra("name3", "up_qp_hint");
                i.putExtra("name4", "up_qp_text");
                startActivity(i);


            }});

        ssc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Question_Paper.this, Other_Data.class);
                i.putExtra("name1", "question_papers");
                i.putExtra("name2", "ssc");
                i.putExtra("name3", "s_qp_hint");
                i.putExtra("name4", "s_qp_text");
                startActivity(i);


            }});
        railway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Question_Paper.this, Other_Data.class);
                i.putExtra("name1", "question_papers");
                i.putExtra("name2", "railway");
                i.putExtra("name3", "r_qp_hint");
                i.putExtra("name4", "r_qp_text");
                startActivity(i);


            }});


        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Question_Paper.this, Other_Data.class);
                i.putExtra("name1", "question_papers");
                i.putExtra("name2", "others");
                i.putExtra("name3", "o_qp_hint");
                i.putExtra("name4", "o_qp_text");
                startActivity(i);

            }});


    }}