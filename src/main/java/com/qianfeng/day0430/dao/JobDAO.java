package com.qianfeng.day0430.dao;

import com.qianfeng.day0430.entity.Job;
import java.util.List;

public interface JobDAO {

    /**
     * 倒序标识
     */
    String DESC=" DESC ";
    /**
     * 正序标识
     */
    String ASC=" ASC ";

    /**
     * 保存实体
     * @author sweeney
     * @param job job实例
     */
    boolean save(Job job);

    /**
     * 通过JobId和更新后的Job实体，修改数据
     *
     * @author sweeney
     * @param id JobId
     * @param job Job实体
     */
    boolean update(String id,Job job);

    /**
     * 通过JobId删除
     *
     * @author sweeney
     * @param id JobId
     */
    boolean delete(String id);

    /**
     * 通过jobId查找
     *
     * @author sweeney
     * @param id JobId
     */
    Job findById(String id);
    /**
     * 通过title查找
     *
     * @author sweeney
     * @param title Job title
     */
    List<Job> findByJobTitle(String title);
    /**
     * 通过minSalary查找
     *
     * @author sweeney
     * @param salary 最低工资
     */
    List<Job> findByMinSalary(Integer salary);
    /**
     * 通过maxSalary查找
     *
     * @author sweeney
     * @param salary 最高公子
     */
    List<Job> findByMaxSalary(Integer salary);
    /**
     * 查找全部并排序返回
     *
     * @author sweeney
     * @param order 排序
     */
    List<Job> findAll(String order);
    default List<Job> findAll() {
        return findAll(ASC);
    }
}
