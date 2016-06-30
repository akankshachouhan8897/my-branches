package com.codekul.materialdesign;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private boolean isClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)
                findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       fab = (FloatingActionButton)
                findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ss("clicked");
            }
        });

        final TextView textSimple = (TextView)
                findViewById(R.id.textSimple);
        textSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isClicked = !isClicked;
                invalidateOptionsMenu();
            }
        });

        registerForContextMenu(textSimple);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater()
                .inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(isClicked) {
            menu.clear();
            getMenuInflater()
                    .inflate(R.menu.simple_menu, menu);
            return true;
        }
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            ss("settings");
            return true;
        }
        if(id == R.id.action_mms){

            ss("mms");
            return true;
        }
        if(id == R.id.action_sms){
            ss("sms");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater()
                .inflate(R.menu.menu_main,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        ss(""+item.getTitle());
        return super.onContextItemSelected(item);
    }

    public void ss(String msg){

        Snackbar
                .make(fab,msg,Snackbar.LENGTH_LONG)
                .setAction("Action",null)
                .show();
    }
}
