package com.gx303.fastandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2015/8/3.
 */
public abstract class FastRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewViewHolder> {
    List<T> mDatas;
    private LayoutInflater mInflater;
    private Context mContext;
    private int listViewItemLayout;
    public FastRecyclerViewAdapter(Context context, List<T> mDatas, int listViewItemLayout)
    {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
        this.listViewItemLayout=listViewItemLayout;
    }
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(listViewItemLayout, viewGroup, false);
        return new RecyclerViewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewViewHolder recyclerViewViewHolder, int i) {
        convert(recyclerViewViewHolder,mDatas.get(i));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    public abstract void convert(RecyclerViewViewHolder helper, T item);
}
