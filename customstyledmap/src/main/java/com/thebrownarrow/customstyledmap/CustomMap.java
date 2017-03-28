package com.thebrownarrow.customstyledmap;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.thebrownarrow.model.MyLocation;

import java.util.ArrayList;

/**
 * Created by iblinfotech on 04/03/17.
 */

public class CustomMap {
    private GoogleMap googleMap;
    private Context mContext;
    private ArrayList<MyLocation> latLngsArrayList;

    public CustomMap(GoogleMap googleMap, ArrayList<MyLocation> latLng, Context context) {
        this.googleMap = googleMap;
        this.mContext = context;
        this.latLngsArrayList = latLng;
    }

    public void setCustomMapStyle(int mapstyle) {
        if (googleMap != null)
            try {
                boolean success = googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(mContext, mapstyle));
                if (!success) {
                    Log.e("mLocation ", "detail activity,Style parsing failed.");
                }
            } catch (Resources.NotFoundException e) {
                Log.e("mLocation ", "detail activity, Can't find style. Error: " + e);
            }

    }

    public void addCustomPin() {
        if (googleMap != null) {
            googleMap.clear();

            for (int i = 0; i < latLngsArrayList.size(); i++) {
                addPin(latLngsArrayList.get(i), i);
            }
        }
    }

    public void addSelectedCustomPin(int position) {
        if (googleMap != null) {
            googleMap.clear();

            for (int i = 0; i < latLngsArrayList.size(); i++) {
                addMarkerSelectedPin(latLngsArrayList.get(i), i,position);
            }
        }
    }

    private static boolean isZooming = false;
    private static boolean isZoomingOut = false;

    public void addPin(MyLocation myLocation, int position) {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        LatLng locationPoint = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(locationPoint));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(12), 2000, null);

        googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {

                if (cameraPosition.zoom >= 13.0f) {
                    if (!isZooming) {
                        googleMap.clear();

                        for (int i = 0; i < latLngsArrayList.size(); i++) {
                            addNearerPin(latLngsArrayList.get(i), i);
                        }
                        isZooming = true;
                        isZoomingOut = true;
                    }
                } else {
                    if (isZoomingOut) {
                        googleMap.clear();

                        for (int i = 0; i < latLngsArrayList.size(); i++) {
                            addNearerPin(latLngsArrayList.get(i), i);
                        }
                        isZoomingOut = false;
                        isZooming = false;
                    }
                }
            }
        });

        if (googleMap.getCameraPosition().zoom >= 13) {
            googleMap.addMarker(new MarkerOptions().position(locationPoint).icon(BitmapDescriptorFactory.fromBitmap(
                    BitmapFactory.decodeResource(mContext.getResources(),
                            R.drawable.ic_near_normal_pin)))).setTag(position);
        } else if (googleMap.getCameraPosition().zoom < 13) {
            googleMap.addMarker(new MarkerOptions().position(locationPoint).icon(BitmapDescriptorFactory.fromBitmap(
                    BitmapFactory.decodeResource(mContext.getResources(),
                            R.drawable.ic_normal_pin)))).setTag(position);
        }

    }

    private void addNearerPin(MyLocation mLocation, int position) {
        LatLng locationPoint = new LatLng(mLocation.getLatitude(), mLocation.getLongitude());
//        map.moveCamera(CameraUpdateFactory.newLatLng(locationPoint));

        if (googleMap.getCameraPosition().zoom >= 13) {
            googleMap.addMarker(new MarkerOptions().position(locationPoint).icon(BitmapDescriptorFactory.fromBitmap(
                    BitmapFactory.decodeResource(mContext.getResources(),
                            R.drawable.ic_near_normal_pin)))).setTag(position);
        } else if (googleMap.getCameraPosition().zoom < 13) {
            googleMap.addMarker(new MarkerOptions().position(locationPoint).icon(BitmapDescriptorFactory.fromBitmap(
                    BitmapFactory.decodeResource(mContext.getResources(),
                            R.drawable.ic_normal_pin)))).setTag(position);
        }
    }

    private void addMarkerSelectedPin(MyLocation mLocation, int position, int selectedPosition) {
        LatLng locationPoint = new LatLng(mLocation.getLatitude(), mLocation.getLongitude());
//        map.moveCamera(CameraUpdateFactory.newLatLng(locationPoint));
        if (position == selectedPosition) {
            googleMap.addMarker(new MarkerOptions().position(locationPoint).icon(BitmapDescriptorFactory.fromBitmap(
                    BitmapFactory.decodeResource(mContext.getResources(),
                            R.drawable.ic_selected_pin)))).setTag(position);
        } else {
            if (googleMap.getCameraPosition().zoom >= 13) {
                googleMap.addMarker(new MarkerOptions().position(locationPoint).icon(BitmapDescriptorFactory.fromBitmap(
                        BitmapFactory.decodeResource(mContext.getResources(),
                                R.drawable.ic_near_normal_pin)))).setTag(position);
            } else if (googleMap.getCameraPosition().zoom < 13) {
                googleMap.addMarker(new MarkerOptions().position(locationPoint).icon(BitmapDescriptorFactory.fromBitmap(
                        BitmapFactory.decodeResource(mContext.getResources(),
                                R.drawable.ic_normal_pin)))).setTag(position);
            }
        }
    }

}
