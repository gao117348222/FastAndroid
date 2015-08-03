package com.gx303.framedemo.recyelcviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gx303.framedemo.R;

import java.util.List;

/**
 * Created by Administrator on 2015/8/3.
 */
public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    private List<String> actors;

    private Context mContext;
    public adapter(Context context , List<String> actors)
    {
        mContext=context;
        this.actors=actors;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.imagetestlistviewitem, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Glide.with(mContext)
                .load(actors.get(i))
                .into(viewHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    // 重写的自定义ViewHolder
    public static class ViewHolder
            extends RecyclerView.ViewHolder
    {
//        public TextView mTextView;
//
        public ImageView mImageView;

        public ViewHolder( View v )
        {
            super(v);
//            mTextView = (TextView) v.findViewById(R.id.name);
            mImageView = (ImageView) v.findViewById(R.id.imageView2);
        }
    }
}
