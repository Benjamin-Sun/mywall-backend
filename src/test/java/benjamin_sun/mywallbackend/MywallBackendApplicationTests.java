package benjamin_sun.mywallbackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MywallBackendApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void dateTest() throws ParseException {
        String formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(formatDate));
    }

}
