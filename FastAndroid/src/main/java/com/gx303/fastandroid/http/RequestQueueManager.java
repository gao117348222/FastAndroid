package com.gx303.fastandroid.http;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2015/7/2.
 */
public class RequestQueueManager {
    private static RequestQueueManager instance;
    public static RequestQueueManager getInstance()
    {
        if(instance==null)
        {
            instance=new RequestQueueManager();
        }
        return  instance;
    }
    private RequestQueue requestQueue;
    public void createRequsetQueue(Context context)
    {
        requestQueue= Volley.newRequestQueue(context);
    }
    public RequestQueue getRequsetQueue()
    {
        return requestQueue;
    }
}
