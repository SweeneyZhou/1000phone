package service.impl;

import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import entity.Employee;
import service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public List<Employee> getAll() {
        return employeeDAO.findAll();
    }
}
