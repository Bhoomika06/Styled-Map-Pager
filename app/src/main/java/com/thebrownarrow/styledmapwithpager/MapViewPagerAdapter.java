package com.thebrownarrow.styledmapwithpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thebrownarrow.model.MyLocation;

import java.util.ArrayList;

public class MapViewPagerAdapter extends PagerAdapter {

    ArrayList<MyLocation> arr_LocationList;
    Context context;

    public MapViewPagerAdapter(Context context, ArrayList<MyLocation> arr_ExploreList) {
        this.context = context;
        this.arr_LocationList = arr_ExploreList;
    }

    @Override
    public int getCount() {
        return arr_LocationList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.row_map_pager, null);

        LinearLayout lnr_main = (LinearLayout) itemView.findViewById(R.id.lnr_main);
        TextView tv_name = (TextView) itemView.findViewById(R.id.tv_name);

        final MyLocation myLocation = arr_LocationList.get(position);

        tv_name.setText("Location:" + (position + 1));

        container.addView(itemView);

        return itemView;
    }

}
