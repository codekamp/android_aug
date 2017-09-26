package in.codekamp.reviewrating;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationManagerCompat;
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
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailchimp_connect);

        notificationManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);

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

    @Subscribe
    void updateConversation(NewMessageEvent e) {

    }

    public void sendNotification(View v) {
        Notification.Builder builder = new Notification.Builder(this);

        builder.setContentTitle("Video is downloading...");
        builder.setContentText("The video download is blah blah blah...");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_ONE_SHOT);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setOngoing(true);
        builder.setProgress(0, 0, true);

        Notification.Action acrhieveAction = new Notification.Action(R.drawable.master, "archieve it", pendingIntent);
        Notification.Action replyAction = new Notification.Action(R.drawable.master, "reply", pendingIntent);

        builder.addAction(acrhieveAction);
        builder.addAction(replyAction);


        Notification notification = builder.build();
        notificationManager.notify(1, notification);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            builder.setProgress(100, i * 10, false);
            notification = builder.build();
            notificationManager.notify(1, notification);
        }

        builder.setContentTitle("Video downloaded Successfully");
        builder.setOngoing(false);
        builder.setProgress(0, 0, false);
        notification = builder.build();
        notificationManager.notify(1, notification);
    }
}
