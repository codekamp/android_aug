package in.codekamp.asynctaskdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    MusicPlayerService mpService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FetchStories stories = new FetchStories();
        stories.execute();

//        VideoDownloader downloader = new VideoDownloader();
//        downloader.execute("http://youtube.com/xyz", "http://vimeo.com/pqr", "http://something");

//        Intent i = new Intent(this, VideoDownloaderService.class);
//        i.putExtra("video_url", "http://youtube/xyz");
//        startService(i);
//
//        Intent j = new Intent(this, VideoDownloaderService.class);
//        j.putExtra("video_url", "http://vimeo.com/pqr");
//        startService(j);
//
//        Intent i = new Intent(this, MusicPlayerService.class);
//
//        bindService(i, this, 0);





    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        if(name.getClass().equals(MusicPlayerService.class)) {
            MusicPlayerService.MusicPlayerBinder binder = (MusicPlayerService.MusicPlayerBinder) service;
            mpService = binder.getService();
        } else if (name.getClass().equals(VideoDownloaderService.class)) {

        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    public void onVolumeUpPressed() {
        mpService.onIncVolume();
    }
}
