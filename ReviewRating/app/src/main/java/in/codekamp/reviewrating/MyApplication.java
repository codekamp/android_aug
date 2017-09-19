package in.codekamp.reviewrating;

import android.app.Application;
import android.content.Context;

import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by cerebro on 09/09/17.
 */

public class MyApplication extends Application {

    private static final long IMAGE_CACHE_SIZE = 1024 * 1024 * 150;  // 100MB

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        setupPicassoConfig();
    }

    public static Context getAppContext() {
        return context;
    }


    private void setupPicassoConfig() {
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this, IMAGE_CACHE_SIZE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(false);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);
    }
}
