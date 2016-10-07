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
 * This class is used for important tweets.
 *
 * @see Tweet
 * @see NormalTweet
 */
public class ImportantTweet extends Tweet {

    /**
     * ImportantTweet constructor, the class has no parameters of its own, therefore it is just
     * calling the constructor of its super class Tweet.
     *
     * @param message Sent to Tweet's constructor to create the important tweet.
     * @see Tweet
     */
    public ImportantTweet(String message){
        super(message);
    }

    /**
     * This function tells the user if the tweet is important or not.
     * @return true
     */
    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}
