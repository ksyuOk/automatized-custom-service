package com.example.android_client2.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android_client2.R;
import com.example.android_client2.model.Category;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class GridMenuAdapter extends ArrayAdapter<Category> {

    private Context mContext;
    private int mLayoutResourceId;
    private List<Category> mCategoryList = new ArrayList<Category>();
    private ImageLoader mImageLoader;
    private DisplayImageOptions displayImageOptions;

    public GridMenuAdapter(Context context, int textViewResourceId, List<Category> categories) {
        super(context, textViewResourceId, categories);
        this.mCategoryList = categories;
        this.mLayoutResourceId = textViewResourceId;
        this.mContext = context;
        this.mImageLoader = ImageLoader.getInstance();
        this.displayImageOptions = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.bg_logo)
                .showImageForEmptyUri(R.drawable.bg_logo)
                .cacheInMemory()
                .build();
    }

    private static class ViewHolder{
        TextView nameCategory;
        ImageView imageView;
    }

//    @Override
//    public int getViewTypeCount() {
//        return 2;
//    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup){
        ViewHolder holder;
        Category category = mCategoryList.get(position);
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(mLayoutResourceId, null);
            holder = new ViewHolder();
            holder.nameCategory = (TextView) view.findViewById(R.id.categoryName);
            holder.imageView = (ImageView) view.findViewById(R.id.image_category);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if(category != null){
            holder.nameCategory.setText(category.getNameCategory());
            Bitmap bitmap = mImageLoader.loadImageSync("http://localhost:8085/service/categories/image/1");
            mImageLoader.displayImage("http://localhost:8085/service/categories/image/1", holder.imageView, displayImageOptions);
        }
        return view;
    }
}
