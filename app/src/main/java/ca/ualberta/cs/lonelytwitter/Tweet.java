package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by mmcote on 2016-09-13.
 */
public abstract class Tweet {
    private String message;
    private Date date;

    public Tweet(String message){
        this.message = message;
    }

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    // method prototype and then all the children classes will be forced to implement this function
    public abstract Boolean isImportant();

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
