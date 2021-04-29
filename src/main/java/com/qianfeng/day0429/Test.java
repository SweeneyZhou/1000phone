package com.qianfeng.day0429;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/java2101?serverTimezone=GMT";
            String username="root";
            String pwd="123456";
            Connection con = DriverManager.getConnection(url, username, pwd);
            System.out.println(con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
