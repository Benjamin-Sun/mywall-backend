package benjamin_sun.mywallbackend.utils;

import benjamin_sun.mywallbackend.MywallBackendApplicationTests;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class AesUtilsTest extends MywallBackendApplicationTests {

    @Test
    public void encrypt() {
        String content = "test";
        String password = "123456";
        //加密
        String aesPwd = AesUtils.encrypt(content, password);
        System.out.println("加密前" + content);
        System.out.println("加密后" + aesPwd);
        //解密
        String afterAesPwd = AesUtils.decrypt("557967DDC0B5428138ADDBE752020E61", password);
        System.out.println("解密后" + afterAesPwd);
    }

    @Test
    public void decrypt() {
        Date date = new Date(2019, 2, 7);
        System.out.println(date);
    }
}