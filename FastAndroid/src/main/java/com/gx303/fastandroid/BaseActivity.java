package com.gx303.fastandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.gx303.fastandroid.utils.LogUtils;

/**
 * Created by Administrator on 2015/7/2.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void init(){
        setContentView();
        findViews();
        getData();
        showContent();
    }

    public abstract void setContentView();
    public abstract void findViews();
    public abstract void getData();
    public abstract void showContent();

    public void e(String msg){
        LogUtils.e(getClassName(),msg);
    }
    public void w(String msg){
        LogUtils.w(getClassName(), msg);
    }
    public void i(String msg){
        LogUtils.i(getClassName(), msg);
    }
    public void d(String msg){
        LogUtils.d(getClassName(), msg);
    }
    public void v(String msg){
        LogUtils.v(getClassName(), msg);
    }
    private String getClassName()
    {
        return getClass().getSimpleName();
    }
    public void t(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
