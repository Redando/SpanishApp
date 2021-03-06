package crescentcitydevelopment.com.spanishapp;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Redando on 9/28/2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    //Resource ID for background color
    private int mColorResourceId;

    //Customer constructor where context inflates layout file
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId)
    {
        //Initialize  the ArrayAdapter's internal for the context and the list
        super(context, 0, words);
        mColorResourceId = colorResourceId;
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

        //Assign Image to ImageView using ResourseId
        ImageView iconImageView = (ImageView) listItemView.findViewById(R.id.list_item_icon);

        //If Image exists set, populate ImageView & set to "Visible". Else, remove imageView
        if(currentWord.hasImage())
        {
            iconImageView.setImageResource(currentWord.getImageResourceId());
            iconImageView.setVisibility(View.VISIBLE);
        }
        else{
            iconImageView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background of the text container View
        textContainer.setBackgroundColor(color);


        //Return list item layout to display
        return listItemView;
    }
}
