package service.impl;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import service.UserService;

import java.util.List;

/**
 * @author sweeney 2021/5/14 17:52
 */
public class UserServiceImpl implements UserService {
    UserDAO userDAO=new UserDAOImpl();
    @Override
    public User list(Integer id) {

        return userDAO.findById(id);
    }

    @Override
    public List<User> list() {

        return userDAO.findAll();
    }

    @Override
    public boolean update(User user) {

        if(user.getId()==null)return false;
        if(user.getName()==null)return false;
        if(user.getPassword()==null)return false;
        if(user.getTel()==null)return false;
        return userDAO.update(user);
    }

    @Override
    public boolean delete(User user) {
        return userDAO.delete(user);
    }

    @Override
    public boolean save(User user) {
        if(user.getName()==null)return false;
        if(user.getPassword()==null)return false;
        if(user.getTel()==null)return false;
        return userDAO.save(user);
    }
}
