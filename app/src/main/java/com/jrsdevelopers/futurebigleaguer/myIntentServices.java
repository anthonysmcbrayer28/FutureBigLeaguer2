package com.jrsdevelopers.futurebigleaguer;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by antho_000 on 6/28/2017.
 */

public class myIntentServices extends IntentService  {

    public myIntentServices() {
        super("MyIntentServices");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {



    }
}
