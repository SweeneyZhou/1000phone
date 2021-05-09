package service;

import entity.Department;
import entity.Employee;
import entity.Job;

import java.util.List;
import java.util.Map;

/**
 * @author sweeney 2021/5/9 18:52
 */
public interface EmployeeService {
    List<Map<String ,Object>> list();
    Employee getById(Integer id);
    List<Job> jobList();
    List<Department> departmentList();
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(Integer id);
}
