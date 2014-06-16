package com.example.android_client2.requests;

import com.example.android_client2.ConstantsACS;
import com.example.android_client2.model.CategoriesFeed;
import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;
import org.springframework.http.*;

public class CategoryRequest extends SpringAndroidSpiceRequest<CategoriesFeed> {

    private final HttpEntity<Object> mRequestEntity;
    private final HttpHeaders headers;

    public CategoryRequest() {
        super(CategoriesFeed.class);
        headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"));
        mRequestEntity = new HttpEntity<Object>(headers);
    }

    @Override
    public CategoriesFeed loadDataFromNetwork() throws Exception {
        ResponseEntity<CategoriesFeed> result = getRestTemplate().exchange(ConstantsACS.GET_CATEGORIES_URL, HttpMethod.GET, mRequestEntity, getResultType());
        CategoriesFeed bb = result.getBody();
        return getRestTemplate().exchange(ConstantsACS.GET_CATEGORIES_URL, HttpMethod.GET, mRequestEntity,getResultType()).getBody();
    }

    public static String getCacheKey() {
        return ConstantsACS.GET_CATEGORIES_URL;
    }
}
