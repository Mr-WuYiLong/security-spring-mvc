package com.wyl.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Description ApplicationConfig 相当于spring-context.xml
 * @Author YiLong Wu
 * @Date 2020/2/4 18:18
 * @Version 1.0.0
 */
@Configuration
@ComponentScan(basePackages = "com.wyl.security"
        ,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {

}
