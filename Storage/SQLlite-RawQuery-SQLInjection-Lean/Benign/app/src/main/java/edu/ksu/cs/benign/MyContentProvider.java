package edu.ksu.cs.benign;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class MyContentProvider extends ContentProvider {

    private static String TAG = "Benign/MyContentProvider";

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        try{
            SQLiteDatabase db = MyDatabaseHelper.getInstance(getContext()).getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MyDatabase.Table1.COLUMN_NAME_USER,"joymitro");
            contentValues.put(MyDatabase.Table1.COLUMN_NAME_PASS,"joypass");
            db.insert(MyDatabase.Table1.TABLE_NAME,null,contentValues);
            contentValues.put(MyDatabase.Table1.COLUMN_NAME_USER,"janedoe");
            contentValues.put(MyDatabase.Table1.COLUMN_NAME_PASS,"329#DSkdisW");
            db.insert(MyDatabase.Table1.TABLE_NAME,null,contentValues);
            contentValues.put(MyDatabase.Table1.COLUMN_NAME_USER,"jacikortna");
            contentValues.put(MyDatabase.Table1.COLUMN_NAME_PASS,"kakj4737");
            db.insert(MyDatabase.Table1.TABLE_NAME,null,contentValues);
            contentValues.put(MyDatabase.Table1.COLUMN_NAME_USER,"jamilaujka");
            contentValues.put(MyDatabase.Table1.COLUMN_NAME_PASS,"password");
            db.insert(MyDatabase.Table1.TABLE_NAME,null,contentValues);
            contentValues.put(MyDatabase.Table1.COLUMN_NAME_USER,"jamie");
            contentValues.put(MyDatabase.Table1.COLUMN_NAME_PASS,"password1234");
            db.insert(MyDatabase.Table1.TABLE_NAME,null,contentValues);
            return uri;
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = MyDatabaseHelper.getInstance(getContext()).getReadableDatabase();
        Cursor cursor;
        if(selectionArgs != null && selectionArgs.length > 0){
            cursor = db.query(MyDatabase.Table1.TABLE_NAME,projection,selection,selectionArgs,null,null,null);
        }
        else{
            String query = "SELECT " + projection[0] + " , " + projection[1]
                    + " from " + MyDatabase.Table1.TABLE_NAME + " WHERE " + selection;
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
