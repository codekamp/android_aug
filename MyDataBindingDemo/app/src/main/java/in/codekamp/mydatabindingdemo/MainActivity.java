package in.codekamp.mydatabindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

import in.codekamp.mydatabindingdemo.databinding.ActivityMainBinding;
import in.codekamp.mydatabindingdemo.utils.RxUtils;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new User("", "Prabhu", "I Love Android");
        binding.setProfile(user);

        RxUtils.toObservable(user.firstName)
                .filter(value -> value.length() > 3)
                .debounce(1, TimeUnit.SECONDS)
                .distinctUntilChanged()
                .subscribe(value -> Log.d("codekamp", value));
    }

    public void save(View view) {
    }
}
