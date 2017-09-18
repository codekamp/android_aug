package in.codekamp.reviewrating;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cerebro on 16/09/17.
 */

public class ApiError {

    @Expose
    @SerializedName("title")
    public String message;

    @Expose
    @SerializedName("status")
    public int status;

    public ApiError(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
