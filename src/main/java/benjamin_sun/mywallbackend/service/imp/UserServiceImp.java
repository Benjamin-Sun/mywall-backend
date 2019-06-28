package benjamin_sun.mywallbackend.service.imp;

import benjamin_sun.mywallbackend.entity.User;
import benjamin_sun.mywallbackend.repository.UserRepository;
import benjamin_sun.mywallbackend.service.UserService;
import benjamin_sun.mywallbackend.utils.AesUtils;
import benjamin_sun.mywallbackend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOneById(String id) {
        return userRepository.getOne(id);
    }

    @Override
    public String insert(User user) {
        if (userRepository.selectByUserName(user.getUserName()) != null){
            return "用户名已存在";
        }else {
            user.setUserPwd(AesUtils.encrypt(user.getUserPwd(), "123456"));
            userRepository.save(user);
            return "添加成功";
        }
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public String getTokenByName(String username, String userpwd){
        User user = userRepository.selectByUserName(username);
        if (user.getUserPwd() == userpwd){
            return JwtUtils.createJWT(username, 20 * 60 * 1000);
        }else {
            return "wrong password";
        }
    }
}
