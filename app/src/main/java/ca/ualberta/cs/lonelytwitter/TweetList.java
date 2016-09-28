package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmcote on 2016-09-27.
 */

public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();
    public void add(Tweet tweet) {
        for (int i = 0; i < tweets.size(); i++) {
            if (tweets.get(i).getMessage() == tweet.getMessage() && tweets.get(i).getDate() == tweet.getDate()) {
                throw new IllegalArgumentException();
            }
        }
        tweets.add(tweet);
    }


    public boolean hasTweet(Tweet tweet) {
        for (int i = 0; i < tweets.size(); i++) {
            if (tweets.get(i).equals(tweet)) {
                return true;
            }
        }
        return false;
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public TweetList getTweets() {
        this.sort();
        return this;
    }

    public void delete(Tweet a) {
        tweets.remove(a);
    }

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

    public int getCount() {
        return tweets.size();
    }
}
