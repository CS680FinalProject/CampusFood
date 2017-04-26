package com.example.yp.campusfood;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    // coordinates for cafes
    // lower cafe
    double latitude = 42.388670;
    double longitude = -71.220050;
    private LatLng position = new LatLng(latitude,longitude);

    // 921
    double latitude1 = 42.385984;
    double longitude1 = -71.222844;
    private LatLng position1 = new LatLng(latitude1,longitude1);

    // Deloitte
    double latitude2 = 42.387941;
    double longitude2 = -71.219851;
    private LatLng position2 = new LatLng(latitude2,longitude2);

    // Currito
    double latitude3 = 42.385199;
    double longitude3 = -71.224808;
    private LatLng position3 = new LatLng(latitude3,longitude3);

    // Dunkin
    double latitude4 = 42.386780;
    double longitude4 = -71.222485;
    private LatLng position4 = new LatLng(latitude4,longitude4);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Bundle b = getIntent().getExtras();
        String cafeName =b.getString("Cafe");

        //reset center of map
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position2, 16.0f));

        LatLng tempPosition = null;

        //add markers for selected cafe
        switch (cafeName) {
            case "LowerCafe":
                tempPosition = position;
                break;

            case "921":
                tempPosition = position1;
                break;

            case "Deloitte":
                tempPosition = position2;
                break;

            case "Currito":
                tempPosition = position3;
                break;

            case "Dunkin":
                tempPosition = position4;
                break;

        }

        mMap.addMarker(new MarkerOptions()
                .position(tempPosition)
                .title(cafeName)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

    }
}
