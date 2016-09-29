package crescentcitydevelopment.com.spanishapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Redando on 9/27/2016.
 */

public class PhrasesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create arraylist of numbers
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("What is your name?","¿Cuál es su nombre?"));
        words.add(new Word("My Name Is","Mi nombre es"));
        words.add(new Word("I Love You","Te amo"));
        words.add(new Word("How are you feeling?","¿Como te sientes?"));
        words.add(new Word("What time is it?","¿Qué hora es?"));
        words.add(new Word("Where are you from?","¿De donde eres?"));
        words.add(new Word("Do you like it here?","¿Te gusta aquí?"));
        words.add(new Word("Where are you going?","¿A dónde vas?"));
        words.add(new Word("What time are you coming?","¿A que hora vienes?"));
        words.add(new Word("I’m feeling good","Me siento bien"));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
