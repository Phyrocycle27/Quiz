package com.example.quiz.game.list.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;

public class TestLauncher extends AppCompatActivity {

    private byte length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_quiz);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button startBtn = findViewById(R.id.start);
        final Intent intent = new Intent(getIntent());
        TextView title = findViewById(R.id.title);
        TextView lengthText = findViewById(R.id.length);
        title.setText(new StringBuilder().append(getString(R.string.questIs)).append(" ").
                append(intent.getStringExtra("theme")).toString());
        length = intent.getByteExtra("length",  (byte) 0);
        lengthText.setText(new StringBuilder().append(getString(R.string.questLen)).append(" ").append(length));
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launch = new Intent(TestLauncher.this, Test.class);
                launch.putExtra("length", length);
                launch.putExtra("arrayOfQuests", intent.getIntArrayExtra("arrayOfQuests"));
                launch.putExtra("arrayOfCorrAnswers", intent.getByteArrayExtra("arrayOfCorrAnswers"));
                startActivity(launch);
                overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, new Test().getCountOfCorrAnswrs()+" правильных из "+length, Toast.LENGTH_SHORT).show();
    }
}