package com.lucas.mp.demo.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author liuxu
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 加入ApiOperation注解的类，才能生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
                // .directModelSubstitute()
                // .securitySchemes(security());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("lucas", "http://www.xlkh.com.cn", "lucas@qq.com");
        return new ApiInfoBuilder()
                .title("后台管理系统")
                .description("后台接口开发文档")
//                .contact(contact)
                .termsOfServiceUrl("http://www.xlkh.com.cn")
                .version("0.0.1")
                .build();
    }

//    private List<ApiKey> security() {
//        return newArrayList(new ApiKey("token","token","header"));
//    }

}
