package com.summer.springvuedemo.demo.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//全局配置类，配置跨域请求
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * 1.访问路径
         * 2.请求来源
         * 3.方法
         * 4.允许携带
         * 5.最大请求时间
         */
        registry.addMapping("/**")
                .allowedOrigins("HTTP://localhost:8080","null")
                .allowedMethods("GET","POST","PUT","OPTION","DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
