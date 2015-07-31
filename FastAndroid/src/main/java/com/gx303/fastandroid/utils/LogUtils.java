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

    static String className;
    static String methodName;
    static int lineNumber;
    private static String createLog( String log ) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(className);
        buffer.append("]");
        buffer.append(log);
        return buffer.toString();
    }
    private static void getMethodNames(StackTraceElement[] sElements){
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }
    public static void e(String tag,String msg){
        if(LOG_LEVEL>ERROR&&msg!=null)
        {
            getMethodNames(new Exception().getStackTrace());
            Log.e(tag, createLog(msg));
        }
    }

    public static void w(String tag,String msg){
        if(LOG_LEVEL>WARN&&msg!=null) {
            getMethodNames(new Exception().getStackTrace());
            Log.w(tag, createLog(msg));
        }
    }
    public static void i(String tag,String msg){
        if(LOG_LEVEL>INFO&&msg!=null) {
            getMethodNames(new Exception().getStackTrace());
            Log.i(tag, createLog(msg));
        }
    }
    public static void d(String tag,String msg){
        if(LOG_LEVEL>DEBUG&&msg!=null) {
            getMethodNames(new Exception().getStackTrace());
            Log.d(tag, createLog(msg));
        }
    }
    public static void v(String tag,String msg){
        if(LOG_LEVEL>VERBOS&&msg!=null) {
            getMethodNames(new Exception().getStackTrace());
            Log.v(tag, createLog(msg));
        }
    }
    static String TAG="com.gx303.fastandroid";
    public static void error(String msg)
    {
        Log.e(TAG,msg);
    }
}
