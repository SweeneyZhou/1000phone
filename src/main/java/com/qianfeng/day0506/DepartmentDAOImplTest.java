package com.qianfeng.day0506;

import com.qianfeng.day0506.dao.DepartmentDAO;
import com.qianfeng.day0506.dao.impl.DepartmentDAOImpl;
import com.qianfeng.day0506.entity.Department;

public class DepartmentDAOImplTest {

    public static void main(String[] args) {
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        //显示所有部门信息
        System.out.println("显示所有部门信息");
        for (Department d : departmentDAO.findAll()) {
            System.out.println(d);
        }
        //根据部门id查询一个部门信息
        System.out.println("根据部门id查询一个部门信息");
        System.out.println(departmentDAO.findById(90));
        //根据地区名查询部门信息(城市名
        System.out.println("根据地区名查询部门信息");
        for (Department d : departmentDAO.findByCity("Seattle")) {
            System.out.println(d);
        }
        //显示第一页的部门信息（每一页的大小为10）
        System.out.println("显示第一页的部门信息（每一页的大小为10）");
        for (Department department : departmentDAO.findFirstPage()) {
            System.out.println(department);
        }
        //根据部门名称显示部门信息
        System.out.println("根据部门名称显示部门信息");
        for (Department department : departmentDAO.findByDepartmentName("外交部")) {
            System.out.println(department);
        }

        //添加新部门
        Department dep = new Department(281, "焚化部", null, null);
        if (departmentDAO.save(dep)) {
            System.out.println("添加成功！");
            System.out.println("显示所有部门信息");
            for (Department d : departmentDAO.findAll()) {
                System.out.println(d);
            }
        }

        //修改部门
        dep.setDepartmentName("文化部");
        if (departmentDAO.update(dep.getDepartmentId(), dep)) {
            System.out.println("修改成功！");
            System.out.println(departmentDAO.findById(dep.getDepartmentId()));
        }
        // *  - 删除部门
        if (departmentDAO.delete(dep.getDepartmentId())) {
            System.out.println("删除成功！");
            System.out.println("显示所有部门信息");
            for (Department d : departmentDAO.findAll()) {
                System.out.println(d);
            }
        }
    }
}
