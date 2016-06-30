package com.codekul.contentproviderclient;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("content://com.codekul.db.contact.provider");
        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        ContentResolver resolver =
                getContentResolver();
        Cursor cursor =
                resolver.query(uri,projection,selection,selectionArgs,sortOrder);

        while(cursor.moveToNext()){

            String name = cursor.getString(cursor.getColumnIndex("userName"));
            String password = cursor.getString(cursor.getColumnIndex("userPhone"));

            Log.i("@codekul",name + " --> "+password);
        }
    }
}
