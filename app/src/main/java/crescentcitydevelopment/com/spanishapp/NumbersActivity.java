package crescentcitydevelopment.com.spanishapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Redando on 9/27/2016.
 */

public class NumbersActivity extends AppCompatActivity {

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
        words.add(new Word("One","Uno", R.drawable.number_one, R.raw.one));
        words.add(new Word("Two","Dos", R.drawable.number_two, R.raw.two));
        words.add(new Word("Three","Tres", R.drawable.number_three, R.raw.three));
        words.add(new Word("Four","Cuatro", R.drawable.number_four, R.raw.four));
        words.add(new Word("Five","Cinco", R.drawable.number_five, R.raw.five));
        words.add(new Word("Six","Seis", R.drawable.number_six, R.raw.six));
        words.add(new Word("Seven","Siete", R.drawable.number_seven, R.raw.seven));
        words.add(new Word("Eight","Ocho", R.drawable.number_eight, R.raw.eight));
        words.add(new Word("Nine","Nueve", R.drawable.number_nine, R.raw.nine));
        words.add(new Word("Ten","Diez", R.drawable.number_ten, R.raw.ten));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

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
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getSoundResourceId());

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
