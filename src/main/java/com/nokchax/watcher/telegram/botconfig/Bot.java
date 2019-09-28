package com.nokchax.watcher.telegram.botconfig;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * https://docs.spring.io/spring-boot/docs/2.1.8.RELEASE/reference/html/configuration-metadata.html#configuration-metadata-annotation-processor
 *
 * need spring boot configuration processor to use below annotation
 * and add @EnableConfigurationProperties
 */

@Data
@ConfigurationProperties("telegram.bot")
public class Bot {
    private String name;
    private String token;
}
