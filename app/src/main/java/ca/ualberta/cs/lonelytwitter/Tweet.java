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
 * This class tweet is used to store tweets which are defined by a message and a date.
 *
 * @see NormalTweet
 * @see ImportantTweet
 */
public abstract class Tweet {

    /**
     * Message: is a String that stores the message of the original tweet.
     */
    private String message;

    /**
     * Date: is of date type, that stores the date the tweet was made
     */
    private Date date;

    /**
     * Tweet is the initializer of tweet, it passes the given message to the message
     * variable and creates a new date of the current time to give to the date
     * variable.
     *
     * @param message the message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Tweet is the initializer of tweet, it passes the given message to the message
     * variable and passes a date that the user specifies to give to the date
     * variable.
     *
     * @param message the message
     * @param date    the date
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * isImportant: Is an abstract class that will define if a tweet is important or not
     *
     * @return boolean
     */
    public abstract Boolean isImportant();

    /**
     * setMessage is used to change the variable message to a new tweet message.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * change the date of the Tweet.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * get the message from the Tweet, returned as a String.
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * get the date from the Tweet, returned as a date.
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Change the whole Tweet to a string, date then message.
     * @return date.toString() + " | " + message
     */
    @Override
    public String toString(){
        return  date.toString() + " | " + message;
    }
}
