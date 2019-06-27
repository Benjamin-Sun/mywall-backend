package benjamin_sun.mywallbackend.service.imp;

import benjamin_sun.mywallbackend.entity.User;
import benjamin_sun.mywallbackend.repository.UserRepository;
import benjamin_sun.mywallbackend.service.UserService;
import benjamin_sun.mywallbackend.utils.AesUtils;
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
    public User getOne(String id) {
        return userRepository.getOne(id);
    }

    @Override
    public void insert(User user) {
        user.setUserPwd(AesUtils.encrypt(user.getUserPwd(), "123456"));
        userRepository.save(user);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
