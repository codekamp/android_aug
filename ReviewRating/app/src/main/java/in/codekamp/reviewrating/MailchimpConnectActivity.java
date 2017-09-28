package in.codekamp.reviewrating;

import android.Manifest;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import in.codekamp.reviewrating.services.BackupService;
import in.codekamp.reviewrating.services.DatabaseHelper;

public class MailchimpConnectActivity extends AppCompatActivity implements LocationListener {

    EditText apiKeyField;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailchimp_connect);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

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
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentTitle("Video is downloading...");
        builder.setContentText("The video download is blah blah blah...");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_ONE_SHOT);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setOngoing(true);
        builder.setProgress(0, 0, true);

        NotificationCompat.BigTextStyle s = new NotificationCompat.BigTextStyle();
        s.bigText("hfaofhado fahdfapfh asdpfhasdpfhasdf");
        builder.setStyle(s);

        NotificationCompat.Action acrhieveAction = new NotificationCompat.Action(R.drawable.master, "archieve it", pendingIntent);
        NotificationCompat.Action replyAction = new NotificationCompat.Action(R.drawable.master, "reply", pendingIntent);

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

    public void setAlarm(View e) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(this, BackupService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //BACKUP SERVICE
        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, 0, 3000, pendingIntent);
//        alarmManager.setInexactRepeating();


        // TODO APP NOTIFICATION SERVICE
//        alarmManager.set(AlarmManager.RTC_WAKEUP, 10000000, pendingIntent);
//        alarmManager.setExact();

    }

    public void navigate(View view) {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        Location lastLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        this.setCurrentLocation(lastLocation);
    }

    private Location currentLocation;

    private void setCurrentLocation(Location l) {
        this.currentLocation = l;

        // change things on map or whatever
        // show new currentLocation on screen
    }

    @Override
    public void onLocationChanged(Location location) {
        if(currentLocation == null || location.getAccuracy() > this.currentLocation.getAccuracy()) {
            this.setCurrentLocation(location);
            return;
        }

//        https://developer.android.com/guide/topics/location/strategies.html


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    protected void onPause() {
        super.onPause();

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.removeUpdates(this);

    }
}
