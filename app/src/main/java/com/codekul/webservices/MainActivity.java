package com.codekul.webservices;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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

                final EditText edtPostId =
                        (EditText) findViewById(R.id.edtPostId);

                new MyTask()
                        .execute("http://jsonplaceholder.typicode.com/posts/"+edtPostId.getText()
                                .toString());
            }
        });
    }

    private class MyTask extends AsyncTask<String,Integer,String> {

        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {

            progressDialog = ProgressDialog.show(MainActivity.this,
                    "Post","Fetching Posts");

        }

        @Override
        protected String doInBackground(String... params) {

            String json = "";
            try {
                URL url = new URL(params[0]);

                HttpURLConnection connection =
                        (HttpURLConnection) url.openConnection();

                if(connection.getResponseCode() == 200){

                    InputStream is =
                            connection.getInputStream();

                    StringBuilder builder =
                            new StringBuilder();
                    while(true){
                        int ch = is.read();
                        if(ch == -1) break;
                        else builder.append((char)ch);
                    }
                    json = builder.toString();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return json;
        }

        @Override
        protected void onPostExecute(String str) {
            super.onPostExecute(str);

            progressDialog.dismiss();

            Log.i("@codekul",str);

            try {
                JSONObject jsonObj = new JSONObject(str);
                String postBody = jsonObj.getString("body");

                final TextView textPost =
                        (TextView) findViewById(R.id.textPost);
                textPost.setText(postBody);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private class MyPostTask extends AsyncTask<String,Integer,String> {

        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {

            progressDialog = ProgressDialog.show(MainActivity.this,
                    "Post","Fetching Posts");

        }

        @Override
        protected String doInBackground(String... params) {

            String json = "";
            try {
                URL url = new URL(params[0]);

                HttpURLConnection connection =
                        (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.getOutputStream()
                        .write("{}".getBytes());
                connection.getOutputStream()
                        .flush();
                connection.getOutputStream()
                        .close();
                connection.connect();

                if(connection.getResponseCode() == 200){

                    InputStream is =
                            connection.getInputStream();

                    StringBuilder builder =
                            new StringBuilder();
                    while(true){
                        int ch = is.read();
                        if(ch == -1) break;
                        else builder.append((char)ch);
                    }
                    json = builder.toString();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return json;
        }

        @Override
        protected void onPostExecute(String str) {
            super.onPostExecute(str);

            progressDialog.dismiss();

            Log.i("@codekul",str);

            try {
                JSONObject jsonObj = new JSONObject(str);
                String postBody = jsonObj.getString("body");

                final TextView textPost =
                        (TextView) findViewById(R.id.textPost);
                textPost.setText(postBody);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
