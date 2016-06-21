package com.codekul.intentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Intent responsibleIntent =
                getIntent();

        Uri uri =
                responsibleIntent.getData();
        // perform ur business logic on the basis of uri

    }
}
