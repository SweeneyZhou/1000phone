package dao.impl;

import dao.UserDAO;
import entity.User;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DruidUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sweeney 2021/5/9 16:21
 */
public class UserDAOImpl implements UserDAO {
    QueryRunner queryRunner= new QueryRunner(DruidUtils.getDataSource());
    @Override
    public User findByUsername(String username) {
        String sql = "select * from users where name=?";
        try {
            return queryRunner.query(sql, new BeanHandler<>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
