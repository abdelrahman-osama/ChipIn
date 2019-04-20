package com.chipin.chipin.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.chipin.chipin.R;
import com.github.vipulasri.timelineview.TimelineView;

import java.util.ArrayList;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimeLineViewHolder> {

    ArrayList<TimeLineModel> timeline;
    Activity context;
    private String TAG = "RecyclerAdaperTest";
    boolean setDate;

    public TimelineAdapter(ArrayList<TimeLineModel> timeline, Activity context, boolean setDate){
        this.timeline=timeline;
        this.context = context;
        this.setDate = setDate;
    }

    @NonNull
    @Override
    public TimeLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_timeline, null);
        return new TimeLineViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeLineViewHolder holder, int position) {

//        Log.d(TAG, "onBindViewHolder: "+ timeline.get(position).getMessage());
        TimeLineModel timeLineModel = timeline.get(position);

//        if(holder.mTimelineView!=null)
        if(timeLineModel.getOrderStatus() == OrderStatus.ACTIVE){
            Drawable x = ContextCompat.getDrawable(context, R.drawable.ic_marker);
            holder.mTimelineView.setMarker(x);
        }
        if(timeLineModel.getOrderStatus() == OrderStatus.INACTIVE){
            holder.mTimelineView.setMarker(ContextCompat.getDrawable(context,R.drawable.ic_marker_inactive));
        }
        if(timeLineModel.getOrderStatus() == OrderStatus.COMPLETED){
            holder.mTimelineView.setMarker(ContextCompat.getDrawable(context,R.drawable.ic_marker_active));
        }
        holder.title.setText(timeline.get(position).getMessage());

        if(setDate){
            holder.dateLayout.setVisibility(View.VISIBLE);
            holder.date.setText(timeline.get(position).getDate());
        }else{
            holder.dateLayout.setVisibility(View.GONE);
        }

//        timeLineModel.setMessage();
    }


    @Override
    public int getItemCount() {
        return timeline.size();
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position, getItemCount());
    }

    public class TimeLineViewHolder extends RecyclerView.ViewHolder {
        public TimelineView mTimelineView;
        public AppCompatTextView title;
        public AppCompatTextView date;
        public LinearLayout dateLayout;

        public TimeLineViewHolder(View itemView, int viewType) {
            super(itemView);
            mTimelineView = (TimelineView) itemView.findViewById(R.id.timeline);
            title = itemView.findViewById(R.id.text_timeline_title);
            date = itemView.findViewById(R.id.text_timeline_date);
            dateLayout = itemView.findViewById(R.id.layout_timeline_date);
            mTimelineView.initLine(viewType);



        }
    }
}
