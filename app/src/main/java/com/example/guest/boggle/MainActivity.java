package com.example.guest.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mGeneratedCharArray;
    public static final String TAG = MainActivity.class.getSimpleName();
    private String[] vowels = new String[] {"a", "a", "a", "e", "e", "e", "i", "i", "i", "o", "o", "o", "u", "u","u",};
    private String[] consonants = new String[] {"b", "b", "c", "d", "d", "f", "f", "g", "g", "h", "h", "j", "k", "l", "l", "m", "m", "p", "p", "qu", "r", "r", "s", "s", "t", "t", "v", "w", "x", "y", "z"};
    private ArrayList<String> generatedChar = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 6; i++){
            int rando = new Random().nextInt(consonants.length);
            generatedChar.add(consonants[rando]);
            Log.v("consonant", consonants[rando]);
        }
        for (int i = 0; i < 2; i++){
            int rando = new Random().nextInt(vowels.length);
            generatedChar.add(vowels[rando]);
        }

        mGeneratedCharArray = (TextView) findViewById(R.id.generatedCharArray);
        mGeneratedCharArray.setText(generatedChar.toString().replaceAll("\\[*,*]*", ""));
    }
}
