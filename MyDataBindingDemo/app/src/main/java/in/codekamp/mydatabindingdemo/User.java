package in.codekamp.mydatabindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableField;

/**
 * Created by cerebro on 07/10/17.
 */

public class User extends BaseObservable {
    public ObservableField<String> firstName = new ObservableField<String>();
    public ObservableField<String> lastName = new ObservableField<String>();
    public ObservableField<String> aboutMe = new ObservableField<String>();

    public User(String firstName, String lastName, String aboutMe) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.aboutMe.set(aboutMe);
    }
}
