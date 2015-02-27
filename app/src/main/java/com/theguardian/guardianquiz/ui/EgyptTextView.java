package com.theguardian.guardianquiz.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.theguardian.guardianquiz.managers.TypefaceHelper;

public class EgyptTextView extends TextView {

    public EgyptTextView(Context context) {
        super(context);
        initTypeface(context);
    }

    public EgyptTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeface(context);
    }

    public EgyptTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeface(context);
    }

    public void initTypeface(Context context) {
        if (!isInEditMode()) {
            Typeface typeface = getTypeface();
            if (typeface != null && typeface.getStyle() == Typeface.BOLD) {
                setTypeface(TypefaceHelper.getEgyptBold());
            } else {
                setTypeface(TypefaceHelper.getEgyptRegular());
            }
        }
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        super.setTypeface(tf, style);
        if (isInEditMode())
            return;
        if (style == Typeface.BOLD) {
            super.setTypeface(TypefaceHelper.getEgyptBold());
        } else {
            super.setTypeface(TypefaceHelper.getEgyptRegular());
        }
    }
}
