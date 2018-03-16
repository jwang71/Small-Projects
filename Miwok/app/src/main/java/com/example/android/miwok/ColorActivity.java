package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        ArrayList<Word> words = new ArrayList<>();

        //   words.add(new Word("One", "一", R.drawable.));
        words.add(new Word("Red", "红色",R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Mustard Yellow", "芥末黄",R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Word("Yellow", "黄色",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("Green", "绿色",R.drawable.color_green, R.raw.color_green));
        words.add(new Word("White", "白色",R.drawable.color_white, R.raw.color_white));
        words.add(new Word("Black", "黑色",R.drawable.color_black, R.raw.color_black));
        words.add(new Word("Brown", "棕色",R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Grey", "灰色",R.drawable.color_gray, R.raw.color_gray));



        //words.add(new Word("Purple", "紫色",R.drawable.purple));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.color_list);

        listView.setAdapter(adapter);
    }
}
