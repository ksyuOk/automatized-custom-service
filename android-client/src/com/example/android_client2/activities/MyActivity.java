package com.example.android_client2.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.example.android_client2.R;
import com.example.android_client2.fragments.CategoryFragment;
import com.example.android_client2.model.CategoriesFeed;
import com.example.android_client2.requests.GetAllCategories;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MyActivity extends FragmentActivity implements CategoryFragment.ActionsListener{

    private CategoryFragment categoryFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        categoryFragment = (CategoryFragment) getSupportFragmentManager().findFragmentById(R.id.fr_category);
//        startLoadMenu();
    }

    private void startLoadMenu(){
        GetAllCategories getAllCategories = new GetAllCategories();
        getAllCategories.execute();


    }

    @Override
    public void onCategorySelected(String selectedItem) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
