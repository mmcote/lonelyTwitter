package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by mmcote on 2016-09-13.
 */

public interface Tweetable { // interfaces are always named with some -able to show that they have some functionality
    public String getMessage();
    public Date getDate();


}
