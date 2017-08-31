package in.codekamp.asynctaskdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        VideoDownloader downloader = new VideoDownloader();
//        downloader.execute("http://youtube.com/xyz", "http://vimeo.com/pqr", "http://something");

        Intent i = new Intent(this, VideoDownloaderService.class);
        i.putExtra("video_url", "http://youtube/xyz");
        startService(i);

        Intent j = new Intent(this, VideoDownloaderService.class);
        j.putExtra("video_url", "http://vimeo.com/pqr");
        startService(j);
    }
}
