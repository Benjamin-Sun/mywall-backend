package benjamin_sun.mywallbackend.service;

import benjamin_sun.mywallbackend.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getOneById(String id);

    User getOneByName(String username);

    String insert(User user);

    void deleteById(String id);

    String getTokenByName(String username);

    boolean pwdIsWrite(String username, String userpwd);
}
