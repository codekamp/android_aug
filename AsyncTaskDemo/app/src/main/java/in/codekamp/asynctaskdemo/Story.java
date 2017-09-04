package in.codekamp.asynctaskdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cerebro on 02/09/17.
 */

public class Story {

    @Expose
    @SerializedName("title")
    public String title;

    @Expose
    @SerializedName("description")
    public String description;


    @Expose
    @SerializedName("thumbnail_url")
    public String thumbnail;

}
