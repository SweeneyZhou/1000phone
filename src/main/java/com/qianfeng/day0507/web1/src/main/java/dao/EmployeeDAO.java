package dao;

import entity.Employee;

import java.util.List;

/**
 * @author sweeney
 */
public interface EmployeeDAO {
    /**
     * 查询所有员工信息
     */
    List<Employee> findAll();

}
