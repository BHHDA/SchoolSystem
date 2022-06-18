package homework.springboothomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHomeworkApplication.class, args);
    }

}
