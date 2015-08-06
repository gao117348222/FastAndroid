package com.gx303.fastandroid.utils;

import android.util.Log;

/**
 * Created by Administrator on 2015/7/2.
 */
public class FastLogUtils {

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
    public static void setTAG(String tag){
        TAG=tag;
    }
    static String className;
    static String methodName;
    static int lineNumber;
    private static String createLog( String log ) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(className);
        buffer.append("[");
        buffer.append(methodName+":"+lineNumber);
        buffer.append("]");
        buffer.append(log);
        return buffer.toString();
    }
    private static void getMethodNames(StackTraceElement[] sElements){
//        for(int i=0;i<sElements.length;i++)
//        {
//            Log.e("Unity",i+"className"+sElements[i].getClassName()+"FileName"+sElements[i].getFileName()+"MethodName"+sElements[i].getMethodName()+"linenumber"+sElements[i].getLineNumber());
//        }
        if(sElements.length>=1) {
            className = sElements[1].getFileName();
            methodName = sElements[1].getMethodName();
            lineNumber = sElements[1].getLineNumber();
        }
    }
    public static void e(String msg){
        if(LOG_LEVEL>ERROR&&msg!=null)
        {
            getMethodNames(new Exception().getStackTrace());
            Log.e(TAG, createLog(msg));
        }
    }

    public static void w(String msg){
        if(LOG_LEVEL>WARN&&msg!=null) {
            getMethodNames(new Exception().getStackTrace());
            Log.w(TAG, createLog(msg));
        }
    }
    public static void i(String msg){
        if(LOG_LEVEL>INFO&&msg!=null) {
            getMethodNames(new Exception().getStackTrace());
            Log.i(TAG, createLog(msg));
        }
    }
    public static void d(String msg){
        if(LOG_LEVEL>DEBUG&&msg!=null) {
            getMethodNames(new Exception().getStackTrace());
            Log.d(TAG, createLog(msg));
        }
    }
    public static void v(String msg){
        if(LOG_LEVEL>VERBOS&&msg!=null) {
            getMethodNames(new Exception().getStackTrace());
            Log.v(TAG, createLog(msg));
        }
    }
    private static String TAG="com.gx303.fastandroid";
    public static void error(String msg)
    {
        Log.e(TAG,msg);
    }
}
