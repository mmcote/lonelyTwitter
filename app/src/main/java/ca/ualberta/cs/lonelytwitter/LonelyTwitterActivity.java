/*
Copyright © 2016 Team 7, CMPUT 301, University of Alberta - All Rights Reserved.
You may use, distribute, and copy all or parts of this code under terms and conditions
of the University of Alberta and the Code of Student Behavior.
You can find a copy of the license http://www.github.com/mmcote/lonelytwitter
For further information, contact myself at mmcote@ualberta.ca
 */
package ca.ualberta.cs.lonelytwitter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * <p>This is the main view class of LonelyTwitter project. It handles all
 * user interactions as well as file manipulations.</p>
 * <pre> All the files are stored in the form of "json" files stored in Emulator accessible Android Device Monitor.</pre>
 *
 * @author Michael Cote
 * @see Tweet
 * @since 1.0
 */
public class LonelyTwitterActivity extends Activity {

    /**
     * This is the final name that is being saved / loaded and contains all the tweets.
     * @see #loadFromFile()
     * @see #saveInFile()
     */
	private static final String FILENAME = "file.sav";
	/**
	 * This is the EditText where the user will imput the tweet message.
	 * @see Tweet
	 */
	private EditText bodyText;
	/**
	 * This is the ListView where the tweets are presented in a list format in the UI.
	 */
	private ListView oldTweetsList;
	/**
	 * This is where the loaded tweets are stored in when the activity is loaded
	 */
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	/**
	 * This is the adapter where the current data in the UI list are currently stored, and this
     * will be updated as the user updates more tweets.
	 */
	private ArrayAdapter<Tweet> adapter;

	/**
     * Called when the activity is first created.
     */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet newTweet = new NormalTweet(text);

				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();

                saveInFile();
			}
		});

        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);

                tweetList.clear();
                adapter.notifyDataSetChanged();

                saveInFile();
            }
        });
	}

    /**
     * Called when the user returns to the screen from another activity.
     */
    @Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
        loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * This method loads the tweets from FILENAME (file.sav), and stores them into
     * the tweetlist.
     * @see TweetList
     * @throws FileNotFoundException
     * @exception RuntimeException
     */
    private void loadFromFile() {
        try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            Type listtype = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

            tweetList = gson.fromJson(in,listtype);
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
    }

    /**
     * This method saves the tweets from tweetList, and stores them into
     * the FILENAME (file.sav).
     * @see TweetList
     * @throws FileNotFoundException
     * @exception RuntimeException
     */
	private void saveInFile() {
		try {
			// https://developer.android.com/reference/android/content/Context.html#openFileOutput(java.lang.String,%20int)
			// openFileOutput(/*The name of the file to open (String)*/, /*Operating mode (Int)*/);
			FileOutputStream fos = openFileOutput(FILENAME, 0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
			gson.toJson(tweetList, out);
            out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
            throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}