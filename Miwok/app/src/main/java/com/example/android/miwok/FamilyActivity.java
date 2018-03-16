package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> words = new ArrayList<>();

        //   words.add(new Word("One", "一", R.drawable.));
        words.add(new Word("Father", "爸爸",R.drawable.family_father, R.raw.family_father));
        words.add(new Word("Mother", "妈妈",R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("Son", "儿子",R.drawable.family_son, R.raw.family_son));
        words.add(new Word("Daughter", "女儿",R.drawable.family_older_sister, R.raw.family_daughter));
        words.add(new Word("Grandmother", "奶奶/姥姥",R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("Grandfather", "爷爷/姥爷",R.drawable.family_grandfather, R.raw.family_grandfather));
        words.add(new Word("Aunt", "阿姨",R.drawable.family_daughter, R.raw.family_older_sister));
        words.add(new Word("Uncle", "叔叔",R.drawable.family_older_brother, R.raw.family_younger_brother));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.family_list);

        listView.setAdapter(adapter);
    }
}
