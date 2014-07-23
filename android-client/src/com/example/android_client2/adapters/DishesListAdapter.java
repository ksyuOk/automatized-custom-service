package com.example.android_client2.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.example.android_client2.model.Dish;

public class DishesListAdapter extends ArrayAdapter<Dish> {

    public DishesListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

}
