package com.jrsdevelopers.futurebigleaguer;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.algolia.search.saas.Client;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.jrsdevelopers.futurebigleaguer.R.id.hits;

public class MainActivity extends Activity {
    public static final String EXTRA_MESSAGE1 = "playerName";
    public static final String EXTRA_MESSAGE2 = "teamPosition";
    public static final Double ExTRA = Double.parseDouble("0.000");
    private AdView mAdView;
    private Tracker mTracker;

    Client client = new Client("com.jrsdevelopers.futurebigleaguer", "8d93c4631bf68d6b73f050114d8e9f15");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-3940256099942544~3347511713");


        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        GoogleAnnlylicsApplication application = (GoogleAnnlylicsApplication) getApplication();
        mTracker = application.getDefaultTracker();







    }


    public void makeCard(View view) {


        Intent startNewActivity = new Intent(this, CardActivity.class);
        Bundle b = new Bundle();
        EditText editText1 = (EditText) findViewById(R.id.playerName);
        EditText editText2 = (EditText) findViewById(R.id.teamName);
        EditText editText3 = (EditText) findViewById(R.id.bats);
        EditText editText4 = (EditText) findViewById(hits);
        if (editText3.getText().length() == 0 || editText4.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), R.string.message, Toast.LENGTH_LONG).show();

        } else {
            Double value1 = Double.parseDouble(editText3.getText().toString());
            Double value2 = Double.parseDouble(editText4.getText().toString());
            Double calculatedValue;
            calculatedValue = value2 / value1;
            b.putDouble(String.valueOf(ExTRA), calculatedValue);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference();
            String math = myRef.push().getKey();

            myRef.child(math).setValue(String.valueOf(String.format("%.3f",calculatedValue)));
           ;



        }


        ContentValues values = new ContentValues();
        String message2 = editText2.getText().toString();
        String message = editText1.getText().toString();
        startNewActivity.putExtra(EXTRA_MESSAGE2, message2);
        startNewActivity.putExtra(EXTRA_MESSAGE1, message);
        startNewActivity.putExtras(b);
        startActivity(startNewActivity);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mTracker.setScreenName("Main Screen");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

    }



}












