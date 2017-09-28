package in.codekamp.reviewrating.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class BackupService extends Service {
    public BackupService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // code to take backup


        Log.d("codekamp", "taking backup");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
