package com.qianfeng.day0430;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    static String driver=null;
    static String url=null;
    static String username=null;
    static String password=null;
    static Connection connection=null;
    static {
        try {
            Properties properties=new Properties();
            InputStream stream = JDBCUtils.class.getResourceAsStream("/config.properties");
            properties.load(stream);
            driver= (String) properties.get("driver");
            url=(String)properties.get("url");
            username=(String)properties.get("username");
            password=(String)properties.get("password");
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return connection!=null?connection: DriverManager.getConnection(url,username,password);
    }
    public static void close(ResultSet resultSet, Statement statement,Connection connection) throws SQLException {
        if (resultSet!=null)resultSet.close();
        if (statement!=null)statement.close();
        if (connection!=null)connection.close();
    }
}
