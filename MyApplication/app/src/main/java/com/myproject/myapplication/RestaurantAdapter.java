package com.myproject.myapplication;

import android.widget.*;
import java.util.*;
import android.content.Context;
import android.view.*;

/**
 * Created by 77 on 12/18/17.
 */

public class RestaurantAdapter extends BaseAdapter {

    private final List<Restaurant> restaurantData;
    Context context;
    List<Restaurant> restauranData;

    public RestaurantAdapter(Context context, List<Restaurant> restaurantData) {
        this.context = context;
       // restauranData = DataService.getRestaurantData();
        this.restaurantData = restaurantData;

    }

    @Override
    public int getCount() {
        return restauranData.size();
    }

    @Override
    public Restaurant getItem(int position) {
        return restauranData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(
                            Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_restaurant_list_item,
                    parent, false);
        }

        TextView restaurantName = (TextView) convertView.findViewById(
                R.id.restaurant_name);
        TextView restaurantAddress = (TextView) convertView.findViewById(
                R.id.restaurant_address);
        TextView restaurantType = (TextView) convertView.findViewById(
                R.id.restaurant_type);
        ImageView restaurantThumbnail = (ImageView) convertView.findViewById(
                R.id.restaurant_thumbnail);
        ImageView restaurantRating = (ImageView) convertView.findViewById(
                R.id.restaurant_rating);

        Restaurant r = restauranData.get(position);
        restaurantName.setText(r.getName());
        restaurantAddress.setText(r.getAddress());
        restaurantType.setText(r.getType());
        restaurantThumbnail.setImageBitmap(r.getThumbnail());
        restaurantRating.setImageBitmap(r.getRating());

        return convertView;
    }

}
