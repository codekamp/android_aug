package in.codekamp.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FriendListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler_view);

        rv.setLayoutManager(new GridLayoutManager(this, 2));

        adapter = new FriendListAdapter();
        rv.setAdapter(adapter);
    }

    public void onSubmit(View view) {
        adapter.notifyDataSetChanged();
    }
}
