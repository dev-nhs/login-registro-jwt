package auth.service.com.AuthService.service;

import java.util.List;

import auth.service.com.AuthService.model.user.user;


public interface userService {
    public user getUser(int id);
    public List<user> getUserAll();
    public user saveUser(user user);
    public user updateUser(user user);
    public boolean deleteUser(int id);

}
