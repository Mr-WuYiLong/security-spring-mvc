package com.wyl.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @Description WebSecurityConfig 认证配置
 * @Author YiLong Wu
 * @Date 2020/2/4 18:32
 * @Version 1.0.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 配置用户信息服务 （查询用户信息）
    @Bean
    public UserDetailsService userDetailsService() {
        // 从你内存查询
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("张三").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return manager;
    }

    // 密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // 配置安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 解决username使用中文登录
        CharacterEncodingFilter filter1 = new CharacterEncodingFilter();
        filter1.setEncoding("utf-8");

        http.addFilterBefore(filter1, ChannelProcessingFilter.class).authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("p1")
                .antMatchers("/r/**").authenticated() // 所有/r/**的请求路径都要认证
                .anyRequest().permitAll() // 除了/r/**，其他请求允许通过
                .and()
                .formLogin() // 允许表单登录
                .successForwardUrl("/loginSuccess");



//      http.csrf().disable();

    }
}
