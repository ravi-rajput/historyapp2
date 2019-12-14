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
 * Created by Ravi on 11/10/2017.
 */

public class Economy extends AppCompatActivity {

   RelativeLayout economy1,economy2,economy3,economy4,economy5,economy6,economy7,economy8;
    TextView result;
    ScrollView text_View;
RelativeLayout economy;
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
        setContentView(R.layout.economy);

        AdView adView=(AdView)findViewById(R.id.bannerAdd);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("अर्थव्यवस्था");
        setSupportActionBar(toolbar);
        pd=new ProgressDialog(this);

        //for text
        result=findViewById(R.id.result);
        text_View=findViewById(R.id.text_View);

        economy=findViewById(R.id.economy);

        economy1=findViewById(R.id.economy1);
        economy2=findViewById(R.id.economy2);
        economy3=findViewById(R.id.economy3);
        economy4=findViewById(R.id.economy4);
        economy5=findViewById(R.id.economy5);
        economy6=findViewById(R.id.economy6);
        economy7=findViewById(R.id.economy7);
        economy8=findViewById(R.id.economy8);

        text_View.setVisibility(View.GONE);
economy.setVisibility(View.VISIBLE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                    finish();
                } else {
                    text_View.setVisibility(View.GONE);
                    economy.setVisibility(View.VISIBLE);
                }

                mBackPressed = System.currentTimeMillis();

            }
        });

       economy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");


                economy.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);
//int i;
//                for(i=1;i<=20;i++)
//                {
//                    DatabaseReference upsc = FirebaseDatabase.getInstance().getReference("frunt_page").child("question_papers").child("railway").child("r_qp_hint"+i);
//                    upsc.setValue("papers of railway");
//                }
//
//                for(i=1;i<=20;i++)
//                {
//                    DatabaseReference upsc = FirebaseDatabase.getInstance().getReference("frunt_page").child("question_papers").child("railway").child("r_qp_text"+i);
//                    upsc.setValue("please insert railway");
//                }
//
//                for(i=1;i<=20;i++)
//                {
//                    DatabaseReference upsc = FirebaseDatabase.getInstance().getReference("frunt_page").child("question_papers").child("others").child("o_qp_hint"+i);
//                    upsc.setValue("papers of others");
//                }

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("economy");

                //setting condom logo.
                modern_history.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("eco1").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); economy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                economy.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference modern_history = FirebaseDatabase.getInstance().getReference("economy");
                //setting condom logo.
                modern_history.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("eco2").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }});

        economy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                economy.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("economy");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("eco3").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); economy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                economy.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("economy");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("eco4").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); economy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                economy.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("economy");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("eco5").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); economy6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                economy.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("economy");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("eco6").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); economy7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                economy.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("economy");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("eco7").getValue());
                        result.setText(title);
                        pd.dismiss();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        }); economy8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd.show();
                pd.setMessage("Loading Data");
                pd.setCancelable(false);
                result.setText("");

                economy.setVisibility(View.GONE);
                text_View.setVisibility(View.VISIBLE);

                DatabaseReference economy_data = FirebaseDatabase.getInstance().getReference("economy");
                //setting condom logo.
                economy_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String title = String.valueOf(dataSnapshot.child("eco8").getValue());
                        String title1 = String.valueOf(dataSnapshot.child("eco9").getValue());
                        String title2 = String.valueOf(dataSnapshot.child("eco10").getValue());
                        result.setText(title+title1+title2);

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
