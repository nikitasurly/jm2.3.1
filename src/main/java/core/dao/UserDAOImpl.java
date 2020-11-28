package core.dao;

import core.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(find(id));
    }

    @Override
    public User edit(User user) {
        return entityManager.merge(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User find(Long id) {
        return entityManager.find(User.class, id);
    }

}
