package in.codekamp.reviewrating;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cerebro on 07/09/17.
 */

public class MailchimpList {

    @Expose
    @SerializedName("id")
    public String id;

    @Expose
    @SerializedName("name")
    public String title;
}
