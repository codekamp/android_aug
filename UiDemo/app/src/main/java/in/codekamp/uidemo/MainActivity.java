package in.codekamp.uidemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText firstField;
    private EditText secondField;
    private TextView resultField;
    private int result;

    private static final int STATE_PICK_REQUEST = 0;
    private static final int COUNTRY_PICK_REQUEST = 1;

    private static final String RESULT_KEY = "my_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstField = (EditText) this.findViewById(R.id.first_field);
        secondField = (EditText) findViewById(R.id.second_field);
        resultField = (TextView) findViewById(R.id.result_view);

        if(savedInstanceState != null) {
            result = savedInstanceState.getInt(RESULT_KEY, 0);
            resultField.setText(Integer.toString(result));
        } else {
            Log.d("codekamp", "activity created for the first time");
        }

        Log.d("codekamp", "onCreate of MainActivity");
    }

    public void addNumbers(View v) {
        TextView firstNumberField = (EditText) findViewById(R.id.first_field);
        Log.d("codekamp", "Button clicked");
        Log.d("codekamp", "First number is " + firstField.getText());
        Log.d("codekamp", "Second number is " + secondField.getText());
//
//        int firstNum = Integer.parseInt(firstField.getText().toString());
//        int secondNum = Integer.parseInt(secondField.getText().toString());
//        result = firstNum + secondNum;

//        resultField.setText(Integer.toString(result));

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:prashant@codekamp.in,helpdesk@codekamp.in"));
        intent.putExtra(Intent.EXTRA_EMAIL, "prashant@codekamp.in");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hello world subject");
        intent.putExtra(Intent.EXTRA_TEXT, "This is message body");

        Intent chooserIntent = Intent.createChooser(intent, "Select an app to invite");
        startActivity(chooserIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == STATE_PICK_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d("codekamp", "selected state is " + data.getStringExtra("selected_state"));
            }
        } else if(requestCode == COUNTRY_PICK_REQUEST) {

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("codekamp", "onStart of MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("codekamp", "onPause of MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("codekamp", "onResume of MainActivity");
    }



    @Override
    protected void onStop() {
        super.onStop();

        Log.d("codekamp", "onStop of MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("codekamp", "onDestroy of MainActivity");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(RESULT_KEY, result);

        Log.d("codekamp", "onSaveInstanceState of MainActivity");
    }
}