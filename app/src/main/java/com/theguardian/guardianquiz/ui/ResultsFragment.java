package com.theguardian.guardianquiz.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.theguardian.guardianquiz.R;
import com.theguardian.guardianquiz.managers.QuizManager;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ResultsFragment extends Fragment {
    @InjectView(R.id.score_text)
    TextView scoreText;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_results, container, false);
        ButterKnife.inject(this, root);
        scoreText.setText(getScoreText());
        return root;
    }

    private String getScoreText() {
        return QuizManager.getNumberOfCorrectAnswers() + "/" + QuizManager.getTotalNumberOfQuestions();
    }
}
