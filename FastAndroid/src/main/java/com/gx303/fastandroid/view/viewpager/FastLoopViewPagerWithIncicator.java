package com.gx303.fastandroid.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.gx303.fastandroid.R;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 自带圆点的无限循环Viewpager，只需要传入图片url即可
 */
public class FastLoopViewPagerWithIncicator extends RelativeLayout {
    private Context mContext;
    private FastLoopViewPager mViewPager;
    private PageIndicator  mPageIndicator;

    public FastLoopViewPagerWithIncicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }
    public FastLoopViewPagerWithIncicator(Context context) {
        super(context);
        initView(context);
    }
    private void initView(Context context) {
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.fastloopviewpager_withincicator_main, null);
        mViewPager=(com.gx303.fastandroid.view.viewpager.FastLoopViewPager)view.findViewById(R.id.viewpager);
        mPageIndicator=(com.gx303.fastandroid.view.viewpager.PageIndicator)view.findViewById(R.id.indicator);


        super.addView(view);
    }
    public void setImages(List<String> imageUrls,onClickViewPagerItemListsner listsner)
    {
        mViewPager.setImages(imageUrls, listsner);
        mPageIndicator.setViewPager(mViewPager);
    }
    Timer timer = new Timer();
    private TimerTask task;
    public void startAutoLoop(long delay, long period)
    {
        if(task==null) {
            task = new TimerTask() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    handlerLoop.sendEmptyMessage(0);
                }
            };
        }
        timer.schedule(task, delay, period);
    }
    public void endAutoLoop()
    {
        timer.cancel();
    }
    Handler handlerLoop=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
        }
    };
}
