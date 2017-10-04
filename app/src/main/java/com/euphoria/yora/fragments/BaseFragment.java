package com.euphoria.yora.fragments;

import android.app.Fragment;
import android.os.Bundle;

import com.euphoria.yora.infrastructure.YoraApplication;

public class BaseFragment extends Fragment {
    protected YoraApplication application;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        application = (YoraApplication) getActivity().getApplication();

    }
}
