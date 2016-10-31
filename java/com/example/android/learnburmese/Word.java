package com.example.android.learnburmese;

/**
 * Created by SherlockHolmes on 2016/9/29.
 */
public class Word {

    /** String resource ID for the default translation of the word */
    private int mDefaultTranslationId;

    private int mPronounceId;

    /** Audio resource ID for the word */
    private int mAudioResourceId;
    private int mWordResourceId;

//    /** Image resource ID for the word */
//    private int mImageResourceId = NO_IMAGE_PROVIDED;
//
//    /** Constant value that represents no image was provided for this word */
//    private static final int NO_IMAGE_PROVIDED = -1;
//


    public Word(int defaultTranslationId, int pronounceId, int audioResourceId) {
        mDefaultTranslationId = defaultTranslationId;
        mPronounceId = pronounceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Create a new Word object.
     *
     * @param defaultTranslationId is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param miwokTranslationId is the string resource Id for the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     * @param audioResourceId is the resource ID for the audio file associated with this word
     */
    public Word(int defaultTranslationId, int pronounceId, int wordResourceId, int audioResourceId) {
        mDefaultTranslationId = defaultTranslationId;
        mPronounceId = pronounceId;
        mWordResourceId = wordResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the string resource ID for the default translation of the word.
     */
    public int getDefaultTranslationId() {
        return mDefaultTranslationId;
    }

    /**
     * Get the string resource ID for the Miwok translation of the word.
     */
    public int getPronounceId() {
        return mPronounceId;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getWordResourceId() {
        return mWordResourceId;
    }

//    /**
//     * Returns whether or not there is an image for this word.
//     */
//    public boolean hasImage() {
//        return mImageResourceId != NO_IMAGE_PROVIDED;
//    }

    /**
     * Return the audio resource ID of the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}