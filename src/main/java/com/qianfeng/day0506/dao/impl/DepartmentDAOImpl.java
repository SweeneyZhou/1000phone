package com.qianfeng.day0506.dao.impl;

import com.qianfeng.DruidUtils;
import com.qianfeng.day0506.dao.DepartmentDAO;
import com.qianfeng.day0506.entity.Department;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDAOImpl implements DepartmentDAO {
    QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    Map<String, String> map = new HashMap<>();
    BasicRowProcessor basicRowProcessor;

    {
        map.put("DEPARTMENT_ID", "departmentId");
        map.put("DEPARTMENT_NAME", "departmentName");
        map.put("MANAGER_ID", "managerId");
        map.put("LOCATION_ID", "locationId");
        basicRowProcessor = new BasicRowProcessor(new BeanProcessor(map));
    }

    @Override
    public List<Department> findAll() {
        String sql = "select * from t_departments";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Department.class, basicRowProcessor));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> findAll(int currentPage, int pageSize) {
        String sql = "SELECT * FROM t_departments limit ?,?";
        try {
            return queryRunner.query(sql, new BeanListHandler<Department>(Department.class, basicRowProcessor), (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Department department) {
        String sql = "insert into t_departments values (?,?,?,?)";
        try {
            return queryRunner.update(sql, department.getDepartmentId(), department.getDepartmentName(), department.getManagerId(), department.getLocationId()) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Integer id, Department department) {
        String sql = "update t_departments set DEPARTMENT_NAME=?,MANAGER_ID=?,LOCATION_ID=? where DEPARTMENT_ID=?";
        try {
            return queryRunner.update(sql, department.getDepartmentName(), department.getManagerId(), department.getLocationId(), id) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "delete from t_departments where DEPARTMENT_ID=?";
        try {
            return queryRunner.update(sql, id) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Department findById(Integer id) {
        String sql = "select * from t_departments where DEPARTMENT_ID=?";
        try {
            return queryRunner.query(sql, new BeanHandler<>(Department.class, basicRowProcessor), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> findByCity(String city) {
        String sql = "Select * from t_departments join t_locations l on t_departments.LOCATION_ID = l.location_id where CITY =?";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Department.class, basicRowProcessor), city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> findByDepartmentName(String name) {
        String sql = "select * from t_departments where DEPARTMENT_NAME like ?";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Department.class, basicRowProcessor), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
