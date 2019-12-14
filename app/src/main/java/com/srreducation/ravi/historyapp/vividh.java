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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Ravi on 1/1/2018.
 */

public class vividh extends AppCompatActivity {

    RelativeLayout vvdh1, vvdh2, vvdh3, vvdh4, vvdh5, vvdh6, vvdh7, vvdh8,vvdh9,vvdh10,vvdh11;
    TextView result;
    ScrollView text_View;
    RelativeLayout vvdh;
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
        setContentView(R.layout.vividh);

        AdView adView=(AdView)findViewById(R.id.bannerAdd);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("विविध");
        setSupportActionBar(toolbar);
        pd=new ProgressDialog(this);

        //for text
        result=findViewById(R.id.result);
        text_View=findViewById(R.id.text_View);

        vvdh=findViewById(R.id.vvdh);

        vvdh1 =findViewById(R.id.vvdh1);
        vvdh2=findViewById(R.id.vvdh2);
        vvdh3=findViewById(R.id.vvdh3);
        vvdh4=findViewById(R.id.vvdh4);
        vvdh5=findViewById(R.id.vvdh5);
        vvdh6=findViewById(R.id.vvdh6);
        vvdh7=findViewById(R.id.vvdh7);
        vvdh8=findViewById(R.id.vvdh8);
        vvdh9=findViewById(R.id.vvdh9);
        vvdh10=findViewById(R.id.vvdh10);
        vvdh11=findViewById(R.id.vvdh11);

        text_View.setVisibility(View.GONE);
        vvdh.setVisibility(View.VISIBLE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                    finish();
                } else {
                    text_View.setVisibility(View.GONE);
                    vvdh.setVisibility(View.VISIBLE);
                }

                mBackPressed = System.currentTimeMillis();

            }
        });

        vvdh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                vvdh.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);


                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("vvdh");

                //setting condom logo.
                modern_history.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("v1").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); vvdh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                vvdh.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("vvdh");
                //setting condom logo.
                modern_history.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("v2").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});

        vvdh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                vvdh.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("vvdh");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("v3").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); vvdh4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                vvdh.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("vvdh");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("v4").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); vvdh5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                vvdh.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("vvdh");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("v5").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); vvdh6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                vvdh.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("vvdh");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("v6").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); vvdh7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                vvdh.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("vvdh");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("v7").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); vvdh8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                vvdh.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("vvdh");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("v8").getValue());
                        result.setText(title);

                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });
        vvdh9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                vvdh.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("vvdh");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("v9").getValue());
                        result.setText(title);

                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });
        vvdh10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                vvdh.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("vvdh");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("v10").getValue());
                        result.setText(title);

                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });
        vvdh11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                vvdh.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("vvdh");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("v11").getValue());
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