package com.theguardian.guardianquiz;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

public class ButtonBackgrounds {
    private static Drawable green;

    public static Drawable correctAnswer(){
        if(green == null)
            green = QuizApplication.appContext.getResources().getDrawable(R.drawable.correct_answer_background);
        return green;
    }

}
