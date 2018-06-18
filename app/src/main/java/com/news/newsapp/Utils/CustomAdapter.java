package com.news.newsapp.Utils;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.news.newsapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joseph on 6/17/2018.
 */

/**
 * Class that enables our data to get correctly displayed in a custom ListView layout.xml file
 */
public class CustomAdapter extends SimpleAdapter {
    private ArrayList<HashMap<String, String>> mItems;
    private ArrayList<HashMap<String, String>> mItemsSelected = new ArrayList<HashMap<String, String>>();
    private Context mContext;
    private LayoutInflater mInflater;
    private int mLayoutId;
    private String[] mFrom;
    private int[] mTo;

    private ViewHolder holder = null;
    private OnListAdapterEventListener mListener;

    public CustomAdapter(Context context, ArrayList<HashMap<String,String>> items, int resourceId, String[] from, int[] to) {
        super(context, items, resourceId, from, to);
        mContext  = context;
        mLayoutId = resourceId;
        mItems    = items;
        mFrom     = from;
        mTo       = to;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(mLayoutId, null);

            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.new_title);

            holder.button = (ImageView) convertView.findViewById(R.id.fav_button);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener!=null) {
                        int position = (Integer) view.getTag();
                        mListener.onItemButtonClick(view, mItems.get(position));
                    }
                }
            });

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        HashMap<String, String> item = mItems.get(position);
        if(item==null){
            return convertView;
        }

        for (int i = 0; i < mTo.length; i++) {
            switch (mTo[i]) {
                case R.id.new_title: {
                    holder.title.setText(Html.fromHtml(item.get(mFrom[i])));
                    break;
                }
            }
        }
        holder.button.setTag(position);
        return convertView;
    }

    public static class ViewHolder {
        public TextView title;
        public TextView description;
        public ImageView button;
    }

    public interface OnListAdapterEventListener {
        void onItemButtonClick(View view, HashMap<String, String> item);
    }
}