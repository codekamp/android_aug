package in.codekamp.reviewrating;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cerebro on 16/09/17.
 */

abstract public class ResponseCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            Gson gson = new Gson();
            try {
                ApiError error = gson.fromJson(response.errorBody().string(), ApiError.class);
                if(error.status == 401) {
                    SharedPrefs.setApiKey(null);
                }
                onError(error);
            } catch (IOException e) {
                onError(new ApiError("Unknown error", 500));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError(new ApiError(t.getMessage(), 500));
    }

    abstract public void onSuccess(T response);

    abstract public void onError(ApiError error);
}
