package com.gx303.fastandroid.view.recyclerview;

/**
 * Created by Administrator on 2015/8/6.
 */
import android.support.v4.widget.SwipeRefreshLayout;
public class SwipeRefreshLayoutOnRefresh implements SwipeRefreshLayout.OnRefreshListener  {
    PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;

    public SwipeRefreshLayoutOnRefresh(PullLoadMoreRecyclerView pullLoadMoreRecyclerView) {
        this.mPullLoadMoreRecyclerView = pullLoadMoreRecyclerView;
    }

    @Override
    public void onRefresh() {
        if (!mPullLoadMoreRecyclerView.isRefresh()) {
            mPullLoadMoreRecyclerView.setIsRefresh(true);
            mPullLoadMoreRecyclerView.refresh();
        }
    }
}
