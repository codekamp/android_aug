package in.codekamp.reviewrating.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import in.codekamp.reviewrating.MailchimpConnectActivity;
import in.codekamp.reviewrating.MainActivity;
import in.codekamp.reviewrating.SharedPrefs;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i;
        if (SharedPrefs.getApiKey() != null) {
            i = new Intent(this, MainActivity.class);
        } else {
            i = new Intent(this, MailchimpConnectActivity.class);
        }

        startActivity(i);
    }

}