package ca.ualberta.cs.lonelytwitter;

import android.provider.Settings;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.internal.runners.statements.Fail;

import java.util.concurrent.TimeUnit;

/**
 * Created by mmcote on 2016-09-27.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello");
        list.add(tweet);

        assertTrue(list.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello");
        assertFalse(list.hasTweet(tweet));

        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello");
        Tweet b = new NormalTweet("Hi");

        list.add(a);
        list.add(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    public void testDeleteTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello");

        list.add(a);
        assertTrue(list.hasTweet(a));

        list.delete(a);
        assertFalse(list.hasTweet(a));
    }

    public void testAddTweetDuplicate() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello");
        list.add(tweet);

        assertTrue(list.hasTweet(tweet));
        try {
            list.add(tweet);
            fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("NO DUPLICATES");
        }
    }

    public void testGetTweets() {
        TweetList list = new TweetList();

        Tweet tweet1 = new NormalTweet("1");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Tweet tweet2 = new NormalTweet("2");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Tweet tweet3 = new NormalTweet("3");
        list.add(tweet3);
        list.add(tweet1);
        list.add(tweet2);

        TweetList sortedList = list.getTweets();

        assertTrue("Not the same", sortedList.getTweet(0) == tweet1);
        assertTrue("Not the same", sortedList.getTweet(1) == tweet2);
        assertTrue("Not the same", sortedList.getTweet(2) == tweet3);
    }

    public void testGetCount() {
        TweetList list = new TweetList();

        Tweet tweet1 = new NormalTweet("1");

        Tweet tweet2 = new NormalTweet("2");

        Tweet tweet3 = new NormalTweet("3");

        list.add(tweet3);
        list.add(tweet1);
        list.add(tweet2);

        assertTrue(list.getCount() == 3);
    }
}
