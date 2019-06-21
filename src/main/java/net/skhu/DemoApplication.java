package net.skhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
            new SpringApplicationBuilder(DemoApplication.class)
                    .run(args);
    }

}
