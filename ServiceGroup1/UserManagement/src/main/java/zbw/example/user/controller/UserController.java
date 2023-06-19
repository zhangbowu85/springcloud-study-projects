package zbw.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zbw.example.user.entity.User;
import zbw.example.user.mapper.impl.UserDao4Redis;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao4Redis userDao;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userDao.saveUser(user);
        return "User added";
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userDao.getOneUser(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public Map<Integer, User> findAll() {
        return userDao.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userDao.deleteUser(id);
        return "User with id " + id + " deleted";
    }
}
