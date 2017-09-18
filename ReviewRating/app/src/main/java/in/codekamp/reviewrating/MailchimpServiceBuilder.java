package in.codekamp.reviewrating;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cerebro on 07/09/17.
 */

public class MailchimpServiceBuilder {

    public static MailchimpService build() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        Interceptor myInterceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("Authorization", "bearer " +
                        SharedPrefs.getApiKey()).build();

                return chain.proceed(newRequest);
            }
        };

        builder.interceptors().add(myInterceptor);
        builder.interceptors().add(logging);
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(MailchimpService.class);
    }

    private static String getBaseUrl() {
        return "https://us11.api.mailchimp.com/3.0/";
    }
}
