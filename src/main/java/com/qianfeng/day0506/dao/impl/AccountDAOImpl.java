package com.qianfeng.day0506.dao.impl;

import com.qianfeng.JDBCUtils;
import com.qianfeng.day0506.dao.AccountDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public boolean add(Integer id, Double money) {
        try {
            Connection connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "update account set money=money+? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, money);
            preparedStatement.setInt(2, id);
            boolean flag = preparedStatement.executeUpdate() > 0;
            JDBCUtils.close(null, preparedStatement, connection);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean transfer(Integer fromId, Integer toId, Double money) {
        try {
            Connection connection = JDBCUtils.getConnection();
            //connection.setAutoCommit(false);
            String sql = "update account set money=money-? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, money);
            preparedStatement.setInt(2, fromId);
            boolean flag = preparedStatement.executeUpdate() > 0;


            String sql2 = "update account set money=money+? where id=?";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setDouble(1, money);
            preparedStatement.setInt(2, toId);
            boolean flag1 = preparedStatement.executeUpdate() > 0;
            //if (flag&&flag1)connection.commit();
            JDBCUtils.close(null, preparedStatement, connection);
            return flag && flag1;

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("修改失败！");

            return false;
        }
    }

    @Override
    public boolean minus(Integer id, Double money) {
        Connection connection;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update account set money=money-? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, money);
            preparedStatement.setInt(2, id);
            boolean flag = preparedStatement.executeUpdate() > 0;
            JDBCUtils.close(null, preparedStatement, connection);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(Integer id, Double money, Connection connection) {
        String sql = "update account set money=money+? where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, money);
            preparedStatement.setInt(2, id);
            boolean flag = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean minus(Integer id, Double money, Connection connection) {
        String sql = "update account set money=money-? where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, money);
            preparedStatement.setInt(2, id);
            boolean flag = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
