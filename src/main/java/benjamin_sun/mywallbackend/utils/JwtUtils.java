package benjamin_sun.mywallbackend.utils;


import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;


@Component
public class JwtUtils {

    public static final String JWT_ID = "5236A";		//jwtid
    public static final String JWT_SECERT = "0000df7f12334e888889999123c0005d";	//密匙，这里是自己随便写，但是一定要32位
    public static final long JWT_TTL = 1 * 5 * 1000;	//token有效时间

    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(JWT_SECERT);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
    public static String createJWT(String id, String subject, long ttlMillis) {
        //jjwt已经发封装好了所有的请求头，这里是指定签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成jwt的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //获取服务器端的密钥，这个不能贡献出去，贡献出去后就可以随意伪造了
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder().setId(id).setSubject(subject).setIssuedAt(now).signWith(signatureAlgorithm,
                secretKey);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }

    /**
     * 解析JWT字符串
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) {
        SecretKey secretKey = generalKey();
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
    }
}
