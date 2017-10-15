package in.codekamp.mydatabindingdemo.utils;


import android.databinding.ObservableField;
import android.support.annotation.NonNull;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import static android.databinding.Observable.OnPropertyChangedCallback;

public class RxUtils {

    private RxUtils() {
    }

    public static <T> Observable<T> toObservable(@NonNull final ObservableField<T> observableField) {

        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e) throws Exception {
                observableField.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
                    @Override
                    public void onPropertyChanged(android.databinding.Observable observable, int i) {
                        if (observable == observableField) {
                            e.onNext(observableField.get());
                        }
                    }
                });
            }
        });
    }
}