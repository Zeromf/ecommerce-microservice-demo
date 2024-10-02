package org.accenture.ecommerce_demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${accenture.openapi.dev-url}")
    private String devUrl;

    @Value("${accenture.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server in Desarrollo");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server in Produccion");

        Contact contact = new Contact();
        contact.setEmail("ferreyraenzo26@hotmail.com");
        contact.setName("Enzo");
        contact.setUrl("https://www.CarritoZero.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Producto Customer API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage Product.").termsOfService("https://www.products.com/produ")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
