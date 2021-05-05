package com.qianfeng.day0430;

import com.qianfeng.day0430.dao.EmployeeDAO;
import com.qianfeng.day0430.dao.impl.EmployeeDAOImpl;
import com.qianfeng.day0430.entity.Employee;

import java.util.Date;

/**
 * 测试EmployDAOImpl类
 * <p>
 * - 查询所有员工信息
 * - 根据用户名查询员工信息
 * - 根据薪水范围查询用户信息
 * - 显示最大薪水的员工信息
 * - 显示最小薪水的员工信息
 * - 显示每个部门的人数及部门名称
 * - 根据Id删除一个员工
 * - 根据多个Id删除多个员工
 * - 修改一个员工
 * - 添加新员工
 *
 * @author sweeney
 */
public class EmployDAOImplTest {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        //测试查询所有员工信息
        System.out.println("测试查询所有员工信息");
        for (Employee employee : employeeDAO.findAll()) {
            System.out.println(employee);
        }
        //测试根据用户名查询员工信息
        System.out.println("测试根据用户名查询员工信息");
        for (Employee employee : employeeDAO.findByFirstName("杨景言")) {
            System.out.println(employee);
        }
        //测试根据薪水范围查询用户信息
        System.out.println("测试根据薪水范围查询用户信息");
        for (Employee employee : employeeDAO.findBySalaryBetween(20000, 26000)) {
            System.out.println(employee);
        }
        //测试显示最大薪水的员工信息
        System.out.println("显示最大薪水的员工信息");
        System.out.println(employeeDAO.findMaxSalary());
        //测试显示最小薪水的员工信息
        System.out.println("测试显示最小薪水的员工信息");
        System.out.println(employeeDAO.findMinSalary());
        //测试显示每个部门的人数及部门名称(显示部门名称应该在DepartmentDAO里，这里返回部门ID
        System.out.println("测试显示每个部门的人数及部门名称");
        for (Integer integer : employeeDAO.findAllDepartmentId()) {
            System.out.println("部门ID:" + integer);
            System.out.println("部门人数:" + employeeDAO.countByDepartmentId(integer));
        }
        //测试添加新员工,修改一个员工
        Employee emp1 = new Employee(207, "sweeney", "zhou", "22222@qq.com", "231231313", new Date(), "SH_CLERK", 23000, 0d, 0, 90, null);
        Employee emp2 = new Employee(208, "sweeney2", "zhou", "22222@qq.com", "231231313", new Date(), "SH_CLERK", 23000, 0d, 0, 90, null);
        Employee emp3 = new Employee(209, "sweeney3", "zhou", "22222@qq.com", "231231313", new Date(), "SH_CLERK", 23000, 0d, 0, 90, null);
        if (employeeDAO.save(emp1) && employeeDAO.save(emp2) && employeeDAO.save(emp3)) {
            System.out.println("添加成功！");
            for (Employee employee : employeeDAO.findAll()) {
                System.out.println(employee);
            }
        }
        //测试修改
        emp1.setFirstName("Sweeney");
        emp1.setLastName("Zhou");
        if (employeeDAO.update(emp1.getEmployeeId(), emp1)) {
            System.out.println("修改成功！");
            System.out.println(employeeDAO.findByEmployeeId(emp1.getEmployeeId()));
        }
        //删除刚刚添加的员工
        //根据Id删除一个员工
        if (employeeDAO.delete(emp1.getEmployeeId())) {
            System.out.println("删除一个员工，成功！");
        }
        //根据多个Id删除多个员工
        if (employeeDAO.delete(emp3.getEmployeeId(), emp2.getEmployeeId())) {
            System.out.println("删除多个员工，成功！");
        }
        //测试结果
        for (Employee employee : employeeDAO.findAll()) {
            System.out.println(employee);
        }
    }
}
