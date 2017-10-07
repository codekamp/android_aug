package in.codekamp.reviewrating;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by cerebro on 05/10/17.
 */

public class AirplaneModeBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("codekamp", "onReceive of AirplaneModeBroadcastReceiver called");
    }
}
