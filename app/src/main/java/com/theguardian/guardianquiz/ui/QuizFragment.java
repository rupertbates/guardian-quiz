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
import com.theguardian.guardianquiz.managers.QuizManager;
import com.theguardian.guardianquiz.managers.TypefaceHelper;
import com.theguardian.guardianquiz.model.Question;
import com.theguardian.guardianquiz.model.QuizTopic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class QuizFragment extends Fragment {
    private static final String ARG_TOPIC_NUMBER = "param1";
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
    public static QuizFragment newInstance(int topicNumber) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TOPIC_NUMBER, topicNumber);
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_quiz, container, false);
        ButterKnife.inject(this, rootView);

        questionText.setTypeface(TypefaceHelper.getEgyptBold());
        QuizTopic quiz = QuizManager.getTopics().topics.get(topicNumber);
        Question question = quiz.questions.get(0);
        questionText.setText(question.question);
        answerList.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> answers = new ArrayList<>(question.incorrectAnswers);
        answers.add(question.correctAnswer);
        Collections.shuffle(answers);
        answerList.setAdapter(new AnswerAdapter(answers));
        return rootView;

    }

}
