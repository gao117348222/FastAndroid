package com.gx303.fastandroid.view.RecyclerView;

/**
 * @author bian.xd
 */
public interface PullCallback {

    void onLoadMore();

    void onRefresh();

    boolean isLoading();

    boolean hasLoadedAllItems();

}
