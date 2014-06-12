package com.example.android_client2.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFeed extends ArrayList<Category> {
    private static final long serialVersionUID = 8192333539004718470L;

    List<Category> mCategories;

    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(List<Category> mCategories) {
        this.mCategories = mCategories;
    }
}
