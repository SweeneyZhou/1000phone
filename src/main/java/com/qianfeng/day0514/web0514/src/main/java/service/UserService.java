package service;

import entity.User;

import java.util.List;

/**
 * @author sweeney 2021/5/14 17:51
 */
public interface UserService {
    User list(Integer id);

    List<User> list();

    boolean update(User user);

    boolean delete(User user);

    boolean save(User user);
}
