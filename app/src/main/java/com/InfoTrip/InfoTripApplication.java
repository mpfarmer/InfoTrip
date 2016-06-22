package com.InfoTrip;

import android.app.Application;

/**
 * Created by GaryC on 3/7/2016.
 */
import com.squareup.leakcanary.LeakCanary;

public class InfoTripApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the application layer
        LeakCanary.install(this);
    }


}
