package in.codekamp.reviewrating;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by cerebro on 09/09/17.
 */

public class SharedPrefs {

    private static final String API_KEY = "api_key";
    private static final String USER_AGE = "user_age";

    private static SharedPreferences getPrefrences() {
        Context c = MyApplication.getAppContext();
        return c.getSharedPreferences("main", Context.MODE_PRIVATE);
    }

    public static void setApiKey(String apiKey) {
        getPrefrences().edit().putString(API_KEY, apiKey).commit();
    }

    public static String getApiKey() {
        return getPrefrences().getString(API_KEY, null);
    }



    public static void setUesrAge(int age) {
        getPrefrences().edit().putInt(USER_AGE, age).commit();
    }

    public static int getUserAge() {
        return getPrefrences().getInt(USER_AGE, 0);
    }
}
