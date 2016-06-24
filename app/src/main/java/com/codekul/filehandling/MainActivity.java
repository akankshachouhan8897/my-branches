package com.codekul.filehandling;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeOnPublicDirectory();
    }

    private void createNewFile(){
        // /data/data/<your-package-name>/files/private-files

        File file = new File(getFilesDir(),
                "my.txt");

        try {

            setSometText(file.createNewFile() ? "File created successfuly .." : "Problem in creating file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setSometText(String text){

        ((TextView)findViewById(R.id.textFileData))
                .append("\n"+text);
    }

    private void writeDataUsingOpenFileOutput(){

        // getFilesDir()
        try {
            FileOutputStream fos =
                    openFileOutput("my.txt",MODE_PRIVATE);

            fos.write("This is my first write".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataUsingOpenFileinput(){

        try {
            FileInputStream fis =
                    openFileInput("my.txt");
            StringBuilder builder =
                    new StringBuilder();

            while(true){
                int ch = fis.read();
                if(ch == -1) break; //EOF
                else builder.append((char)ch);
            }

            setSometText(builder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeOnExternalPrivate(){

        File file =
                new File(getExternalFilesDir(""),
                        "my.txt");

        try {
            FileOutputStream fos =
                    new FileOutputStream(file);
            fos.write("this my external write"
                    .getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readPrivateOnExternalStorage(){

        File file =
                new File(getExternalFilesDir(""),
                        "my.txt");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            StringBuilder builder =
                    new StringBuilder();

            while(true){
                int ch = fis.read();
                if(ch == -1) break; //EOF
                else builder.append((char)ch);
            }

            setSometText(builder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeOnPublicDirectory(){

        if(Environment
                .getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED)){

            File dirCodekul =
                    new File(Environment.getExternalStorageDirectory(),"codekul");

            setSometText(dirCodekul.mkdir() ? "dir created" : "error in dir creation");

            File file =
                    new File(Environment
                            .getExternalStoragePublicDirectory("codekul"),"our.txt");


            try {
                file.createNewFile();

                FileOutputStream fos =
                        new FileOutputStream(file);
                fos.write("it is on external storage"
                        .getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else{
            setSometText("Bad SD Card");
        }

    }
}
