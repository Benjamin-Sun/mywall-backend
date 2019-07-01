package benjamin_sun.mywallbackend.repository;

import benjamin_sun.mywallbackend.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumRepository extends JpaRepository<Forum, String> {

    @Query(value = "select new Forum(f.forumId, f.forumName, f.userId, f.picId, f.messageDisc, f.createTime, f.updateTime) " +
            "from Forum f where f.forumName =: name order by f.createTime")
    List<Forum> selectAllByName(@Param("ForumName")String name);

    @Query(value = "select new Forum(f.forumId, f.forumName, f.userId, f.picId, f.messageDisc, f.createTime, f.updateTime) " +
            "from Forum f order by f.createTime")
    List<Forum> selectAllByCreateTime();

    @Query(value = "select new Forum(f.forumId, f.forumName, f.userId, f.picId, f.messageDisc, f.createTime, f.updateTime) " +
            "from Forum f order by f.updateTime")
    List<Forum> selectAllByUpdateTime();

    @Query(value = "select new Forum(f.forumId, f.forumName, f.userId, f.picId, f.messageDisc, f.createTime, f.updateTime) " +
            "from Forum f where f.userId =: userId order by f.createTime")
    List<Forum> selectAllByUser(@Param("userName")String userId);
}
