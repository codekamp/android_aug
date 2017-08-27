package in.codekamp.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements NumberInput.TextListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = this.getSupportFragmentManager();

        if (fm.findFragmentById(R.id.container_1) == null) {
            NumberInput f1 = NumberInput.createInstace("I Love Android");

            FragmentTransaction transaction = fm.beginTransaction();
            transaction.add(R.id.container_1, f1);
            transaction.commit();
        }

    }

    @Override
    public void onTextSet(String text) {
        Log.d("codekamp", "text received in MainActivty: " + text);
    }
}
