package com.gx303.fastandroid.view.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gx303.fastandroid.R;

import java.util.ArrayList;
import java.util.List;

import static com.gx303.fastandroid.utils.FastLogUtils.e;

/**
 * Created by Administrator on 2015/8/11.
 */
public class FastLoopViewPager extends ViewPager {
    Context mContext;
    public FastLoopViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
    }
    public FastLoopViewPager(Context context) {
        super(context);
        mContext=context;
    }
    private List<String> images;
    public void setImages(List<String> imageUrls,final onClickViewPagerItemListsner listener)
    {
        this.images=imageUrls;
        List<View> list1=new ArrayList<>();
        for(int i=0;i<imageUrls.size();i++)
        {
            ImageView iv1=new ImageView(mContext);
            iv1.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(mContext)
                    .load(imageUrls.get(i))
                    .into(iv1);
            iv1.setTag(R.layout.fastloopviewpager_withincicator_main, i);
            iv1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int index = (int) ((ImageView) v).getTag(R.layout.fastloopviewpager_withincicator_main);
                        listener.onclick(index);
                    }
                }
            });
            list1.add(iv1);
        }
        MyViewPagerAdapter adapter=new MyViewPagerAdapter(list1);
        super.setAdapter(adapter);
        super.setCurrentItem(list1.size() * 20000);
    }
    public int getCount()
    {
        return images.size();
    }
    public int getCurrentItem1()
    {
        e("aa"+super.getCurrentItem()+" "+getCount()+" "+super.getCurrentItem()%getCount());
        return super.getCurrentItem()%getCount();
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private List<View> mListViews;
        private int MAX_INT=Integer.MAX_VALUE;
        public MyViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mListViews.get(position % mListViews.size()));//删除页卡
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {//这个方法用来实例化页卡
            container.addView(mListViews.get(position % mListViews.size()), 0);//添加页卡
            return mListViews.get(position%mListViews.size());
        }

        @Override
        public int getCount() {
            return  MAX_INT;//返回页卡的数量
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }

    }
}
