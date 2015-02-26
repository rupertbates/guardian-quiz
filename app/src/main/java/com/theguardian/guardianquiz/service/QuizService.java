package com.theguardian.guardianquiz.service;

import android.content.Context;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theguardian.guardianquiz.model.TopicList;

import java.io.IOException;

public class QuizService {
    private static ObjectMapper mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public static TopicList getTopics(Context context) throws IOException {
        return mapper.readValue(context.getAssets().open("TopicList.json"), TopicList.class);

    }


}
