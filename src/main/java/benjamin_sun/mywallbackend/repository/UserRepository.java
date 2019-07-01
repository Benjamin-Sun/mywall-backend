package benjamin_sun.mywallbackend.repository;

import benjamin_sun.mywallbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select new User(u.userId, u.userName, u.userPwd, u.userAge, u.userSex, u.userDisc, u.userCate, u.userImg) from User u where u.userName = :username")
    User selectByUserName(@Param("username") String username);
}
