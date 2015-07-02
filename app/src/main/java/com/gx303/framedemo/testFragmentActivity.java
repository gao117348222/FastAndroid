package com.gx303.framedemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2015/7/2.
 */
public class testFragmentActivity extends android.support.v4.app.FragmentActivity {

    F1 f1;
    F2 f2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testfragment);

        f1=new F1();
        f2=new F2();



        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fra, f1);
        transaction.commit();

    }
    boolean isf1=true;
    public void test1(View v)
    {
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        if(isf1)
        {
            transaction.replace(R.id.fra, f2);
        }
        else
        {
            transaction.replace(R.id.fra, f1);
        }
        transaction.commit();
        isf1=!isf1;
    }
}
