package entity;

import lombok.Data;

import java.util.Date;

/**
 * @author sweeney
 */
@Data
public class User {
    String name;
    String password;
    String tel;
    Date lastLoginTime;
    public User(){}
}
