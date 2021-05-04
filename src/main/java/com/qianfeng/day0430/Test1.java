package com.qianfeng.day0430;

import com.qianfeng.day0430.dao.JobDAO;
import com.qianfeng.day0430.dao.dao.impl.JobDAOImpl;
import com.qianfeng.day0430.entity.Job;
import java.util.List;

/**
 * JobDAO测试类
 *
 * @author sweeney
 */
public class Test1 {
    public static void main(String[] args) {
        JobDAO jobDAO=new JobDAOImpl();
        //测试findAll()方法
        List<Job> all = jobDAO.findAll();
        for (Job job : all) {
            System.out.println(job);
        }

        Job job_test=new Job("IT_PR","程序员",14000,24000);
        if (jobDAO.save(job_test)){
            System.out.println("Save success~~~");
            for (Job job : jobDAO.findAll()) {
                System.out.println(job);
            }
        }

        job_test.setJobTitle("new程序员");
        if (jobDAO.update(job_test.getJobId(),job_test)){
            System.out.println("Update Success~~~");
            for (Job job : jobDAO.findAll()) {
                System.out.println(job);
            }
        }

        System.out.println("通过ID查找IT_PR");
        System.out.println(jobDAO.findById("IT_PR"));

        System.out.println("通过title查找new程序员");
        for (Job job : jobDAO.findByJobTitle("new程序员")) {
            System.out.println(job);
        }
        if (jobDAO.delete(job_test.getJobId())){
            System.out.println("Delete Success~~~");
            for (Job job : jobDAO.findAll()) {
                System.out.println(job);
            }
        }
    }
}
