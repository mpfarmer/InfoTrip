package com.InfoTrip;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by GaryC on 4/4/2016.
 */
public class VideoIntentService extends IntentService {

    private static final String TAG = "com.InfoWay";
    public VideoIntentService() {
        super("InfoWayIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "InfoWay Service has now started");
    }
}
