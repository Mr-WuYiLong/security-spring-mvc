package com.wyl.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Description WebMvcConfig 相当于spring-mvc.xml
 * @Author YiLong Wu
 * @Date 2020/2/4 18:22
 * @Version 1.0.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.wyl.security"
        ,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class WebMvcConfig extends WebMvcConfigurationSupport {

    // 视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("redirect:/login");
    }
}
