package com.theguardian.guardianquiz.managers;

import android.util.SparseArray;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theguardian.guardianquiz.QuizApplication;
import com.theguardian.guardianquiz.model.QuizTopic;
import com.theguardian.guardianquiz.model.TopicList;

import java.io.IOException;

public class QuizManager {
    private static ObjectMapper mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    private static TopicList topics;
    private static int currentQuizNumber;
    private static QuizTopic currentQuiz;
    private static SparseArray<String> answers;

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
        currentQuizNumber = quizNumber;
        currentQuiz = topics.topics.get(currentQuizNumber);
        answers = new SparseArray<>(4);
        FlowManager.gotoQuiz(quizNumber, 0);
    }


    public static void questionAnswered(int questionNumber, String answer) {
        answers.put(questionNumber, answer);
        if(questionNumber < currentQuiz.questions.size() - 1)
            FlowManager.gotoQuizDelayed(currentQuizNumber, questionNumber + 1);
        else
            FlowManager.gotoResults();
    }

    public static int getNumberOfCorrectAnswers(){
        int correct = 0;
        for (int i = 0; i < answers.size(); i++) {
            String answer = answers.get(i);
            String correctAnswer = currentQuiz.questions.get(i).correctAnswer;
            correct += answer.equals(correctAnswer) ? 1 : 0;
        }
        return correct;
    }

    public static int getTotalNumberOfQuestions(){
        return currentQuiz.questions.size();
    }
}
