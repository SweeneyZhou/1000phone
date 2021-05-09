package entity;

import lombok.Data;

import java.util.Date;

/**
 * @author sweeney
 * @date 2021/5/8 17:38
 */
@Data
public class User {
    String name;
    String password;
    String Tel;
    Date lastLoginTime;
    public User(){}

    public User(String username, String password, Object o, Object o1) {
    }
}
