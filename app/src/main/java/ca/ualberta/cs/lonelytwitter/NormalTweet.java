/*
Copyright © 2016 Michael Cote, CMPUT 301, University of Alberta - All Rights Reserved.
You may use, distribute, and copy all or parts of this code under terms and conditions
of the University of Alberta and the Code of Student Behavior.
You can find a copy of the license http://www.github.com/mmcote/lonelytwitter
For further information, contact myself at mmcote@ualberta.ca
 */
package ca.ualberta.cs.lonelytwitter;

/**
 * Created by watts1 on 9/13/16.
 * This is a subclass of tweet which is used to store tweets which are defined by a message and a date.
 * This class is used for non-important tweets.
 *
 * @see Tweet
 * @see ImportantTweet
 */
public class NormalTweet extends Tweet implements Tweetable {

    /**
     * This constructor makes a normalTweet with given string parameter. This constructor simply
     * calls the constructor of its super class Tweet.
     *
     * @param message this parameter is the given string for the tweet.
     * @see Tweet
     */
    public NormalTweet(String message){
        super(message);
    }

    /**
     * This function tells the user if the tweet is important or not.
     * @return false
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
