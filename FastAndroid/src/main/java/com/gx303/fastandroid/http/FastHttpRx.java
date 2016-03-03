package com.gx303.fastandroid.http;


import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2015/12/7.
 */
public class FastHttpRx{
    public static OkHttpClient client = new OkHttpClient();
    public static Observable<String> GET(final String url)
    {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                Request request = new Request.Builder().url(url).build();
                try
                {
                    Response response = client.newCall(request).execute();
                    subscriber.onNext(response.body().string());
                    subscriber.onCompleted();
                }
                catch (Exception e)
                {
                    subscriber.onError(e);
                }
            }
        });
    }
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public static Observable<String> POST(final String url,final String content)
    {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                RequestBody formBody=RequestBody.create(JSON,content);
                Request request = new Request.Builder().url(url).post(formBody).build();
                try
                {
                    Response response = client.newCall(request).execute();
                    subscriber.onNext(response.body().string());
                    subscriber.onCompleted();
                }
                catch (Exception e)
                {
                    subscriber.onError(e);
                }
            }
        });
    }
    public static Observable<String> POST(final String url,final Map<String, String> params)
    {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                FormBody.Builder formBody =new FormBody.Builder();
                if (params != null) {
                    for (Map.Entry<String, String> e : params.entrySet()) {
                        formBody.add(e.getKey(),e.getValue());
                    }
                }
                Request request = new Request.Builder().url(url).post(formBody.build()).build();
                try
                {
                    Response response = client.newCall(request).execute();
                    subscriber.onNext(response.body().string());
                    subscriber.onCompleted();
                }
                catch (Exception e)
                {
                    subscriber.onError(e);
                }
            }
        });
    }

}
