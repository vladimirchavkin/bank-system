package ru.chavkin.billservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Data
@Configuration
@ConfigurationProperties("springdoc")
public class OpenApiProperties {

    private InfoConfig info;

    private List<ServerConfig> servers;

    @Data
    public static final class InfoConfig {
        private String title;

        private String version;

        private String description;
    }


    @Data
    public static final class ServerConfig {

        private String url;

        private String description;
    }

}