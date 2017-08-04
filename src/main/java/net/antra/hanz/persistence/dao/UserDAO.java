package net.antra.hanz.persistence.dao;

import net.antra.hanz.persistence.entity.User;

import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
public interface UserDAO {

    public User findUserByName(String userName);
    public List<User> findAllUsers();
}
