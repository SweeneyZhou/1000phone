package com.qianfeng.day0430.dao;

import com.qianfeng.day0430.entity.Department;

import java.util.List;

/**
 * - 显示所有部门信息
 * - 根据部门id查询一个部门信息
 * - 根据地区名查询部门信息
 * - 显示第一页的部门信息（每一页的大小为10）
 * - 根据部门名称显示部门信息
 * - 添加新部门
 * - 修改部门
 * - 删除部门
 *
 * @author sweeney
 */
public interface DepartmentDAO {
    /**
     * 显示所有部门信息
     *
     * @author sweeney
     */
    List<Department> findALl();

    /**
     * 显示某一页的部门信息（每一页的大小为pageCount）
     *
     * @param pageNumber 页号 第一页为0
     * @param pageCount  每页个数
     * @author sweeney
     */
    List<Department> findAll(int pageNumber, int pageCount);

    /**
     * 显示第一页的部门信息（每一页的大小为10）
     *
     * @author sweeney
     */
    default List<Department> findFirstPage() {
        return findAll(1, 10);
    }

    /**
     * 添加部门
     *
     * @param department 要添加的部门实例
     * @author sweeney
     */
    boolean save(Department department);

    /**
     * 修改部门
     *
     * @param id         要修改的部门ID
     * @param department 修改后的部门实例
     * @author sweeney
     */
    boolean update(Integer id, Department department);

    /**
     * 删除部门
     *
     * @param id 要删除的部门id
     * @author sweeney
     */
    boolean delete(Integer id);

    /**
     * 根据部门id查询一个部门信息
     *
     * @param id 部门id
     * @author sweeney
     */
    Department findById(Integer id);

    /**
     * 根据地区名查询部门信息（城市名
     *
     * @param city 城市名
     * @author sweeney
     */
    List<Department> findByCity(String city);

    /**
     * 根据部门名称显示部门信息
     *
     * @param name 部门名
     * @author sweeney
     */
    List<Department> findByDepartmentName(String name);

}
