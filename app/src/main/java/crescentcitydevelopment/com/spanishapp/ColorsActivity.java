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
        words.add(new Word("Red","Rojo", R.drawable.color_red));
        words.add(new Word("Green","Verde",R.drawable.color_green));
        words.add(new Word("Yellow","Amarillo",R.drawable.color_mustard_yellow));
        words.add(new Word("Black","Negro",R.drawable.color_black));
        words.add(new Word("White","Blanco",R.drawable.color_white));
        words.add(new Word("Grey","Gris",R.drawable.color_gray));
        words.add(new Word("Brown","Marrón", R.drawable.color_brown));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
