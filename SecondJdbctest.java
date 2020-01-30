package com.tzr;
import java.sql.*;
public class SecondJdbctest {
    public static void main(String[] args) throws SQLException {
        Mysqlconect msl=new Mysqlconect();
        Connection conn=msl.getConn();
        //插入---------------
       /* String sql="insert into student values(?, ?,?,?,?);";
        PreparedStatement statement =  conn.prepareStatement(sql);//防止SQL注入 预编译SQL,先定好格式，不执行
        statement.setInt(1,120);
        statement.setString(2,"李莉");
        statement.setString(3,"女");
        statement.setString(4,"1999-5-16");
        statement.setString(5,"二班");
        int i= statement.executeUpdate();
        if(i>0)
            System.out.println("插入成功！");  */
       //删除---------------------------------------
        /*
        String sql="delete from student where snumber=?";
        PreparedStatement statement =  conn.prepareStatement(sql);//防止SQL注入 预编译SQL,先定好格式，不执行
        statement.setInt(1,120);
        int i= statement.executeUpdate();
        if(i>0)
            System.out.println("删除成功！");*/
        //修改---------------------------------------
       /* String sql="update student set sname=?  where snumber=?";
        PreparedStatement statement =  conn.prepareStatement(sql);//防止SQL注入 预编译SQL,先定好格式，不执行
        statement.setString(1,"刘大朋");
        statement.setInt(2,106);
        int i= statement.executeUpdate();
        if(i>0)
            System.out.println("修改成功！");*/
        //查询---------------------------------------
        String sql="select * from student  where snumber = ?";
        PreparedStatement statement =  conn.prepareStatement(sql);//防止SQL注入 预编译SQL,先定好格式，不执行
        statement.setInt(1,106);
        ResultSet res=statement.executeQuery();//注意，不需要参数
        if(res.next()){
            System.out.println(res.getString("sname"));
        }
        statement.close();
        conn.close();
        msl.close();
    }
}
