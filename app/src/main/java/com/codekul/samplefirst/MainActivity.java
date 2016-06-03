package com.codekul.samplefirst;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Click click = new Click();
        setContentView(R.layout.activity_main);

        Button btnUpper = (Button) findViewById(R.id.btnUpper);
        btnUpper.setOnClickListener(click);

        Button btnLower = (Button) findViewById(R.id.btnLower);
        btnLower.setOnClickListener(click);
        Integer.parseInt("10");
    }

    private class Click implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.btnUpper) {
                final EditText edtName = (EditText)
                        findViewById(R.id.edtName);

                String name = edtName.getText()
                        .toString();

                edtName.setText(name.toUpperCase());
            }
            else if(v.getId() == R.id.btnLower){

                final EditText edtName = (EditText)
                        findViewById(R.id.edtName);

                String name = edtName.getText()
                        .toString();

                edtName.setText(name.toLowerCase());
            }
        }
    }
}
