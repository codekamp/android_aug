package in.codekamp.reviewrating;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by cerebro on 07/09/17.
 */

public interface MailchimpService {

    @GET("lists")
    Call<AllListsResponse> getAllLists();


    // GET request on baseURl/lists?count=<a>&offset=<b>


    @GET("/lists/{xyz}/{members}")
    Call<AllContactsResponse> getContacts(@Header("Authorization") String auth,
                     @Path("members") String listId,
                     @Query("hello") float a,
                     @Path("xyz") int something);

    // GET request on baseURl/lists/<something>/<listId>"

    // getContacts("I love Android", "qwerty", 55.5f, 10);
    // GET request on baseURl/lists/10/qwerty?hello=55.5"


}
