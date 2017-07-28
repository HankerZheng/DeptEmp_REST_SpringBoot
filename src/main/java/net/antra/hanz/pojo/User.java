package net.antra.hanz.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by hanzheng on 7/27/17.
 */
@Entity
public class User
{
    @Id
    @Column(name="user_name")
    String userName;

    @Column(name="password")
    String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
