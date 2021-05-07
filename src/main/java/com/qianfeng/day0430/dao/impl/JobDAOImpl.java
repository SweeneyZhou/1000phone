package com.qianfeng.day0430.dao.impl;

import com.qianfeng.JDBCUtils;
import com.qianfeng.day0430.dao.JobDAO;
import com.qianfeng.day0430.entity.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JobDAO实现类
 *
 * @see com.qianfeng.day0430.dao.JobDAO
 * @author sweeney
 */
public class JobDAOImpl implements JobDAO {
    @Override
    public boolean save(Job job) {
        boolean flag=false;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql="INSERT INTO `t_jobs` VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,job.getJobId());
            preparedStatement.setString(2,job.getJobTitle());
            preparedStatement.setInt(3,job.getMinSalary());
            preparedStatement.setInt(4,job.getMaxSalary());
            flag=preparedStatement.executeUpdate()>0;

            JDBCUtils.close(null, preparedStatement, connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(String id,Job job) {
        boolean flag=false;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql="UPDATE t_jobs SET JOB_TITLE = ?,MIN_SALARY=?,MAX_SALARY=? WHERE JOB_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,job.getJobTitle());
            preparedStatement.setInt(2,job.getMinSalary());
            preparedStatement.setInt(3,job.getMaxSalary());
            preparedStatement.setString(4,job.getJobId());
            flag=preparedStatement.executeUpdate()>0;

            JDBCUtils.close(null, preparedStatement, connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        boolean flag=false;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql="delete from t_jobs where JOB_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,id);
            flag=preparedStatement.executeUpdate()>0;

            JDBCUtils.close(null, preparedStatement, connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Job findById(String id) {
        Job job=null;
        try {
            Connection connection=JDBCUtils.getConnection();

            String sql="Select * from t_jobs where JOB_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                job=new Job(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                );
            }

            JDBCUtils.close(resultSet, preparedStatement, connection);

            return job;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Job> findByJobTitle(String title) {
        List<Job> jobs;
        try {
            //1.建立连接
            Connection connection=JDBCUtils.getConnection();

            //2、创建对象
            String sql="Select * from t_jobs where JOB_TITLE like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //3.执行查询
            preparedStatement.setString(1,title);
            ResultSet resultSet = preparedStatement.executeQuery();

            //4.处理结果集
            jobs=new ArrayList<>();
            while (resultSet.next()){
                Job job=new Job(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                );
                jobs.add(job);
            }
            //5.关闭流
            JDBCUtils.close(resultSet, preparedStatement, connection);

            return jobs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Job> findByMinSalary(Integer salary) {
        List<Job> jobs;
        try {
            //1.建立连接
            Connection connection=JDBCUtils.getConnection();

            //2、创建对象
            String sql="Select * from t_jobs where MIN_SALARY= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //3.执行查询
            preparedStatement.setInt(1,salary);
            ResultSet resultSet = preparedStatement.executeQuery();

            //4.处理结果集
            jobs=new ArrayList<>();
            while (resultSet.next()){
                Job job=new Job(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                );
                jobs.add(job);
            }
            //5.关闭流
            JDBCUtils.close(resultSet, preparedStatement, connection);

            return jobs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Job> findByMaxSalary(Integer salary) {
        List<Job> jobs;
        try {
            //1.建立连接
            Connection connection=JDBCUtils.getConnection();

            //2、创建对象
            String sql="Select * from t_jobs where MAX_SALARY=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //3.执行查询
            preparedStatement.setInt(1,salary);
            ResultSet resultSet = preparedStatement.executeQuery();

            //4.处理结果集
            jobs=new ArrayList<>();
            while (resultSet.next()){
                Job job=new Job(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                );
                jobs.add(job);
            }
            //5.关闭流
            JDBCUtils.close(resultSet, preparedStatement, connection);

            return jobs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Job> findAll(String order) {
        List<Job> jobs;
        try {
            //1.建立连接
            Connection connection=JDBCUtils.getConnection();

            //2、创建对象
            String sql="Select * from t_jobs ORDER BY ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //3.执行查询
            preparedStatement.setString(1,order);
            ResultSet resultSet = preparedStatement.executeQuery();

            //4.处理结果集
            jobs=new ArrayList<>();
            while (resultSet.next()){
                Job job=new Job(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                );
                jobs.add(job);
            }
            //5.关闭流
            JDBCUtils.close(resultSet, preparedStatement, connection);

            return jobs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
