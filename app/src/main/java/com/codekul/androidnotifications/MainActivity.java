package com.codekul.androidnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int ID_NOTIFICATION_COMPACT = 1235;
    private static final int REQUEST_NOTIFICATION_ACT = 5698;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnToast).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

               createNormalToast();
            }
        });

        findViewById(R.id.btnStatusBar).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                notificationWithActions();
            }
        });
    }

    private final void createNormalToast(){

        Toast.makeText( MainActivity.this,
                "This is toast",
                Toast.LENGTH_SHORT).show();
    }

    private final void createCustomToast(){

        Toast toast = Toast.makeText(MainActivity.this,"This is toast",Toast.LENGTH_LONG);

        Button button = new Button(this);
        button.setText("Okay");

        toast.setView(button);
        toast.show();
    }

    private final void simpleStatusBarNotification(){

        Notification.Builder builder =
                new Notification.Builder(this)
                .setTicker("Ticker")
                .setContentText("Content Text")
                .setContentTitle("Content Title")
                .setSmallIcon(R.mipmap.ic_launcher); // builder design pattern

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            Notification notification = builder.build();

            NotificationManager manager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(ID_NOTIFICATION_COMPACT,notification);

            // here you will need notification compact
        }
    }

    private final void createCompitibleNotification(){

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Content Title")
                .setContentInfo("Content Info")
                .setContentText("Content Text")
                .setTicker("Ticker");

        Notification notification =
                builder.build();

        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(ID_NOTIFICATION_COMPACT,notification);
    }

    private final void notificationWithSomeFlags(){

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Content Title")
                        .setContentInfo("Content Info")
                        .setContentText("Content Text")
                        .setTicker("Ticker")
                        .setDefaults(Notification.DEFAULT_ALL);

        Notification notification =

                builder.build();
        notification.flags = Notification.FLAG_NO_CLEAR;

        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(ID_NOTIFICATION_COMPACT,notification);
    }

    private final void notificationWithPendingIntents(){


        Intent content = new Intent(this,NotificationActivity.class);

        PendingIntent intent = PendingIntent
                .getActivity(this,
                        REQUEST_NOTIFICATION_ACT,
                        content,
                        PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Content Title")
                        .setContentInfo("Content Info")
                        .setContentText("Content Text")
                        .setTicker("Ticker")
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setContentIntent(intent);

        Notification notification =
                builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;

        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(ID_NOTIFICATION_COMPACT,notification);
    }

    private final void notificationWithActions(){

        Intent content = new Intent(this,NotificationActivity.class);

        PendingIntent intent = PendingIntent
                .getActivity(this,
                        REQUEST_NOTIFICATION_ACT,
                        content,
                        PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Content Title")
                        .setContentInfo("Content Info")
                        .setContentText("Content Text")
                        .setTicker("Ticker")
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setContentIntent(intent)
                        .addAction(R.mipmap.ic_launcher,"Title",intent);

        Notification notification =
                builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;

        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(ID_NOTIFICATION_COMPACT,notification);
    }
}
