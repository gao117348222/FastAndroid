package com.gx303.fastandroid.adapter;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by Administrator on 2015/7/2.
 */
public class ViewHolder {
    SparseArray viewmap;
    View convertView;
    public ViewHolder(View convertView)
    {
        this.convertView=convertView;
        viewmap=new SparseArray();
    }
    public <T1 extends View> T1 getView(int id)
    {
        if(viewmap.get(id,-1)!=-1)
        {
            return (T1)viewmap.get(id);
        }
        else
        {
            T1 tv1= (T1)convertView.findViewById(id);
            viewmap.put(id,tv1);
            return  tv1;
        }
    }
}
