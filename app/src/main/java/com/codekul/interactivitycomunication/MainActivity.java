package com.codekul.interactivitycomunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_NEWS_TOPIC = "newsTopic";
    public static final int REQUEST_CODE_NEWS = 123 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnNews = (Button)
                findViewById(R.id.btnNews);

        btnNews.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // source -> u need to pass context
                // target -> u need to pass type information of target activity

                // NewsActivity.class is referring to Class class

                final EditText edtNewsTopic =
                        (EditText) findViewById(R.id.edtNewsTopic);


                Intent intent = new Intent(MainActivity.this,
                        NewsActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString(KEY_NEWS_TOPIC,
                        edtNewsTopic.getText().toString());

                intent.putExtras(bundle);

                startActivityForResult(intent,REQUEST_CODE_NEWS);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_NEWS){ // you are coming back from news activity
            if(resultCode == RESULT_OK){ // with success result

                Bundle bundle = data.getExtras();
                String additionalNews = bundle.getString(NewsActivity.KEY_ADDITIONAL_NEWS);

                final EditText edtNewsTopic = (EditText) findViewById(R.id.edtNewsTopic);
                edtNewsTopic.setText(additionalNews);
            }
        }
    }
}
