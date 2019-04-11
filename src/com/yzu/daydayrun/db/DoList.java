package com.yzu.daydayrun.db;

import com.yzu.daydayrun.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoList {
    public List<User> userList;
    public List<User> GetList()
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn  = DBUtil.getConnection();

            String Sql = "select * from score order by score desc limit 3";
            stmt = conn.prepareStatement(Sql);
            rs  = stmt.executeQuery();
            userList = new ArrayList<User>();
            while (rs.next())
            {
                User u=new User();
                u.setName(rs.getString("name"));
                u.setSocre(rs.getInt("score"));
                userList.add(u);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeAll(rs, stmt, conn);
        }
        return userList;
    }
}
