package com.nokchax.watcher;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class WatcherApplication {

    private static final String TOKEN_PROPERTY = "file:/data/etc/watcher/token.yml";

    public static void main(String[] args) {
        ApiContextInitializer.init();

        new SpringApplicationBuilder()
                .sources(WatcherApplication.class)
                .properties("spring.config.additional-location=" + TOKEN_PROPERTY)
                .run(args);
    }

}
