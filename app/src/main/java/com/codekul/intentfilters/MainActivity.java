package com.codekul.intentfilters;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStart)
                .setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

               intentsWithData();
            }
        });
    }

    private void customActivty(){
        Intent intent =
                new Intent();
        intent.setAction("com.codekul.action.news");
        //intent.addCategory("com.codekul.category.info");

        startActivity(intent);
    }
    private void dialActivity(){

        Intent intent =
                new Intent();
        intent.setAction(Intent.ACTION_DIAL);

        startActivity(intent);
    }

    private void callPhone(){
        Intent intent =
                new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel://9762548833"));

        startActivity(intent);
    }

    private void openWebUrl(){

        Intent intent =
                new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://codekul.com"));

        startActivity(intent);
    }

    private void allInstalledApps(){

        Intent intent =
                new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        startActivity(intent);
    }

    private void intentsWithData(){

        Intent intent =
                new Intent();
        intent.setAction("com.codekul.action.news");
        intent.setData(Uri.parse("codekul://codekul.com"));

        startActivity(intent);
    }

    private void intentFilterDemo(){

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.codekul.action.news");
        filter.addCategory("com.codekul.category.news");
        filter.addDataScheme("codeku://coekul.com");
    }
}
