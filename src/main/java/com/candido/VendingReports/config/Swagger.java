package com.candido.VendingReports.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("VENDING MACHINES - ESTATÍSTICAS DE VENDAS")
                        .version("1.0")
                        .description("API para coleta de dados em máquinas modelo SNAKKY"));
    }
}
