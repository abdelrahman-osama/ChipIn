package com.chipin.chipin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import butterknife.BindView;

public class MapActivity extends AppCompatActivity {


    @BindView(R.id.bottom_sheet)
    LinearLayout layoutBottomSheet;
    BottomSheetBehavior sheetBehavior;
    String TAG = "bottomSheet";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        MapViewFragment MapsFragment = new MapViewFragment();
        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        getSupportFragmentManager().beginTransaction().replace(R.id.map_container, MapsFragment, "").commit();


    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


}