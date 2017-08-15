package in.codekamp.uidemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by cerebro on 12/08/17.
 */

public class ResultActivity extends AppCompatActivity {

    public TextView resultView;
    public EditText uselessField;
    private static final String INTENT_RESULT_KEY = "my_final_result";

    public static Intent createIntent(Context c, int result) {
        Intent i = new Intent(c, ResultActivity.class);
        i.putExtra(INTENT_RESULT_KEY, result);
        return i;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);

        resultView = (TextView)findViewById(R.id.result_view);
        uselessField = (EditText) findViewById(R.id.useless_field);

        Intent i = getIntent();
        int result = i.getIntExtra(INTENT_RESULT_KEY, 0);

        resultView.setText(Integer.toString(result));

        Log.d("codekamp", "onCreate of ResultActivity");
    }

    public void sendDataBack(View view) {
        String dataToSend = uselessField.getText().toString();
        Intent i = new Intent();
        i.putExtra("selected_state", dataToSend);
        setResult(Activity.RESULT_OK, i);
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("codekamp", "onStart of ResultActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("codekamp", "onPause of ResultActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("codekamp", "onResume of ResultActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("codekamp", "onStop of ResultActivity");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("codekamp", "onDestroy of ResultActivity");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("codekamp", "onSaveInstanceState of ResultActivity");
    }
}
