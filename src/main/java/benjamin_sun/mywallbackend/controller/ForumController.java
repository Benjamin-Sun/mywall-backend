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

    /**
     * 根据动态标题搜索
     * @param forumName
     * @return
     */
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

    /**
     * 根据用户名搜索
     * @param userName
     * @return
     */
    @GetMapping("/selectByUserName")
    @ResponseBody
    public List<Forum> selectAllByUserName(String userName){
        return forumService.selectByUserName(userName);
    }

    /**
     * 添加动态
     * @param forum
     * @param request
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public String addForum(Forum forum, HttpServletRequest request){
        try {
            String token = request.getHeader("Authorization");
            JwtUtils.parseJWT(token);

            Forum forum1 = forumService.insert(forum);
            return "添加成功" + "\n" + forum1;
        } catch (ExpiredJwtException e){
            e.printStackTrace();
            return "token过期，请重新登陆";
        } catch (Exception e){
            e.printStackTrace();
            return "添加失败";
        }
    }

    /**
     * 删除动态
     * @param forumId
     * @param request
     * @return
     */
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
