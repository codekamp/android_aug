package in.codekamp.uidemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText firstField;
    private EditText secondField;

    private static final int STATE_PICK_REQUEST = 0;
    private static final int COUNTRY_PICK_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstField = (EditText) findViewById(R.id.first_field);
        secondField = (EditText) findViewById(R.id.second_field);
    }

    public void addNumbers(View v) {
        Log.d("codekamp", "Button clicked");
        Log.d("codekamp", "First number is " + firstField.getText());
        Log.d("codekamp", "Second number is " + secondField.getText());

        int firstNum = Integer.parseInt(firstField.getText().toString());
        int secondNum = Integer.parseInt(secondField.getText().toString());
        int result = firstNum + secondNum;

        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("my_final_result", result);
        startActivityForResult(i, STATE_PICK_REQUEST);
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
}

//github.com/codekamp
