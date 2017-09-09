package in.codekamp.reviewrating;

import android.app.Application;
import android.content.Context;

/**
 * Created by cerebro on 09/09/17.
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
    }

    public static Context getAppContext() {
        return context;
    }
}
