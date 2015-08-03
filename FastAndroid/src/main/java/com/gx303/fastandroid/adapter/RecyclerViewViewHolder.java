package com.gx303.fastandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by Administrator on 2015/8/3.
 */
public class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
    SparseArray viewmap;
    View convertView;
    public RecyclerViewViewHolder(View itemView) {
        super(itemView);
        this.convertView=itemView;
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
