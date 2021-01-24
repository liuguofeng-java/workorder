package com.workorder.config;

import com.workorder.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有
        registry.addInterceptor(LoginInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public AdminInterceptor LoginInterceptor() {
        return new AdminInterceptor();
    }


}
