package in.codekamp.reviewrating;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import in.codekamp.reviewrating.requests.AddContactRequest;
import in.codekamp.reviewrating.responses.AddContactResponse;
import in.codekamp.reviewrating.responses.AllListsResponse;
import in.codekamp.reviewrating.services.MailchimpService;
import in.codekamp.reviewrating.services.MailchimpServiceBuilder;

public class MainActivity extends AppCompatActivity {

    EditText emailField;
    EditText passwordField;



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

        emailField = (EditText)findViewById(R.id.email);
        passwordField = (EditText)findViewById(R.id.password);


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

    public void login(View view) {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()) {
                           //raise intent to dashboard screen
                           Log.d("codekamp", "Login successful");
                       } else {
                           Log.d("codekamp", "Login failed");
                       }
                    }
                });
    }
}


// https://developer.android.com/reference/android/R.styleable.html#Theme
