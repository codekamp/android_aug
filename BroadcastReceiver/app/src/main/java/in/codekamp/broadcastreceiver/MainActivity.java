package in.codekamp.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    MyReceiver receiver;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.my_web_view);
//        webView.loadUrl("http://abes.ac.in");

        webView.loadData("<h1>Hello world!<h1/><p>I love java<p/>", "text/html", "UTF-8");

        receiver = new MyReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();


        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(receiver);
    }

    public void onAirplaneModeOn() {
        Log.d("codekamp", "onAirplaneModeOn called");

    }

    public void onAirplaneModeOff() {
        Log.d("codekamp", "onAirplaneModeOff called");
    }

    public class MyReceiver extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {
            boolean status = intent.getBooleanExtra("state", true);

            if (status) {
                MainActivity.this.onAirplaneModeOn();
            } else {
                MainActivity.this.onAirplaneModeOff();
            }
        }
    }
}

// Animations
// RxJava
// Oauth
// ConstraintLayout
// ButterKnife, Dagger and Dependency Injection
// WebView
