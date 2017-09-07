package in.codekamp.reviewrating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

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



    //temporary jugaad, later we will take input from user
    public static final String API_KEY = "YOUR_KEY_HERE";


    public static final String MAILCHIMP_BASE_URL = "https://us11.api.mailchimp.com/3.0/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MailchimpServiceBuilder.build().getAllLists("bearer " + API_KEY).enqueue(new Callback<AllListsResponse>() {
            @Override
            public void onResponse(Call<AllListsResponse> call, Response<AllListsResponse> response) {
                Log.d("codekamp", response.body().lists.get(2).title);
            }

            @Override
            public void onFailure(Call<AllListsResponse> call, Throwable t) {
            }
        });

        Log.d("codekamp", "onCreate complete");
    }
}
