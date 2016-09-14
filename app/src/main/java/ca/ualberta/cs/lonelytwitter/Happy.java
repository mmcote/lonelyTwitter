package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by mmcote on 2016-09-13.
 */
public class Happy extends CurrentMood {

    public Happy(String mood) {
        super(mood);
    }

    public Happy(String mood, Date date){
        super(mood,date);
    }

    @Override
    public String format() {
        return "Really Really Happy!";
    }

}
