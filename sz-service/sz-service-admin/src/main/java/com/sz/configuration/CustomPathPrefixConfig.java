package com.sz.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;


/**
 * @ClassName CustomPathPrefixConfig
 * @Author mengke
 * @create 2025/5/1 21:36
 * @Description
 */
@Slf4j
@Configuration
public class CustomPathPrefixConfig {

    @Bean
    @Primary
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {

        log.info("CustomPathPrefixConfig loaded...");
        return new RequestMappingHandlerMapping() {
            @Override
            protected void registerHandlerMethod(Object handler, java.lang.reflect.Method method, RequestMappingInfo mapping) {
                Class<?> beanType = method.getDeclaringClass();
                if (beanType.isAnnotationPresent(RestController.class)) {
                    String packageName = beanType.getPackage().getName();
                    String prefix = getPrefixFromPackage(packageName);
                    if (prefix != null) {
                        RequestMappingInfo newMapping = RequestMappingInfo
                                .paths(prefix)
                                .build()
                                .combine(mapping);
                        super.registerHandlerMethod(handler, method, newMapping);
                        return;
                    }
                }
                super.registerHandlerMethod(handler, method, mapping);
            }

            private String getPrefixFromPackage(String packageName) {
                if (packageName.contains(".controller.admin.")) {
                    return "/admin";
                } else if (packageName.contains(".controller.app.")) {
                    return "/app";
                }
                return null;
            }
        };
    }
}