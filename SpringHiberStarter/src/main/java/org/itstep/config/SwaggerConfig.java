package org.itstep.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        log.info("Swagger config");
        return new Docket(DocumentationType.SWAGGER_2).groupName("Project REST Service")
                .apiInfo(new ApiInfoBuilder().title("Itstep REST API").description("All the methods of the REST API").build()).select().apis(
                        RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration("validatorUrl", // url
                "none", // docExpansion => none | list
                "alpha", // apiSorter => alpha
                "model", // defaultModelRendering => schema
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, // enableJsonEditor => true | false
                true, // showRequestHeaders => true | false
                60000L); // requestTimeout => in milliseconds, defaults to null (uses jquery xh timeout)
    }
}
