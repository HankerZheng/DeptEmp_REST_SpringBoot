package net.antra.hanz.dao;

import net.antra.hanz.pojo.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    EntityManager em;


    @Override
    public User findUserByName(String userName) {
        return em.find(User.class, userName);
    }

    @Override
    public List<User> findAllUsers() {
        Query query = em.createQuery("select distinct object (u) from User u");
        return query.getResultList();
    }
}
