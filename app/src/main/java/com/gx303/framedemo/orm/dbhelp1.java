package com.gx303.framedemo.orm;

import android.content.Context;

import com.gx303.fastandroid.db.FastDatabaseHelper;

/**
 * Created by Administrator on 2015/7/3.
 */
public class dbhelp1 extends FastDatabaseHelper{
    static  String DataBaseName="db1.db";
    static int DATABASE_VERSION=2;
    public dbhelp1(Context context)
    {
        super(context,DataBaseName,DATABASE_VERSION);

    }

    @Override
    public void setBeans() {
        super.beans.add(User.class);
    }
}
