package com.gx303.framedemo.pulllistview;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gx303.framedemo.R;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by Administrator on 2015/7/1.
 */
public class PullRefreshActivity extends Activity {

    private LinearLayout linearLayout;
    private ImageView imageView;
    private PtrFrameLayout ptrFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pulllistview);
        ptrFrameLayout = (PtrFrameLayout) findViewById(R.id.store_house_ptr_frame);


        final StoreHouseHeader storeHouseHeader = new StoreHouseHeader(getApplicationContext());
        //storeHouseHeader.initWithString("Domon");//使用文字
        storeHouseHeader.initWithStringArray(R.array.storehouse);
        ptrFrameLayout.setResistance(1.7f);//阻尼系数,默认: 1.7f，越大，感觉下拉时越吃力。
        ptrFrameLayout.setRatioOfHeaderHeightToRefresh(1.2f);//触发刷新时移动的位置比例,默认，1.2f，移动达到头部高度1.2倍时可触发刷新操作。
        ptrFrameLayout.setDurationToClose(200);//回弹延时,默认 200ms，回弹到刷新高度所用时间
        ptrFrameLayout.setDurationToCloseHeader(3000);//头部回弹时间,默认1000ms
        ptrFrameLayout.setPullToRefresh(false);//刷新是保持头部,默认值 true.
        ptrFrameLayout.setKeepHeaderWhenRefresh(true);//下拉刷新 / 释放刷新,默认为释放刷新
        ptrFrameLayout.setHeaderView(storeHouseHeader);
        ptrFrameLayout.addPtrUIHandler(storeHouseHeader);
        ptrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrFrameLayout.autoRefresh(false);
            }
        }, 100);
        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return true;
            }
            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        frame.refreshComplete();
                    }
                }, 2000);
            }
        });


    }
}
