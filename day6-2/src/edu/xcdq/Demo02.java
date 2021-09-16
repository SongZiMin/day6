package edu.xcdq;

import java.sql.*;

public class Demo02 {

    public static class Deom02 {
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            //1 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2 获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01","root","123456");
            //3准备状态 传输器
            String sql01 = "select * from book where author = ? " ;  //查
            String sql02="insert into book values(null , ? , ? , ?)" ; //增
            String sql03= "delete from book where author = ? ";  // 删
            String sql04 ="update book set name = ? , author = ? where id = ?" ; //改
            //PreparedStatement preparedStatement = connection.prepareStatement(sql02);
            //PreparedStatement preparedStatement = connection.prepareStatement(sql03);
            PreparedStatement preparedStatement = connection.prepareStatement(sql04);

            /*preparedStatement.setInt(1, 6);
            preparedStatement.setString(1, "暴烈学姐");
            preparedStatement.setString(2, "张美玉");
            preparedStatement.setDouble(3, 666);*/
            //preparedStatement.setString(1,"张美玉");

            preparedStatement.setString(1,"大碗牢饭");
            preparedStatement.setString(2,"吴签");
            preparedStatement.setInt(3,5);

            int result = preparedStatement.executeUpdate();
            /* while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "
            + resultSet.getString(3) + " " + resultSet.getDouble(4)
            );*/
            String message = result == -1 ? "没有成功" : "操作成功" ;
            System.out.println(message);
            // 6
            preparedStatement.close();
            connection.close();
        }
    }

}
