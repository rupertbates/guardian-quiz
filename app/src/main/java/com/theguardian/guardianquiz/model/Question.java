
package com.theguardian.guardianquiz.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Question {

    public final String question;
    public final String correctAnswer;
    public final List<String> incorrectAnswers;

    @JsonCreator
    public Question(@JsonProperty("question") String question,
                    @JsonProperty("correctAnswer") String correctAnswer,
                    @JsonProperty("incorrectAnswers") List<String> incorrectAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }
}
