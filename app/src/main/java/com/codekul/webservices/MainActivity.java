package com.codekul.webservices;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnOkay =
                (Button) findViewById(R.id.btnOkay);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MyTask().execute(/*params*/);
            }
        });
    }

    private void forOnMainThared(){

        final TextView textView =
                (TextView) findViewById(R.id.textView);

        for(int i = 0; i < 10 ;i++){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            textView.setText(""+i);
        }
    }

    private void forOnWorkerThread(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                final TextView textView =
                        (TextView) findViewById(R.id.textView);

                for(int i = 0; i < 10 ;i++){

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    textView.setText(""+i);
                }
            }
        }).start();
    }

    private class MyTask extends AsyncTask<String/*params*/,Integer/*progress*/,Float/*Result*/> {

        @Override
        protected void onPreExecute() {

            // UI thread
        }

        @Override
        protected Float doInBackground(String... params/*params*/) {
            // deals with worker thread

            for(int i = 0 ;i < 10; i++){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(new Integer[]{i/*progress*/});
                // it will call onProgressUpdate
            }
            return null;
        }

        @Override
        protected void onPostExecute(Float aFloat/*Result*/) {
            super.onPostExecute(aFloat);


            //UI thread
        }

        @Override
        protected void onProgressUpdate(Integer... values/*progress*/) {
            super.onProgressUpdate(values);

            final TextView textView =
                    (TextView) findViewById(R.id.textView);
            textView.setText(""+values[0]);
            // UI thread
        }
    }
}
