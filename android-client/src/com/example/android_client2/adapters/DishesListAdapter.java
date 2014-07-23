package com.example.android_client2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android_client2.R;
import com.example.android_client2.model.Dish;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class DishesListAdapter extends ArrayAdapter<Dish> {

    private Context mContext;
    private int mLayoutResourceId;
    private List<Dish> dishesList = new ArrayList<Dish>();
    private ImageLoader mImageLoader;
    private DisplayImageOptions displayImageOptions;


    public DishesListAdapter(Context context, int textViewResourceId, List<Dish> dishesList) {
        super(context, textViewResourceId, dishesList);
        this.dishesList = dishesList;
        this.mContext = context;
        this.mLayoutResourceId = textViewResourceId;
        this.mImageLoader = ImageLoader.getInstance();
        this.displayImageOptions = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.men4)
                .cacheInMemory(true)
                .build();
    }

    private static class ViewHolder{
        ImageView dishImage;
        TextView dishName;
        TextView dishDescription;
        TextView dishPrice;
        TextView dishWeight;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup){
         ViewHolder viewHolder;
        Dish dish = dishesList.get(position);
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(mLayoutResourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.dishImage = (ImageView) view.findViewById(R.id.imageDish);
            viewHolder.dishName = (TextView) view.findViewById(R.id.dishName);
            viewHolder.dishDescription = (TextView) view.findViewById(R.id.dishDescription);
            viewHolder.dishPrice = (TextView) view.findViewById(R.id.dishPrice);
            viewHolder.dishWeight = (TextView) view.findViewById(R.id.dishWeight);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if(dish != null){
            viewHolder.dishImage.setImageResource(R.drawable.little_foto_dish);
            viewHolder.dishName.setText(dish.getNameDish());
            viewHolder.dishDescription.setText(dish.getDescriptionDish());
            viewHolder.dishPrice.setText(String.valueOf(dish.getPriceDish()));
            viewHolder.dishWeight.setText(String.valueOf(dish.getTimeCook()));
        }
        return view;
    }
}
