package com.yzu.daydayrun.db;

import com.yzu.daydayrun.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoWriteScore {

    private int flag;

    public int getFlag() {
        return flag;
    }

    public User WriteScore(String name, int score){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u  =null;
        try{
            conn  = DBUtil.getConnection();
            String Sql = "insert into score(name,score)values('"+name+"','"+score+"')";
            stmt = conn.prepareStatement(Sql);
            flag=stmt.executeUpdate(Sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeAll(rs, stmt, conn);
        }
        return u;
    }
}
