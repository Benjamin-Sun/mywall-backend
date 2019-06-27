package benjamin_sun.mywallbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MywallBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MywallBackendApplication.class, args);
    }

}
