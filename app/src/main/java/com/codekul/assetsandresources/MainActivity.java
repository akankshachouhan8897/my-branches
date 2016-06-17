package com.codekul.assetsandresources;

import android.content.res.AssetManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            demoAssets();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void demoResources(){

        String []arrCities = getResources().getStringArray(R.array.arrCities);

        String textData = getResources().getString(R.string.helloWorld);

        int color = getResources()
                .getColor(R.color.pureWhite);

        int colorOther = ContextCompat.getColor(this, R.color.pureWhite);
    }

    private final void demoAssets() throws Exception{

        // assets will never have id
        /// it can be accessed by input stream
        AssetManager manager = getAssets();
        InputStream is = manager.open("my.json");
    }
}
