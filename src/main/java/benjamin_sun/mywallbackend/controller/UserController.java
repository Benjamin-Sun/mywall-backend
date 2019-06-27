package benjamin_sun.mywallbackend.controller;

import benjamin_sun.mywallbackend.entity.User;
import benjamin_sun.mywallbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/getById")
    @ResponseBody
    public User getById(String id){
        return userService.getOne(id);
    }

    @PostMapping("/addUser")
    @ResponseBody
    public int addUser(@RequestBody User user){
        try {
            userService.insert(user);
            return 1;
        } catch (Exception e){
            return 0;
        }
    }

    @GetMapping("/deleteById")
    @ResponseBody
    public int deleteUser(String id){
        try {
            userService.deleteById(id);
            return 1;
            } catch (Exception e){
            return 0;
        }
    }

}
