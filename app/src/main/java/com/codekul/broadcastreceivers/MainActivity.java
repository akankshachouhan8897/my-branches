package com.codekul.broadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //registerBroadcastReceiverViaCode();

        findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fireOwnBroadCast();
            }
        });
    }

    private void registerBroadcastReceiverViaCode(){

        // if u register via code
        // u will receive broadcast only when
        // app is running

        IntentFilter filter =
                new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(new MyReceiver(),filter);
    }

    private void fireOwnBroadCast(){

        Intent intent =
                new Intent("com.codekul.action.custom.broadcast");

        sendBroadcast(intent);
    }
}
