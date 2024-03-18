package com.colak.springlogbackpropertiestutorial.config;

import com.colak.springlogbackpropertiestutorial.interceptor.MDCMessageHandlerInterceptor;
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
