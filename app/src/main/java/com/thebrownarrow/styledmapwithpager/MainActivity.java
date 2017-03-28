package com.thebrownarrow.styledmapwithpager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.thebrownarrow.customstyledmap.CustomMap;
import com.thebrownarrow.model.MyLocation;
import com.thebrownarrow.utils.GlobalUtils;

import java.util.ArrayList;

import permission.auron.com.marshmallowpermissionhelper.ActivityManagePermission;
import permission.auron.com.marshmallowpermissionhelper.PermissionResult;
import permission.auron.com.marshmallowpermissionhelper.PermissionUtils;

public class MainActivity extends ActivityManagePermission {
    private ArrayList<MyLocation> latLngsArrayList;

    private Animation slide_out_down, slide_in_up;
    public static GoogleMap map;
    private SupportMapFragment supportMapFragment;
    Marker hamburg, previousSelectedMarker;
    private static ViewPager event_pager;

    CustomMap customMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            setContents();

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            askCompactPermissions(new String[]{PermissionUtils.Manifest_ACCESS_COARSE_LOCATION, PermissionUtils.Manifest_ACCESS_FINE_LOCATION}, new PermissionResult() {
                @Override
                public void permissionGranted() {
                    setContents();
                }

                @Override
                public void permissionDenied() {

                }
            });
        }
    }

    private void setContents() {
        latLngsArrayList = new ArrayList<>();
        latLngsArrayList.clear();
        latLngsArrayList = GlobalUtils.getLatLongArray();

        slide_out_down = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_down);
        slide_in_up = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_up);

        event_pager = (ViewPager) findViewById(R.id.event_pager);

        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                map = googleMap;
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                customMap = new CustomMap(map, latLngsArrayList, MainActivity.this);

                try {
                    customMap.setCustomMapStyle(R.raw.mapstyle);
                    // Customise the styling of the base map using a JSON object defined in a raw resource file.
                } catch (Resources.NotFoundException e) {
                    Log.e("Explore detail activity", "Can't find style. Error: " + e);
                }

                handleMap();
                customMap.addCustomPin();
                event_pager.setAdapter(new MapViewPagerAdapter(MainActivity.this,
                        latLngsArrayList));
            }
        });


        event_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                MyLocation location = latLngsArrayList.get(position);
                Point mappoint = map.getProjection().toScreenLocation(
                        new LatLng(location.getLatitude(), location.getLongitude()));
                mappoint.set(mappoint.x, mappoint.y - 30);
                map.animateCamera(CameraUpdateFactory.newLatLng(map.getProjection().fromScreenLocation(mappoint)));

                customMap.addSelectedCustomPin(position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    private void handleMap() {
        if (map != null) {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }

            map.setMyLocationEnabled(true);

            map.getUiSettings().setMapToolbarEnabled(false);
            map.getUiSettings().setZoomControlsEnabled(false);

            map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {

                    final int mPosition = (int) marker.getTag();
                    try {
                        if (previousSelectedMarker != null) {

                            MyLocation location = latLngsArrayList.get(mPosition);

                            if (map.getCameraPosition().zoom >= 13) {
                                previousSelectedMarker.setIcon(BitmapDescriptorFactory.fromBitmap(
                                        BitmapFactory.decodeResource(getResources(),
                                                R.drawable.ic_near_normal_pin)));
                            } else if (map.getCameraPosition().zoom < 13) {
                                previousSelectedMarker.setIcon(BitmapDescriptorFactory.fromBitmap(
                                        BitmapFactory.decodeResource(getResources(),
                                                R.drawable.ic_normal_pin)));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    marker.setIcon(null);
                    marker.setIcon(BitmapDescriptorFactory.fromBitmap(
                            BitmapFactory.decodeResource(getResources(),
                                    R.drawable.ic_selected_pin)));

                    previousSelectedMarker = marker;

                    if (event_pager.getVisibility() != View.VISIBLE) {

                        event_pager.startAnimation(slide_in_up);
                        slide_in_up.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation arg0) {

                                event_pager.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onAnimationRepeat(Animation arg0) {

                            }

                            @Override
                            public void onAnimationEnd(Animation arg0) {

                            }
                        });

                        event_pager.setCurrentItem(mPosition, true);

                    } else {
                        event_pager.setCurrentItem(mPosition, true);
                    }

                    return false;
                }
            });

            map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {

                    if (event_pager.getVisibility() == View.VISIBLE) {
                        event_pager.startAnimation(slide_out_down);

                        slide_out_down.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation arg0) {

                            }

                            @Override
                            public void onAnimationRepeat(Animation arg0) {

                            }

                            @Override
                            public void onAnimationEnd(Animation arg0) {
                                event_pager.setVisibility(View.GONE);
                                event_pager.clearAnimation();
                            }
                        });
                    }
                }
            });


        } else {
            supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {

                    map = googleMap;
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    customMap = new CustomMap(map, latLngsArrayList, MainActivity.this);

                    try {
                        customMap.setCustomMapStyle(R.raw.mapstyle);
                        // Customise the styling of the base map using a JSON object defined in a raw resource file.
                    } catch (Resources.NotFoundException e) {
                        Log.e("Explore detail activity", "Can't find style. Error: " + e);
                    }

                    handleMap();

                }
            });

        }
    }


}
