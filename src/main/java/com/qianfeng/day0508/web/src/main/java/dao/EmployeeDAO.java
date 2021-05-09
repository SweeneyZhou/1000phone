package dao;

import entity.Department;
import entity.Employee;
import entity.Job;

import java.util.List;
import java.util.Map;

/**
 * @author sweeney 2021/5/9 18:39
 */
public interface EmployeeDAO {
    List<Map<String ,Object>> findAll();
    Employee findByEmployeeId(Integer id);
    boolean save(Employee employee);
    boolean update(Employee employee);
    boolean delete(Integer id);
    List<Job> findAllJob();
    List<Department> findAllDepartment();
}
