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

public class Scince extends AppCompatActivity {
    RelativeLayout science,physics_deep,chemistry_deep,bio_deep;
   RelativeLayout physics1,physics2,physics3,physics4,physics5,physics6,physics7,physics8,physics9,physics10,physics11,physics12;
    RelativeLayout chemestry1,chemestry2,chemestry3,chemestry4,chemestry5,chemestry6,chemestry7;
    RelativeLayout bio1,bio2,bio3,bio4,bio5,bio6,bio7,bio8,bio9,bio10,bio11,bio12;
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
        setContentView(R.layout.science);

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
        toolbar.setTitle("विज्ञान");
        setSupportActionBar(toolbar);
        pd=new ProgressDialog(this);

        //for text
        result=findViewById(R.id.result);
        text_View=findViewById(R.id.text_View);


        science=findViewById(R.id.science);
        physics_deep=findViewById(R.id.physics_deep);
        chemistry_deep=findViewById(R.id.chemestry_deep);
        bio_deep=findViewById(R.id.bio_deep);

        science.setVisibility(View.VISIBLE);

        physics1=findViewById(R.id.physics1);
        physics2=findViewById(R.id.physics2);
        physics3=findViewById(R.id.physics3);
        physics4=findViewById(R.id.physics4);
        physics5=findViewById(R.id.physics5);
        physics6=findViewById(R.id.physics6);
        physics7=findViewById(R.id.physics7);
        physics8=findViewById(R.id.physics8);
        physics9=findViewById(R.id.physics9);
        physics10=findViewById(R.id.physics10);
        physics11=findViewById(R.id.physics11);
        physics12=findViewById(R.id.physics12);



        chemestry1=findViewById(R.id.chemestry1);
        chemestry2=findViewById(R.id.chemestry2);
        chemestry3=findViewById(R.id.chemestry3);
        chemestry4=findViewById(R.id.chemestry4);
        chemestry5=findViewById(R.id.chemestry5);
        chemestry6=findViewById(R.id.chemestry6);
        chemestry7=findViewById(R.id.chemestry7);

        bio1=findViewById(R.id.bio1);
        bio2=findViewById(R.id.bio2);
        bio3=findViewById(R.id.bio3);
        bio4=findViewById(R.id.bio4);
        bio5=findViewById(R.id.bio5);
        bio6=findViewById(R.id.bio6);
        bio7=findViewById(R.id.bio7);
        bio8=findViewById(R.id.bio8);
        bio9=findViewById(R.id.bio9);
        bio10=findViewById(R.id.bio10);
        bio11=findViewById(R.id.bio11);
        bio12=findViewById(R.id.bio12);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                    finish();
                } else {
                      science.setVisibility(View.VISIBLE);
                      physics_deep.setVisibility(View.GONE);
                      chemistry_deep.setVisibility(View.GONE);
                      bio_deep.setVisibility(View.GONE);
                      text_View.setVisibility(View.GONE);

                  }

                mBackPressed = System.currentTimeMillis();


            }
        });

        findViewById(R.id.physics).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.VISIBLE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.GONE);

            }
        });

        findViewById(R.id.chemestry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.VISIBLE);
                bio_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.GONE);

            }
        }); findViewById(R.id.bio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.VISIBLE);
                text_View.setVisibility(View.GONE);

            }
        });


        physics1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p1").getValue());
                        result.setText(title);
                   pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});

        physics2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p2").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});
        physics3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p3").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});
        physics4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p4").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});
        physics5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p5").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});
        physics6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p6").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});
        physics7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p7").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});
        physics8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p8").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});
        physics9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p9").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});
        physics10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p10").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});
        physics11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p11").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});
        physics12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("physics").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("p12").getValue());
                        String title1 = String.valueOf(dataSnapshot.child("p13").getValue());

                        result.setText(title + title1);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});


        chemestry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("chemistry").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("c1").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        chemestry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("chemistry").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("c2").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }}); chemestry3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("chemistry").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("c3").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }}); chemestry4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("chemistry").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("c4").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }}); chemestry5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("chemistry").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("c5").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }}); chemestry6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("chemistry").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("c6").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }}); chemestry7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("chemistry").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("c7").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});

// for Biology data call

        bio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

//

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
               // modern_history16.setValue(" ");



//                        //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b1").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});


        bio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b2").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});

        bio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b3").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        bio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b4").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        bio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b5").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        bio6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b6").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        bio7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b7").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        bio8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b8").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        bio9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b9").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        bio10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b10").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        bio11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b11").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
        bio12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                text_View.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                physics_deep.setVisibility(View.GONE);
                chemistry_deep.setVisibility(View.GONE);
                bio_deep.setVisibility(View.GONE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("science");
                //setting condom logo.
                modern_history.child("biology").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("b12").getValue());
                        String title1 = String.valueOf(dataSnapshot.child("b13").getValue());
                        String title2 = String.valueOf(dataSnapshot.child("b14").getValue());


                        result.setText(title+title1+title2);
pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});

    }
}