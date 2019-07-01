package benjamin_sun.mywallbackend.controller;

import benjamin_sun.mywallbackend.entity.Forum;
import benjamin_sun.mywallbackend.service.ForumService;
import benjamin_sun.mywallbackend.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String addForum(Forum forum, HttpServletRequest request){
        try {
            String token = request.getHeader("Authorization");
            JwtUtils.parseJWT(token);

            forumService.insert(forum);
            return "添加成功";
        } catch (ExpiredJwtException e){
            e.printStackTrace();
            return "token过期，请重新登陆";
        } catch (Exception e){
            e.printStackTrace();
            return "添加失败";
        }
    }

    @GetMapping("/deleteThisForum")
    @ResponseBody
    public String deleteById(String forumId, HttpServletRequest request){
        try {
            String token = request.getHeader("Authorization");
            JwtUtils.parseJWT(token);

            forumService.deleteById(forumId);
            return "删除成功";
        } catch (ExpiredJwtException e){
            e.printStackTrace();
            return "token过期，请重新登录";
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "请选择图片";
        } catch (Exception e){
            e.printStackTrace();
            return "删除失败";
        }
    }
}
