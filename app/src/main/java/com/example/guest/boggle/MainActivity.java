package com.example.guest.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.generatedCharArray) TextView mGeneratedCharArray;
    @Bind (R.id.editAnswerText) EditText mEditAnswerText;
    @Bind (R.id.answerButton) Button mAnswerButton;

    public static final String TAG = MainActivity.class.getSimpleName();
    private String[] vowels = new String[] {"a", "a", "a", "e", "e", "e", "i", "i", "i", "o", "o", "o", "u", "u","u",};
    private String[] consonants = new String[] {"b", "b", "c", "d", "d", "f", "f", "g", "g", "h", "h", "j", "k", "l", "l", "m", "m", "p", "p", "qu", "r", "r", "s", "s", "t", "t", "v", "w", "x", "y", "z"};
    private ArrayList<String> generatedChar = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        for (int i = 0; i < 6; i++){
            int rando = new Random().nextInt(consonants.length);
            if (generatedChar != null && !generatedChar.contains(i)){
                generatedChar.add(consonants[rando]);
            }
        }

        for (int i = 0; i < 2; i++){
            int rando = new Random().nextInt(vowels.length);
            generatedChar.add(vowels[rando]);
        }

        mGeneratedCharArray.setText(generatedChar.toString().replaceAll("\\[*,*]*", "")); //"\\[*,*]*" = REGEX TO REMOVE BRACKETS AND COMMAS FROM ARRAY

        mAnswerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String answer = mEditAnswerText.getText().toString();
                answers.add(answer);
                Log.v("answers", answers.toString());
            }
        });
    }
}
