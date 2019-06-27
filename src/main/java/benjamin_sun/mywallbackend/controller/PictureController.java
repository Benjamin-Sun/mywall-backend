package benjamin_sun.mywallbackend.controller;

import benjamin_sun.mywallbackend.entity.Picture;
import benjamin_sun.mywallbackend.service.PictureService;
import benjamin_sun.mywallbackend.utils.FtpUtils;
import benjamin_sun.mywallbackend.utils.ImageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api/picture")
@Slf4j
public class PictureController {

    @Autowired
    private PictureService pictureService;

    /**
     * 上传图片
     *
     * @param picName
     * @param picCate
     * @param userId
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String addAndUpload(String picName, Integer picCate, String userId, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        String filePath = FtpUtils.ftpUpload(file, fileName);
        log.info(filePath);

        Picture picture = new Picture();
        picture.setUserId(userId);
        picture.setPicCate(picCate);
        picture.setPicName(picName);
        picture.setImagePath(filePath);

        try {
            pictureService.insert(picture);
            return "添加成功";

        } catch (Exception e){
            e.printStackTrace();
            return "添加失败";
        }
    }


}
