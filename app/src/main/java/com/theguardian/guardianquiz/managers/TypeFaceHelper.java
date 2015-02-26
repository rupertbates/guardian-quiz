package com.theguardian.guardianquiz.managers;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;

import com.theguardian.guardianquiz.QuizApplication;
import com.theguardian.guardianquiz.R;

public class TypefaceHelper {

    private static Typeface egyptBold;

    /**
     * Gets a font TypeFace corresponding to a font file
     * @param fontResource resource id of the font file location string
     * @return the title font type face from R.string.title_font
     */
    public static Typeface getTypeface(int fontResource){
        AssetManager assets = QuizApplication.appContext.getAssets();
        Resources resources = QuizApplication.appContext.getResources();
        return Typeface.createFromAsset(assets, resources.getString(fontResource));
    }

    public static Typeface getEgyptBold() {
        if (egyptBold == null) {
            egyptBold = getTypeface(R.string.egyde4med_font);
        }
        return egyptBold;
    }
}
