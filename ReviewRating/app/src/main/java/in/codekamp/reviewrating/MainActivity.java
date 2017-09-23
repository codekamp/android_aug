package in.codekamp.reviewrating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import in.codekamp.reviewrating.requests.AddContactRequest;
import in.codekamp.reviewrating.responses.AddContactResponse;
import in.codekamp.reviewrating.responses.AllListsResponse;
import in.codekamp.reviewrating.services.MailchimpService;
import in.codekamp.reviewrating.services.MailchimpServiceBuilder;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        AddContactRequest r = new AddContactRequest("prashant@akgec.com", "subscribed");


        HashMap<String, Object> map = new HashMap<>();
        map.put("email_address", "prashant@ipec.com");
        map.put("status", "subscribed");

        MailchimpServiceBuilder.build().addContact("085c2bcf83", map).enqueue(new ResponseCallback<AddContactResponse>() {
            @Override
            public void onSuccess(AddContactResponse response) {
                Log.d("codekamp", "Contact added Successfully");
            }

            @Override
            public void onError(ApiError error) {
                Log.d("codekamp", "Contact add failed " + error.message);
            }
        });





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


//        MailchimpServiceBuilder.build().getAllLists().enqueue(new ResponseCallback<AllListsResponse>() {
//            @Override
//            public void onSuccess(AllListsResponse response) {
//                Log.d("codekamp", "onSuccess called");
//                Log.d("codekamp", response.lists.get(0).title);
//
//                EventBus.getDefault().post(new LoginEvent("Prashant Chaudhary"));
//
//                //show success popup
//                MainActivity.this.finish();
//            }
//
//            @Override
//            public void onError(ApiError error) {
//                Log.d("codekamp", "onError called");
//                Log.d("codekamp", error.message);
//            }
//        });
//
//        Log.d("codekamp", "onCreate complete");
    }
}


// https://developer.android.com/reference/android/R.styleable.html#Theme
