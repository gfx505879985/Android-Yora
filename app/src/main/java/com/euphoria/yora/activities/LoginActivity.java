package com.euphoria.yora.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.euphoria.yora.R;
import com.euphoria.yora.fragments.LoginFragment;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginFragment.Callbacks {
    private static final int REQUEST_NARROW_LOGIN = 1;
    private static final int REQUEST_REGISTER = 2;

    private View loginButton;
    private View registerButton;
    private View googleButton;
    private View facebookButton;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.activity_login_login);
        registerButton = findViewById(R.id.activity_login_register);
        googleButton = findViewById(R.id.activity_login_google);
        facebookButton = findViewById(R.id.activity_login_facebook);

        if(loginButton != null) {
            loginButton.setOnClickListener(this);
        }

        registerButton.setOnClickListener(this);
        googleButton.setOnClickListener(this);
        facebookButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == loginButton)
            startActivityForResult(new Intent(this, LoginNarrowActivity.class),REQUEST_NARROW_LOGIN);
        else if (v == registerButton)
            startActivityForResult(new Intent(this, RegisterActivity.class),REQUEST_REGISTER);
        else if (v == googleButton)
            doExternalLogin("Google");
        else if (v == facebookButton)
            doExternalLogin("Facebook");
    }

    private void doExternalLogin(String externalProvider) {
        Intent intent = new Intent (this, ExternalLoginActivity.class);
        intent.putExtra(ExternalLoginActivity.EXTRA_EXTERNAL_SERVICE, externalProvider);
        startActivityForResult(intent, REQUEST_REGISTER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != RESULT_OK)
            return;
        if(requestCode == REQUEST_NARROW_LOGIN || requestCode == REQUEST_REGISTER)
            finishLogin();
    }

    private void finishLogin() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onLoggedIn() {
        finishLogin();
    }
}
