package com.jrsdevelopers.futurebigleaguer;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static com.jrsdevelopers.futurebigleaguer.R.id.hits;

public class MainActivity extends Activity {
    public static final String EXTRA_MESSAGE1 = "playerName";
    public static final String EXTRA_MESSAGE2 = "teamPosition";
    public static final Double ExTRA = Double.parseDouble("0.000");
    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-3940256099942544~3347511713");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }

    public void makeCard(View view) {


        Intent startNewActivity = new Intent(this, CardActivity.class);
        Bundle b = new Bundle();
        EditText editText1 = (EditText) findViewById(R.id.playerName);
        EditText editText2 = (EditText) findViewById(R.id.teamName);
        EditText editText3 = (EditText) findViewById(R.id.bats);
        EditText editText4 = (EditText) findViewById(hits);
        if (editText3.getText().length() == 0 || editText4.getText().length() == 0) {
            Toast.makeText(getApplicationContext(),"entter hit and abats",Toast.LENGTH_LONG).show();

        } else {
            Double value1 = Double.parseDouble(editText3.getText().toString());
            Double value2 = Double.parseDouble(editText4.getText().toString());
            Double calculatedValue;
            calculatedValue = value2 / value1;
            b.putDouble(String.valueOf(ExTRA), calculatedValue);


        }
        ContentValues values = new ContentValues();
        String message2 = editText2.getText().toString();
        String message = editText1.getText().toString();
        startNewActivity.putExtra(EXTRA_MESSAGE2, message2);
        startNewActivity.putExtra(EXTRA_MESSAGE1, message);
        startNewActivity.putExtras(b);
        startActivity(startNewActivity);



    }

    }












