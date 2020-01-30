package com.tzr;
import java.sql.Connection;
import java.sql.DriverManager;
public class Mysqlconect {
    // 定义数据库操作的常量、对象// 数据库驱动程序
    private  String DBDRIVER	= "com.mysql.cj.jdbc.Driver" ;
    private  String DBURL		= "jdbc:mysql://192.168.48.129:3306/";// 数据库连接地址
    private String  DBDATABASE  =  "test" ;
    private  String STR="?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false" ;
    private  String DBUSER		= "cat" ;//账号// 数据库用户名
    private  String DBPASSWORD	= "111" ;// 数据库连接密码
    // 声明一个数据库连接对象
    private Connection conn			= null ;
    public Mysqlconect() {
        try  {
            DBURL=DBURL+DBDATABASE+STR;
            Class.forName(DBDRIVER) ;// 加载驱动程序
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); // 连接数据库
            System.out.println("数据库连接成功******************") ;
        }
        catch (Exception e) {
            System.out.println("数据库连接异常！！！") ;
        }
    }
    public Connection getConn() {   return conn;   }
    // 关闭数据库连接
    public void close() {
        try  {        this.conn.close() ;    }
        catch (Exception e)    {     }
    }
}
