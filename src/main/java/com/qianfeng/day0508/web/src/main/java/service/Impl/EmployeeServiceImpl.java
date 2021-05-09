package service.Impl;

import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import entity.Department;
import entity.Employee;
import entity.Job;
import service.EmployeeService;

import java.util.List;
import java.util.Map;

/**
 * @author sweeney 2021/5/9 18:53
 */
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDAO employeeDAO=new EmployeeDAOImpl();
    @Override
    public List<Map<String ,Object>> list() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeDAO.findByEmployeeId(id);
    }

    @Override
    public List<Job> jobList() {
        return employeeDAO.findAllJob();
    }

    @Override
    public List<Department> departmentList() {
        return employeeDAO.findAllDepartment();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeDAO.update(employee);
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        return employeeDAO.delete(id);
    }
}
