package com.codekul.sqliteapp.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import java.util.ArrayList;

/**
 * Created by aniruddha on 28/6/16.
 */
public class ContactFetcher {

    private Context context;

    public ContactFetcher(Context context){
        this.context = context;
    }

    public ArrayList<String> fetchContacts(){

        Uri uri = ContactsContract
                .CommonDataKinds
                .Phone
                .CONTENT_URI;

        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        ContentResolver resolver =
                context.getContentResolver();

        Cursor cursor =
                resolver.query(uri,projection,selection,selectionArgs,sortOrder);
        final ArrayList<String> dataSet =
                new ArrayList<>();

        while(cursor.moveToNext()){


            dataSet
                    .add(cursor
                            .getString(cursor
                                    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)) + "\n " +
                            cursor
                                    .getString(cursor
                                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
        }

        return dataSet;
    }
}
