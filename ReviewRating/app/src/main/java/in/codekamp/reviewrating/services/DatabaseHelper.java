package in.codekamp.reviewrating.services;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import in.codekamp.reviewrating.MyApplication;

/**
 * Created by cerebro on 09/09/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper() {
        super(MyApplication.getAppContext(), "db_name", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("codekamp", "onCreate of DatabaseHelper called");
        db.execSQL("CREATE TABLE `todo` ( `_id` INTEGER PRIMARY KEY AUTOINCREMENT, `title` TEXT, `completed` INTEGER DEFAULT 0 );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("codekamp", "onUpgrade of DatabaseHelper called " + oldVersion + " new " + newVersion);
    }
}
