package com.qianfeng.day0430.dao.impl;

import com.qianfeng.JDBCUtils;
import com.qianfeng.day0430.dao.EmployeeDAO;
import com.qianfeng.day0430.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeDAO实现类
 *
 * @author sweeney
 * @see com.qianfeng.day0430.dao.EmployeeDAO
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> findAll() {
        List<Employee> list;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "select * from t_employees";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getDouble(9),
                        resultSet.getInt(10),
                        resultSet.getInt(11),
                        resultSet.getString(12)
                );
                list.add(employee);
            }

            JDBCUtils.close(resultSet, preparedStatement);

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Employee employee) {
        boolean flag = false;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "insert into t_employees values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Date date = new Date(employee.getHireDate().getTime());
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setDate(6, date);
            preparedStatement.setString(7, employee.getJobId());
            preparedStatement.setInt(8, employee.getSalary());
            preparedStatement.setDouble(9, employee.getComm());
            preparedStatement.setInt(10, employee.getManagerId());
            preparedStatement.setInt(11, employee.getDepartmentId());
            preparedStatement.setString(12, employee.getPic());
            flag = preparedStatement.executeUpdate() > 0;

            JDBCUtils.close(null, preparedStatement);

            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(Integer id, Employee employee) {
        boolean flag = false;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "update t_employees set " +
                    "FIRST_NAME=? ," +
                    "LAST_NAME=?," +
                    "EMAIL=?," +
                    "PHONE_NUMBER=?," +
                    "HIRE_DATE=?," +
                    "JOB_ID=?," +
                    "SALARY=?," +
                    "COMM=?," +
                    "MANAGER_ID=?," +
                    "DEPARTMENT_ID=?," +
                    "PIC=? " +
                    "where EMPLOYEE_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Date date = new Date(employee.getHireDate().getTime());
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDate(5, date);
            preparedStatement.setString(6, employee.getJobId());
            preparedStatement.setInt(7, employee.getSalary());
            preparedStatement.setDouble(8, employee.getComm());
            preparedStatement.setInt(9, employee.getManagerId());
            preparedStatement.setInt(10, employee.getDepartmentId());
            preparedStatement.setString(11, employee.getPic());
            preparedStatement.setInt(12, id);
            flag = preparedStatement.executeUpdate() > 0;

            JDBCUtils.close(null, preparedStatement);

            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean delete(Integer... id) {
        boolean flag = true;
        for (Integer i : id) {
            if (!delete(i)) {
                flag = false;
            }
        }
        return flag;
    }

    private boolean delete(Integer id) {
        boolean flag = false;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "delete from t_employees where EMPLOYEE_ID=?";
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
    public List<Employee> findByFirstName(String name) {
        List<Employee> list;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "select * from t_employees where FIRST_NAME like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getDouble(9),
                        resultSet.getInt(10),
                        resultSet.getInt(11),
                        resultSet.getString(12)
                );
                list.add(employee);
            }

            JDBCUtils.close(resultSet, preparedStatement);

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findBySalaryBetween(int minSalary, int maxSalary) {
        List<Employee> list;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "select * from t_employees where SALARY between ? and ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, minSalary);
            preparedStatement.setInt(2, maxSalary);
            ResultSet resultSet = preparedStatement.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getDouble(9),
                        resultSet.getInt(10),
                        resultSet.getInt(11),
                        resultSet.getString(12)
                );
                list.add(employee);
            }

            JDBCUtils.close(resultSet, preparedStatement);

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findAllOrderBySalary(String order) {
        List<Employee> list;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "select * from t_employees order by  ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "Salary " + order);
            ResultSet resultSet = preparedStatement.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getDouble(9),
                        resultSet.getInt(10),
                        resultSet.getInt(11),
                        resultSet.getString(12)
                );
                list.add(employee);
            }

            JDBCUtils.close(resultSet, preparedStatement);

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Integer> findAllDepartmentId() {

        List<Integer> list;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "select distinct DEPARTMENT_ID from t_employees ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(resultSet.getInt(1));
            }

            JDBCUtils.close(resultSet, preparedStatement);

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int countByDepartmentId(Integer id) {
        int n = 0;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "select count(*) from t_employees where DEPARTMENT_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) n = resultSet.getInt(1);
            JDBCUtils.close(resultSet, preparedStatement);
            return n;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Employee findByEmployeeId(Integer id) {
        Employee emp = null;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "select * from t_employees where EMPLOYEE_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                emp = new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getDouble(9),
                        resultSet.getInt(10),
                        resultSet.getInt(11),
                        resultSet.getString(12)
                );
            }

            JDBCUtils.close(resultSet, preparedStatement);

            return emp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
