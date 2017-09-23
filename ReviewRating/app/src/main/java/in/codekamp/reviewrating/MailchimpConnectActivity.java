package in.codekamp.reviewrating;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import in.codekamp.reviewrating.services.DatabaseHelper;

public class MailchimpConnectActivity extends AppCompatActivity {

    EditText apiKeyField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailchimp_connect);

        apiKeyField = (EditText) findViewById(R.id.api_key_field);

        EventBus.getDefault().register(this);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void updateCart(LoginEvent e) {


    }

    @Subscribe void updateConversation(NewMessageEvent e) {

    }
}
