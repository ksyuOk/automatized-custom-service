package com.example.android_client2.fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.android_client2.R;
import com.example.android_client2.adapters.GridMenuAdapter;
import com.example.android_client2.model.CategoriesFeed;
import com.example.android_client2.model.Category;
import com.example.android_client2.requests.CategoryRequest;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import java.util.List;

public class CategoryFragment extends BaseSpiceFragment {

    private CategoryRequest mCategoryRequest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.category_fragment, null);
//        initFragmentViews();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCategoryRequest = new CategoryRequest();
        loadCategories();
//        initFragmentViews();
    }

    private void initFragmentViews() {
        ImageLoader mImageLoader= ImageLoader.getInstance();
        mImageLoader.init(ImageLoaderConfiguration.createDefault(getActivity()));
        Bitmap bitmap = mImageLoader.loadImageSync("http://10.0.2.2:8085/service/categories/image/1.png");
//        ImageView imageView = (ImageView) getActivity().findViewById(R.id.imageTest);
//        mImageLoader.displayImage("http://localhost:8085/service/categories/image/1.png", imageView);
    }

    private RequestListener<CategoriesFeed> categoriesFeedRequestListener = new RequestListener<CategoriesFeed>() {
        @Override
        public void onRequestFailure(SpiceException spiceException) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void onRequestSuccess(CategoriesFeed categoriesFeed) {
            CategoriesFeed categoriesFeed1 = categoriesFeed;
            GridView gridView = (GridView) getActivity().findViewById(R.id.grid_view);
            List<Category> categories = categoriesFeed.getCategories();
            GridMenuAdapter gridAdapter = new GridMenuAdapter(getActivity(), R.layout.grid_layout, categoriesFeed);
            gridView.setAdapter(gridAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getActivity(),""+view.getTag(), Toast.LENGTH_LONG).show();
                }
            });

        }
    };

    public void loadCategories() {
        getSpiceManager().execute(mCategoryRequest, CategoryRequest.getCacheKey(),
                DurationInMillis.ALWAYS, categoriesFeedRequestListener);


    }
}