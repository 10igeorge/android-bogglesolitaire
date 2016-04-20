package com.example.guest.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AnswerActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.answerListView) ListView mAnswerListView;
    private static ArrayList<String> mGeneratedCharArray;
    private static ArrayList<String> mAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        ButterKnife.bind(this);




        Intent intent = getIntent();

        ArrayList<String> answers = intent.getStringArrayListExtra("answers");

        ArrayList<String> generatedCharArray = intent.getStringArrayListExtra("generatedCharArray");
        mGeneratedCharArray = generatedCharArray;
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, answers);
        mAnswers = answers;
        mAnswerListView.setAdapter(adapter);


    }


//    public boolean wordChecker(){
//
//        }

}


