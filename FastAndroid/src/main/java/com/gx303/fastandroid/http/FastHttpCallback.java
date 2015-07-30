package com.gx303.fastandroid.http;

/**
 * Created by Administrator on 2015/7/30.
 */
public interface FastHttpCallback {
    public void onResponse(String result);
    public void onFailure(String error);
}
