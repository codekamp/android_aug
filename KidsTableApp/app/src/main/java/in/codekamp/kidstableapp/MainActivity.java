package in.codekamp.kidstableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements RotatorViewListner {

    EditText numberField;
    EditText uptoField;
    TableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler_view);
        numberField = (EditText) findViewById(R.id.number_field);
        uptoField = (EditText)findViewById(R.id.upto_field);

        adapter = new TableAdapter();

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        RotatorView frequencyRotator = new RotatorView(this, 0, 250);
        frequencyRotator.addListner(this);

        RotatorView volumeRotator = new RotatorView(this, 0, 150);
        volumeRotator.addListner(this);
    }

    public void onSubmit(View view) {
        adapter.number = Integer.parseInt(numberField.getText().toString());
        adapter.upto = Integer.parseInt(uptoField.getText().toString());
        adapter.notifyDataSetChanged();
    }
}
