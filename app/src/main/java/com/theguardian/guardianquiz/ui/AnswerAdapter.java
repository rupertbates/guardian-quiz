package com.theguardian.guardianquiz.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.theguardian.guardianquiz.ButtonBackgrounds;
import com.theguardian.guardianquiz.R;
import com.theguardian.guardianquiz.managers.QuizManager;
import com.theguardian.guardianquiz.managers.TypefaceHelper;
import com.theguardian.guardianquiz.model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {
    private final List<String> answers;
    private final Question question;
    private OnSelectionListener listener;
    private String selected;

    public interface OnSelectionListener{
        public void onAnswerSelected(String answer);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;

        public ViewHolder(TextView v) {
            super(v);
            textView = v;
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AnswerAdapter(Question question, OnSelectionListener listener) {
        this.question = question;
        this.listener = listener;
        answers = new ArrayList<>(question.incorrectAnswers);
        answers.add(question.correctAnswer);
        Collections.shuffle(answers);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AnswerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.answer_text_view, parent, false);

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String answer = answers.get(position);
        holder.textView.setText(answer);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = answer;
                listener.onAnswerSelected(answer);
                notifyDataSetChanged();
            }
        });

        if (selected != null && question.correctAnswer.equals(answer))
            holder.textView.setBackgroundDrawable(ButtonBackgrounds.correctAnswer());
        else if (selected != null && selected.equals(answer))
            holder.textView.setBackgroundDrawable(ButtonBackgrounds.incorrectAnswer());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return answers.size();
    }
}
