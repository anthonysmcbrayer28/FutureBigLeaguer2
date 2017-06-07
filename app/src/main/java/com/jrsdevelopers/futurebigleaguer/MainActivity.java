package com.jrsdevelopers.futurebigleaguer;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.id.message;
import static com.jrsdevelopers.futurebigleaguer.R.id.hits;

public class MainActivity extends Activity {
    public static final String  EXTRA_MESSAGE1 ="playerName";
    public static final String EXTRA_MESSAGE2 ="teamPosition";
    public  static final Double ExTRA= Double.parseDouble("0.000");






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void makeCard (View view){

        Intent startNewActivity = new Intent(this,CardActivity.class);
        Bundle b = new Bundle();
        EditText editText1 = (EditText) findViewById(R.id.playerName);
        EditText editText2 = (EditText) findViewById(R.id.teamName);
        EditText editText3 = (EditText)findViewById(R.id.bats);
        EditText editText4 = (EditText)findViewById(hits);
        ContentValues values = new ContentValues();
        Double value1 = Double.parseDouble(editText3.getText().toString());
        Double value2 = Double.parseDouble(editText4.getText().toString());
        String message2 = editText2.getText().toString();
        String message = editText1.getText().toString();
        Double calculatedValue;
        calculatedValue = value2 / value1 ;
        b.putDouble(String.valueOf(ExTRA),calculatedValue);
        startNewActivity.putExtra(EXTRA_MESSAGE2,message2);
        startNewActivity.putExtra(EXTRA_MESSAGE1,message);
        startNewActivity.putExtras(b);
        startActivity(startNewActivity);

    }

    }




