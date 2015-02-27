package com.theguardian.guardianquiz.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.theguardian.guardianquiz.R;
import com.theguardian.guardianquiz.managers.FlowManager;
import com.theguardian.guardianquiz.managers.QuizManager;
import com.theguardian.guardianquiz.managers.TypefaceHelper;
import com.theguardian.guardianquiz.model.Question;
import com.theguardian.guardianquiz.model.QuizTopic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class QuizFragment extends Fragment implements AnswerAdapter.OnSelectionListener {
    private static final String ARG_TOPIC_NUMBER = "topicNumber";
    private static final String ARG_QUESTION_NUMBER = "questionNumber";
    private int questionNumber;
    private int topicNumber;

    @InjectView(R.id.question_text)
    TextView questionText;
    @InjectView(R.id.answer_list)
    RecyclerView answerList;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment QuizFragment.
     */
    public static QuizFragment newInstance(int topicNumber, int questionNumber) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TOPIC_NUMBER, topicNumber);
        args.putInt(ARG_QUESTION_NUMBER, questionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public QuizFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            topicNumber = getArguments().getInt(ARG_TOPIC_NUMBER);
            questionNumber = getArguments().getInt(ARG_QUESTION_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_quiz, container, false);
        ButterKnife.inject(this, rootView);

        QuizTopic quiz = QuizManager.getTopics().topics.get(topicNumber);
        Question question = quiz.questions.get(questionNumber);
        questionText.setText(question.question);
        answerList.setLayoutManager(new LinearLayoutManager(getActivity()));
        answerList.setAdapter(new AnswerAdapter(question, this));
        return rootView;

    }

    @Override
    public void onAnswerSelected(final String answer) {
        QuizManager.questionAnswered(questionNumber, answer);

    }
}
