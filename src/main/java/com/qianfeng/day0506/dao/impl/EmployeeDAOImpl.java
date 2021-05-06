package com.qianfeng.day0506.dao.impl;

import com.qianfeng.DruidUtils;
import com.qianfeng.day0506.dao.EmployeeDAO;
import com.qianfeng.day0506.entity.Employee;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAOImpl implements EmployeeDAO {
    QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    BasicRowProcessor basicRowProcessor;

    {
        Map<String, String> map = new HashMap<>();
        map.put("EMPLOYEE_ID", "employeeId");
        map.put("FIRST_NAME", "firstName");
        map.put("LAST_NAME", "lastName");
        map.put("EMAIL", "email");
        map.put("PHONE_NUMBER", "phoneNumber");
        map.put("HIRE_DATE", "hireDate");
        map.put("JOB_ID", "jobId");
        map.put("SALARY", "salary");
        map.put("COMM", "comm");
        map.put("MANAGER_ID", "managerId");
        map.put("DEPARTMENT_ID", "departmentId");
        map.put("PIC", "pic");
        basicRowProcessor = new BasicRowProcessor(new BeanProcessor(map));
    }

    @Override
    public List<Employee> findAll() {
        String sql = "select * from t_employees";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Employee.class, basicRowProcessor));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Employee employee) {
        String sql = "insert into t_employees values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            return queryRunner.update(sql,
                    employee.getEmployeeId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail(),
                    employee.getPhoneNumber(),
                    employee.getHireDate(),
                    employee.getJobId(),
                    employee.getSalary(),
                    employee.getComm(),
                    employee.getManagerId(),
                    employee.getDepartmentId(),
                    employee.getPic()) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Integer id, Employee employee) {
        String sql = "update t_employees set " +
                "FIRST_NAME=?," +
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
        try {
            return queryRunner.update(sql,
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail(),
                    employee.getPhoneNumber(),
                    employee.getHireDate(),
                    employee.getJobId(),
                    employee.getSalary(),
                    employee.getComm(),
                    employee.getManagerId(),
                    employee.getDepartmentId(),
                    employee.getPic(),
                    employee.getEmployeeId()) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer... id) {
        if (id.length <= 0) {
            return false;
        }
        String str = "?" + ",?".repeat(id.length - 1);
        String sql = "delete from t_employees where EMPLOYEE_ID in (" + str + ")";
        try {
            return queryRunner.update(sql, id) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> findByFirstName(String name) {
        String sql = "select * from t_employees where FIRST_NAME like ?";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Employee.class, basicRowProcessor), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findBySalaryBetween(int minSalary, int maxSalary) {
        String sql = "select * from t_employees where SALARY between ? and ?";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Employee.class, basicRowProcessor), minSalary, maxSalary);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findAllOrderBySalary(String order) {
        String sql = "select * from t_employees order by ?";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Employee.class, basicRowProcessor), " salary " + order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Integer> findAllDepartmentId() {
        String sql = "select distinct DEPARTMENT_ID from t_employees";
        try {
            return queryRunner.query(sql, new ResultSetHandler<>() {
                @Override
                public List<Integer> handle(ResultSet resultSet) throws SQLException {
                    List<Integer> list = new ArrayList<>();
                    while (resultSet.next()) {
                        list.add(resultSet.getInt(1));
                    }
                    return list;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int countByDepartmentId(Integer id) {
        String sql = "select count(*) from t_employees where DEPARTMENT_ID=?";
        try {
            return queryRunner.query(sql, new ResultSetHandler<>() {
                @Override
                public Integer handle(ResultSet resultSet) throws SQLException {
                    if (resultSet.next())
                        return resultSet.getInt(1);
                    return null;
                }
            }, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Employee findByEmployeeId(Integer id) {
        String sql = "select * from t_employees where EMPLOYEE_ID=?";
        try {
            return queryRunner.query(sql, new BeanHandler<>(Employee.class, basicRowProcessor), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
