package in.codekamp.kidstableapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by cerebro on 22/08/17.
 */

public class TableViewHolder extends RecyclerView.ViewHolder {

    int multiplier;

    TextView resultView;
    Context context;

    public TableViewHolder(View view, Context c) {
        super(view);

        this.context = c;
        resultView = (TextView)view;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("codekamp", "multiplier is " + multiplier);

                context.startActivity();
            }
        });
    }
}
