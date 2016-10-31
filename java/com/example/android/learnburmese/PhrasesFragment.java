package com.example.android.learnburmese;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SherlockHolmes on 2016/9/29.
 */
public class PhrasesFragment extends Fragment {

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

    public PhrasesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.phrase_ch_hi,
                R.string.phrase_hi, R.raw.phrase_are_you_coming));
        words.add(new Word(R.string.phrase_ch_greet,
                R.string.phrase_greet, R.raw.phrase_are_you_coming));
        words.add(new Word(R.string.phrase_ch_thanks,
                R.string.phrase_thanks, R.raw.phrase_what_is_your_name));
        words.add(new Word(R.string.phrase_ch_name,
                R.string.phrase_name, R.raw.phrase_my_name_is));
        words.add(new Word(R.string.phrase_ch_mname,
                R.string.phrase_mname, R.raw.phrase_how_are_you_feeling));
        words.add(new Word(R.string.phrase_ch_fname,
                R.string.phrase_fname, R.raw.phrase_im_feeling_good));
        words.add(new Word(R.string.phrase_ch_welcome,
                R.string.phrase_welcome, R.raw.phrase_are_you_coming));
        words.add(new Word(R.string.phrase_ch_from,
                R.string.phrase_from, R.raw.phrase_yes_im_coming));
        words.add(new Word(R.string.phrase_ch_froms,
                R.string.phrase_froms, R.raw.phrase_im_coming));
        words.add(new Word(R.string.phrase_ch_meet,
                R.string.phrase_meet, R.raw.phrase_lets_go));
        words.add(new Word(R.string.phrase_ch_bye,
                R.string.phrase_bye, R.raw.phrase_come_here));
        words.add(new Word(R.string.phrase_ch_unders,
                R.string.phrase_unders, R.raw.phrase_come_here));
        words.add(new Word(R.string.phrase_ch_disunders,
                R.string.phrase_disunders, R.raw.phrase_come_here));
        words.add(new Word(R.string.phrase_ch_yes,
                R.string.phrase_yes, R.raw.phrase_lets_go));
        words.add(new Word(R.string.phrase_ch_know,
                R.string.phrase_know, R.raw.phrase_come_here));
        words.add(new Word(R.string.phrase_ch_again,
                R.string.phrase_again, R.raw.phrase_come_here));
        words.add(new Word(R.string.phrase_ch_eng,
                R.string.phrase_eng, R.raw.phrase_come_here));



        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
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
