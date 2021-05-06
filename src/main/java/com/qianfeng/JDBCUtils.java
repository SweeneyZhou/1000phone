package com.qianfeng;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    static String url = null;
    static String username = null;
    static String password = null;
    static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private JDBCUtils() {
    }

    static {
        try {
            String driver = null;
            Properties properties = new Properties();
            InputStream stream = JDBCUtils.class.getResourceAsStream("/jdbc-config.properties");
            properties.load(stream);
            driver = (String) properties.get("driver");
            url = (String) properties.get("url");
            username=(String)properties.get("username");
            password=(String)properties.get("password");
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
            threadLocal.set(connection);
        }
        return connection;
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) {
                connection.close();
                if (connection.equals(threadLocal.get())) {
                    threadLocal.remove();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void start() {
        Connection connection = threadLocal.get();
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocal.set(connection);
        }
    }

    public static void commit() {
        Connection connection = threadLocal.get();
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void rollback() {
        Connection connection = threadLocal.get();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
