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

    /**
     * 根据id获取用户信息
     * @param id
     * @return User
     */
    @GetMapping("/getById")
    @ResponseBody
    public User getById(String id){
        return userService.getOneById(id);
    }

    /**
     * 登陆验证，前端发送用户名和密码
     * @param username
     * @param userpwd
     * @return token
     */
    @GetMapping("/getTokenByName")
    @ResponseBody
    public String getTokenByName(String username, String userpwd){
        return userService.getTokenByName(username, userpwd);
    }

    /**
     * 添加用户，同时验证用户名唯一性
     * @param user
     * @return 添加信息
     */
    @PostMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestBody User user){
        return userService.insert(user);
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
