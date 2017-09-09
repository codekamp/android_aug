package in.codekamp.reviewrating;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MailchimpConnectActivity extends AppCompatActivity {

    EditText apiKeyField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailchimp_connect);

        apiKeyField = (EditText)findViewById(R.id.api_key_field);

        String apiKey = SharedPrefs.getApiKey() != null ? SharedPrefs.getApiKey() : "No Key set";

        Log.d("codekamp", apiKey);

        DatabaseHelper helper = new DatabaseHelper();
        SQLiteDatabase database = helper.getReadableDatabase();



    }

    public void connect(View view) {
        SharedPrefs.setApiKey(apiKeyField.getText().toString());
    }
}
