package crescentcitydevelopment.com.spanishapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.name;

/**
 * Created by Redando on 9/28/2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {


    //Customer constructor where context inflates layout file
    public WordAdapter(Activity context, ArrayList<Word> words)
    {
        //Initialize  the ArrayAdapter's internal for the context and the list
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        View listItemView = convertView;
        //Determine if existing view is being reused... If not, inflate view
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Get the work object located at this position in the list
        Word currentWord = getItem(position);

        //Set SpanishTranslation to TextView
        TextView spanishTextView = (TextView) listItemView.findViewById(R.id.spanish_text_view);
        spanishTextView.setText(currentWord.getSpanishTranslation());

        //Set EnglishTranslation to TextView
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        englishTextView.setText(currentWord.getEnglishTranslation());


        //Return list item layout to display
        return listItemView;
    }
}
