package com.codekul.samplefirst;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layoutRoot = new LinearLayout(this);
        layoutRoot.setOrientation(LinearLayout.VERTICAL);
        layoutRoot.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

        EditText edtName = new EditText(this);
        edtName.setHint("User Name");
        edtName.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        layoutRoot.addView(edtName);

        Button btnOkay = new Button(this);
        btnOkay.setText("Okay");
        btnOkay.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

        layoutRoot.addView(btnOkay);

        setContentView(layoutRoot);
    }

    private class Click implements View.OnHoverListener{

        @Override
        public boolean onHover(View v, MotionEvent event) {
            return false;
        }
    }
}
