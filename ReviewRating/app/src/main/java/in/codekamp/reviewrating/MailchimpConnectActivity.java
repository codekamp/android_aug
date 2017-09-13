package in.codekamp.reviewrating;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MailchimpConnectActivity extends AppCompatActivity {

    EditText apiKeyField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailchimp_connect);

        apiKeyField = (EditText) findViewById(R.id.api_key_field);
    }

    public void connect(View view) {
        DatabaseHelper helper = new DatabaseHelper();
        SQLiteDatabase database = helper.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put("title", apiKeyField.getText().toString());

        database.insert("todo", null, values);

        String[] ids = {"1"};
        database.delete("todo", "_id = ?", ids);

        ContentValues values1 = new ContentValues();
        values1.put("title", "updated title");
        database.update("todo", values1, "_id > ?", ids);
        database.close();
    }

    public void readData(View view) {
        DatabaseHelper helper = new DatabaseHelper();
        SQLiteDatabase database = helper.getReadableDatabase();

        Cursor cursor = database.query("todo", null, null, null, null, null, null, null);

        TodoCursor todoCursor = new TodoCursor(cursor);

        while (todoCursor.moveToNext()) {
            int id = todoCursor.getId();
            String title = todoCursor.getTitle();
            int completed = todoCursor.getInt(todoCursor.getColumnIndex("completed"));

            Log.d("codekamp", "id: " + id + ", title: " + title + ", completed: " + completed);
        }
    }
}
