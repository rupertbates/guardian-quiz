package com.theguardian.guardianquiz.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.theguardian.guardianquiz.R;
import com.theguardian.guardianquiz.managers.TypefaceHelper;
import com.theguardian.guardianquiz.model.TopicList;
import com.theguardian.guardianquiz.managers.FlowManager;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {
    private final TopicList topicList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;

        public ViewHolder(TextView v) {
            super(v);
            textView = v;
            textView.setTypeface(TypefaceHelper.getEgyptBold());
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TopicAdapter(TopicList topicList) {
        this.topicList = topicList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TopicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.topic_text_view, parent, false);


        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(topicList.topics.get(position).topic);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlowManager.gotoQuiz(position, 0);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return topicList.topics.size();
    }
}
