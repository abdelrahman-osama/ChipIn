package com.chipin.chipin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class MapActivity extends AppCompatActivity {



    String TAG = "bottomSheet";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        MapViewFragment MapsFragment = new MapViewFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map_container, MapsFragment, "").commit();

    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


}