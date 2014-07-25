package com.example.android_client2.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.example.android_client2.R;
import com.example.android_client2.fragments.CategoryFragment;
import com.example.android_client2.fragments.DishesFragment;
import com.example.android_client2.model.CategoriesFeed;
import com.example.android_client2.requests.GetAllCategories;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends FragmentActivity implements CategoryFragment.ActionsListener {

    private CategoryFragment categoryFragment;
    private DishesFragment dishesFragment;
    private final int CATEGORY_FRAGMENT = 0;
    private final int DISHES_FRAGMENT = 1;
    private final int DEFAULT_VISIBLE_FRAGMENT = CATEGORY_FRAGMENT;
    private final int FRAGMENT_NULL = -1;

    private int currentVisibleFragment = FRAGMENT_NULL;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        categoryFragment = (CategoryFragment) getSupportFragmentManager().findFragmentById(R.id.fr_category);
        dishesFragment = (DishesFragment) getSupportFragmentManager().findFragmentById(R.id.fr_dishes);
//        startLoadMenu();
        setVisibleFragment(DEFAULT_VISIBLE_FRAGMENT);

    }

    private void startLoadMenu() {
        GetAllCategories getAllCategories = new GetAllCategories();
        getAllCategories.execute();

    }

    @Override
    public void onCategorySelected(String selectedCategory) {
        dishesFragment.loadDishes();
        switchFragment();
    }

    private void setVisibleFragment(int visibleFragmentConstant) {
        if (visibleFragmentConstant != currentVisibleFragment) {

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            switch (visibleFragmentConstant) {
                case CATEGORY_FRAGMENT:
                    transaction.show(categoryFragment).
                            hide(dishesFragment).
                            commit();
                    break;
                case DISHES_FRAGMENT:
                    transaction.hide(categoryFragment).
                            show(dishesFragment).
                            commit();
                    break;
                default:
                    Log.e("MainActivity", "Wrong visible fragment constant");
            }

            currentVisibleFragment = visibleFragmentConstant;
        }
    }

    private void switchFragment() {
        switch (currentVisibleFragment) {
            case CATEGORY_FRAGMENT:
                setVisibleFragment(DISHES_FRAGMENT);
                break;
            case DISHES_FRAGMENT:
                setVisibleFragment(CATEGORY_FRAGMENT);
                break;
            default:
                Log.e("MainActivity", "Wrong visible fragment constant");
        }
    }
}
