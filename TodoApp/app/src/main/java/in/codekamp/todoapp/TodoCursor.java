package in.codekamp.todoapp;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;

/**
 * Created by cerebro on 12/09/17.
 */

public class TodoCursor extends CursorWrapper {

    public TodoCursor(Cursor cursor) {
        super(cursor);
    }

    public Todo getTodo() {
        Log.d("codekamp", "" + getInt(this.getColumnIndex("_id")));
        return new Todo(getInt(this.getColumnIndex("_id")),
                getString(this.getColumnIndex("title")),
                getInt(this.getColumnIndex("completed")) > 0);
    }
}
