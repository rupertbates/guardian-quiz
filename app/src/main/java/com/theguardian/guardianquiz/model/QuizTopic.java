
package com.theguardian.guardianquiz.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuizTopic {

    public final Integer id;
    public final String topic;
    public final List<Question> questions;
    public final List<Integer> relatedTopics;

    @JsonCreator
    public QuizTopic(@JsonProperty("id") Integer id,
                     @JsonProperty("topic") String topic,
                     @JsonProperty("questions") List<Question> questions,
                     @JsonProperty("relatedTopics") List<Integer> relatedTopics) {
        this.id = id;
        this.topic = topic;
        this.questions = questions;
        this.relatedTopics = relatedTopics;
    }
}
