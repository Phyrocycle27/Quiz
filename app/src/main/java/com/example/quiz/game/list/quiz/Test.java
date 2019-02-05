package com.example.quiz.game.list.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiz.R;

import java.util.ArrayList;
import java.util.List;

public class Test extends AppCompatActivity implements View.OnClickListener {
    private Button next;
    private TextView currentNum, question;
    private List<Button> buttons;
    private byte currNumOfQuestion = 0, length, arrOfCorrectAnswers[], trueAnswrs;
    private int arrOfQuestions[];
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
    }

    @Override
    protected void onResume() {
        super.onResume();
        next = findViewById(R.id.nextQuestBtn);
        currentNum = findViewById(R.id.questNum);
        question = findViewById(R.id.question);
        buttons = new ArrayList<>();
        buttons.add((Button) findViewById(R.id.answerBtn1));
        buttons.add((Button) findViewById(R.id.answerBtn2));
        buttons.add((Button) findViewById(R.id.answerBtn3));
        buttons.add((Button) findViewById(R.id.answerBtn4));
        for (byte i = 0; i < buttons.size(); i++) buttons.get(i).setOnClickListener(this);
        Intent in = new Intent(getIntent());
        length = in.getByteExtra("length", (byte) 0);
        arrOfQuestions = in.getIntArrayExtra("arrayOfQuests");
        arrOfCorrectAnswers = in.getByteArrayExtra("arrayOfCorrAnswers");
        setQuestion(currNumOfQuestion);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.answerBtn1:
                showCorrectAnswer((byte) 1);
                break;
            case R.id.answerBtn2:
                showCorrectAnswer((byte) 2);
                break;
            case R.id.answerBtn3:
                showCorrectAnswer((byte) 3);
                break;
            case R.id.answerBtn4:
                showCorrectAnswer((byte) 4);
        }
    }

    private void lockBtns(boolean state) {
        for (byte i = 0; i < buttons.size(); i++) buttons.get(i).setClickable(state);
    }

    private void showCorrectAnswer(byte clickedBtnNum) {
        lockBtns(false);
        if (clickedBtnNum != 0) {
            if (clickedBtnNum != arrOfCorrectAnswers[currNumOfQuestion - 1])
                buttons.get(clickedBtnNum - 1).setBackgroundColor(getResources().getColor(R.color.fail));
            else trueAnswrs++;
        }
        buttons.get(arrOfCorrectAnswers[currNumOfQuestion - 1] - 1).setBackgroundColor(getResources().getColor(R.color.succes));
        if (currNumOfQuestion == length) {
            next.setText(getString(R.string.finish));
            currNumOfQuestion++;
        } else next.setText(getString(R.string.nextQuest));
        flag = true;
    }

    private void setQuestion(byte currQuestionNum) {
        String myArr[] = getResources().getStringArray(arrOfQuestions[currQuestionNum]);
        currNumOfQuestion++;
        currentNum.setText(new StringBuilder().append("Вопрос ").append(currNumOfQuestion).append(" из ").
                append(length).toString());
        question.setText(myArr[0]);
        for (byte i = 1; i < myArr.length; i++) {
            buttons.get(i - 1).setText(myArr[i]);
            buttons.get(i - 1).setBackgroundColor(getResources().getColor(R.color.blank));
        }
        flag = false;
        next.setText(getString(R.string.help));
        lockBtns(true);
    }

    public void nextClick(View view) {
        if (currNumOfQuestion <= length) {
            if (flag) setQuestion(currNumOfQuestion);
            else showCorrectAnswer((byte) 0);
        } else finish();
    }

    public byte getCountOfCorrAnswrs() {
        return trueAnswrs;
    }
}
