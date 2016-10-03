package crescentcitydevelopment.com.spanishapp;

/**
 * Created by Redando on 9/28/2016.
 */

public class Word
{
   private String mSpanishTranslation;

   private  String mEnglishTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mSoundResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(String spanish, String english, int soundResourceId)
    {
        this.mSpanishTranslation = spanish;
        this.mEnglishTranslation = english;
        this.mSoundResourceId = soundResourceId;
    }



    public Word(String spanish, String english, int imageResourceId, int soundResourceId)
    {
        this.mSpanishTranslation = spanish;
        this.mEnglishTranslation = english;
        this.mImageResourceId = imageResourceId;
        this.mSoundResourceId = soundResourceId;
    }


    public String getSpanishTranslation() {
        return mSpanishTranslation;
    }

    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }

    public int getImageResourceId() { return mImageResourceId;}

    public int getSoundResourceId() { return mSoundResourceId;}


    //Determine if an image exists
    public boolean hasImage(){

        return mImageResourceId != NO_IMAGE_PROVIDED;

    }
}
