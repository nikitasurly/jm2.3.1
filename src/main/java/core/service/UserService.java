package core.service;

import core.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(Long id);
    User edit(User user);
    List<User> listUsers();
    User find(Long id);
}
