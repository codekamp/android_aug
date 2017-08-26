package in.codekamp.kidstableapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by cerebro on 22/08/17.
 */

public class TableAdapter extends RecyclerView.Adapter<TableViewHolder> {

    public int number = 9;
    public int upto = 30;

    @Override
    public TableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.table_row, parent, false);

        return new TableViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(TableViewHolder holder, int position) {
        int multiplier = position + 1;
        int result = number * multiplier;
        String text = number + " X " + multiplier + " = " + result;

        holder.resultView.setText(text);
        holder.multiplier = multiplier;
    }

    @Override
    public int getItemCount() {
        return upto;
    }
}
