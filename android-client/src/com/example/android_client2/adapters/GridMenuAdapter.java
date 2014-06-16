package com.example.android_client2.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class GridMenuAdapter extends ArrayAdapter {
    public GridMenuAdapter(Context context, int textViewResourceId, Object[] objects) {
        super(context, textViewResourceId, objects);
    }

    public GridMenuAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public GridMenuAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public GridMenuAdapter(Context context, int resource, int textViewResourceId, Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public GridMenuAdapter(Context context, int textViewResourceId, List objects) {
        super(context, textViewResourceId, objects);
    }

    public GridMenuAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
