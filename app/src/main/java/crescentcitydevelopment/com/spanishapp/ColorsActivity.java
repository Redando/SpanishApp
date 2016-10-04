package crescentcitydevelopment.com.spanishapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Redando on 9/27/2016.
 */

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    //Handle audio focus when playing a sound focus
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener(){
                public void onAudioFocusChange(int focusChange){
                    if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                        // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio
                        // focus for a short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK
                        // case means that our app is allowed to continue playing sound but at a
                        // lower volume. Both case will be treated the same way since the app plays
                        // short sound files.
                        //Pause playback
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                        //The AUDIOFOCUS_GAIN case means we have regained focus
                        // and can resume playback
                        mMediaPlayer.start();
                    }else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){

                        // The AUDIOFOCUS_LOSS case means we've lost audio focus
                        // and stop playback and cleanup resources
                        releaseMediaPlayer();
                    }
                }
            };


    private MediaPlayer.OnCompletionListener mCompleteListener = new MediaPlayer.OnCompletionListener(){

        @Override
        public void onCompletion(MediaPlayer mediaPlayer)
        {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        //Create arraylist of colors
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red", "Rojo", R.drawable.color_red, R.raw.red));
        words.add(new Word("Green", "Verde", R.drawable.color_green, R.raw.green));
        words.add(new Word("Yellow", "Amarillo", R.drawable.color_mustard_yellow, R.raw.yellow));
        words.add(new Word("Black", "Negro", R.drawable.color_black, R.raw.black));
        words.add(new Word("White", "Blanco", R.drawable.color_white, R.raw.white));
        words.add(new Word("Grey", "Gris", R.drawable.color_gray, R.raw.grey));
        words.add(new Word("Brown", "Marrón", R.drawable.color_brown, R.raw.brown));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Release the media player if it currently exists because a different sound
                //file is about to be played.
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                //Release the media player if it currently exists because a different sound
                //file is about to be played.
                releaseMediaPlayer();


                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,

                        //Use the music stream.
                        AudioManager.STREAM_MUSIC,

                        //Request Permanent focus
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){

                    // Create and setup the {@link MediaPlayer} for the audio resource associated with
                    // the current word
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getSoundResourceId());

                    //Start the audio file
                    mMediaPlayer.start();

                    //Setup a listener on the media player so that we can stop and release the
                    //media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener(mCompleteListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        //When the activity is stopped, release the media player resources.
        releaseMediaPlayer();
    }

    //Clean up the media player by releasing its resources
    private void releaseMediaPlayer(){

        //If the medial player is not null, then it may be currently playing a sound.
        if(mMediaPlayer!= null){

            //Regardless of the current state of the media player, release its resources
            //because it is no longer needed.
            mMediaPlayer.release();

            //Set the medial player back to null.
            //For this application, setting the media player to null is an easy way to tell that
            //the media player is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            //Abandon audio focus when playback complete
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);

        }
    }


}
