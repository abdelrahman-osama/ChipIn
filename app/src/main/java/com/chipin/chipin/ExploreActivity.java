package com.chipin.chipin;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        seed();

    }


    public void seed(){
        SDGObject zeroHunger = new SDGObject();
        zeroHunger.setSdgTitle("Zero Hunger");
        zeroHunger.setSdgDetails("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ac tortor dignissim convallis aenean et tortor at risus. Auctor neque vitae tempus quam pellentesque. Turpis cursus in hac habitasse platea dictumst quisque sagittis purus. In eu mi bibendum neque egestas.");
        zeroHunger.setSdgImage("url");

        SDGObject womenEmpowerment = new SDGObject();
        womenEmpowerment.setSdgTitle("Women Empowerment");
        womenEmpowerment.setSdgDetails("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ac tortor dignissim convallis aenean et tortor at risus. Auctor neque vitae tempus quam pellentesque. Turpis cursus in hac habitasse platea dictumst quisque sagittis purus. In eu mi bibendum neque egestas.");
        womenEmpowerment.setSdgImage("url");

        CaseObject quenaWaterways = new CaseObject();
        quenaWaterways.setCaseTitle("Quena Waterway Project");
        quenaWaterways.setCaseDetails("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

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
        aswanRevolvingFund.setCaseDetails("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

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



        //---------------------
        timeLineModels = new ArrayList<>();

        timeLineModels.add(new TimeLineModel("Start donations", OrderStatus.COMPLETED, "24/1"));
        timeLineModels.add(new TimeLineModel("Done donations", OrderStatus.COMPLETED, "24/2"));
        timeLineModels.add(new TimeLineModel("Start project", OrderStatus.ACTIVE, "22/3"));
        timeLineModels.add(new TimeLineModel("Done project", OrderStatus.INACTIVE, "22/4"));

        timelineAdapter = new TimelineAdapter(timeLineModels, this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(timelineAdapter);
        timelineAdapter.notifyDataSetChanged();

    }
}
