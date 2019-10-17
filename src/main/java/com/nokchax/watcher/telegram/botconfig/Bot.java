package com.nokchax.watcher.telegram.botconfig;


import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * https://docs.spring.io/spring-boot/docs/2.1.8.RELEASE/reference/html/configuration-metadata.html#configuration-metadata-annotation-processor
 *
 * need spring boot configuration processor to use below annotation
 * and add @Configuration.. (but intellij recognize it as an error)
 * so use @Component instead of  @Configuration
 *
 * or
 *
 * use enable configuration properties annotation like below
 * @EnableConfigurationProperties(Bot.class)
 */

@Getter
@Component
@ConfigurationProperties("telegram.bot")
public class Bot {
    private String name;
    private String token;
    private Long noticeRoomNo;
}
