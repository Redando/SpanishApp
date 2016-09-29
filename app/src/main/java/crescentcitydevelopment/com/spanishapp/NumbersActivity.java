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
        words.add(new Word("One","Uno", R.drawable.number_one));
        words.add(new Word("Two","Dos", R.drawable.number_two));
        words.add(new Word("Three","Tres", R.drawable.number_three));
        words.add(new Word("Four","Cuatro", R.drawable.number_four));
        words.add(new Word("Five","Cinco", R.drawable.number_five));
        words.add(new Word("Six","Seis", R.drawable.number_six));
        words.add(new Word("Seven","Siete", R.drawable.number_seven));
        words.add(new Word("Eight","Ocho", R.drawable.number_eight));
        words.add(new Word("Nine","Nueve", R.drawable.number_nine));
        words.add(new Word("Ten","Diez", R.drawable.number_ten));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


    }


}
