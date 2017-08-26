package in.codekamp.kidstableapp;

import android.content.Context;
import android.view.View;

/**
 * Created by cerebro on 24/08/17.
 */

public class RotatorView extends View {

    private RotatorViewListner listner;


    public RotatorView(Context context, int min, int max) {
        super(context);
    }

    public void onSwipe() {
        // code to show rotation animation

        this.listner.onValueSelected(this, 10.5f);
    }


    public void addListner(RotatorViewListner l) {
        this.listner = l;
    }

}
