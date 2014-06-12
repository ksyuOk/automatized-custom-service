package com.example.android_client2.requests;

import android.net.Uri;
import android.os.AsyncTask;
import com.example.android_client2.ConstantsACS;
import com.example.android_client2.model.CategoriesFeed;
import com.example.android_client2.model.Category;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class GetAllCategories extends AsyncTask {

    @Override
    protected Object doInBackground(Object... objects) {
        String getCategoriesUrl = ConstantsACS.GET_CATEGORIES_URL;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        ResponseEntity<Category> responce = restTemplate.getForEntity(getCategoriesUrl, Category.class);
        int i = 0+2;

//        HttpClient httpClient = new DefaultHttpClient();
//        String url = "http://10.0.2.2:8085/service/categories/all";
//        String updateUrl = Uri.decode(url);
//        HttpGet httpGet = new HttpGet(updateUrl);
////        httpGet.setHeader("accept", "application/json");
////        httpGet.setHeader("cache_control", "no-cache");
//
//        HttpResponse httpResponse = null;
//        org.json.JSONObject jsonResponce = null;
//        try {
//            httpResponse = httpClient.execute(httpGet);
//            if (httpResponse != null) {
//                String responceString = EntityUtils.toString(httpResponse.getEntity());
//                try {
//                    jsonResponce = new org.json.JSONObject(responceString);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
