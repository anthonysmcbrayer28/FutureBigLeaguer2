package com.jrsdevelopers.futurebigleaguer;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by antho_000 on 6/15/2017.
 */

public class GoogleAnnlylicsApplication extends Application {
    private Tracker mTracker;

    synchronized public Tracker getDefaultTracker(){
        if (mTracker == null){
            GoogleAnalytics analytics =GoogleAnalytics.getInstance(this);
            mTracker = analytics.newTracker(R.xml.analytics_tracker);
        }
        return mTracker;
    }
}
