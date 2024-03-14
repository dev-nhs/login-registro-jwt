package auth.service.com.AuthService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.service.com.AuthService.service.userService;
import auth.service.com.AuthService.model.user.user;
import lombok.RequiredArgsConstructor;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class userController {

    @Autowired
    private userService user;

    @GetMapping("/get/{id}")
    public user getUser(@PathVariable("id") int id){
        return this.user.getUser(id);
    }

    @GetMapping("/all")
    public List<user> getUsers(){
        return this.user.getUserAll();
    }

    @PostMapping("/save")
    public user saveUser(@RequestBody user user){
        return this.user.saveUser(user);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable("id") int id){
        return this.user.deleteUser(id);
    }


}
