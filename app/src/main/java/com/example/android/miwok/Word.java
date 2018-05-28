package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;
    private int mAudioResourceId;

    private static final int IMAGE_RESOURCE_NUMBER = 0;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public void setDefaultTranslation(String defaultTranslation) {
        mDefaultTranslation = defaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public void setMiwokTranslation(String miwokTranslation) {
        mMiwokTranslation = miwokTranslation;
    }

    public int getImageResource() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != IMAGE_RESOURCE_NUMBER;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    public void setAudioResourceId(int audioResourceId) {
        mAudioResourceId = audioResourceId;
    }
}
