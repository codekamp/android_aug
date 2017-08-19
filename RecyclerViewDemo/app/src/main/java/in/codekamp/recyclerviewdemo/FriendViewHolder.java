package in.codekamp.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cerebro on 19/08/17.
 */

public class FriendViewHolder extends RecyclerView.ViewHolder {

    TextView nameView;
    TextView hometownView;

    public FriendViewHolder(View view) {
        super(view);

        nameView = (TextView) view.findViewById(R.id.name_view);
        hometownView = (TextView) view.findViewById(R.id.hometown_view);
    }

}
