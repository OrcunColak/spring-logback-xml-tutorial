package com.colak.springtutorial.config;

import com.colak.springtutorial.interceptor.MDCMessageHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MDCConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Add interceptor for MDC logging
        registry.addInterceptor(new MDCMessageHandlerInterceptor());
    }
}
