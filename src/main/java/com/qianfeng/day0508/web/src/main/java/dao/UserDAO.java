package dao;

import entity.User;

/**
 * @author sweeney
 */
public interface UserDAO {
    User findByUsername(String username);

}
