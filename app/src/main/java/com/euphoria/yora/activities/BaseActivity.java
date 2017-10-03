package com.euphoria.yora.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.euphoria.yora.infrastructure.YoraApplication;

public class BaseActivity extends AppCompatActivity {
    protected YoraApplication application;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        application = (YoraApplication) getApplication();
    }
}
