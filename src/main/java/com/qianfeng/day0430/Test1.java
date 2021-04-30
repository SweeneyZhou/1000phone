package com.qianfeng.day0430;

import java.sql.*;

public class Test1 {
    public static void main(String[] args) {
        try {
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2101?serverTimezone=Asia/Shanghai", "root", "123456");
            Connection connection = JDBCUtils.getConnection();
            String sql="select * from Users where username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"sweeney");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("password"));
            }
            JDBCUtils.close(resultSet,preparedStatement,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
