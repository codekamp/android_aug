package in.codekamp.asynctaskdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by cerebro on 02/09/17.
 */

public class StoryResponse {

    @Expose
    @SerializedName("total")
    public int count;

    @Expose
    @SerializedName("data")
    public ArrayList<Story> stories;
}