package com.example.quiz.game.list;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quiz.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.QuizViewHolder> {

    private List<ListTests.Test> tests;

        RVAdapter(List<ListTests.Test> tests) {
        this.tests = tests;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new QuizViewHolder(v);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder quizViewHolder, int i) {
        quizViewHolder.quizName.setText(tests.get(i).name);
        quizViewHolder.quizLength.setText(Byte.toString(tests.get(i).length) + " Вопросов");
        quizViewHolder.quizPhoto.setImageResource(tests.get(i).imgId);
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView quizName;
        TextView quizLength;
        ImageView quizPhoto;

        QuizViewHolder(final View itemView) {
            super(itemView);
            quizName = itemView.findViewById(R.id.quiz_name);
            quizLength = itemView.findViewById(R.id.quiz_length);
            quizPhoto = itemView.findViewById(R.id.quiz_photo);
        }
    }
}
