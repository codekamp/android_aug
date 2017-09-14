package in.codekamp.todoapp;

import android.content.ContentValues;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by cerebro on 14/09/17.
 */

public class TodoViewHolder extends RecyclerView.ViewHolder {

    private Todo todo;
    private TextView todoTitle;
    private CheckBox todoCompleted;
    DatabaseHelper helper = new DatabaseHelper();

    public TodoViewHolder(View itemView) {
        super(itemView);

        todoTitle = (TextView)itemView.findViewById(R.id.todo_title);
        todoCompleted = (CheckBox)itemView.findViewById(R.id.todo_checkbox);

        todoCompleted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SQLiteDatabase database = helper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("completed", isChecked ? 1 : 0);
                database.update(DatabaseHelper.TODO_TABLE, values,"_id = " + todo.id, null);
                database.close();

                todo.completed = isChecked;

                TodoViewHolder.this.itemView.setBackgroundColor(getColor());
            }
        });
    }

    public void setTodo(Todo t) {
        todo = t;
        todoTitle.setText(t.title);
        todoCompleted.setChecked(t.completed);

        itemView.setBackgroundColor(getColor());
    }

    private int getColor() {
        Resources res = MyApplication.getAppContext().getResources();
        return todo.completed ? res.getColor(R.color.colorTodoCompleted) : res.getColor(R.color.colorPrimary);
    }
}
