package com.codekul.cameraapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnCapture)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ImageView image =
                        (ImageView) findViewById(R.id.imageCaptured);
                image.setVisibility(View.VISIBLE);

                final ListView listCaptured =
                        (ListView) findViewById(R.id.listCapturedPhotos);
                listCaptured.setVisibility(View.GONE);

                Intent intent =
                        new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

                File fileImage =
                        new File(Environment
                                .getExternalStoragePublicDirectory("myProject"),
                                new Date().toString() + ".jpg");

                imageUri = Uri.fromFile(fileImage);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        imageUri);

                startActivityForResult(intent,4563);
            }
        });

        findViewById(R.id.btnList)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final ImageView image =
                                (ImageView) findViewById(R.id.imageCaptured);
                        image.setVisibility(View.GONE);

                        final ListView listCaptured =
                                (ListView) findViewById(R.id.listCapturedPhotos);
                        listCaptured.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                final ImageView image =
                                        (ImageView) findViewById(R.id.imageCaptured);
                                image.setVisibility(View.VISIBLE);

                                final ListView listCaptured =
                                        (ListView) findViewById(R.id.listCapturedPhotos);
                                listCaptured.setVisibility(View.GONE);

                                TextView text = (TextView) view;

                                File file = new File(Environment.getExternalStoragePublicDirectory("myProject"),text.getText().toString());
                                image.setImageURI(Uri.fromFile(file));

                            }
                        });
                        listCaptured.setVisibility(View.VISIBLE);

                        File rootDir =
                                Environment
                                        .getExternalStoragePublicDirectory("myProject");

                        ArrayList<String> listPhotos = new ArrayList<String>();

                        for(File file : rootDir.listFiles()) {

                            listPhotos.add(file.getName());
                        }

                        ArrayAdapter<String> adapter =
                                new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,listPhotos);
                        listCaptured.setAdapter(adapter);
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 4563) {
            if(resultCode == RESULT_OK){

                final ImageView image =
                        (ImageView) findViewById(R.id.imageCaptured);

                image.setImageURI(imageUri);
            }
        }
    }
}
