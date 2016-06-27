package com.codekul.sqliteapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DbHelper helper =
                new DbHelper(this,"userDb",null/*use default cursor factory*/,1);

        findViewById(R.id.btnInsert)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insert(helper,getName(),getPhone());
            }
        });

        findViewById(R.id.btnUpdate)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

        findViewById(R.id.btnDelete)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

        findViewById(R.id.btnDisplay)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
    }

    private String getName(){
        return ((EditText)findViewById(R.id.edtName))
                .getText()
                .toString();
    }

    private String getPhone(){
        return ((EditText)findViewById(R.id.edtMobile))
                .getText()
                .toString();
    }

    private void insert(DbHelper helper, String name, String phone){

        SQLiteDatabase sqDb =
                helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("userName",name);
        values.put("userPhone",phone);

        sqDb.insert("profile",null/*i will not accept empty row*/,values);

        sqDb.close();
    }
}
