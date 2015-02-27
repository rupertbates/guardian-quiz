package com.theguardian.guardianquiz.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.theguardian.guardianquiz.R;
import com.theguardian.guardianquiz.managers.FlowManager;
import com.theguardian.guardianquiz.managers.QuizManager;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ResultsFragment extends Fragment {
    @InjectView(R.id.score_text)
    TextView scoreText;
    @InjectView(R.id.summary_text)
    TextView summaryText;
    @InjectView(R.id.new_topic)
    Button newTopicButton;
    @InjectView(R.id.play_again)
    Button playAgainButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_results, container, false);
        ButterKnife.inject(this, root);
        scoreText.setText(getScoreText());
        summaryText.setText(getSummaryText());
        newTopicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlowManager.gotoTopicList();
            }
        });
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizManager.restartQuiz();
            }
        });
        return root;
    }

    private String getScoreText() {
        return QuizManager.getNumberOfCorrectAnswers() + "/" + QuizManager.getTotalNumberOfQuestions();
    }

    private String getSummaryText(){
        //if user gets 4 or 5 right "Well done! You seem to really know your news."
        // if user gets 3 right "Pretty good. Have another go and see if you can up your score."
        // if user gets 0, 1 or 2 right "Oh dear. You might want to read the stories below to get up to speed."
        switch (QuizManager.getNumberOfCorrectAnswers()){
            case 0:
            case 1:
            case 2:
                return "Oh dear. You might want to read the stories below to get up to speed.";
            case 3:
                return "Pretty good. Have another go and see if you can up your score.";
            default:
                return "Well done! You seem to really know your news.";
        }
    }
}
