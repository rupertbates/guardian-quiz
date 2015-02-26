package com.theguardian.guardianquiz.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TopicList {
    public final List<QuizTopic> topics;

    @JsonCreator
    public TopicList(@JsonProperty("topics") List<QuizTopic> topics) {
        this.topics = topics;
    }
}
