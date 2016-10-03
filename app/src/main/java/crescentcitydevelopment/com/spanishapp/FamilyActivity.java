package crescentcitydevelopment.com.spanishapp;

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

public class FamilyActivity extends AppCompatActivity{

    private MediaPlayer mMediaPlayer;

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

        //Create arraylist of numbers
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Chris","Cris",R.drawable.family_chris, R.raw.chris));
        words.add(new Word("Eddy","Remolino",R.drawable.family_eddy, R.raw.eddy));
        words.add(new Word("George","Jorge",R.drawable.family_george, R.raw.george));
        words.add(new Word("Glen","La Cañada",R.drawable.family_glen, R.raw.glen));
        words.add(new Word("John","Juan",R.drawable.family_john, R.raw.john));
        words.add(new Word("Joseph","José",R.drawable.family_joseph, R.raw.joseph));
        words.add(new Word("Michael","Miguel",R.drawable.family_michael, R.raw.michael));
        words.add(new Word("Paul","Pablo",R.drawable.family_pablo, R.raw.pablo));
        words.add(new Word("Richard","Ricardo",R.drawable.family_richard, R.raw.richard));
        words.add(new Word("William","Guillermo",R.drawable.family_william, R.raw.william));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

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

                // Create and setup the {@link MediaPlayer} for the audio resource associated with
                // the current word
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getSoundResourceId());

                //Start the audio file
                mMediaPlayer.start();

                //Setup a listener on the media player so that we can stop and release the
                //media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompleteListener);
            }
        });
    }

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

        }
    }
}
