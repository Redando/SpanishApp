package crescentcitydevelopment.com.spanishapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        //Create arraylist of numbers
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One","Uno"));
        words.add(new Word("Two","Dos"));
        words.add(new Word("Three","Tres"));
        words.add(new Word("Four","Cuatro"));
        words.add(new Word("Five","Cinco"));
        words.add(new Word("Six","Seis"));
        words.add(new Word("Seven","Siete"));
        words.add(new Word("Eight","Ocho"));
        words.add(new Word("Nine","Nueve"));
        words.add(new Word("Ten","Diez"));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


    }


}
