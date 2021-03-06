package benjamin_sun.mywallbackend.controller;

import benjamin_sun.mywallbackend.entity.Picture;
import benjamin_sun.mywallbackend.service.PictureService;
import benjamin_sun.mywallbackend.utils.AipImageCensorUtils;
import benjamin_sun.mywallbackend.utils.FtpUtils;
import benjamin_sun.mywallbackend.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    /**
     * 上传图片
     * @param picName
     * @param picCate
     * @param userId
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String addAndUpload(String picName, Integer picCate, String userId, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(picName);
        System.out.println(picCate);
        System.out.println(userId);
        if (file == null){
            System.out.println("空");
        }else {
            System.out.println("不空");
        }
        System.out.println(file.getSize());

        String token = request.getHeader("Authorization");
        String fileName = file.getOriginalFilename();

        try {
            JwtUtils.parseJWT(token);
            String filePath = FtpUtils.ftpUpload(file, fileName);
            System.out.println(fileName);

            Picture picture = new Picture();
            picture.setUserId(userId);
            picture.setPicCate(picCate);
            picture.setPicName(picName);
            picture.setImagePath(filePath);

            //添加内容审核
//            System.out.println((AipImageCensorUtils .imageCheck(file).get("conclusion")));
            if (AipImageCensorUtils .imageCheck(file).get("conclusion").equals("合规")){
                pictureService.insert(picture);
//                return "添加成功" + "\n" + picture1;
                return "添加成功";
            } else {
                return "图片内包含违规内容，请重新选择";
            }
        } catch (ExpiredJwtException e){
            return "token过期，请重新登录";
        } catch (IllegalArgumentException e){
            return "请先登录";
        } catch (Exception e){
            e.printStackTrace();
            return "添加失败";
        }
    }

    @GetMapping("/getAllByLatest")
    @ResponseBody
    public List<Picture> getAllByLatest(){
        return pictureService.selectAllByLatest();
    }

    @GetMapping("/getAllByRandom")
    @ResponseBody
    public List<Picture> getAllByRandom(){
        return pictureService.selectAllByRandom();
    }

    @GetMapping("/getAllByFavorTime")
    @ResponseBody
    public List<Picture> getAllByFavorTime(){
        return pictureService.selectAllByFavorTimes();
    }

    @GetMapping("/getOnePicture")
    @ResponseBody
    public Picture getOne(String picId){
        return pictureService.getOne(picId);
    }

    @GetMapping("/deleteThisPicture")
    @ResponseBody
    public String deleteById(String picId, HttpServletRequest request){
        try {
            String token = request.getHeader("Authorization");
            JwtUtils.parseJWT(token);

            pictureService.deleteById(picId);
            return "删除成功";
        } catch (ExpiredJwtException e){
            e.printStackTrace();
            return "token过期,请重新登录";
        } catch (Exception e){
            return "删除失败";
        }
    }
}
