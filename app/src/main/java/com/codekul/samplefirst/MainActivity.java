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
public class MainActivity extends Activity {

    public static final int ID_BTN_OKAY = 12345;

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

        final Click click = new Click(edtName);

        Button btnOkay = new Button(this);
        btnOkay.setId(ID_BTN_OKAY);
        btnOkay.setOnClickListener(click);
        btnOkay.setText("Okay");
        btnOkay.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

        layoutRoot.addView(btnOkay);

        setContentView(layoutRoot);
    }

    public class Click implements View.OnClickListener{

        private final EditText edtName;

        public Click(final EditText edtName){
            this.edtName = edtName;
        }

        @Override
        public void onClick(View v) {

            if(v.getId() == ID_BTN_OKAY){

                String name = edtName.getText().toString();
                edtName.setText(name.toUpperCase());
            }
        }
    }
}
