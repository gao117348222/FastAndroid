package com.gx303.fastandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/7/2.
 */
public abstract class FastAdapter<T> extends BaseAdapter {
    List<T> mDatas;
    private LayoutInflater mInflater;
    private Context mContext;
    private int listViewItemLayout;
    public FastAdapter(Context context, List<T> mDatas, int listViewItemLayout)
    {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
        this.listViewItemLayout=listViewItemLayout;
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            convertView = mInflater.inflate(listViewItemLayout, parent,
                    false);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        convert(viewHolder,mDatas.get(position));
        return convertView;
    }
    public abstract void convert(ViewHolder helper, T item);

}
