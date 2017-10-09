package in.codekamp.mydatabindingdemo;

import android.databinding.ObservableField;

/**
 * Created by cerebro on 07/10/17.
 */

public class User {
    public ObservableField<String> firstName = new ObservableField<>();
    public ObservableField<String> lastName = new ObservableField<>();
    public ObservableField<String> aboutMe = new ObservableField<>();

    public User(String firstName, String lastName, String aboutMe) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.aboutMe.set(aboutMe);
    }
}
