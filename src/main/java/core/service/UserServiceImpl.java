package core.service;

import core.dao.UserDAO;
import core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }

    @Transactional
    @Override
    public User edit(User user) {
        return userDAO.edit(user);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    public User find(Long id) {
        return userDAO.find(id);
    }
}
