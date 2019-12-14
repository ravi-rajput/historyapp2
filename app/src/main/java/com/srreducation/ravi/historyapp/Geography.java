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

public class Geography extends AppCompatActivity {

    RelativeLayout geography1,geography2,geography3,geography4,geography5,geography6,geography7,geography8,geography9;
    RelativeLayout w1,w2,w3,w4,w5,w6,w7,w8,w9,w10,w11,w12;
    RelativeLayout world_geography,indian_geography;
    ProgressDialog pd;
    TextView result;
    ScrollView text_View;
    RelativeLayout world_geography_deep,indian_geography_deep,geog;
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        setContentView(R.layout.geography);

        AdView adView=(AdView)findViewById(R.id.bannerAdd);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);

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



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("भूगोल");
        setSupportActionBar(toolbar);

        pd=new ProgressDialog(this);

        //for text
        result=findViewById(R.id.result);
        text_View=findViewById(R.id.text_View);
        world_geography_deep=findViewById(R.id.world_geography_deep);
        indian_geography_deep=findViewById(R.id.indian_geography_deep);
        geog=findViewById(R.id.geog);

        geog.setVisibility(View.VISIBLE);

        w1=findViewById(R.id.w1);
        w2=findViewById(R.id.w2);
        w3=findViewById(R.id.w3);
        w4=findViewById(R.id.w4);
        w5=findViewById(R.id.w5);
        w6=findViewById(R.id.w6);
        w7=findViewById(R.id.w7);
        w8=findViewById(R.id.w8);
        w9=findViewById(R.id.w9);
        w10=findViewById(R.id.w10);
        w11=findViewById(R.id.w11);
        w12=findViewById(R.id.w12);


        geography1=findViewById(R.id.geography1);
        geography2=findViewById(R.id.geography2);
        geography3=findViewById(R.id.geography3);
        geography4=findViewById(R.id.geography4);
        geography5=findViewById(R.id.geography5);
        geography6=findViewById(R.id.geography6);
        geography7=findViewById(R.id.geography7);
        geography8=findViewById(R.id.geography8);
        geography9=findViewById(R.id.geography9);

world_geography=findViewById(R.id.world_geography);
        world_geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                geog.setVisibility(View.GONE);
                text_View.setVisibility(View.GONE);
                world_geography_deep.setVisibility(View.VISIBLE);
                indian_geography_deep.setVisibility(View.GONE);

            }});
indian_geography=findViewById(R.id.indian_geography);
        indian_geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                geog.setVisibility(View.GONE);
                text_View.setVisibility(View.GONE);
                indian_geography_deep.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

            }});

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                    finish();
                } else {
                    geog.setVisibility(View.VISIBLE);
                    text_View.setVisibility(View.GONE);
                    indian_geography_deep.setVisibility(View.GONE);
                    world_geography_deep.setVisibility(View.GONE);
                }

                mBackPressed = System.currentTimeMillis();


            }
        });

        geography1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("g1").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });

        geography2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("g2").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });
        geography3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("g3").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });
        geography4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("g4").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });
        geography5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("g5").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });
        geography6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("g6").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });
        geography7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("g7").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });
        geography8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("g8").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });
        geography9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("g9").getValue());
                        String title1 = String.valueOf(dataSnapshot.child("g10").getValue());

                        result.setText(title+title1);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g1").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        w2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g2").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        w3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g3").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        w4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g4").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        w5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g5").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        w6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g6").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        w7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g7").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        w8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g8").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        w9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g9").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        w10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g10").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        w11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g11").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        w12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_geography_deep.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
                world_geography_deep.setVisibility(View.GONE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("world_geography");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("w_g12").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });



    }
}
