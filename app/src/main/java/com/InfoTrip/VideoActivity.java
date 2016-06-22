package com.InfoTrip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by GaryC on 3/30/2016.
 */
public class VideoActivity extends AppCompatActivity {

    public static final String TAG = VideoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        if (savedInstanceState == null) {
            Fragment myFragment = VideoFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.root_layout, myFragment,
                    VideoFragment.TAG).commit();
        }

    }

}
