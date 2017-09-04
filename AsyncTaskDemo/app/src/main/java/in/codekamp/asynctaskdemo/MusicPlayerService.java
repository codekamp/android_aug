package in.codekamp.asynctaskdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by cerebro on 02/09/17.
 */

public class MusicPlayerService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MusicPlayerBinder();
    }

    public void onPlayNext() {

    }

    public void onIncVolume() {

    }

    public class MusicPlayerBinder extends Binder {

        public MusicPlayerService getService() {
            return MusicPlayerService.this;
        }
    }
}
