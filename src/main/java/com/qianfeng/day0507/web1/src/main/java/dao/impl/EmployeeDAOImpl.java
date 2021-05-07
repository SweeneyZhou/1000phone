package dao.impl;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DruidUtils;
import dao.EmployeeDAO;
import entity.Employee;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
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
        map.put("JOB_TITLE", "jobTitle");
        map.put("SALARY", "salary");
        map.put("COMM", "comm");
        map.put("MANAGER_ID", "managerId");
        map.put("DEPARTMENT_NAME", "departmentName");
        map.put("PIC", "pic");
        basicRowProcessor = new BasicRowProcessor(new BeanProcessor(map));
    }

    @Override
    public List<Employee> findAll() {
        String sql = "select * from t_employees t left join t_departments td on t.DEPARTMENT_ID = td.DEPARTMENT_ID left join t_jobs tj on t.JOB_ID = tj.JOB_ID";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Employee.class, basicRowProcessor));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
