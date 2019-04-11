package com.yzu.daydayrun.db;

import com.yzu.daydayrun.entity.User;
import com.yzu.daydayrun.utils.MD5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoRegister {
    private int flag;

    private boolean Panchong;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public User RegisterUser(String name, String pwd)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u  =null;



        try{
            conn  = DBUtil.getConnection();
            String SqlPanchong = "select * from user where name = '" + name + "'" ;
//            System.out.println(SqlPanchong);
            stmt = conn.prepareStatement(SqlPanchong);
            Panchong = stmt.execute(SqlPanchong);
//            System.out.println(Panchong);
            if (Panchong!=true){
                flag = 0;
            }
            else {
                MD5 md5 = new MD5();
                pwd = md5.MD5Encode(pwd);
                String Sql = "insert into user(name,password)values('" + name + "','" + pwd + "')";
                stmt = conn.prepareStatement(Sql);
                flag = stmt.executeUpdate(Sql);
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
        return u;
    }
}