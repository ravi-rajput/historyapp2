package com.srreducation.ravi.historyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Ravi on 11/10/2017.
 */

public class Other_Data extends AppCompatActivity {
    RelativeLayout result1,result2,result3,result4,result5,result6,result7,result8,result9,result10,result11,result12,result13,result14,result15,result16,result17,result18,result19,result20;

  TextView text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        setContentView(R.layout.other_data);


        AdView adView=(AdView)findViewById(R.id.bannerAdd);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);



        pd=new ProgressDialog(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("GK GuruJi: 1 Lakh Questions");
        setSupportActionBar(toolbar);



        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);
        text4=findViewById(R.id.text4);
        text5=findViewById(R.id.text5);
        text6=findViewById(R.id.text6);
        text7=findViewById(R.id.text7);
        text8=findViewById(R.id.text8);
        text9=findViewById(R.id.text9);
        text10=findViewById(R.id.text10);
        text11=findViewById(R.id.text11);
        text12=findViewById(R.id.text12);
        text13=findViewById(R.id.text13);
        text14=findViewById(R.id.text14);
        text15=findViewById(R.id.text15);



        result1=findViewById(R.id.result1);
        result2=findViewById(R.id.result2);
        result3=findViewById(R.id.result3);
        result4=findViewById(R.id.result4);
        result5=findViewById(R.id.result5);
        result6=findViewById(R.id.result6);
        result7=findViewById(R.id.result7);
        result8=findViewById(R.id.result8);
        result9=findViewById(R.id.result9);
        result10=findViewById(R.id.result10);
        result11=findViewById(R.id.result11);
        result12=findViewById(R.id.result12);
        result13=findViewById(R.id.result13);
        result14=findViewById(R.id.result14);
        result15=findViewById(R.id.result15);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        //getting intent from previous activity(i.e on tapping to product).
        Intent intent = getIntent();
        final String name1 = intent.getStringExtra("name1");
        final String name2 = intent.getStringExtra("name2");
        final String name3 = intent.getStringExtra("name3");
        final String name4 = intent.getStringExtra("name4");

        pd.show();
        pd.setMessage("Loading Data");
        pd.setCancelable(false);

        DatabaseReference upsc = FirebaseDatabase.getInstance().getReference("frunt_page").child(name1).child(name2);
        upsc.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String title = String.valueOf(dataSnapshot.child(name3+"1").getValue());
                text1.setHint(title);
                String title2 = String.valueOf(dataSnapshot.child(name3+"2").getValue());
                text2.setHint(title2);
                String title3 = String.valueOf(dataSnapshot.child(name3+"3").getValue());
                text3.setHint(title3);
                String title4 = String.valueOf(dataSnapshot.child(name3+"4").getValue());
                text4.setHint(title4);
                String title5 = String.valueOf(dataSnapshot.child(name3+"5").getValue());
                text5.setHint(title5);
                String title6 = String.valueOf(dataSnapshot.child(name3+"6").getValue());
                text6.setHint(title6);
                String title7 = String.valueOf(dataSnapshot.child(name3+"7").getValue());
                text7.setHint(title7);
                String title8 = String.valueOf(dataSnapshot.child(name3+"8").getValue());
                text8.setHint(title8);
                String title9 = String.valueOf(dataSnapshot.child(name3+"9").getValue());
                text9.setHint(title9);
                String title10 = String.valueOf(dataSnapshot.child(name3+"10").getValue());
                text10.setHint(title10);
                String title11 = String.valueOf(dataSnapshot.child(name3+"11").getValue());
                text11.setHint(title11);
                String title12 = String.valueOf(dataSnapshot.child(name3+"12").getValue());
                text12.setHint(title12);
                String title13 = String.valueOf(dataSnapshot.child(name3+"13").getValue());
                text13.setHint(title13);
                String title14 = String.valueOf(dataSnapshot.child(name3+"14").getValue());
                text14.setHint(title14);
                String title15 = String.valueOf(dataSnapshot.child(name3+"15").getValue());
                text15.setHint(title15);
                final String url1 = String.valueOf(dataSnapshot.child(name4+"1").getValue());
                final String url2 = String.valueOf(dataSnapshot.child(name4+"2").getValue());
                final String url3 = String.valueOf(dataSnapshot.child(name4+"3").getValue());
                final String url4 = String.valueOf(dataSnapshot.child(name4+"4").getValue());
                final String url5 = String.valueOf(dataSnapshot.child(name4+"5").getValue());
                final String url6 = String.valueOf(dataSnapshot.child(name4+"6").getValue());
                final String url7 = String.valueOf(dataSnapshot.child(name4+"7").getValue());
                final String url8 = String.valueOf(dataSnapshot.child(name4+"8").getValue());
                final String url9 = String.valueOf(dataSnapshot.child(name4+"9").getValue());
                final String url10 = String.valueOf(dataSnapshot.child(name4+"10").getValue());
                final String url11 = String.valueOf(dataSnapshot.child(name4+"11").getValue());
                final String url12 = String.valueOf(dataSnapshot.child(name4+"12").getValue());
                final String url13 = String.valueOf(dataSnapshot.child(name4+"13").getValue());
                final String url14 = String.valueOf(dataSnapshot.child(name4+"14").getValue());
                final String url15 = String.valueOf(dataSnapshot.child(name4+"15").getValue());

                result1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

if(url1.contains("http")) {
    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
    startActivity(browserIntent);
}
else{
    Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
}
                    }});

                result2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url2.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url3.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url3));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url4.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url4));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url5.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url5));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url6.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url6));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url7.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url7));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url8.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url8));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url9.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url9));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url10.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url10));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url11.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url11));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url12.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url12));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url13.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url13));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url14.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url14));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});
                result15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(url15.contains("http")) {

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url15));
                            startActivity(browserIntent);
                        }
                        else{
                            Toast.makeText(Other_Data.this, "Not Updated Try Later", Toast.LENGTH_SHORT).show();
                        }

                    }});

                pd.dismiss();
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        }
}