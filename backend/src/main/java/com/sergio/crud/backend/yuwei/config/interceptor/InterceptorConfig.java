package com.sergio.crud.backend.yuwei.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private YuWeiInterceptor ccc;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ccc).addPathPatterns("/**");
    }
}
