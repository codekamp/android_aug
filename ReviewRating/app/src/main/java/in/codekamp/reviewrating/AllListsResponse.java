package in.codekamp.reviewrating;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by cerebro on 07/09/17.
 */

public class AllListsResponse {
    @Expose
    @SerializedName("total_items")
    public int listsCount;

    @Expose
    @SerializedName("lists")
    public ArrayList<MailchimpList> lists;
}
