package com.example.pratik.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TodoDBHelper extends SQLiteOpenHelper {
    // Database Info
    private static final String DATABASE_NAME = "itemsDatabase";
    private static final int DATABASE_VERSION = 1;
    // Table Names
    private static final String TABLE_ITEMS = "items";
    // items Table Columns
    private static final String KEY_ITEM_ID = "id";
    private static final String KEY_ITEM_TEXT = "text";

    //making DBHelpler Singleton
    private static TodoDBHelper sInstance;

    public static synchronized TodoDBHelper getInstance(Context context)
    {
        if(sInstance == null)
        {
            sInstance = new TodoDBHelper(context.getApplicationContext());

        }
        return sInstance;
    }
    private TodoDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);

    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLE_ITEMS +
                "(" +
                KEY_ITEM_ID + " INTEGER PRIMARY KEY," + // Define a primary key
                KEY_ITEM_TEXT + " TEXT" +
                ")";
        db.execSQL(CREATE_ITEMS_TABLE);

    }

    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);

            onCreate(db);
        }
    }

    public void addItem(Item item)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_ITEM_TEXT,item.text.toString());

            db.insertOrThrow(TABLE_ITEMS, null, contentValues);
            db.setTransactionSuccessful();
            Log.d("DB", "added");
        }catch(Exception e){
            Log.d("DB", "Error while trying to add item to database");
    } finally {
        db.endTransaction();
    }
    }

    public List<String> getAllItems()
    {
        List<String> items = new ArrayList<>();
        String ITEMS_SELECT_QUERY = String.format("SELECT * FROM %s",TABLE_ITEMS);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor= db.rawQuery(ITEMS_SELECT_QUERY, null);
        try {

            if(cursor.moveToFirst())
            {
                do{
                    Item item = new Item();
                    item.text = cursor.getString(cursor.getColumnIndex(KEY_ITEM_TEXT));
                    items.add(item.text);
                    Log.d("item", item.text);
                }
                while(cursor.moveToNext());
            }
        }catch (Exception e){
            Log.d("DB","Error getting items frm DB");
        }
        finally {
            if(cursor != null && !cursor.isClosed())
            {cursor.close();}
        }
        return  items;
    }

    public void deleteItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

     db.beginTransaction();
        try {
            int row = db.delete(TABLE_ITEMS, KEY_ITEM_TEXT + "= ?", new String[]{item.text});
            if(row == 1)
            {
                db.setTransactionSuccessful();
            }
        }catch (Exception e)
        {
            Log.d("DB","Error while deleting items frm db");
        }
        finally{
            db.endTransaction();
        }
    }
}
