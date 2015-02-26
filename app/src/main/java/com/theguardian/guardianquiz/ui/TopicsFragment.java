package com.theguardian.guardianquiz.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.theguardian.guardianquiz.R;
import com.theguardian.guardianquiz.model.TopicList;
import com.theguardian.guardianquiz.service.QuizService;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TopicsFragment extends Fragment {
    @InjectView(R.id.topic_list) RecyclerView topicRecyclerView;

    private TopicList topicList;
    private LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            this.topicList = QuizService.getTopics(getActivity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        View rootView = inflater.inflate(R.layout.fragment_topic_list, container, false);
        ButterKnife.inject(this, rootView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        topicRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        topicRecyclerView.setLayoutManager(layoutManager);

        topicRecyclerView.setAdapter(new TopicAdapter(topicList));

        return rootView;
    }
}
