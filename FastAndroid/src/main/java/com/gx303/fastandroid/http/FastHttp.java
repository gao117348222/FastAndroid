package com.gx303.fastandroid.http;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gx303.fastandroid.utils.LogUtils;

import org.json.JSONObject;

/**
 * Created by Administrator on 2015/7/2.
 */
public class FastHttp {
    public static void getJson(String url,String requestBody,FastHttpCallback callback)
    {
        useValleyJson(Request.Method.GET,url,requestBody,callback);

    }
    public static void postJson(String url,String requestBody,FastHttpCallback callback)
    {
        useValleyJson(Request.Method.GET,url,requestBody,callback);
    }
    private static void useValleyJson(int method,String url,String requestBody, final FastHttpCallback callback)
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                callback.onEnd();
                callback.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onEnd();
                callback.onErrorResponse(error);
            }
        });
        if(RequestQueueManager.getInstance().getRequsetQueue()!=null)
        {
            callback.onStart();
            RequestQueueManager.getInstance().getRequsetQueue().add(jsonObjectRequest);
        }
        else
        {
            LogUtils.error("RequestQueueManager为空，请设置一个application并继承BaseFragmentActivity");
        }
    }
}
