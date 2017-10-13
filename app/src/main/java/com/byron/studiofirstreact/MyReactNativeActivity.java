package com.byron.studiofirstreact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.react.ReactActivity;

import javax.annotation.Nullable;

public class MyReactNativeActivity extends ReactActivity {

    @Nullable
    @Override
    protected String getMainComponentName() {
        return "StudioFirstReact";
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
