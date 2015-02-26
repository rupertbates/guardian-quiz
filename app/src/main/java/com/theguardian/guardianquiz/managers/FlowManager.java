package com.theguardian.guardianquiz.managers;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.theguardian.guardianquiz.R;
import com.theguardian.guardianquiz.ui.QuizFragment;
import com.theguardian.guardianquiz.ui.TopicsFragment;

public class FlowManager {
    private static FragmentManager fragmentManager;

    public static void setFragmentManager(FragmentManager supportFragmentManager) {
        fragmentManager = supportFragmentManager;
    }

    public static void gotoTopicList() {
        fragmentManager.beginTransaction()
                .add(R.id.container, new TopicsFragment())
                .commit();
    }

    public static void gotoQuiz(int quizNumber, int questionNumber) {
        QuizFragment fragment = QuizFragment.newInstance(quizNumber, questionNumber);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left, R.anim.slide_from_left, R.anim.slide_to_right);
        ft.replace(R.id.container, fragment);
        ft.addToBackStack(null);
        ft.commit();

    }
}
