package in.codekamp.asynctaskdemo;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by cerebro on 02/09/17.
 */

public class FetchStories extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {

        try {
            URL url = new URL("https://startupbriefs.today/stories");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream stream = connection.getInputStream();

            String data = "";

            int i = stream.read();
            while (i >= 0) {
                data += (char)i;
                i = stream.read();
            }

            Gson g = new Gson();

            StoryResponse res = g.fromJson(data, StoryResponse.class);

            Log.d("codekamp", "" + res.count);
            Log.d("codekamp", "title of 3rd story: " + res.stories.get(2).title);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
