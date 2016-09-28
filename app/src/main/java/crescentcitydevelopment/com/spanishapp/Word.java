package crescentcitydevelopment.com.spanishapp;

/**
 * Created by Redando on 9/28/2016.
 */

public class Word
{
   private String mSpanishTranslation;

   private  String mEnglishTranslation;


    public Word(String spanish, String english)
    {
        this.mSpanishTranslation = spanish;
        this.mEnglishTranslation = english;
    }

    public String getSpanishTranslation() {
        return mSpanishTranslation;
    }

    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }
}
