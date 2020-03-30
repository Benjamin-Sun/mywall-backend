package benjamin_sun.mywallbackend.utils;

import com.baidu.aip.contentcensor.AipContentCensor;
import com.baidu.aip.contentcensor.EImgType;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 调用百度人工智能接口实现对上传的图片的内容识别
 */
@Component
public class AipImageCensorUtils {

    //设置APPID/AK/SK
    public static final String APP_ID = "19150861";
    public static final String API_KEY = "Fn8FrdnDlS4jTeAiszGe8rYt";
    public static final String SECRET_KEY = "8GzHp5AyyYW2u1HeRInIPkeL3HxOyqPl";
    public static final AipContentCensor client = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);

    public static JSONObject imageCheck(String url) throws IOException {
        // 参数为本地图片路径
//        JSONObject response = BaiDuAiConfig.client.imageCensorUserDefined(imgPath, EImgType.FILE, null);
//        System.out.println(response.toString());

        // 参数为url
//        String url = "http://testurl";
        JSONObject response = client.imageCensorUserDefined(url, EImgType.URL, null);
        System.out.println(response.toString());
        return response;
    }

    public static JSONObject imageCheck(MultipartFile file) throws IOException {
        // 参数为本地图片文件二进制数组
        byte[] files = FileCopyUtils.copyToByteArray(file.getInputStream());
        JSONObject response = client.imageCensorUserDefined(files, null);
        System.out.println(response);
        return response;
    }
}
