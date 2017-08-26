package in.codekamp.recyclerviewdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cerebro on 17/08/17.
 */

public class FriendListAdapter extends RecyclerView.Adapter<FriendViewHolder> {

    public int kisKaTable = 0;
    public int kahanTak = 0;

    private static String[] DUMMY_NAME = new String[50];
    private static String[] DUMMY_CITY = new String[50];

    static {
        for (int i = 0; i < 50; i++) {
            DUMMY_NAME[i] = "Name " + i;
            DUMMY_CITY[i] = "City " + i;
        }
    }

    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("codekamp", "onCreateViewHolder called");
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.friend_list_row, parent, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendViewHolder holder, int position) {
        Log.d("codekamp", "onBindViewHolder called for postion " + position);
        String name = DUMMY_NAME[position];
        String city = DUMMY_CITY[position];


        if(position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.BLUE);
        } else {
            holder.itemView.setBackgroundColor(Color.GREEN);
        }

        holder.nameView.setText(name);
        holder.hometownView.setText(city);
    }

    @Override
    public int getItemCount() {

        return kahanTak;
    }
}
