/**
 * @program: yeb
 * @description: Swagger配置类
 * @author nnnNN
 * @date 2021-04-04 23:41:25
 */

package com.hk01.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@Component
public class Swagger2Config {
     @Bean
    public Docket createRestApi(){
         return new Docket(DocumentationType.SWAGGER_2)
                 .apiInfo(apiInfo())
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("com.hk01.server.controller"))
                 .paths(PathSelectors.any())
                 .build()
                 .securityContexts(securityContexts())
                 .securitySchemes(securitySchemes());
     }
     private ApiInfo apiInfo(){
         return new ApiInfoBuilder()
                 .title("云E办接口文档")
                 .description("云E办接口文档")
                 .contact(new Contact("hk01","http:localhost:8081/doc.html","xxx@163.com"))
                 .version("1.9")
                 .build();
     }

     private List<ApiKey> securitySchemes(){
         //设置请求头信息
         List<ApiKey> result = new ArrayList<>();
         ApiKey apiKey = new ApiKey("Authorization", "Authorization", "Header");
         result.add(apiKey);
         return result;
     }

     private List<SecurityContext> securityContexts(){
         //设置需要登录认证的路径
         List<SecurityContext> result = new ArrayList<>();
         result.add(getContextPathByPath("/hello/.*"));
         return result;
     }

    private SecurityContext  getContextPathByPath(String pathRegex) {
        return SecurityContext.builder()
                .securityReferences(defaultPath())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private List<SecurityReference> defaultPath() {
        ArrayList<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization",authorizationScopes));
        return result;
    }
}
