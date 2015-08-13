package com.gx303.framedemo.orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gx303.fastandroid.db.FastDatabaseHelper;
import com.j256.ormlite.support.ConnectionSource;

import static com.gx303.fastandroid.utils.FastLogUtils.e;

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
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        e("onCreate sql");
        super.onCreate(database, connectionSource);
        //在这里继续做逻辑
        SQLiteDatabase sql1=openDatabaseFromAsset("db123.db","o2odb1.db");
    }

    @Override
    public void setBeans() {
        super.beans.add(User.class);
    }
}
