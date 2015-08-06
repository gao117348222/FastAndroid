package com.gx303.framedemo.cardview;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.gx303.fastandroid.adapter.RecyclerViewViewHolder;
import com.gx303.fastandroid.view.RecyclerView.PullCallback;
import com.gx303.framedemo.R;

import java.util.ArrayList;
import java.util.List;

import static com.gx303.fastandroid.utils.FastLogUtils.e;

/**
 * Created by Administrator on 2015/8/5.
 */
public class recycler_fresh extends com.gx303.fastandroid.BaseActivity {
    com.gx303.fastandroid.view.RecyclerView.PullToLoadView rv1;
    List<String> datas1;
    @Override
    public void setContentView() {
        setContentView(R.layout.recycler_fresh_main);
    }

    @Override
    public void findViews() {
        rv1=(com.gx303.fastandroid.view.RecyclerView.PullToLoadView)findViewById(R.id.pulltoloadview);
        rv1.getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        rv1.getRecyclerView().setItemAnimator(new DefaultItemAnimator());
        rv1.getRecyclerView().setHasFixedSize(true);

    }

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
        com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String> adapter1=new com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String>(getApplicationContext(),datas1,R.layout.cardview_item){
            @Override
            public void convert(RecyclerViewViewHolder helper, String item) {
                TextView tv1=helper.getView(R.id.text_view);
                tv1.setText(item);
            }
        };
        rv1.getRecyclerView().setAdapter(adapter1);
        rv1.isLoadMoreEnabled(true);
        rv1.setPullCallback(new PullCallback() {
            @Override
            public void onLoadMore() {
                e("onLoadMore");
                handler.sendEmptyMessageDelayed(1, 2000);
            }

            @Override
            public void onRefresh() {
                e("onRefresh");
                handler.sendEmptyMessageDelayed(1, 2000);
            }

            @Override
            public boolean isLoading() {
                return false;
            }

            @Override
            public boolean hasLoadedAllItems() {
                return false;
            }
        });
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            rv1.setComplete();
        }
    };
}
