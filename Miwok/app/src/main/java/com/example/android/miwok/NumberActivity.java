package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class NumberActivity extends AppCompatActivity {
    private MediaPlayer mp;

    private AudioManager mAudioManager;

    private Handler mHandler = new Handler();
    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        mediaController.getTransportControls().pause();
                        // Wait 30 seconds before stopping playback
                        mHandler.postDelayed(mDelayedStopRunnable,
                                TimeUnit.SECONDS.toMillis(30));
                    }
                    else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT) {
                        // Pause playback
                    } else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Lower the volume, keep playing
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                    }
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        
        final ArrayList<Word> words = new ArrayList<>();

     //   words.add(new Word("One", "一", R.drawable.));
        words.add(new Word("One", "一",R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two", "二",R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three", "三",R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four", "四",R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five", "五",R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six", "六",R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven", "七",R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight", "八",R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine", "九",R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten", "十",R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
             //   releaseMediaPlayer();
                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mp = MediaPlayer.create(NumberActivity.this, word.getAudioId());
                    mp.start();
                }

            }
        });
    }
}
