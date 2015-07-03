package com.gx303.framedemo.orm;

/**
 * Created by Administrator on 2015/7/2.
 */
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_user")
public class User {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "name")
    private String name;


    public User()
    {

    }
    public User(String ss)
    {
        name=ss;
    }
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "User [id=" + id + ", name=" + name
                + "]";
    }

}
