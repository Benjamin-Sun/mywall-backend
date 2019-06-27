package benjamin_sun.mywallbackend.repository;

import benjamin_sun.mywallbackend.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLikeRepository extends JpaRepository<UserLike, String> {
}
