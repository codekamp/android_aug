package in.codekamp.reviewrating.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cerebro on 23/09/17.
 */

public class AddContactRequest {

    @Expose
    @SerializedName("email_address")
    public String email;

    @Expose
    @SerializedName("status")
    public String status;

    @Expose
    @SerializedName("merge_fields")
    public MergeFields m;

    public AddContactRequest(String email, String status, String fname, String lname) {
        this.email = email;
        this.status = status;
        this.m = new MergeFields(fname, lname);
    }

    public class MergeFields {
        @Expose
        @SerializedName("FNAME")
        String firstName;

        @Expose
        @SerializedName("LNAME")
        String lastName;

        public MergeFields(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}
