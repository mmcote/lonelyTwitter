package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by mmcote on 2016-09-13.
 */
public abstract class CurrentMood {
    private Date date;
    private String mood;

    public CurrentMood(String mood){
        this.mood = mood;
        this.date = new Date();
    }

    public abstract String format();

    public Date getDate() {
        return date;
    }

    public void setDate(){
        this.date = new Date();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
