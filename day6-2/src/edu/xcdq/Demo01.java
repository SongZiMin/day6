package edu.xcdq;

import java.sql.*;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01", "root", "123456");
        //准备
        Statement statement = connection.createStatement();
        //4
        String sql01 = "select * from book" ;
        String sql02 = "insert into book values (null , '暴烈学姐'  , '张美玉' ,999 )" ;
        //String sql03 = "delete from book where author = '张美玉'";
        //String sql04 = "update book set author = '刘华强' where name '大棚的瓜' ";

        /*ResultSet resultSet = statement.executeQuery(sql01);*/
        int result = statement.executeUpdate(sql02);
        //5
       /* while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "
            + resultSet.getString(3) + " " + resultSet.getDouble(4)
            );*/
        String message = result == -1 ? "没有成功" : "操作成功" ;
        System.out.println(message);
        // 6
        statement.close();
        connection.close();
        }
    }

