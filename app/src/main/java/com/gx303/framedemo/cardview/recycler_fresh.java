package com.gx303.framedemo.cardview;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.gx303.fastandroid.adapter.RecyclerViewViewHolder;
//import com.gx303.fastandroid.view.RecyclerView.PullCallback;
import com.gx303.fastandroid.view.recyclerview1.PullLoadMoreRecyclerView;
import com.gx303.framedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/5.
 */
public class recycler_fresh extends com.gx303.fastandroid.BaseActivity {
    com.gx303.fastandroid.view.recyclerview1.PullLoadMoreRecyclerView rv1;
    List<String> datas1;
    @Override
    public void setContentView() {
        setContentView(R.layout.recycler_fresh_main);
    }

    @Override
    public void findViews() {
        rv1=(com.gx303.fastandroid.view.recyclerview1.PullLoadMoreRecyclerView)findViewById(R.id.pulltoloadview);
//        rv1.setRefreshing(true);
//        new DataAsyncTask().execute();
        rv1.setLinearLayout();
        rv1.setPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener(){
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(1,2000);
            }

            @Override
            public void onLoadMore() {
                handler.sendEmptyMessageDelayed(2,2000);
            }
        });
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
    com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String> adapter1;
    @Override
    public void showContent() {
        adapter1=new com.gx303.fastandroid.adapter.FastRecyclerViewAdapter<String>(getApplicationContext(),datas1,R.layout.cardview_item){
            @Override
            public void convert(RecyclerViewViewHolder helper, String item) {
                TextView tv1=helper.getView(R.id.text_view);
                tv1.setText(item);
            }
        };
        rv1.setAdapter(adapter1);
    }
    int i=0;
    int j=0;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what)
            {
                case 1:
                    datas1.add(0, "刷新出来的" + i++);
//                    adapter1.notifyItemInserted(0);
                    adapter1.notifyDataSetChanged();
                    break;
                case 2:
                    datas1.add(datas1.size(),"load出来的"+j++);
//                    adapter1.notifyItemInserted(datas1.size());
                    adapter1.notifyDataSetChanged();
                    break;
            }
            rv1.setPullLoadMoreCompleted();
        }
    };
}
