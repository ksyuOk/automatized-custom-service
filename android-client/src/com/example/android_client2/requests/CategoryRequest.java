package com.example.android_client2.requests;

import com.example.android_client2.ConstantsACS;
import com.example.android_client2.model.CategoriesFeed;
import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public class CategoryRequest extends SpringAndroidSpiceRequest<CategoriesFeed> {

    private final HttpEntity<Object> mRequestEntity;
    private final HttpHeaders headers;

    public CategoryRequest() {
        super(CategoriesFeed.class);
        headers = new HttpHeaders();
        mRequestEntity = new HttpEntity<Object>(headers);
    }

    @Override
    public CategoriesFeed loadDataFromNetwork() throws Exception {
        return getRestTemplate().exchange(ConstantsACS.GET_CATEGORIES_URL, HttpMethod.GET, mRequestEntity,getResultType()).getBody();
    }

    public static String getCacheKey() {
        return ConstantsACS.GET_CATEGORIES_URL;
    }
}
