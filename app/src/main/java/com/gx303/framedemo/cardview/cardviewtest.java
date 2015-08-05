package com.gx303.framedemo.cardview;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gx303.fastandroid.adapter.RecyclerViewViewHolder;
import com.gx303.framedemo.R;
import com.gx303.framedemo.recyelcviewdemo.adapter;

import java.util.ArrayList;
import java.util.List;

import static com.gx303.fastandroid.utils.LogUtils.e;

/**
 * Created by Administrator on 2015/8/4.
 */
public class cardviewtest extends com.gx303.fastandroid.BaseActivity {
    @Override
    public void setContentView() {
        setContentView(R.layout.cardviewtest_main);
    }
    RecyclerView rv1;
    List<String> datas1;
    SwipeRefreshLayout refreshLayout1;//下拉刷新
    LinearLayoutManager mLayoutManager;
    @Override
    public void findViews() {
        rv1=(RecyclerView)findViewById(R.id.recyclerview1);

//        rv1.setLayoutManager(new LinearLayoutManager(this));
        mLayoutManager=new LinearLayoutManager(this);
        rv1.setLayoutManager(mLayoutManager);
//        rv1.setLayoutManager(new GridLayoutManager(this, 3));
        // 设置ItemAnimator
        rv1.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        rv1.setHasFixedSize(true);

        refreshLayout1=(SwipeRefreshLayout)findViewById(R.id.refreshLayout1);

        refreshLayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                e("刷新了");
                handler.sendEmptyMessageDelayed(1, 5000);
            }
        });



    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
               super.handleMessage(msg);
              refreshLayout1.setRefreshing(false);
                 }
        };

    @Override
    public void getData() {
        datas1=new ArrayList<String>();
        datas1.add("测试1");
        datas1.add("测试2");
        datas1.add("测试3");
        datas1.add("测试4");
        datas1.add("测试5");
        datas1.add("测试6\r\n测试6\r\n测试6");
        datas1.add("测试7\n测试7\n测试7");
        datas1.add("测试8\r测试8\r测试8");

    }

    @Override
    public void showContent() {

    }
    public void cardviewtest1(View v)
    {
        e("测试");
        com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String> adapter1=new com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String>(getApplicationContext(),datas1,R.layout.cardview_item){
            @Override
            public void convert(RecyclerViewViewHolder helper, String item) {
                TextView tv1=helper.getView(R.id.text_view);
                tv1.setText(item);
            }
        };
        rv1.setAdapter(adapter1);
    }
    public void lineartest(View v)
    {
        com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String> adapter1=new com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String>(getApplicationContext(),datas1,R.layout.cardview_linearlayout_item){
            @Override
            public void convert(RecyclerViewViewHolder helper, String item) {
                TextView tv1=helper.getView(R.id.text_view);
                tv1.setText(item);
            }
        };
        rv1.setAdapter(adapter1);
    }
    public void relatest(View v)
    {
        com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String> adapter1=new com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String>(getApplicationContext(),datas1,R.layout.cardview_relative_item){
            @Override
            public void convert(RecyclerViewViewHolder helper, String item) {
                TextView tv1=helper.getView(R.id.text_view);
                tv1.setText(item);
            }
        };
        rv1.setAdapter(adapter1);
    }
}
