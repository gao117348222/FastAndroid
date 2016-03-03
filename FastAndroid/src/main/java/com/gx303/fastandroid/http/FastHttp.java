package com.gx303.fastandroid.http;




import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2015/7/2.
 */
public class FastHttp {
    public static OkHttpClient client = new OkHttpClient();
    public static void GET(String url,final FastHttpCallback callback)
    {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onResponse(response.body().string());
            }
        });
    }
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public static void POST(String url,String content,final FastHttpCallback callback)
    {
        RequestBody formBody=RequestBody.create(JSON,content);
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onResponse(response.body().string());
            }
        });

    }

    public static void POST(String url,Map<String, String> params,final FastHttpCallback callback)
    {
        FormBody.Builder formBody =new FormBody.Builder();
        if (params != null) {
        for (Map.Entry<String, String> e : params.entrySet()) {
            formBody.add(e.getKey(),e.getValue());
         }
         }
        Request request = new Request.Builder()
                .url(url)
                .post(formBody.build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onResponse(response.body().string());
            }
        });

    }



}
