package com.chipin.chipin.adapters;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.chipin.chipin.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MapCasesAdapter extends ArrayAdapter{


    public MapCasesAdapter(@NonNull Activity context, ArrayList<HashMap> paperName) {
        super(context, R.layout.component_explore_card, paperName);




    }
}
