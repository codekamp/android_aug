package in.codekamp.reviewrating;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import in.codekamp.reviewrating.responses.AllListsResponse;
import in.codekamp.reviewrating.services.MailchimpServiceBuilder;

/**
 * Created by cerebro on 07/09/17.
 */

public class GetListsAsync extends AsyncTask<Void, Void, Void> {

    public static final String API_KEY = "YOUR_KEY_HERE";

    @Override
    protected Void doInBackground(Void... params) {

        try {
            AllListsResponse r1 = MailchimpServiceBuilder.build()
                    .getAllLists().execute().body();

            Log.d("codekamp", r1.lists.get(2).title);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
