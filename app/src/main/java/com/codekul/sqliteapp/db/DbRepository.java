package com.codekul.sqliteapp.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.codekul.sqliteapp.db.DbHelper;

/**
 * Created by aniruddha on 28/6/16.
 */
public class DbRepository {

    private DbHelper helper;

    public DbRepository(DbHelper helper) {
        this.helper = helper;
    }

    public void insert(String name, String phone){

        SQLiteDatabase sqDb =
                helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("userName",name);
        values.put("userPhone",phone);

        sqDb.insert("profile",null/*i will not accept empty row*/,values);

        sqDb.close();
    }

    public void display(String phone){

        SQLiteDatabase sqDb =
                helper.getReadableDatabase();

        String table = "profile"; //from
        String[] columns = new String[]{"userName"}; // columnn
        String selection = "userPhone = ?"; // where
        String[] selectionArgs = new String[]{phone}; // where
        String groupBy = null; // groupby
        String having = null; // like
        String orderBy = null; // asc or desc

        Cursor cursor = sqDb.query(table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);

        while(cursor.moveToNext()){

            String name = cursor
                    .getString(cursor
                            .getColumnIndex("userName"));

            Log.i("@codekul","Name - "+name +" Phone - "+phone);
        }

        cursor.close();
        sqDb.close();
    }

    public final void update(String name, String phone){

        SQLiteDatabase sqDb =
                helper.getWritableDatabase();

        String table = "profile";
        ContentValues values = new ContentValues();
        values.put("userName",name);
        String whereClause = "userPhone = ?";
        String[] whereArgs = { phone};

        sqDb.update(table, values, whereClause, whereArgs);

        sqDb.close();
    }
}
