package com.gx303.fastandroid.http;

import android.util.Log;


import com.gx303.fastandroid.utils.LogUtils;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2015/7/2.
 */
public class FastHttp {
    static OkHttpClient client = new OkHttpClient();
    public static void GET(String url,final FastHttpCallback callback)
    {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onFailure(e.toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                callback.onResponse(response.body().string());
            }
        });
    }
    public static void POST(String url,Map<String, String> params,final FastHttpCallback callback)
    {
        FormEncodingBuilder FEB1=new FormEncodingBuilder();
        if (params != null) {
            for (Map.Entry<String, String> e : params.entrySet()) {
                FEB1.add(e.getKey(),e.getValue());
            }
        }
        RequestBody formBody=FEB1.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onFailure(e.toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                callback.onResponse(response.body().string());
            }
        });

    }


}
