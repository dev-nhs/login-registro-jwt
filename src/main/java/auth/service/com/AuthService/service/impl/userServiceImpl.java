package auth.service.com.AuthService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import auth.service.com.AuthService.model.user.user;
import auth.service.com.AuthService.repository.userRepository;
import auth.service.com.AuthService.service.userService;



@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepository repo;

    @Override
    public user getUser(int id){
        return this.repo.findById(id).get();
    }

    @Override
    public List<user> getUserAll() {
        return (List<user>) this.repo.findAll();
    }

    @Override
    public user saveUser(user user) {
        return this.repo.save(user);
    }

    @Override
    public user updateUser(user user) {

            if(this.repo.findById(user.getId()).isPresent()) repo.save(user);
            return null;
        }

    @Override
    public boolean deleteUser(int id) {
        try {
            this.repo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
