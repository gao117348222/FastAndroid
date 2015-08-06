package com.gx303.framedemo.orm;

import android.view.View;

import com.gx303.fastandroid.db.FastDbHelper;
import com.gx303.framedemo.R;

import java.util.List;

import static com.gx303.fastandroid.utils.FastLogUtils.e;

/**
 * Created by Administrator on 2015/8/4.
 */
public class ormtest extends com.gx303.fastandroid.BaseActivity {
    @Override
    public void setContentView() {
        setContentView(R.layout.ormtestmain);
    }

    @Override
    public void findViews() {

    }

    @Override
    public void getData() {

    }

    @Override
    public void showContent() {

    }
    public void inserttest(View v)
    {
        FastDbHelper fh=new FastDbHelper(new dbhelp1(getApplicationContext()));
        fh.create(new User("呵呵呵123123"));
    }
    public void updatetest(View v)
    {
        FastDbHelper fh=new FastDbHelper(new dbhelp1(getApplicationContext()));
        List<User> l1=fh.queryForAll(User.class);
        for(int i=0;i<l1.size();i++)
        {
           l1.get(i).setName("更新之后的123213123");
            fh.update(l1.get(i));
        }
    }
    public void selecttest(View v)
    {
        FastDbHelper fh=new FastDbHelper(new dbhelp1(getApplicationContext()));
        List<User> l1=fh.queryForAll(User.class);
        for(int i=0;i<l1.size();i++)
        {
            e("user:"+l1.get(i).getName());
        }
    }
}
