package dao;

import entity.User;

/**
 * @author sweeney
 * @date 2021/5/8 17:38
 */
public interface UserDAO {
    User findByUsername(String username);
}
