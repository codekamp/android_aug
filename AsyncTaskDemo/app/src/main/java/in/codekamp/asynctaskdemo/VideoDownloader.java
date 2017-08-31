package in.codekamp.asynctaskdemo;

import android.os.AsyncTask;
import android.util.Log;

import java.io.File;

/**
 * Created by cerebro on 31/08/17.
 */

public class VideoDownloader extends AsyncTask<String, Integer, File> {


    @Override
    protected File doInBackground(String... params) {
        Log.d("codekamp", "first element: " + params[0]);
        Log.d("codekamp", "second element: " + params[1]);

        Log.d("codekamp","doInBackground thread is " + Thread.currentThread().getName());
        File f = new File("/a/b/c/d");

//        download the file
//        save the downloaded file

//        return the file
        return f;
    }

    @Override
    protected void onPostExecute(File file) {
//        play the downloaded file

        Log.d("codekamp","onPostExecute thread is " + Thread.currentThread().getName());
        Log.d("codekamp","file path is " + file.getPath());
    }
}
