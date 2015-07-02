package com.gx303.fastandroid.utils;

import android.util.Log;

/**
 * Created by Administrator on 2015/7/2.
 */
public class LogUtils {

    private static int LOG_LEVEL = 6;
    private static int ERROR = 1;
    private static int WARN = 2;
    private static int INFO = 3;
    private static int DEBUG = 4;
    private static int VERBOS = 5;


    public static void setLogLevel(int logLevel)
    {
        LOG_LEVEL=logLevel;
    }

    public static void e(String tag,String msg){
        if(LOG_LEVEL>ERROR&&msg!=null)
            Log.e(tag, msg);
    }

    public static void w(String tag,String msg){
        if(LOG_LEVEL>WARN&&msg!=null)
            Log.w(tag, msg);
    }
    public static void i(String tag,String msg){
        if(LOG_LEVEL>INFO&&msg!=null)
            Log.i(tag, msg);
    }
    public static void d(String tag,String msg){
        if(LOG_LEVEL>DEBUG&&msg!=null)
            Log.d(tag, msg);
    }
    public static void v(String tag,String msg){
        if(LOG_LEVEL>VERBOS&&msg!=null)
            Log.v(tag, msg);
    }
    static String TAG="com.gx303.fastandroid";
    public static void error(String msg)
    {
        Log.e(TAG,msg);
    }
}
