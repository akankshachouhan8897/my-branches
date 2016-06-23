package com.codekul.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnWrite)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToPreferences();
            }
        });

        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFromPreferences();
            }
        });
    }

    private void writeToPreferences(){

        /*SharedPreferences prefs =
                getPreferences(MODE_PRIVATE);*/ // for activity

        SharedPreferences prefs = getSharedPreferences("my",
                MODE_PRIVATE); // for app

        SharedPreferences.Editor editor =
                prefs.edit();
        editor.putString("myStr","codekul.com");
        editor.putFloat("myFloat",15.6f);

        editor.commit(); //imp
    }

    private void readFromPreferences(){

        SharedPreferences prefs =
                getSharedPreferences("my",MODE_PRIVATE);
        String myStr = prefs.getString("myStr","default");
        Float myFloat = prefs.getFloat("myFloat",-1f);

        Log.i("@codekul","String - "+myStr);
        Log.i("@codekul","Float - "+myFloat);

    }
}
