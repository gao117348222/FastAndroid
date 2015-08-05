package com.gx303.fastandroid.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.gx303.fastandroid.utils.LogUtils;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.UpdateBuilder;
/**
 * Created by Administrator on 2015/7/3.
 */
public class FastDbHelper<T> {
    FastDatabaseHelper db;
    public FastDbHelper(FastDatabaseHelper db)
    {
        this.db=db;
    }
    /** 新增一条记录 */
    public int create(T po) {
        try
        {
            Dao dao = db.getDao(po.getClass());
            return dao.create(po);
        }
        catch (SQLException e)
        {
            LogUtils.e("create"+e.toString());
        }
        finally
        {
//            if (db != null)
//                db.close();
        }
        return -1;
    }

    public boolean exists(T po, Map<String, Object> where) {
        try
        {
            Dao dao = db.getDao(po.getClass());
            if (dao.queryForFieldValues(where).size() > 0) {
                return true;
            }
        }
        catch (SQLException e)
        {
            LogUtils.e("exists"+e.toString());
        }
        finally
        {
//            if (db != null)
//                db.close();
        }
        return false;
    }

    public int createIfNotExists(T po, Map<String, Object> where) {
        try
        {
            Dao dao = db.getDao(po.getClass());
            if (dao.queryForFieldValues(where).size() < 1) {
                return dao.create(po);
            }
        }
        catch (SQLException e)
        {
            LogUtils.e("createIfNotExists"+e.toString());
        }
        finally
        {
//            if (db != null)
//                db.close();
        }
        return -1;
    }
    /** 查询一条记录 */
    public List<T> queryForEq(Class<T> c, String fieldName, Object value) {
        try
        {
            Dao dao = db.getDao(c);
            return dao.queryForEq(fieldName, value);

        }
        catch (SQLException e)
        {
            LogUtils.e("queryForEq"+e.toString());
        }
        finally
        {
//            if (db != null)
//                db.close();
        }
        return new ArrayList<T>();
    }
    /** 删除一条记录 */
    public int remove(T po) {
        try
        {
            Dao dao = db.getDao(po.getClass());
            return dao.delete(po);
        }
        catch (SQLException e)
        {
            LogUtils.e("remove"+e.toString());
        }
        finally
        {
//            if (db != null)
//                db.close();
        }
        return -1;
    }
    /**
     * 根据特定条件更新特定字段
     *
     * @param c
     * @param values
     * @param columnName where字段
     * @param value where值
     * @return
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public int update(Class<T> c, ContentValues values, String columnName, Object value) {
        try
        {
            Dao dao = db.getDao(c);
            UpdateBuilder<T, Long> updateBuilder = dao.updateBuilder();
            updateBuilder.where().eq(columnName, value);
            for (String key : values.keySet()) {
                updateBuilder.updateColumnValue(key, values.get(key));
            }
            return updateBuilder.update();
        }
        catch (SQLException e)
        {
            LogUtils.e("update"+e.toString());
        }
        finally
        {
//            if (db != null)
//                db.close();
        }
        return -1;
    }
    /** 更新一条记录 */
    public int update(T po) {
        try
        {
            Dao dao = db.getDao(po.getClass());
            return dao.update(po);
        }
        catch (SQLException e)
        {
            LogUtils.e("update"+e.toString());
        }
        finally
        {
//            if (db != null)
//                db.close();
        }
        return -1;
    }
    /** 查询所有记录 */
    public List<T> queryForAll(Class<T> c) {
        try
        {
            Dao dao = db.getDao(c);
            return dao.queryForAll();
        }
        catch (SQLException e)
        {
            LogUtils.e("queryForAll"+e.toString());
        }
        finally
        {
//            if (db != null)
//                db.close();
        }
        return new ArrayList<T>();
    }
}
