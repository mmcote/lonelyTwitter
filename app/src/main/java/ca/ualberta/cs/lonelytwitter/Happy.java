package ca.ualberta.cs.lonelytwitter;

/**
 * Created by mmcote on 2016-09-13.
 */
public class Happy extends CurrentMood {

    public Happy(String mood) {
        super(mood);
    }

    @Override
    public String format() {
        return "Really Really Happy!";
    }

}
