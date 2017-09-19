package in.codekamp.reviewrating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        MailchimpServiceBuilder.build().getAllLists().enqueue(new Callback<AllListsResponse>() {
//            @Override
//            public void onResponse(Call<AllListsResponse> call, Response<AllListsResponse> response) {
//                Log.d("codekamp", "onResponse called");
//                Log.d("codekamp", response.body().lists.get(2).title);
//            }
//
//            @Override
//            public void onFailure(Call<AllListsResponse> call, Throwable t) {
//                Log.d("codekamp", "onFailure called");
//            }
//        });


        MailchimpServiceBuilder.build().getAllLists().enqueue(new ResponseCallback<AllListsResponse>() {
            @Override
            public void onSuccess(AllListsResponse response) {
                Log.d("codekamp", "onSuccess called");
                Log.d("codekamp", response.lists.get(0).title);

                EventBus.getDefault().post(new LoginEvent("Prashant Chaudhary"));

                //show success popup
                MainActivity.this.finish();
            }

            @Override
            public void onError(ApiError error) {
                Log.d("codekamp", "onError called");
                Log.d("codekamp", error.message);
            }
        });

        Log.d("codekamp", "onCreate complete");
    }
}


// https://developer.android.com/reference/android/R.styleable.html#Theme
