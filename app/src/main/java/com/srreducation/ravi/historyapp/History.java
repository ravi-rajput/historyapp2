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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Ravi on 11/10/2017.
 */

public class History extends AppCompatActivity {

    RelativeLayout history,ancnt_deep,madvel_deep,modern_deep;
    RelativeLayout ancnt1,ancnt2,ancnt3,ancnt4,ancnt5,ancnt6,ancnt7,ancnt8,ancnt9,ancnt10,ancnt11,ancnt12,ancnt13,ancnt14,ancnt15;
    RelativeLayout madvel1,madvel2,madvel3,madvel4,madvel5,madvel6,madvel7,madvel8;
    RelativeLayout modern1,modern2,modern3,modern4,modern5,modern6,modern7,modern8,modern9,modern10,modern11,modern12,modern13,modern14,modern15,modern16,modern17,modern18,modern19,modern20;
    TextView result;
    ScrollView text_View;

    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
        setContentView(R.layout.history);

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
        toolbar.setTitle("इतिहास");
        setSupportActionBar(toolbar);
pd=new ProgressDialog(this);
        //for text
        result=findViewById(R.id.result);
        text_View=findViewById(R.id.text_View);

        //History layouts
        history=findViewById(R.id.history);
        ancnt_deep=findViewById(R.id.ancnt_deep);
        madvel_deep=findViewById(R.id.madvel_deep);
        modern_deep=findViewById(R.id.modern_deep);


        //ancnt Buttons
        ancnt1=findViewById(R.id.ancnt1);
        ancnt2=findViewById(R.id.ancnt2);
        ancnt3=findViewById(R.id.ancnt3);
        ancnt4=findViewById(R.id.ancnt4);
        ancnt5=findViewById(R.id.ancnt5);
        ancnt6=findViewById(R.id.ancnt6);
        ancnt7=findViewById(R.id.ancnt7);
        ancnt8=findViewById(R.id.ancnt8);
        ancnt9=findViewById(R.id.ancnt9);
        ancnt10=findViewById(R.id.ancnt10);
        ancnt11=findViewById(R.id.ancnt11);
        ancnt12=findViewById(R.id.ancnt12);
        ancnt13=findViewById(R.id.ancnt13);
        ancnt14=findViewById(R.id.ancnt14);


        //madvl button
        madvel1=findViewById(R.id.madvel1);
        madvel2=findViewById(R.id.madvel2);
        madvel3=findViewById(R.id.madvel3);
        madvel4=findViewById(R.id.madvel4);
        madvel5=findViewById(R.id.madvel5);
        madvel6=findViewById(R.id.madvel6);
        madvel7=findViewById(R.id.madvel7);
        madvel8=findViewById(R.id.madvel8);


        //modern button
        modern1=findViewById(R.id.modern1);
        modern2=findViewById(R.id.modern2);
        modern3=findViewById(R.id.modern3);
        modern4=findViewById(R.id.modern4);
        modern5=findViewById(R.id.modern5);
        modern6=findViewById(R.id.modern6);
        modern7=findViewById(R.id.modern7);
        modern8=findViewById(R.id.modern8);
        modern9=findViewById(R.id.modern9);
        modern10=findViewById(R.id.modern10);
        modern11=findViewById(R.id.modern11);
        modern12=findViewById(R.id.modern12);
        modern13=findViewById(R.id.modern13);
        modern14=findViewById(R.id.modern14);
        modern15=findViewById(R.id.modern15);
        modern16=findViewById(R.id.modern16);
        modern17=findViewById(R.id.modern17);
        modern18=findViewById(R.id.modern18);
        modern19=findViewById(R.id.modern19);
        modern20=findViewById(R.id.modern20);



        history.setVisibility(View.VISIBLE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                    finish();
                } else {
                    history.setVisibility(View.VISIBLE);
                    madvel_deep.setVisibility(View.GONE);
                    modern_deep.setVisibility(View.GONE);
                    ancnt_deep.setVisibility(View.GONE);
                    text_View.setVisibility(View.GONE);
                }

                mBackPressed = System.currentTimeMillis();


            }
        });

        findViewById(R.id.ancnt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           ancnt_deep.setVisibility(View.VISIBLE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                history.setVisibility(View.GONE);
                text_View.setVisibility(View.GONE);

            }
        });

        findViewById(R.id.medval).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                madvel_deep.setVisibility(View.VISIBLE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);
                history.setVisibility(View.GONE);
                text_View.setVisibility(View.GONE);

            }
        }); findViewById(R.id.modern).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modern_deep.setVisibility(View.VISIBLE);
                ancnt_deep.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                history.setVisibility(View.GONE);
                text_View.setVisibility(View.GONE);
            }
        });


        ancnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);
result.setText("");
                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an1").getValue());
                        result.setText(title);
          pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});

        ancnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

pd.show();
pd.setMessage("Loading Data");
pd.setCancelable(false);
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);
                result.setText("");
                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an2").getValue());
                        result.setText(title);
pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);
                result.setText("");
                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an3").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);
                result.setText("");
                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an4").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);
                result.setText("");
                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an5").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);
                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an6").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an7").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an8").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an9").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an10").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an11").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an12").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an13").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});   ancnt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("ancient").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("an14").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});
// click to open madvel files

        madvel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("medieval").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("me1").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});

        madvel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("medieval").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("me2").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        madvel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("medieval").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("me3").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        madvel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("medieval").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("me4").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        madvel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("medieval").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("me5").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        madvel6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("medieval").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("me6").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        madvel7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("medieval").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("me7").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        madvel8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("medieval").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("me8").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});

//for Modern data call


        modern1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo1").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});


        modern2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo2").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});

        modern3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo3").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo4").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo5").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo6").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo7").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo8").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo9").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo10").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo11").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo12").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo13").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo14").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo15").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo16").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo17").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo18").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo19").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        modern20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);

                result.setText("");
                text_View.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                madvel_deep.setVisibility(View.GONE);
                modern_deep.setVisibility(View.GONE);
                ancnt_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("history");
                //setting condom logo.
                modern_history.child("modern_history").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("mo20").getValue());
                        result.setText(title);
pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});

    }


    }