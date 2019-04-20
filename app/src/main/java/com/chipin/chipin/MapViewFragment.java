package com.chipin.chipin;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.chipin.chipin.adapters.MapCasesAdapter;
import com.chipin.chipin.view.CaseObject;
import com.chipin.chipin.view.SDGObject;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class MapViewFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private static final int DEFAULT_ZOOM = 10;
    private GoogleMap mMap;
    private final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 0;
    private boolean mLocationPermissionGranted;
    private LocationCallback mLocationCallback;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Location mLastKnownLocation;
    private String TAG = "MapsTesting";
    private View view;
    ViewPager viewPager;
    MapCasesAdapter mapCasesAdapter;
    private ArrayList<CaseObject> cases;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_map_view, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);

        cases = new ArrayList<>();
        seed();

        viewPager = view.findViewById(R.id.viewpager);

        mapCasesAdapter = new MapCasesAdapter(getActivity(), cases);

        viewPager.setAdapter(mapCasesAdapter);

        float density = getResources().getDisplayMetrics().density;
        int partialWidth = (int) (16 * density); // 16dp
        int pageMargin = (int) (32 * density); // 8dp

        int viewPagerPadding = partialWidth + pageMargin;

        viewPager.setPageMargin(pageMargin);
        viewPager.setPadding(32, 32, viewPagerPadding * 3, 32);
        viewPager.setClipToPadding(false);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                // Check if this is the page you want.
                if(mMap == null){
                    return;
                }
                if(position == 0){
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 14.0f));
                }else{
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney2, 14.0f));
                }
            }
        });

        mapFragment.getMapAsync(this);
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

        view.findViewById(R.id.inbox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), NotificationsActivity.class));
            }
        });

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        // LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in
        // Sydney"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        updateLocationUI();

        getDeviceLocation();
        // getView().setFocusable(true);

    }

    private void getLocationPermission() {
        /*
         * Request location permission, so that we can get the location of the device.
         * The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.getContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[] { android.Manifest.permission.ACCESS_FINE_LOCATION },
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
            @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
        case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionGranted = true;
            }
        }
        }
        updateLocationUI();
    }
    LatLng sydney;
    LatLng sydney2;
    private void updateLocationUI() {
        if (mMap == null) {
            return;
        }
        try {
            if (mLocationPermissionGranted) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                mMap.setMyLocationEnabled(false);
                mMap.getUiSettings().setMyLocationButtonEnabled(false);
                mLastKnownLocation = null;
                getLocationPermission();
            }
        } catch (SecurityException e) {
            Log.e("Exception: %s", e.getMessage());
        }


        sydney = new LatLng(30.789514, 31.352167);
        sydney2 = new LatLng(30.805950, 31.324699);
        mMap.addMarker(new MarkerOptions().position(sydney)
                .title("Sanafa"));

        mMap.addMarker(new MarkerOptions().position(sydney2)
                .title("Damas"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney2, 14.0f));


        CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(30.805950, 31.324699))
                .strokeWidth(0)
                .strokeColor(Color.argb(90, 193, 51, 19))
                .fillColor(Color.argb(90, 193, 51, 19))
                .radius(5000); // In meters

// Get back the mutable Circle
        Circle circle = mMap.addCircle(circleOptions);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getPosition().equals(sydney2)){
                    viewPager.setCurrentItem(1);
                }else{
                    viewPager.setCurrentItem(0);
                }
                return false;
            }
        });
    }

    private void getDeviceLocation() {
        /*
         * Get the best and most recent location of the device, which may be null in
         * rare cases when a location is not available.
         */
        try {
            if (mLocationPermissionGranted) {
                Task locationResult = mFusedLocationProviderClient.getLastLocation();
                locationResult.addOnCompleteListener(getActivity(), new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            // Set the map's camera position to the current location of the device.
                            mLastKnownLocation = (Location) task.getResult();
                            // Log.d(TAG, "onMapReady: Did I come here?"+mLastKnownLocation.getLongitude());
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                    new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()),
                                    DEFAULT_ZOOM));
                            updateLocationUI();
                        } else {
                            Log.d("LocationDebug", "Current location is null. Using defaults.");
                            Log.e("LocationDebug", "Exception: %s", task.getException());
                            LatLng latLng = new LatLng(mLastKnownLocation.getLatitude(),
                                    mLastKnownLocation.getLongitude());
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, DEFAULT_ZOOM));
                            mMap.getUiSettings().setMyLocationButtonEnabled(false);
                        }
                    }
                });
            }
        } catch (SecurityException e) {
            Log.e("Exception: %s", e.getMessage());
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    public void seed() {
        SDGObject zeroHunger = new SDGObject();
        zeroHunger.setSdgTitle("Zero Hunger");
        zeroHunger.setSdgDetails(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ac tortor dignissim convallis aenean et tortor at risus. Auctor neque vitae tempus quam pellentesque. Turpis cursus in hac habitasse platea dictumst quisque sagittis purus. In eu mi bibendum neque egestas.");
        zeroHunger.setSdgImage("url");

        SDGObject womenEmpowerment = new SDGObject();
        womenEmpowerment.setSdgTitle("Women Empowerment");
        womenEmpowerment.setSdgDetails(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ac tortor dignissim convallis aenean et tortor at risus. Auctor neque vitae tempus quam pellentesque. Turpis cursus in hac habitasse platea dictumst quisque sagittis purus. In eu mi bibendum neque egestas.");
        womenEmpowerment.setSdgImage("url");

        CaseObject quenaWaterways = new CaseObject();
        quenaWaterways.setCaseTitle("Damas Needs Your Help: Chip In New Water Tunnels For the Village");
        quenaWaterways.setCaseDetails(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        ArrayList<String> goals = new ArrayList();
        goals.add("Buy cement");
        goals.add("build construction base");
        goals.add("connect to water link");

        quenaWaterways.setCaseGoals(goals);

        quenaWaterways.setCaseLocation("Quena, Egypt");
        quenaWaterways.setProgressReached(0);
        quenaWaterways.setProgressTarget(10000);

        ArrayList<String> images = new ArrayList<>();
        images.add("img1");
        images.add("img2");
        quenaWaterways.setCaseImages(images);

        // --------------------------------
        ArrayList<SDGObject> sdgObjects = new ArrayList<>();
        sdgObjects.add(zeroHunger);
        // ---------------------------------

        quenaWaterways.setSdgObjects(sdgObjects);

        CaseObject aswanRevolvingFund = new CaseObject();
        aswanRevolvingFund.setCaseTitle("Damas Needs Your Help: Chip In New Water Tunnels For the Village");
        aswanRevolvingFund.setCaseDetails(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        ArrayList<String> goals2 = new ArrayList();
        goals.add("Buy cement");
        goals.add("build construction base");
        goals.add("connect to water link");

        aswanRevolvingFund.setCaseGoals(goals);

        aswanRevolvingFund.setCaseLocation("Quena, Egypt");
        aswanRevolvingFund.setProgressReached(0);
        aswanRevolvingFund.setProgressTarget(10000);

        ArrayList<String> images2 = new ArrayList<>();
        images.add("img1");
        images.add("img2");
        aswanRevolvingFund.setCaseImages(images);

        aswanRevolvingFund.setSdgObjects(sdgObjects);

        cases.add(quenaWaterways);
        cases.add(aswanRevolvingFund);
    }
}
