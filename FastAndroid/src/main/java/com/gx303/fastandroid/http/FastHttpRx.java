package com.gx303.fastandroid.http;

import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Map;

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
    public static Observable<String> POST(final String url,final Map<String, String> params)
    {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                FormEncodingBuilder FEB1=new FormEncodingBuilder();
                if (params != null) {
                    for (Map.Entry<String, String> e : params.entrySet()) {
                        FEB1.add(e.getKey(),e.getValue());
                    }
                }
                RequestBody formBody=FEB1.build();
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
}
