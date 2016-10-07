/*
Copyright © 2016 Michael Cote, CMPUT 301, University of Alberta - All Rights Reserved.
You may use, distribute, and copy all or parts of this code under terms and conditions
of the University of Alberta and the Code of Student Behavior.
You can find a copy of the license http://www.github.com/mmcote/lonelytwitter
For further information, contact myself at mmcote@ualberta.ca
 */
package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by watts1 on 9/13/16.
 * This is a interface that is used to specify which fields if a
 * class wants to be "Tweetable.
 */
public interface Tweetable {
    /**
     * Gets message. Tells the implementee to
     * create a method to get the message from the
     * specific-type-tweet.
     *
     * @return the message
     */
    public String getMessage();

    /**
     * Gets date. Tells the implementee to
     * create a method to get the date from the
     * specific-type-tweet.
     *
     * @return the date
     */
    public Date getDate();
}
