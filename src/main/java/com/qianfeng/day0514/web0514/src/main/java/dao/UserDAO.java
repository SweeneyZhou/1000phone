package dao;

import entity.User;

import java.util.List;

/**
 * @author sweeney 2021/5/14 17:51
 */
public interface UserDAO {
    List<User> findAll();

    User findById(Integer id);

    boolean save(User user);

    boolean delete(User user);

    boolean update(User user);
}
