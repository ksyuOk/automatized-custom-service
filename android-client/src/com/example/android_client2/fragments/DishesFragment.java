package com.example.android_client2.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.android_client2.R;
import com.example.android_client2.model.DishesFeed;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

public class DishesFragment extends BaseSpiceFragment {

    private static String TAG = DishesFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dishes_layout, null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private RequestListener<DishesFeed> dishesFeedRequestListener = new RequestListener<DishesFeed>() {
        @Override
        public void onRequestFailure(SpiceException spiceException) {
            Log.d(TAG, "Error receiving categories: " + spiceException);
        }

        @Override
        public void onRequestSuccess(DishesFeed dishesFeed) {
            ListView dishesList = (ListView) getActivity().findViewById(R.id.listDishes);

        }
    };

//    private RequestListener<CategoriesFeed> categoriesFeedRequestListener = new RequestListener<CategoriesFeed>() {
//        @Override
//        public void onRequestFailure(SpiceException spiceException) {
//            Log.d(TAG, "Error receiving categories: " + spiceException);
//        }
//
//        @Override
//        public void onRequestSuccess(final CategoriesFeed categoriesFeed) {
//            GridView gridView = (GridView) getActivity().findViewById(R.id.grid_view);
//            GridMenuAdapter gridAdapter = new GridMenuAdapter(getActivity(), R.layout.category_grid_layout, categoriesFeed);
//            gridView.setAdapter(gridAdapter);
//            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                    Toast.makeText(getActivity(),""+view.getTag(), Toast.LENGTH_LONG).show();
//                    Category selectedCategory = categoriesFeed.get(i);
//                    actionsListener.onCategorySelected(selectedCategory.getNameCategory());
//                }
//            });
//        }
//    };
}
