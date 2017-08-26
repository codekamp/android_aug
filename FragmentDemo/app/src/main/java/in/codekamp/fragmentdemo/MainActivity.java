package in.codekamp.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberInput f1 = new NumberInput();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction =  fm.beginTransaction();
        transaction.add(R.id.number_input_fragment_container, f1);
        transaction.commit();

    }
}
