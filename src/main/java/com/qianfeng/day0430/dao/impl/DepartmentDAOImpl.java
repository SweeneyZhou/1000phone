package com.qianfeng.day0430.dao.impl;

import com.qianfeng.day0430.JDBCUtils;
import com.qianfeng.day0430.dao.DepartmentDAO;
import com.qianfeng.day0430.entity.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DepartmentDAO的实现类
 *
 * @author sweeney
 * @see com.qianfeng.day0430.dao.DepartmentDAO
 */
public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public List<Department> findALl() {
        List<Department> list;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "select * from t_departments";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()) {
                Department department = new Department(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                list.add(department);
            }

            JDBCUtils.close(resultSet, preparedStatement);

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> findAll(int pageNumber, int pageCount) {
        List<Department> list;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "select * from t_departments Limit ?,?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, (pageNumber - 1) * pageCount);
            preparedStatement.setInt(2, pageCount);
            ResultSet resultSet = preparedStatement.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()) {
                Department department = new Department(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                list.add(department);
            }

            JDBCUtils.close(resultSet, preparedStatement);

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Department department) {
        boolean flag = false;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "insert into t_departments values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, department.getDepartmentId());
            preparedStatement.setString(2, department.getDepartmentName());
            preparedStatement.setString(3, department.getManagerId());
            preparedStatement.setString(4, department.getLocationId());
            flag = preparedStatement.executeUpdate() > 0;

            JDBCUtils.close(null, preparedStatement);

            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(Integer id, Department department) {
        boolean flag = false;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "update t_departments set DEPARTMENT_NAME=?,MANAGER_ID=?,LOCATION_ID=? where DEPARTMENT_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setString(2, department.getManagerId());
            preparedStatement.setString(3, department.getLocationId());
            preparedStatement.setInt(4, department.getDepartmentId());
            flag = preparedStatement.executeUpdate() > 0;

            JDBCUtils.close(null, preparedStatement);

            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag = false;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "delete from t_departments where DEPARTMENT_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            flag = preparedStatement.executeUpdate() > 0;

            JDBCUtils.close(null, preparedStatement);

            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Department findById(Integer id) {
        Department department = null;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "select * from t_departments where DEPARTMENT_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                department = new Department(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
            }

            JDBCUtils.close(resultSet, preparedStatement);

            return department;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> findByCity(String city) {
        List<Department> list;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "Select * from t_departments join t_locations l on t_departments.LOCATION_ID = l.location_id where CITY =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, city);
            ResultSet resultSet = preparedStatement.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()) {
                Department department = new Department(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                list.add(department);
            }

            JDBCUtils.close(resultSet, preparedStatement);

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Department findByDepartmentName(String name) {
        Department department = null;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "select * from t_departments where DEPARTMENT_NAME=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                department = new Department(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
            }

            JDBCUtils.close(resultSet, preparedStatement);

            return department;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
