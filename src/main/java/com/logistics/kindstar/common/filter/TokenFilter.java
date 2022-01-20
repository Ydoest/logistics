package com.logistics.kindstar.common.filter;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * token过滤器
 *
 * @author KG06884
 * @date 2022-01-17
 */
public class TokenFilter extends UsernamePasswordAuthenticationFilter {

    @Value("${token.signer}")
    private String TOKEN_KEY;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // step.1 将 ServletRequest 转换为 HttpServletRequest 才能拿到请求头中的 token
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // step.2 尝试获取请求头的 token
        String authToken = httpServletRequest.getHeader("authToken");
        // step.3 尝试解析 token
        JWT jwt = JWTUtil.parseToken(authToken);
//        boolean validate = jwt.setSigner().validate(0);

        super.doFilter(request, response, chain);
    }
}
