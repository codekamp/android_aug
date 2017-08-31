package in.codekamp.asynctaskdemo;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by cerebro on 31/08/17.
 */

public class VideoDownloaderService extends IntentService {

    public VideoDownloaderService() {
        super("hello world");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("codekamp", "onCreate called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("codekamp","onStartCommand thread is " + Thread.currentThread().getName());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("codekamp","onHandleIntent thread is " + Thread.currentThread().getName() + " url: " + intent.getStringExtra("video_url"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
