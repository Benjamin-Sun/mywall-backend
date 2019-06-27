package benjamin_sun.mywallbackend.repository;

import benjamin_sun.mywallbackend.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends JpaRepository<Forum, String> {
}
