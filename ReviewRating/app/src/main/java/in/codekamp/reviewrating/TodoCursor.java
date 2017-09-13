package in.codekamp.reviewrating;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by cerebro on 12/09/17.
 */

public class TodoCursor extends CursorWrapper {

    public TodoCursor(Cursor cursor) {
        super(cursor);
    }

    public String getTitle() {
        return this.getString(this.getColumnIndex("title"));
    }


    public int getId() {
        return this.getInt(this.getColumnIndex("_id"));
    }

    public int getCompleted() {
        return this.getInt(this.getColumnIndex("completed"));
    }

    public Todo getTodo() {
        return new Todo(getInt(this.getColumnIndex("_id")), getString(this.getColumnIndex("title")), getInt(this.getColumnIndex("completed")));
    }
}
