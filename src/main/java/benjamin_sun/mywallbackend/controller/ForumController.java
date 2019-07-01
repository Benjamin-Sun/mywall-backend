package benjamin_sun.mywallbackend.controller;

import benjamin_sun.mywallbackend.entity.Forum;
import benjamin_sun.mywallbackend.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forum")
public class ForumController {

    @Autowired
    ForumService forumService;

    @GetMapping("/selectAllByForumName")
    @ResponseBody
    public List<Forum> selectAllByForumName(String forumName){
        if (!forumName.isEmpty()){
            return forumService.selectAllByName(forumName);
        } else {
            return null;
        }
    }

    @GetMapping("/getAllByCreateTime")
    @ResponseBody
    public List<Forum> getAllByCreateTime(){
        return forumService.selectAllByCreatTime();
    }

    @GetMapping("/getAllByUpdateTime")
    @ResponseBody
    public List<Forum> getAllByUpdateTime(){
        return forumService.selectAllByUpdateTime();
    }

    @GetMapping("/selectAllByUserName")
    @ResponseBody
    public List<Forum> selectAllByUserName(String userName){
        return forumService.selectAllByName(userName);
    }

    @PostMapping("/add")
    @ResponseBody
    public String addForum(Forum forum){
        try {
            forumService.insert(forum);
            return "添加成功";
        } catch (Exception e){
            e.printStackTrace();
            return "添加失败";
        }
    }
}
