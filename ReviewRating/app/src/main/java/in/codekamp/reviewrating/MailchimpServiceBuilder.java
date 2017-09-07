package in.codekamp.reviewrating;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cerebro on 07/09/17.
 */

public class MailchimpServiceBuilder {

    public static final String MAILCHIMP_BASE_URL = "https://us11.api.mailchimp.com/3.0/";

    public static MailchimpService build() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MAILCHIMP_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MailchimpService.class);
    }
}
