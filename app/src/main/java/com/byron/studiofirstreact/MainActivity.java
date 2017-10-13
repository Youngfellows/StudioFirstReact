package com.byron.studiofirstreact;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();

    private OpenReactService.OpenReactBinder openReactBinder;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "---------服务绑定成功了----------");
            openReactBinder = (OpenReactService.OpenReactBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "---------服务解绑了----------");
            openReactBinder = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG," -----onCreate()------    ");


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyReactNativeActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (openReactBinder != null) {
                    openReactBinder.open();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
       Log.i(TAG," -----onResume()------    ");
        binderService();
    }

    private void binderService() {
        Intent intent = new Intent(this, OpenReactService.class);
        startService(intent);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
