package com.theguardian.guardianquiz.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.theguardian.guardianquiz.ButtonBackgrounds;
import com.theguardian.guardianquiz.R;
import com.theguardian.guardianquiz.managers.TypefaceHelper;

import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder>{
    private final List<String> answers;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView textView;

        public ViewHolder(TextView v) {
            super(v);
            textView = v;
            textView.setTypeface(TypefaceHelper.getEgyptBold());
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            textView.setBackgroundDrawable(ButtonBackgrounds.correctAnswer());
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AnswerAdapter(List<String> answers) {
        this.answers = answers;
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
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(answers.get(position));


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return answers.size();
    }
}
