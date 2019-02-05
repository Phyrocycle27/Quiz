package com.example.quiz.game.list.quiz;

import com.example.quiz.R;

public class Quests {
    int[] cosmo_arr = new int[]{R.array.cosmos_question_1, R.array.cosmos_question_2, R.array.cosmos_question_3,
            R.array.cosmos_question_4, R.array.cosmos_question_5, R.array.cosmos_question_6, R.array.cosmos_question_7,
            R.array.cosmos_question_8, R.array.cosmos_question_9, R.array.cosmos_question_10, R.array.cosmos_question_11,
            R.array.cosmos_question_12, R.array.cosmos_question_13, R.array.cosmos_question_14, R.array.cosmos_question_15};
    byte[] correctAnswers = new byte[]{2, 1, 1, 3, 3, 4, 4, 3, 2, 2, 3, 1, 2, 4, 3};

    public byte getCosmo_length() {
        return (byte) cosmo_arr.length;
    }

    public int[] getCosmo_arr() {
        return cosmo_arr;
    }

    public byte[] getCorrectAnswers() {
        return correctAnswers;
    }
}
