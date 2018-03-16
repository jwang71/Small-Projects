package com.example.android.miwok;

/**
 * Created by 77 on 12/31/17.
 */

public class Word {

    private String englishWord;
    private String miwokWord;

    private int imgResourceId;
    private int audioId;

    public Word(String englishWord, String miwokWord, int imgResourceId, int audioId) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
        this.imgResourceId = imgResourceId;
        this.audioId = audioId;
    }

    public Word(String englishWord, String miwokWord, int imgResourceId) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
        this.imgResourceId = imgResourceId;
    }
    public Word(String englishWord, String miwokWord) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    public int getAudioId() {return audioId; }
}
