package in.codekamp.reviewrating.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import in.codekamp.reviewrating.MailchimpConnectActivity;
import in.codekamp.reviewrating.MainActivity;
import in.codekamp.reviewrating.SharedPrefs;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        Intent i;
        if (currentUser == null) {
            i = AuthUI.getInstance().createSignInIntentBuilder().build();
            startActivityForResult(i, 10);
        } else {
            i = new Intent(this, MailchimpConnectActivity.class);
            startActivity(i);
        }


    }

}