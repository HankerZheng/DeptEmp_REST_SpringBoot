package net.antra.hanz.dao;

import net.antra.hanz.pojo.User;

import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
public interface UserDAO {

    public User findUserByName(String userName);
    public List<User> findAllUsers();
}
