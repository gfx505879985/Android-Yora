package com.euphoria.yora.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.euphoria.yora.R;

public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private Button loginButton;
    private Callbacks callback;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle savedState) {
        View view = inflater.inflate(R.layout.fragment_login, root, false);

        loginButton = (Button) view.findViewById(R.id.fragment_login_loginButton);
        loginButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == loginButton) {
            //notify parent activity
            application.getAuth().getUser().setLoggedIn(true);
            callback.onLoggedIn();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callback = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    public interface Callbacks{
        void onLoggedIn();
    }
}
