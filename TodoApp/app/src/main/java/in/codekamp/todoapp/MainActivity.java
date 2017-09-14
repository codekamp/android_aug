package in.codekamp.todoapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText addTodoField;
    DatabaseHelper helper = new DatabaseHelper();
    TodoListAdapter adapter = new TodoListAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addTodoField = (EditText)findViewById(R.id.todo_field);

        RecyclerView rv = (RecyclerView)findViewById(R.id.todo_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setAdapter(adapter);
    }


    public void onAdd(View view) {
        String title = addTodoField.getText().toString();
        SQLiteDatabase d = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", title);
        int id = (int)d.insert(DatabaseHelper.TODO_TABLE, null, values);
        d.close();

        Todo t = new Todo(id, title, false);

        adapter.todos.add(t);
        adapter.notifyDataSetChanged();
    }
}
