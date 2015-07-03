package com.gx303.fastandroid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/2.
 */
public abstract class FastDatabaseHelper extends OrmLiteSqliteOpenHelper {
    public List<Class> beans=new ArrayList<Class>();
    public FastDatabaseHelper(Context context,String DATABASE_NAME,int DATABASE_VERSION)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setBeans();
    }
    /**
     * 设置所有的bean类
     */
    public abstract void setBeans();

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try
        {
            for(int i=0;i<beans.size();i++)
            {
                TableUtils.createTable(connectionSource,beans.get(i));
            }
        }
        catch (SQLException e)
        {

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try
        {
            for(int i=0;i<beans.size();i++)
            {
                TableUtils.dropTable(connectionSource, beans.get(i), true);
            }
            onCreate(database, connectionSource);
        }
        catch (SQLException e)
        {

        }
    }
}
