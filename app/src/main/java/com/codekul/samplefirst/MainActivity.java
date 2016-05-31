package com.codekul.samplefirst;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView view = new TextView(this);
        view.setText("HEllo World");
        view.setLayoutParams(new ViewGroup.LayoutParams(500,500));
        setContentView(view);

        System.out.print("Hello World");
    }
}
