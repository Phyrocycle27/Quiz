package com.example.quiz.game.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.quiz.R;
import com.example.quiz.game.list.quiz.Quests;
import com.example.quiz.game.list.quiz.TestLauncher;

import java.util.ArrayList;
import java.util.List;

public class ListTests extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_themes);
        recyclerView = findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeData();
        RVAdapter adapter = new RVAdapter(tests);
        recyclerView.setAdapter(adapter);
        intent = new Intent(ListTests.this, TestLauncher.class);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        intent.putExtra("theme", tests.get(position).name);
                        intent.putExtra("length", tests.get(position).length);
                        intent.putExtra("arrayOfQuests", tests.get(position).questsArr);
                        intent.putExtra("arrayOfCorrAnswers", tests.get(position).correctAnswers);
                        startActivity(intent);
                        overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(ListTests.this, "О квесте " + Integer.toString(position),
                                Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }

    class Test {
        String name;
        byte length;
        int imgId;
        int[] questsArr;
        byte[] correctAnswers;

        Test(String name, byte length, int imgId, int[] questsArr, byte[] correctAnswers) {
            this.name = name;
            this.length = length;
            this.imgId = imgId;
            this.questsArr = questsArr;
            this.correctAnswers = correctAnswers;
        }
    }

    private List<Test> tests;

    private void initializeData() {
        tests = new ArrayList<>();
        Quests quests = new Quests();
        /* НОВЫЕ ТЕМЫ КВЕСТОВ ДОБАВЛЯТЬ СЮДА */
        tests.add(new Test(getString(R.string.cosmos_name), quests.getCosmo_length(), R.drawable.cosmos,
                quests.getCosmo_arr(), quests.getCorrectAnswers()));
        tests.add(new Test(getString(R.string.cosmos_name), quests.getCosmo_length(), R.drawable.cosmos,
                quests.getCosmo_arr(), quests.getCorrectAnswers()));
        tests.add(new Test(getString(R.string.cosmos_name), quests.getCosmo_length(), R.drawable.cosmos,
                quests.getCosmo_arr(), quests.getCorrectAnswers()));
        tests.add(new Test(getString(R.string.cosmos_name), quests.getCosmo_length(), R.drawable.cosmos,
                quests.getCosmo_arr(), quests.getCorrectAnswers()));
        tests.add(new Test(getString(R.string.cosmos_name), quests.getCosmo_length(), R.drawable.cosmos,
                quests.getCosmo_arr(), quests.getCorrectAnswers()));
        tests.add(new Test(getString(R.string.cosmos_name), quests.getCosmo_length(), R.drawable.cosmos,
                quests.getCosmo_arr(), quests.getCorrectAnswers()));
        tests.add(new Test(getString(R.string.cosmos_name), quests.getCosmo_length(), R.drawable.cosmos,
                quests.getCosmo_arr(), quests.getCorrectAnswers()));
        /* ********************************* */
    }
}
