package com.richieoscar.shopaholic.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        OpenAPI openAPI = new OpenAPI();
        Info info = new Info();
        info.title("Shopaholic API");
        info.description("This is the official Api Documenation for the Shopaholic Application.");
        info.version("Version 1");
        info.setTermsOfService("Terms & Conditon Apply");
        info.setContact(new Contact().email("oscaranyiam94@gmail.com").name("Oscar Anyiam"));
        Server server = new Server();
        server.url("http://localhost:8080/shopaholic");
        server.description("Base Url");
        openAPI.setInfo(info);
        openAPI.setServers(List.of(server));
        return openAPI;
    }
}
