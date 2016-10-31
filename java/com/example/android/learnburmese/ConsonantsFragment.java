package com.example.android.learnburmese;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SherlockHolmes on 2016/9/29.
 */
public class ConsonantsFragment extends Fragment {
    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public ConsonantsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.con_ch1, R.string.con_1,
                R.string.con_word1, R.raw.number_one));
        words.add(new Word(R.string.con_ch2, R.string.con_2,
                R.string.con_word2, R.raw.number_one));
        words.add(new Word(R.string.con_ch3, R.string.con_3,
                R.string.con_word3, R.raw.number_one));
        words.add(new Word(R.string.con_ch4, R.string.con_4,
                R.string.con_word4, R.raw.number_one));
        words.add(new Word(R.string.con_ch5, R.string.con_5,
                R.string.con_word5, R.raw.number_one));
        words.add(new Word(R.string.con_ch6, R.string.con_6,
                R.string.con_word6, R.raw.number_one));
        words.add(new Word(R.string.con_ch7, R.string.con_7,
                R.string.con_word7, R.raw.number_one));
        words.add(new Word(R.string.con_ch8, R.string.con_8,
                R.string.con_word8, R.raw.number_one));
        words.add(new Word(R.string.con_ch9, R.string.con_9,
                R.string.con_word9, R.raw.number_one));
        words.add(new Word(R.string.con_ch10, R.string.con_10,
                R.string.con_word10, R.raw.number_one));
        words.add(new Word(R.string.con_ch11, R.string.con_11,
                R.string.con_word11, R.raw.number_one));
        words.add(new Word(R.string.con_ch12, R.string.con_12,
                R.string.con_word12, R.raw.number_one));
        words.add(new Word(R.string.con_ch13, R.string.con_13,
                R.string.con_word13, R.raw.number_one));
        words.add(new Word(R.string.con_ch14, R.string.con_14,
                R.string.con_word14, R.raw.number_one));
        words.add(new Word(R.string.con_ch15, R.string.con_15,
                R.string.con_word15, R.raw.number_one));
        words.add(new Word(R.string.con_ch16, R.string.con_16,
                R.string.con_word16, R.raw.number_one));
        words.add(new Word(R.string.con_ch17, R.string.con_17,
                R.string.con_word17, R.raw.number_one));
        words.add(new Word(R.string.con_ch18, R.string.con_18,
                R.string.con_word18, R.raw.number_one));
        words.add(new Word(R.string.con_ch19, R.string.con_19,
                R.string.con_word19, R.raw.number_one));
        words.add(new Word(R.string.con_ch20, R.string.con_20,
                R.string.con_word20, R.raw.number_one));
        words.add(new Word(R.string.con_ch21, R.string.con_21,
                R.string.con_word21, R.raw.number_one));
        words.add(new Word(R.string.con_ch22, R.string.con_22,
                R.string.con_word22, R.raw.number_one));
        words.add(new Word(R.string.con_ch23, R.string.con_23,
                R.string.con_word23, R.raw.number_one));
        words.add(new Word(R.string.con_ch24, R.string.con_24,
                R.string.con_word24, R.raw.number_one));
        words.add(new Word(R.string.con_ch25, R.string.con_25,
                R.string.con_word25, R.raw.number_one));
        words.add(new Word(R.string.con_ch26, R.string.con_26,
                R.string.con_word26, R.raw.number_one));
        words.add(new Word(R.string.con_ch27, R.string.con_27,
                R.string.con_word27, R.raw.number_one));
        words.add(new Word(R.string.con_ch28, R.string.con_28,
                R.string.con_word28, R.raw.number_one));
        words.add(new Word(R.string.con_ch29, R.string.con_29,
                R.string.con_word29, R.raw.number_one));
        words.add(new Word(R.string.con_ch30, R.string.con_30,
                R.string.con_word30, R.raw.number_one));
        words.add(new Word(R.string.con_ch31, R.string.con_31,
                R.string.con_word31, R.raw.number_one));
        words.add(new Word(R.string.con_ch32, R.string.con_32,
                R.string.con_word32, R.raw.number_one));
        words.add(new Word(R.string.con_ch33, R.string.con_33,
                R.string.con_word33, R.raw.number_one));



        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_consonants);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);


                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());

                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return rootView;
    }


    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}

