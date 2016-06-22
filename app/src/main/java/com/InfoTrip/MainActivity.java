package com.InfoTrip;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/*
MainActivity for Entry
 */
public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Fragment myFragment = MainFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.root_layout, myFragment,
                    MainFragment.TAG).commit();
        }

    }

}
