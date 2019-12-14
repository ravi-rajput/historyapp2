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
 * Created by Ravi on 12/26/2017.
 */

public class Indian_Polity extends AppCompatActivity {

    RelativeLayout indian_polity1,indian_polity2,indian_polity3,indian_polity4,indian_polity5,indian_polity6,indian_polity7,indian_polity8,indian_polity9,indian_polity10,indian_polity11,indian_polity12,indian_polity13,indian_polity14,indian_polity15,indian_polity16,indian_polity17,indian_polity18;
    TextView result;
    ScrollView text_View;
    RelativeLayout indian_polity;
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
        setContentView(R.layout.indian_polity);

        AdView adView=(AdView)findViewById(R.id.bannerAdd);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("राजव्यवस्था(polity)");
        setSupportActionBar(toolbar);
        pd=new ProgressDialog(this);


        //for text
        result=findViewById(R.id.result);
        text_View=findViewById(R.id.text_View);
        indian_polity=findViewById(R.id.indian_polity);


        indian_polity1=findViewById(R.id.indian_polity1);
        indian_polity2=findViewById(R.id.indian_polity2);
        indian_polity3=findViewById(R.id.indian_polity3);
        indian_polity4=findViewById(R.id.indian_polity4);
        indian_polity5=findViewById(R.id.indian_polity5);
        indian_polity6=findViewById(R.id.indian_polity6);
        indian_polity7=findViewById(R.id.indian_polity7);
        indian_polity8=findViewById(R.id.indian_polity8);
        indian_polity9=findViewById(R.id.indian_polity9);
        indian_polity10=findViewById(R.id.indian_polity10);
        indian_polity11=findViewById(R.id.indian_polity11);
        indian_polity12=findViewById(R.id.indian_polity12);
        indian_polity13=findViewById(R.id.indian_polity13);
        indian_polity14=findViewById(R.id.indian_polity14);
        indian_polity15=findViewById(R.id.indian_polity15);
        indian_polity16=findViewById(R.id.indian_polity16);
        indian_polity17=findViewById(R.id.indian_polity17);
        indian_polity18=findViewById(R.id.indian_polity18);

        text_View.setVisibility(View.GONE);
        indian_polity.setVisibility(View.VISIBLE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                    finish();
                } else {
                    text_View.setVisibility(View.GONE);
                    indian_polity.setVisibility(View.VISIBLE);
                }

                mBackPressed = System.currentTimeMillis();


            }
        });
        indian_polity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p1").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });

        indian_polity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p2").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p3").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p4").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p5").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p6").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p7").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p8").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p9").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p10").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p11").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p12").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p13").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p14").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p15").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p16").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p17").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); indian_polity18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                indian_polity.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("indian_polity");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("i_p18").getValue());
                        result.setText(title);
                    pd.dismiss();

                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });

    }}
