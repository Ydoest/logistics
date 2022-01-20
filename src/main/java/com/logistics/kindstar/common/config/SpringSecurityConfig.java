package com.logistics.kindstar.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * spring security配置
 *
 * @author KG06884
 * @date 2022-01-13
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 需携带有效 token
                .antMatchers("/auth").authenticated()
                // 需拥有 admin 这个权限
                .antMatchers("/admin").hasAuthority("admin")
                // 需拥有 ADMIN 这个身份
                .antMatchers("/ADMIN").hasRole("ADMIN")
                // 允许所有请求通过
                .anyRequest().permitAll()
                .and()
                .csrf()
                // 禁用 Spring Security 自带的跨域处理
                .disable()
                // 定制我们自己的 session 策略
                .sessionManagement()
                // 调整为让 Spring Security 不创建和使用 session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }
}
