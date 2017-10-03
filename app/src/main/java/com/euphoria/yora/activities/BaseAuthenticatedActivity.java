package com.euphoria.yora.activities;

import android.content.Intent;
import android.os.Bundle;

public abstract class BaseAuthenticatedActivity extends BaseActivity {
    @Override
    protected final void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        if(!application.getAuth().getUser().isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        //this code will only run when the user is logged in
        onYoraCreate(savedState);
    }

    protected abstract void onYoraCreate(Bundle savedState);
}
