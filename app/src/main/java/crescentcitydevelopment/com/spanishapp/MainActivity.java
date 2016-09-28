package crescentcitydevelopment.com.spanishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the View that shows the number category
        TextView numbers = (TextView) findViewById(R.id.numbers);
        TextView colors = (TextView) findViewById(R.id.colors);
        TextView phrases = (TextView) findViewById(R.id.phrases);
        TextView family = (TextView) findViewById(R.id.family);

        //Set a clicklistener on numbers View
        numbers.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        colors.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });

        family.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(familyIntent);
            }
        });

        phrases.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent phraseIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phraseIntent);
            }
        });
    }


}
