package com.qianfeng.day0430.dao;

import com.qianfeng.day0430.entity.Department;
import com.qianfeng.day0430.entity.Employee;

import java.util.List;

/**
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
public interface EmployeeDAO {
    /**
     * 倒序标识
     */
    String DESC = " DESC ";
    /**
     * 正序标识
     */
    String ASC = " ASC ";

    /**
     * 查询所有员工信息
     *
     * @author sweeney
     */
    List<Employee> findAll();

    /**
     * 添加新员工
     *
     * @author sweeney
     */
    boolean save(Employee employee);

    /**
     * 修改一个员工
     *
     * @param id       要修改的员工ID
     * @param employee 更新后的employee实例
     * @author sweeney
     */
    boolean update(Integer id, Employee employee);

    /**
     * 根据Id删除一个员工
     * 根据多个Id删除多个员工
     *
     * @param id 可变长参数 需要删除的员工ID
     * @author sweeney
     */
    boolean delete(Integer... id);

    /**
     * 根据用户名查询员工信息
     *
     * @param name 用户名
     * @author sweeney
     */
    List<Employee> findByFirstName(String name);

    /**
     * 根据薪水范围查询用户信息
     *
     * @param minSalary 薪水范围起点
     * @param maxSalary 薪水范围终点
     * @author sweeney
     */
    List<Employee> findBySalaryBetween(int minSalary, int maxSalary);

    /**
     * 根据工资进行排序
     *
     * @param order 排序方式 DESC或者ASC
     * @author sweeney
     */
    List<Employee> findAllOrderBySalary(String order);

    /**
     * 显示最大薪水的员工信息
     *
     * @author sweeney
     */
    default Employee findMaxSalary() {
        return findAllOrderBySalary(DESC).get(0);
    }

    /**
     * 显示最小薪水的员工信息
     *
     * @author sweeney
     */
    default Employee findMinSalary() {
        return findAllOrderBySalary(ASC).get(0);
    }

    /**
     * 查询所有部门ID
     * 根据部门ID返回部门人数
     * 显示每个部门的人数及部门名称(查询部门名称应该在departmentDAO里的
     *
     * @author sweeney
     */
    List<Integer> findAllDepartmentId();

    /**
     * 根据部门ID返回人数
     *
     * @param id 部门ID
     * @author sweeney
     */
    int countByDepartmentId(Integer id);

    /**
     * 根据员工ID返回员工信息
     *
     * @param id 员工id
     * @author sweeney
     */
    Employee findByEmployeeId(Integer id);
}
