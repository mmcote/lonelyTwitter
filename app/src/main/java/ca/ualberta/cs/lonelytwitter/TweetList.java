/*
Copyright © 2016 Michael Cote, CMPUT 301, University of Alberta - All Rights Reserved.
You may use, distribute, and copy all or parts of this code under terms and conditions
of the University of Alberta and the Code of Student Behavior.
You can find a copy of the license http://www.github.com/mmcote/lonelytwitter
For further information, contact myself at mmcote@ualberta.ca
 */
package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmcote on 2016-09-27.
 * This is the TweetList class which holds all of the tweets that have been inputted.
 * This TweetList holds a list of Tweets.
 */
public class TweetList {
    /**
     * The Tweets are stored in this list of tweets.
     *
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Add a tweet to tweetList and ensure the tweet
     * is unique in terms of the message and the date
     *
     * @param tweet the tweet
     */
    public void add(Tweet tweet) {
        for (int i = 0; i < tweets.size(); i++) {
            if (tweets.get(i).getMessage() == tweet.getMessage() && tweets.get(i).getDate() == tweet.getDate()) {
                throw new IllegalArgumentException();
            }
        }
        tweets.add(tweet);
    }


    /**
     * Has tweet boolean, to check whether the tweetList has
     * the specified tweet, requested by the Tweet param.
     *
     * @param tweet the Tweet
     * @return the boolean
     */
    public boolean hasTweet(Tweet tweet) {
        for (int i = 0; i < tweets.size(); i++) {
            if (tweets.get(i).equals(tweet)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets tweet from TweetList, given the integer i it was
     * inputed in.
     *
     * @param i the
     * @return the tweet
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Gets tweets in tweet list in a sorted manner returning the tweetList
     * in a TweetList.
     *
     * @return the tweets
     */
    public TweetList getTweets() {
        this.sort();
        return this;
    }

    /**
     * Delete a Tweet from the tweetList.
     *
     * @param a the a
     */
    public void delete(Tweet a) {
        tweets.remove(a);
    }

    /**
     * Sort the tweetList.
     */
    public void sort() {
        int max; // end of list
        Tweet temp;
        for (int i = tweets.size() - 1; i >= 0; --i) {
            max = i;
            for(int j = 0; j <= i; ++j) {
                if (tweets.get(j).getDate().after(tweets.get(max).getDate())) {
                    max = j;
                }
            }
            temp = tweets.get(i);
            tweets.set(i,tweets.get(max));
            tweets.set(max, temp);
        }
    }

    /**
     * Gets count of the amount of tweets in the TweetList.
     *
     * @return the count
     */
    public int getCount() {
        return tweets.size();
    }
}
