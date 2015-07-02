package com.gx303.fastandroid.http;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Administrator on 2015/7/2.
 */
public interface FastHttpCallback {
    /**
     * 网络请求开始
     */
    public void onStart();

    /**
     * 网络请求结束
     */
    public void onEnd();

    /**
     * 正确获取JSON
     * @param response
     */
    public void onResponse(JSONObject response);

    /**
     * 网络请求错误
     * @param error
     */
    public void onErrorResponse(VolleyError error);
}
