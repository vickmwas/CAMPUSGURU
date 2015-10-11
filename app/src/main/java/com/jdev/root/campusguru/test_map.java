package com.jdev.root.campusguru;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

/**
 * Created by jdev on 10/8/15.
 */


public class test_map extends AppCompatActivity {

    MyItemizedOverlay myItemizedOverlay = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_map_layout);
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);

        //Im using marker below
        Drawable marker= getResources().getDrawable(android.R.drawable.star_big_on);
        int markerWidth = marker.getIntrinsicWidth();
        int markerHeight = marker.getIntrinsicHeight();
        marker.setBounds(0, markerHeight, markerWidth, 0);

        ResourceProxy resourceProxy = new DefaultResourceProxyImpl(getApplicationContext());

        myItemizedOverlay = new MyItemizedOverlay(marker, resourceProxy);
        mapView.getOverlays().add(myItemizedOverlay);

        //add markers to to the geopoints.
        GeoPoint myPoint1 = new GeoPoint(0, 0);   //mark map origin
        myItemizedOverlay.addItem(myPoint1, "myPoint1", "myPoint1");

        GeoPoint myPoint2 = new GeoPoint(-2*1000000, 37*1000000); //mark somewhere in Kenya.near Nai
        myItemizedOverlay.addItem(myPoint2, "myPoint2", "myPoint2");

    }
}
