package com.wyl.security.init;

import com.wyl.security.config.ApplicationConfig;
import com.wyl.security.config.WebMvcConfig;
import com.wyl.security.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Description SpringApplicationInit 相当于web,xml
 * @Author YiLong Wu
 * @Date 2020/2/4 18:26
 * @Version 1.0.0
 */
public class SpringApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class,WebSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
