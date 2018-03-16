package com.example.android.courtcount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void threePointA(View v) {
        scoreA += 3;
        displayA(scoreA);
    }

    public void twoPointA(View v) {
        scoreA += 2;
        displayA(scoreA);
    }

    public void freeThrowA(View v){
        scoreA += 1;
        displayA(scoreA);
    }

    public void threePointB(View v) {
        scoreB += 3;
        displayB(scoreB);
    }

    public void twoPointB(View v) {
        scoreB += 2;
        displayB(scoreB);
    }

    public void freeThrowB(View v){
        scoreB += 1;
        displayB(scoreB);
    }

    public void reset(View v){
        scoreA = 0;
        displayA(scoreA);
        scoreB = 0;
        displayB(scoreB);
    }

    private void displayA(int number) {
        TextView scoreText = findViewById(R.id.score_a_text);
        scoreText.setText(String.valueOf(number));
    }
    private void displayB(int number) {
        TextView scoreText = findViewById(R.id.score_b_text);
        scoreText.setText(String.valueOf(number));
    }

}
