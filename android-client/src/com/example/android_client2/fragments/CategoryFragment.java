package com.example.android_client2.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.android_client2.R;
import com.example.android_client2.model.CategoriesFeed;
import com.example.android_client2.requests.CategoryRequest;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

public class CategoryFragment extends BaseSpiceFragment {

    private CategoryRequest mCategoryRequest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.category_fragment, null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragmentViews();
        mCategoryRequest = new CategoryRequest();
    }

    private void initFragmentViews() {

    }

    private RequestListener<CategoriesFeed> categoriesFeedRequestListener = new RequestListener<CategoriesFeed>() {
        @Override
        public void onRequestFailure(SpiceException spiceException) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void onRequestSuccess(CategoriesFeed categoriesFeed) {
            CategoriesFeed categoriesFeed1 = categoriesFeed;
        }
    };

    public void loadCategories() {
        getSpiceManager().execute(mCategoryRequest, CategoryRequest.getCacheKey(),
                DurationInMillis.ALWAYS, categoriesFeedRequestListener);
    }
}