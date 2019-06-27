package benjamin_sun.mywallbackend.service.imp;

import benjamin_sun.mywallbackend.MywallBackendApplicationTests;
import benjamin_sun.mywallbackend.entity.User;
import benjamin_sun.mywallbackend.repository.UserRepository;
import benjamin_sun.mywallbackend.utils.AesUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Slf4j
public class UserServiceImpTest extends MywallBackendApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void getAll() {
        List<User> list = userRepository.findAll();
        System.out.println(list);
    }

    @Test
    public void getOne() {
        String id = "4028096b6b696984016b6969993f0000";
//        System.out.println(userRepository.findById(id));
        User user = userRepository.findById(id).get();
        String savedPwd = user.getUserPwd();
        System.out.println("数据库中保存的密码：" + savedPwd);
        String realPwd = AesUtils.decrypt(savedPwd, "123456");
        System.out.println("解密之后的密码：" + realPwd);
    }

    @Test
    public void insert() {
        User user = new User("Ben", "123456", 10, 1, 1);
        user.setUserPwd(AesUtils.encrypt(user.getUserPwd(), "123456"));
        System.out.println(userRepository.save(user));
    }
}