package com.euphoria.yora.activities;

import android.os.Bundle;

import com.euphoria.yora.R;
import com.euphoria.yora.fragments.LoginFragment;

public class LoginNarrowActivity extends BaseActivity implements LoginFragment.Callbacks{

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        setContentView(R.layout.activity_login_narrow_);

    }

    @Override
    public void onLoggedIn() {
        setResult(RESULT_OK);
        finish();
    }
}
