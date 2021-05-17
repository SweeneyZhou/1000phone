package dao.impl;

import dao.UserDAO;
import entity.User;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DruidUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @author sweeney 2021/5/14 17:52
 */
public class UserDAOImpl implements UserDAO {
    QueryRunner queryRunner=new QueryRunner(DruidUtils.getDataSource());
    BasicRowProcessor processor;
    {
        HashMap<String , String> map = new HashMap<>();
        map.put("last_login_time","lastLoginTime");
        processor = new BasicRowProcessor(new BeanProcessor(map));
    }
    @Override
    public List<User> findAll() {
        String sql="SELECT * FROM users";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(User.class, processor));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(Integer id) {
        String sql="SELECT * FROM users where id=?";
        try {
            return queryRunner.query(sql, new BeanHandler<>(User.class, processor), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(User user) {
        String sql="insert into users values (?,?,?,?,?)";
        try {
            return queryRunner.update(sql,user.getId(),user.getName(),user.getPassword(),user.getTel(),user.getLastLoginTime())>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        String sql="delete from users where id=?";
        try {
           return queryRunner.update(sql,user.getId())>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        String sql="update users set name = ? ,password=?,tel=?,last_login_time=? where id=?";
        try {
            return queryRunner.update(sql,user.getName(),user.getPassword(),user.getTel(),user.getLastLoginTime(),user.getId())>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
