package in.codekamp.todoapp;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 14/09/17.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoViewHolder> {

    List<Todo> todos = new ArrayList<>();
    DatabaseHelper helper;

    public TodoListAdapter() {
       helper = new DatabaseHelper();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query(DatabaseHelper.TODO_TABLE, null, null, null, null, null, null);
        TodoCursor cw = new TodoCursor(c);

        while (cw.moveToNext()) {
            todos.add(cw.getTodo());
        }
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.todo_view, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Todo t = todos.get(position);
        holder.setTodo(t);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }
}
