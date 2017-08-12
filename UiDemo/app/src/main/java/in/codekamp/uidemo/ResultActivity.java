package in.codekamp.uidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by cerebro on 12/08/17.
 */

public class ResultActivity extends AppCompatActivity {

    public TextView resultView;
    public EditText uselessField;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);

        resultView = (TextView)findViewById(R.id.result_view);
        uselessField = (EditText) findViewById(R.id.useless_field);

        Intent i = getIntent();
        int result = i.getIntExtra("my_final_result", 0);

        resultView.setText(Integer.toString(result));

    }

    public void sendDataBack(View view) {
        String dataToSend = uselessField.getText().toString();
        Intent i = new Intent();
        i.putExtra("selected_state", dataToSend);
        setResult(Activity.RESULT_OK, i);
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
