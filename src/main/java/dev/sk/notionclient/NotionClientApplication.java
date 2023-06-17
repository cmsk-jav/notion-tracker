package dev.sk.notionclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication( scanBasePackages = "dev.sk.notionclient", exclude = {DataSourceAutoConfiguration.class})
public class NotionClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotionClientApplication.class, args);
    }
}
