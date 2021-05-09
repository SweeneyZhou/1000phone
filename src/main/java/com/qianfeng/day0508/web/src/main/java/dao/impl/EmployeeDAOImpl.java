package dao.impl;

import dao.EmployeeDAO;
import entity.Department;
import entity.Employee;
import entity.Job;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import utils.DruidUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sweeney 2021/5/9 18:42
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    QueryRunner queryRunner=new QueryRunner(DruidUtils.getDataSource());
    BasicRowProcessor basicRowProcessor;
    Map<String, String> map;
    {
        map = new HashMap<>();
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
        map.put("DEPARTMENT_NAME","departmentName");
        map.put("JOB_TITLE","jobTitle");
        basicRowProcessor = new BasicRowProcessor(new BeanProcessor(map));
    }
    @Override
    public List<Map<String ,Object>> findAll() {
        String sql="select * from t_employees left join t_departments td on t_employees.DEPARTMENT_ID = td.DEPARTMENT_ID left join t_jobs tj on t_employees.JOB_ID = tj.JOB_ID";

        try {
            return queryRunner.query(sql,new MapListHandler(basicRowProcessor));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee findByEmployeeId(Integer id) {
        String sql="select * from t_employees where EMPLOYEE_ID=?";
        try {
            return queryRunner.query(sql,new BeanHandler<>(Employee.class,basicRowProcessor),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Employee employee) {
        String sql="insert into t_employees values(?,?,?,?,?,?,?,?,?,?,?,?)";
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
                    employee.getPic())>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        String sql="update t_employees set FIRST_NAME=?,LAST_NAME=?,EMAIL=?,PHONE_NUMBER=?,HIRE_DATE=?,JOB_ID=?,SALARY=?,COMM=?,MANAGER_ID=?,DEPARTMENT_ID=?,PIC=? where EMPLOYEE_ID=?";
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
                    employee.getEmployeeId())>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql="delete from t_employees where EMPLOYEE_ID=?";
        try {
            return queryRunner.update(sql,id)>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Job> findAllJob() {
        String sql="select * from t_jobs";
        try {
            return queryRunner.query(sql,new BeanListHandler<>(Job.class,basicRowProcessor));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> findAllDepartment() {
        String sql="select * from t_departments";
        try {
            return queryRunner.query(sql,new BeanListHandler<>(Department.class,basicRowProcessor));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
