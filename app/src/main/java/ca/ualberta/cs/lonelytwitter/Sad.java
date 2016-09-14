package ca.ualberta.cs.lonelytwitter;

/**
 * Created by mmcote on 2016-09-13.
 */
public class Sad extends CurrentMood {

    public Sad(String mood) {
        super(mood);
    }

    @Override
    public String format() {
        return "Really Really Sad!";
    }

}
