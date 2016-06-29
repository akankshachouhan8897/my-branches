package com.codekul.sqliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        findViewById(R.id.btnSqlite).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(SelectionActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                });

        findViewById(R.id.btnContentProvider).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionActivity.this, ContentProviderActivity.class);
                startActivity(intent);
            }

        });
    }
}
