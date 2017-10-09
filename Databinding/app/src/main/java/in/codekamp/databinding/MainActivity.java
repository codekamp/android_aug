package in.codekamp.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import in.codekamp.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding b = DataBindingUtil.setContentView(this, R.layout.activity_main);

        User user = new User("Prashant", "Chaudhary", "101.prashant@gmail.com");
        b.setUser(user);
    }
}
