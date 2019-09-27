package com.nokchax.watcher;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WatcherApplication {

    private static final String TOKEN_PROPERTY = "file:/data/etc/watcher/token.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(WatcherApplication.class)
                .properties("spring.config.additional-location=" + TOKEN_PROPERTY)
                .run(args);
    }

}
