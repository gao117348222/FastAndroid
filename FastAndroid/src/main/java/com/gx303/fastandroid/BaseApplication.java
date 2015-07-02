package com.gx303.fastandroid;

import android.app.Application;

import com.gx303.fastandroid.http.RequestQueueManager;

/**
 * Created by Administrator on 2015/7/2.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RequestQueueManager.getInstance().createRequsetQueue(getApplicationContext());
    }
}
