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
        words.add(new Word("Chris","Cris",R.drawable.family_chris));
        words.add(new Word("Eddy","Remolino",R.drawable.family_eddy));
        words.add(new Word("George","Jorge",R.drawable.family_george));
        words.add(new Word("Glen","La Cañada",R.drawable.family_glen));
        words.add(new Word("John","Juan",R.drawable.family_john));
        words.add(new Word("Joseph","José",R.drawable.family_joseph));
        words.add(new Word("Michael","Miguel",R.drawable.family_michael));
        words.add(new Word("Paul","Pablo",R.drawable.family_pablo));
        words.add(new Word("Richard","Ricardo",R.drawable.family_richard));
        words.add(new Word("William","Guillermo",R.drawable.family_william));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
