package com.codekul.sqliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.codekul.sqliteapp.db.DbHelper;
import com.codekul.sqliteapp.db.DbRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DbHelper helper =
                new DbHelper(this,"userDb",null/*use default cursor factory*/,1);

        final DbRepository repository =
                new DbRepository(helper);

        findViewById(R.id.btnInsert)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                repository.insert(getName(),getPhone());
            }
        });

        findViewById(R.id.btnUpdate)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        repository.update(getName(),getPhone());
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

                        repository.display(getPhone());
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
}
