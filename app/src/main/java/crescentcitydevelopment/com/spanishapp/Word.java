package crescentcitydevelopment.com.spanishapp;

/**
 * Created by Redando on 9/28/2016.
 */

public class Word
{
   private String mSpanishTranslation;

   private  String mEnglishTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(String spanish, String english)
    {
        this.mSpanishTranslation = spanish;
        this.mEnglishTranslation = english;
    }

    public Word(String spanish, String english, int imageResourceId)
    {
        this.mSpanishTranslation = spanish;
        this.mEnglishTranslation = english;
        this.mImageResourceId = imageResourceId;
    }

    public String getSpanishTranslation() {
        return mSpanishTranslation;
    }

    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }

    public int getImageResourceId() { return mImageResourceId;}

    //Determine if an image exists
    public boolean hasImage(){

        return mImageResourceId != NO_IMAGE_PROVIDED;

    }
}
