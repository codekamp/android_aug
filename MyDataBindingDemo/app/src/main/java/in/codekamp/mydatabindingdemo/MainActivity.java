package in.codekamp.mydatabindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import in.codekamp.mydatabindingdemo.databinding.ActivityMainBinding;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements TextWatcher, Observer<Long> {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setProfile(new User("Suresh", "Prabhu", "I Love Android"));
        binding.setEditingEnabled(true);
        EditText t = new EditText(this);

        t.addTextChangedListener(this);

        Observable.interval(2, TimeUnit.SECONDS).debounce(1, TimeUnit.SECONDS).subscribe(this);
    }

    public void save(View view) {
        binding.getProfile().firstName.set("my new name");
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(s.length() < 3) {
            return;
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }


    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(Long l) {
        Log.d("codekamp", l.toString());
    }

    @Override
    public void onError(Throwable t) {
        Log.d("codekamp", t.getMessage());
    }

    @Override
    public void onComplete() {
        Log.d("codekamp", "observable complete");
    }
}
