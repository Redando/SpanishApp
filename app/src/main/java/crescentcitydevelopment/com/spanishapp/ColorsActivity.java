package crescentcitydevelopment.com.spanishapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Redando on 9/27/2016.
 */

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create arraylist of colors
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red","Rojo"));
        words.add(new Word("Blue","Azul"));
        words.add(new Word("Green","Verde"));
        words.add(new Word("Orange","Naranja"));
        words.add(new Word("Yellow","Amarillo"));
        words.add(new Word("Purple","Púrpura"));
        words.add(new Word("Black","Negro"));
        words.add(new Word("White","Blanco"));
        words.add(new Word("Grey","Gris"));
        words.add(new Word("Brown","Marrón"));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
