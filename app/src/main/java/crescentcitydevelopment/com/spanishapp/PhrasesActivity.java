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

public class PhrasesActivity extends AppCompatActivity {

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
        words.add(new Word("What is your name?","¿Cuál es su nombre?", R.raw.name));
        words.add(new Word("My Name Is","Mi nombre es", R.raw.nameis));
        words.add(new Word("I Love You","Te amo", R.raw.love));
        words.add(new Word("How are you feeling?","¿Como te sientes?", R.raw.feel));
        words.add(new Word("What time is it?","¿Qué hora es?", R.raw.time));
        words.add(new Word("Where are you from?","¿De donde eres?", R.raw.from));
        words.add(new Word("Do you like it here?","¿Te gusta aquí?", R.raw.likeithere));
        words.add(new Word("Where are you going?","¿A dónde vas?", R.raw.going));
        words.add(new Word("What time are you coming?","¿A que hora vienes?", R.raw.coming));
        words.add(new Word("I’m feeling good","Me siento bien", R.raw.feelgood));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

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
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getSoundResourceId());

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
