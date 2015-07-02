package com.gx303.framedemo.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gx303.framedemo.R;

import java.util.List;

/**
 * Created by Administrator on 2015/6/30.
 */
public class lvAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;
    public  lvAdapter(Context context, List<String> mDatas)
    {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
    }
    static class ViewHolder
    {
        TextView tv1;
        TextView tv2;
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
            convertView = mInflater.inflate(R.layout.lv_item1, parent,
                    false);
            viewHolder=new ViewHolder();
            viewHolder.tv1=(TextView)convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv1.setText(mDatas.get(position));
        return convertView;
    }
}
