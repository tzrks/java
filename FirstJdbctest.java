package com.tzr;
import java.sql.*;
public class FirstJdbctest {
    public static void main(String[] args) throws SQLException {
        Mysqlconect msl=new Mysqlconect();
        Connection conn=msl.getConn();
        Statement statement =conn.createStatement();//执行sql的对象  注：使用Statement易发生SQL注入
        String sql="select * from student";
      ResultSet resultSet= statement.executeQuery(sql);//返回所有结果集
        while (resultSet.next()){
            System.out.println("=================================");
            System.out.println("sunumber="+resultSet.getString("snumber"));
            System.out.println("sunumber="+resultSet.getObject("snumber"));
            System.out.println("name="+resultSet.getString("sname"));
            System.out.println("gender="+resultSet.getString("ssex"));
            System.out.println("出生日期="+resultSet.getString("sbirthday"));
            System.out.println("班级="+resultSet.getString("class"));
        }
        //String sqlinsert="insert into student values(107, '刘名','男','1992-04-01 00:00:00','二班');";//插入
        String sqltable="create table str(name1 varchar(20) ,sname varchar(20) )";//建表
       // statement.execute(sqltable);
        statement.close();
        resultSet.close();
        conn.close();
        msl.close();
    }
}
