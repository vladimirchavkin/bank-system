package ru.chavkin.billservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(OpenApiProperties.class)
public class OpenApiConfiguration {

    private final OpenApiProperties openApiProperties;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(getInfoForOpenApi())
                .servers(getServersForOpenApi());
    }

    public Info getInfoForOpenApi() {
        OpenApiProperties.InfoConfig infoConfig = openApiProperties.getInfo();
        return new Info()
                .title(infoConfig.getTitle())
                .version(infoConfig.getVersion())
                .contact(getContactForOpenApi())
                .description(infoConfig.getDescription())
                .license(getLicenseForOpenApi())
                .termsOfService("https://vladimirchavkin.ru/terms");
    }

    private Contact getContactForOpenApi() {
        return new Contact()
                .name("Vladimir Chavkin")
                .email("vladimirchavkinwork@gmail.com")
                .url("https://github.com/vladimirchavkin");
    }

    private License getLicenseForOpenApi() {
        return new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");
    }

    private List<Server> getServersForOpenApi() {
        return openApiProperties.getServers().stream()
                .map(serverConfig -> new Server().url(serverConfig.getUrl()).description(serverConfig.getDescription()))
                .collect(Collectors.toList());
    }

}