package service.Impl;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import service.UserService;

/**
 * @author sweeney 2021/5/9 16:19
 */
public class UserServiceImpl implements UserService {
    @Override
    public User check(User user) {
        UserDAO userDAO=new UserDAOImpl();
        return userDAO.findByUsername(user.getName());

    }
}
