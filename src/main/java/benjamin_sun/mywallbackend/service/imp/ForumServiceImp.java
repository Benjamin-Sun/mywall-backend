package benjamin_sun.mywallbackend.service.imp;

import benjamin_sun.mywallbackend.entity.Forum;
import benjamin_sun.mywallbackend.repository.ForumRepository;
import benjamin_sun.mywallbackend.repository.UserRepository;
import benjamin_sun.mywallbackend.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImp implements ForumService{

    @Autowired
    ForumRepository forumRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Forum> selectAllByName(String forumName) {
        return forumRepository.selectAllByName(forumName);
    }

    @Override
    public List<Forum> selectAllByCreatTime() {
        return forumRepository.selectAllByCreateTime();
    }

    @Override
    public List<Forum> selectAllByUpdateTime() {
        return forumRepository.selectAllByUpdateTime();
    }

    @Override
    public List<Forum> selectByUserName(String userName) {
        String userId = userRepository.selectByUserName(userName).getUserId();
        System.out.println(userId);
        return forumRepository.selectAllByUser(userId);
    }

    @Override
    public void deleteById(String forumId) {
        forumRepository.deleteById(forumId);
    }

    @Override
    public Forum insert(Forum forum) {
        return forumRepository.save(forum);
    }
}
