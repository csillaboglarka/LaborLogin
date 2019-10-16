package com.example.laborlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by ravi on 15/03/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="hobbies_db";

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Hobbie.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Hobbie.TABLE_NAME);
        onCreate(db);
    }

    public long insertHobbie(String hobbie)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Hobbie.COLUMN_HOBBIE,hobbie);
        long id=db.insert(Hobbie.TABLE_NAME,null,values);
        db.close();
        return id;
    }

    public Hobbie getHobbie(long id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query(Hobbie.TABLE_NAME,
                new String[]{Hobbie.COLUMN_ID, Hobbie.COLUMN_HOBBIE},
                Hobbie.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if(cursor != null)
        {
            cursor.moveToFirst();
        }
        Hobbie hobbie=new Hobbie(
                cursor.getInt(cursor.getColumnIndex(Hobbie.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Hobbie.COLUMN_HOBBIE)));
        cursor.close();
        return hobbie;
    }

    public List <Hobbie> getAllHobbie()
    {
        List <Hobbie> hobbies = new ArrayList<>();
        String selectQuery="SELECT * FROM " + Hobbie.TABLE_NAME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                Hobbie hobbie=new Hobbie();
                hobbie.setId(cursor.getInt(cursor.getColumnIndex(Hobbie.COLUMN_ID)));
                hobbie.setHobbie(cursor.getString(cursor.getColumnIndex(Hobbie.COLUMN_HOBBIE)));
                hobbies.add(hobbie);
            }while(cursor.moveToNext());
        }
        db.close();
        return hobbies;
    }

    public int getHobbiesCount()
    {
        String countQuery = "SELECT * FROM " + Hobbie.TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(countQuery,null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int updateHobbie(Hobbie hobbie)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Hobbie.COLUMN_HOBBIE,hobbie.getHobbie());
        return db.update(Hobbie.TABLE_NAME,values,Hobbie.COLUMN_ID + " =? ", new String[]{String.valueOf(hobbie.getId())});
    }

    public void deleteHobbie(Hobbie hobbie)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Hobbie.TABLE_NAME, Hobbie.COLUMN_ID + " = ?",
                new String[]{String.valueOf(hobbie.getId())});
        db.close();
    }
}