package in.codekamp.reviewrating;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cerebro on 09/09/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper() {
        super(MyApplication.getAppContext(), "db_name", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
