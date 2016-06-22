package com.InfoTrip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/*
MainActivity for Entry
 */
public class MapActivity extends AppCompatActivity {

    public static final String TAG = MapActivity.class.getSimpleName();
    private static final String FRAG_MAP = "map";
    public static final float DEFAULT_ZOOM_LEVEL = 3.0f;

    MapController mapController;
    private View progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        progress = findViewById(R.id.progress);
        mapController = new MapController(this, savedInstanceState);
        SupportMapFragment mapFragment;
        if (savedInstanceState == null) {
            mapFragment = SupportMapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.map_content, mapFragment, FRAG_MAP).commit();
        } else {
            mapFragment = findMapFragment();
        }
        mapFragment.getMapAsync(mapController);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapController.onDestroy();
    }

    protected SupportMapFragment findMapFragment() {
        return (SupportMapFragment) getSupportFragmentManager().findFragmentByTag(FRAG_MAP);
    }

    public static class MapController implements OnMapReadyCallback, GoogleMap.OnCameraChangeListener,GoogleMap.OnMapClickListener, GoogleMap.OnMarkerClickListener {

        private GoogleMap map;
        MapActivity mapActivity;
        @Override
        public void onCameraChange(CameraPosition cameraPosition) {

        }

        @Override
        public void onMapClick(LatLng latLng) {

        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            map = googleMap;
            LatLng sydney = new LatLng(37, -121);
            map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }

        @Override
        public boolean onMarkerClick(Marker marker) {
//            if(marker !=null)
            return false;
        }

        public MapController(final MapActivity mapActivity, Bundle savedInstanceState) {
            this.mapActivity = mapActivity;

        }

        public void onDestroy() {
            if (map != null) {
                map.setOnMarkerClickListener(null);
                map.setOnCameraChangeListener(null);
                map.setOnMapClickListener(null);
            }
        }
    }
}
