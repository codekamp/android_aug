package in.codekamp.reviewrating.services;

import java.util.HashMap;

import in.codekamp.reviewrating.requests.AddContactRequest;
import in.codekamp.reviewrating.responses.AddContactResponse;
import in.codekamp.reviewrating.responses.AllListsResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by cerebro on 07/09/17.
 */

public interface MailchimpService {

    @GET("lists")
    Call<HashMap<String, String>> getAllLists();

    @POST("lists/{listId}/members")
    Call<AddContactResponse> addContact(@Path("listId") String listId, @Body HashMap<String, Object> request);
}

//  https://futurestud.io/tutorials/retrofit-2-how-to-add-query-parameters-to-every-request
