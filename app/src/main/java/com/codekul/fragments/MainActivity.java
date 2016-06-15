package com.codekul.fragments;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String KEY_TEXT_STATUS = "textStatus" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setBackgroundDrawableResource(R.drawable.my);

        mt("onCreate");

        /*if(savedInstanceState != null) {
            ((TextView) findViewById(R.id.textStatus))
                    .setText(savedInstanceState
                            .getString(KEY_TEXT_STATUS));
        }*/
    }

    /*@Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null) {
            ((TextView) findViewById(R.id.textStatus))
                    .setText(savedInstanceState
                            .getString(KEY_TEXT_STATUS));
        }
    }*/

    @Override
    protected void onStart() {
        super.onStart();

        mt("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mt("onReStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        mt("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        mt("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        mt("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mt("onDestroy");
    }

    private final void mt(String msg){

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void myClick(View v){

        ((TextView)findViewById(R.id.textStatus)).setText(""+System.currentTimeMillis());
    }

    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_TEXT_STATUS,((TextView)findViewById(R.id.textStatus)).getText().toString());
    }*/

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){

            getWindow().setBackgroundDrawableResource(R.drawable.hands);
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

            getWindow().setBackgroundDrawableResource(R.drawable.circle);
        }
        else{

            getWindow().setBackgroundDrawableResource(R.drawable.my);
        }
    }
}
