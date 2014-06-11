package com.example.android_client2.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.example.android_client2.service.JsonSpiceService;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;

public class BaseSpiceFragment extends Fragment {

    public ActionsListener actionsListener;
    protected SpiceManager spiceManager = new SpiceManager(JsonSpiceService.class);

    public interface ActionsListener {

        void onCategorySelected(String selectedItem);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Check that the container activity has implemented the callback interface
        try {
            actionsListener = (ActionsListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ActionsListener");
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        spiceManager.start(getActivity());
    }

    @Override
    public void onStop() {
        spiceManager.shouldStop();
        super.onStop();
    }

    protected SpiceManager getSpiceManager() {
        return spiceManager;
    }
}
