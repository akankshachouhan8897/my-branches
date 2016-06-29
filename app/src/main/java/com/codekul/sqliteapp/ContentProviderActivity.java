package com.codekul.sqliteapp;

import android.content.ContentResolver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.codekul.sqliteapp.provider.ContactFetcher;

public class ContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        initContactList();
    }

    private final void initContactList(){

        final ListView listContacts =
                (ListView) findViewById(R.id.listContacts);

        final ContactFetcher fetcher =
                new ContactFetcher(this);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        fetcher.fetchContacts());

        listContacts.setAdapter(adapter);
    }

}
