package edu.ksu.cs.benign;



import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

/**
 * Helper class for MyDatabase.
 *
 * @author joymitro1989@gmail.com (Joydeep Mitra)
 */
public class MyDatabaseHelper extends SQLiteOpenHelper{

    //If you change the Database Schema you must increment the DATABASE_VERSION
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CloudDBCache.db";

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + MyDatabase.Table1.TABLE_NAME + " (" +
                    MyDatabase.Table1._ID + " INTEGER PRIMARY KEY," +
                    MyDatabase.Table1.COLUMN_NAME_USER + " TEXT," +
                    MyDatabase.Table1.COLUMN_NAME_PASS + " TEXT)";

    private static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + MyDatabase.Table1.TABLE_NAME;

    private static MyDatabaseHelper myDatabaseHelper = null;

    public static MyDatabaseHelper getInstance(Context context){
        if(myDatabaseHelper == null){
            myDatabaseHelper = new MyDatabaseHelper(context);
        }
        return myDatabaseHelper;
    }

    private MyDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

}