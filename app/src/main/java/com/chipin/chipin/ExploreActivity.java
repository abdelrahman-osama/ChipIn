package com.chipin.chipin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chipin.chipin.view.CaseObject;
import com.chipin.chipin.view.OrderStatus;
import com.chipin.chipin.view.SDGObject;
import com.chipin.chipin.view.TimeLineModel;
import com.chipin.chipin.view.TimelineAdapter;

import java.util.ArrayList;

public class ExploreActivity extends AppCompatActivity {

    ArrayList<TimeLineModel> timeLineModels;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private TimelineAdapter timelineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        int myCase = -1; // or other values
        if(b != null)
            myCase = b.getInt("case");


        if(myCase == 2){
            ((ImageView)findViewById(R.id.background)).setImageDrawable(ContextCompat.getDrawable(this,R.drawable.image2));
            ((ImageView)findViewById(R.id.badge)).setImageDrawable(ContextCompat.getDrawable(this,R.drawable.gender_equality));
            ((TextView)findViewById(R.id.title)).setText("Help Om Islam Out: Chip In Buying Her the Poultry She Needs");
            ((TextView)findViewById(R.id.details)).setText("Om Islam is a 40 year old mother of six. She decided to help her husband out on the farm and start her own small-scale poultry farm. In order for her to start her business, she needs your help. The money you chip in will be used to buy Om Islam five chickens and three turkeys, and remember; a little goes a long way.");
            ((TextView)findViewById(R.id.location)).setText("Tal Haween, Sharqia");

            ((ImageView)findViewById(R.id.badgeSmall)).setImageDrawable(ContextCompat.getDrawable(this,R.drawable.gender_equality));
            ((TextView)findViewById(R.id.badge_title)).setText("GOAL 5");
            ((TextView)findViewById(R.id.badge_type)).setText("Achieve gender equality and empower all women and girls");
            ((TextView)findViewById(R.id.badge_desc1)).setText("Globally, women are just 13 per cent of agricultural land holders. ");
            ((TextView)findViewById(R.id.badge_desc2)).setText("Gender equality is not only a fundamental human right, but a necessary foundation for a peaceful, prosperous and sustainable world. If women farmers had the same access to resources as men, the number of hungry in the world could be reduced by up to 150 million.");

        }
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        seed();

        findViewById(R.id.chipin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExploreActivity.this, PaymentActivity.class));
            }
        });

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
        quenaWaterways.setCaseTitle("Quena Waterway Project");
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

        ArrayList<SDGObject> sdgObjects = new ArrayList<>();
        sdgObjects.add(zeroHunger);

        quenaWaterways.setSdgObjects(sdgObjects);

        CaseObject aswanRevolvingFund = new CaseObject();
        aswanRevolvingFund.setCaseTitle("Quena Waterway Project");
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

        // ---------------------
        timeLineModels = new ArrayList<>();

        timeLineModels.add(new TimeLineModel("Start donations", OrderStatus.COMPLETED, "04 Apr, 2019"));
        timeLineModels.add(new TimeLineModel("Done donations", OrderStatus.COMPLETED, "07 Apr, 2019"));
        timeLineModels.add(new TimeLineModel("Start project", OrderStatus.ACTIVE, "22 Apr, 2019"));
        timeLineModels.add(new TimeLineModel("Done project", OrderStatus.ACTIVE, "05 May, 2019"));

        timelineAdapter = new TimelineAdapter(timeLineModels, this, false);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(timelineAdapter);
        timelineAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
