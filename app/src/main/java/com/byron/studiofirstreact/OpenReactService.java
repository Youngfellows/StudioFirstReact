package com.byron.studiofirstreact;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.facebook.react.common.ReactConstants.TAG;

/**
 * Created by Byron on 2017/10/12.
 */

public class OpenReactService extends Service {
    private String TAG = this.getClass().getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new OpenReactBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class OpenReactBinder extends Binder {
        public void open() {
            Log.i(TAG, "SADFASDFDSFDSFA");
            Intent intent = new Intent(OpenReactService.this, MyReactNativeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
