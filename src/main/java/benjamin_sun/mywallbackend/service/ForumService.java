package benjamin_sun.mywallbackend.service;

import benjamin_sun.mywallbackend.entity.Forum;

import java.util.List;

public interface ForumService {
    List<Forum> selectAllByName(String forumName);
    List<Forum> selectAllByCreatTime();
    List<Forum> selectAllByUpdateTime();
    List<Forum> selectByUserName(String userName);

    void deleteById(String forumId);

    Forum insert(Forum forum);
}
