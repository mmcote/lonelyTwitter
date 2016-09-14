package ca.ualberta.cs.lonelytwitter;

/**
 * Created by mmcote on 2016-09-13.
 */
public class NormalTweet extends Tweet implements Tweetable{ // able to implement multiple interfaces but cannot extend more than one class
    public NormalTweet(String message){
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }


}
