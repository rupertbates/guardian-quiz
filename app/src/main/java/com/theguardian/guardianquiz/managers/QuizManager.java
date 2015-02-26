package com.theguardian.guardianquiz.managers;

import android.content.Context;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theguardian.guardianquiz.QuizApplication;
import com.theguardian.guardianquiz.model.TopicList;

import java.io.IOException;

public class QuizManager {
    private static ObjectMapper mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    private static TopicList topics;

    public static TopicList getTopics() {
        if (topics == null)
            try {
                topics = mapper.readValue(QuizApplication.appContext.getAssets().open("TopicList.json"), TopicList.class);
            } catch (IOException e) {
                throw new RuntimeException("Couldn't load topics");
            }
        return topics;
    }

    public static void startQuiz(int quizNumber) {

    }


}
