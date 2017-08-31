package in.codekamp.viewpagerdemo;

import android.app.Application;
import android.util.Log;

/**
 * Created by cerebro on 29/08/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("codekamp", "onCreate of MyApplication called");
    }
}
