package com.chipin.chipin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.andrefrsousa.superbottomsheet.SuperBottomSheetFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

public class MapActivity extends AppCompatActivity {


    BottomSheetFragment bottomSheetFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MapView MapsFragment = new MapView();
        getSupportFragmentManager().beginTransaction().replace(R.id.map_container, MapsFragment, "").commit();
        bottomSheetFragment = new BottomSheetFragment();


        bottomSheetFragment.showNow(getSupportFragmentManager(), "BottomSheet");
        bottomSheetFragment.setCancelable(false);

//        MapsFragment.getView().setFocusable(true);
//        bottomSheetFragment.setShowsDialog(true);

//        bottomSheetFragment.onAttach(new View.OnAttachStateChangeListener());

    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;

    }





}



class BottomSheetFragment extends SuperBottomSheetFragment{

//    BottomSheetBehavior mBottomSheetBehavior;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view  = inflater.inflate(R.layout.fragment_demo_sheet, container, false);
//        mBottomSheetBehavior = BottomSheetBehavior.from(view.findViewById(R.id.bottom_sheet));
//
//
//        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                // React to state change
//                Log.d("onStateChanged", "onStateChanged:" + newState);
//                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
////                    fab.setVisibility(View.GONE);
//                } else {
//                    if (newState == BottomSheetBehavior.STATE_COLLAPSED){
//                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
//                    }
////                    fab.setVisibility(View.VISIBLE);
//                }
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//                // React to dragging events
//                Log.e("onSlide", "onSlide");
//            }
//        });
//
//        mBottomSheetBehavior.setPeekHeight(100);
        return view;

    }

    @Override
    public float getCornerRadius() {
        return super.getCornerRadius();
    }

    @Override
    public int getStatusBarColor() {
        return super.getStatusBarColor();
    }

    @Override
    public float getDim() {
        return 0.1f;
    }

    @Override
    public int getPeekHeight() {
        return 100;
    }

    @Override
    public boolean isCancelable() {
        return false;
    }
}
