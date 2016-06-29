package com.codekul.comman;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {

    private MyImpl impl = new MyImpl();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return impl;
    }

    public class MyImpl extends IKeyListener.Stub {

        @Override
        public char hereIsKey(int key) throws RemoteException {
            return (char)key;
        }
    }
}
