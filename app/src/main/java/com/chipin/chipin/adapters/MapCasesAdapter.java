package com.chipin.chipin.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.chipin.chipin.R;
import com.chipin.chipin.view.CaseObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MapCasesAdapter extends PagerAdapter {

    private final ArrayList<CaseObject> caseObjects;

    Activity context;
    LayoutInflater layoutInflater;
    public MapCasesAdapter(@NonNull Activity context, ArrayList<CaseObject> caseObjects) {
        this.context=context;
        this.caseObjects=caseObjects;
        layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return caseObjects.size();
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        if(convertView == null) {
//            LayoutInflater inflater = context.getLayoutInflater();
//            convertView = inflater.inflate(R.layout.component_card_map, null, true);
//        }
//        TextView title = convertView.findViewById(R.id.title);
//        title.setText(caseObjects.get(position).getCaseTitle());
//
//        TextView location = convertView.findViewById(R.id.location);
//        location.setText(caseObjects.get(position).getCaseLocation());
//
//        ProgressBar progressBar = convertView.findViewById(R.id.progressbar);
//        progressBar.setProgress(caseObjects.get(position).getProgressReached());
//        progressBar.setMax(caseObjects.get(position).getProgressTarget());
//
//        TextView progressText = convertView.findViewById(R.id.progress_text);
//        progressText.setText(caseObjects.get(position).getProgressReached() + "/" +caseObjects.get(position).getProgressTarget()+"EGP");
//
//
//        return convertView;
//    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.component_card_map,container,false);

        TextView title = itemView.findViewById(R.id.title);
        title.setText(caseObjects.get(position).getCaseTitle());

        ImageView imageView = itemView.findViewById(R.id.background);

        container.addView(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CaseAdapter", "onClick: card map item was clicked" + position);
            }
        });


        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
