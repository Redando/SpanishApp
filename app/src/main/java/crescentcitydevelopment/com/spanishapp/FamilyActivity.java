package crescentcitydevelopment.com.spanishapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Redando on 9/27/2016.
 */

public class FamilyActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create arraylist of numbers
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Chris","Cris"));
        words.add(new Word("Eddy","Remolino"));
        words.add(new Word("George","Jorge"));
        words.add(new Word("Glen","La Cañada"));
        words.add(new Word("John","Juan"));
        words.add(new Word("Joseph","José"));
        words.add(new Word("Michael","Miguel"));
        words.add(new Word("Paul","Pablo"));
        words.add(new Word("Richard","Ricardo"));
        words.add(new Word("William","Guillermo"));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
