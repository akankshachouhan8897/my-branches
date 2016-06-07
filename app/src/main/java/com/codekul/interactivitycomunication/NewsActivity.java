package com.codekul.interactivitycomunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewsActivity extends AppCompatActivity {

    public static final String KEY_ADDITIONAL_NEWS = "additionalNews";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Intent responsibleIntent = getIntent();

        Bundle bundle = responsibleIntent.getExtras();
        String newsTopic = bundle.getString(MainActivity.KEY_NEWS_TOPIC);

        final EditText edtNews = (EditText) findViewById(R.id.edtNews);
        edtNews.setText(newsTopic);

        final Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent data = new Intent();

                Bundle dataBundle = new Bundle();
                dataBundle.putString(KEY_ADDITIONAL_NEWS,edtNews.getText().toString());
                data.putExtras(dataBundle);

                setResult(RESULT_OK,data);
                finish();

            }
        });
    }
}
