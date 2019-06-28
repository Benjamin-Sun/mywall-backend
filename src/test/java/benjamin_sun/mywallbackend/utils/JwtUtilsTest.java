package benjamin_sun.mywallbackend.utils;

import benjamin_sun.mywallbackend.MywallBackendApplicationTests;
import benjamin_sun.mywallbackend.entity.User;
import io.jsonwebtoken.Claims;
import org.junit.Test;

import static org.junit.Assert.*;

public class JwtUtilsTest extends MywallBackendApplicationTests{

    @Test
    public void generalKey(){
        String a = null;
        try {
            a=JwtUtils.createJWT( "456", 20 * 60 * 1000);
            System.out.println(a);
            System.out.println();
            Claims d =JwtUtils.parseJWT(a);
            System.out.println(JwtUtils.parseJWT(a));
            System.out.println(d);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}