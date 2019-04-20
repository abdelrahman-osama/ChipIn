package com.chipin.chipin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.chipin.chipin.view.OrderStatus;
import com.chipin.chipin.view.TimeLineModel;
import com.chipin.chipin.view.TimelineAdapter;

import java.util.ArrayList;

public class PreviousDonations extends AppCompatActivity {
    ArrayList<TimeLineModel> timeLineModels;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private TimelineAdapter timelineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_donations);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        timeLineModels = new ArrayList<>();

        timeLineModels.add(new TimeLineModel("Start donations", OrderStatus.COMPLETED, "04 Apr, 2019"));
        timeLineModels.add(new TimeLineModel("Done donations", OrderStatus.COMPLETED, "07 Apr, 2019"));
        timeLineModels.add(new TimeLineModel("Start project", OrderStatus.ACTIVE, "22 Apr, 2019"));
        timeLineModels.add(new TimeLineModel("Done project", OrderStatus.ACTIVE, "05 May, 2019"));
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        timelineAdapter = new TimelineAdapter(timeLineModels, this, true);
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
