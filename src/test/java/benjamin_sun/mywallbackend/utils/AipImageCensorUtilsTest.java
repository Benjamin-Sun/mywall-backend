package benjamin_sun.mywallbackend.utils;

import benjamin_sun.mywallbackend.MywallBackendApplicationTests;
import com.baidu.aip.contentcensor.AipContentCensor;
import com.baidu.aip.contentcensor.EImgType;
import org.json.JSONObject;
import org.junit.Test;

public class AipImageCensorUtilsTest extends MywallBackendApplicationTests {

    @Test
    public void imageCheck(){
        //设置APPID/AK/SK
        String APP_ID = "19150861";
        String API_KEY = "Fn8FrdnDlS4jTeAiszGe8rYt";
        String SECRET_KEY = "8GzHp5AyyYW2u1HeRInIPkeL3HxOyqPl";
        AipContentCensor client = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);

//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);

        // 参数为本地图片路径 92d69e5c6e404b2c8ff3b1b77a540618.jpg
        String url = "https://w.wallhaven.cc/full/lm/wallhaven-lmogdr.jpg";
        JSONObject response = client.imageCensorUserDefined(url, EImgType.URL, null);
        System.out.println(response.toString());
    }
}
