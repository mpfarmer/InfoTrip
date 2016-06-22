package com.InfoTrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by GaryC on 3/2/2016.
 */
public class MainFragment extends Fragment {

    public static final String TAG = MainFragment.class.getSimpleName();

    Button mapButton;
    Button vidButton;
    Button bltButton;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mapButton = (Button) view.findViewById(R.id.map_button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMap();

            }
        });
        vidButton = (Button) view.findViewById(R.id.vid_button);
        vidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchVideo();

            }
        });
        bltButton = (Button) view.findViewById(R.id.blt_button);
        bltButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchBluetooth();
            }
        });
        return view;
    }

    public void launchMap() {
        Intent intent = new Intent(getContext(), MapActivity.class);
        startActivity(intent);
    }

    public void launchVideo() {
        Intent intent = new Intent(getContext(), VideoActivity.class);
        startActivity(intent);
    }

    public void launchBluetooth() {
        Intent intent = new Intent(getContext(), BluetoothActivity.class);
        startActivity(intent);
    }


}
